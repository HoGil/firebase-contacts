package com.example.gilho.buildthree;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by gilho on 27/11/16.
 */
public class ListFragment extends Fragment {

    // iv for header
    private TextView mText;

    // iv for recyclerview
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    // firebase
    private Backend controller;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<Contact, ViewHolder> mFirebaseAdapter;

    // view holder
    private static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;
        private TextView mAge;
        private TextView mStatus;

        public ViewHolder(View v) {
            super(v);
            mName = (TextView)itemView.findViewById(R.id.view_name);
            mAge = (TextView)itemView.findViewById(R.id.view_age);
            mStatus = (TextView)itemView.findViewById(R.id.view_status);
        }

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_list, container, false);
        mText = (TextView)v.findViewById(R.id.test);

        // recyclerview stuff
        mRecyclerView = (RecyclerView)v.findViewById(R.id.list_recycler);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setStackFromEnd(false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        controller = new Backend();
        mFirebaseDatabaseReference = controller.getDatabaseReference();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Contact, ViewHolder>(Contact.class, R.layout.individual_view, ViewHolder.class, mFirebaseDatabaseReference) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Contact model, int position) {

                viewHolder.mName.setText("Name: " + model.getName());
                viewHolder.mAge.setText("Age: " + model.getAge());

                if (model.isSingle()) {
                    viewHolder.mStatus.setText("Relationship Status: Single");
                } else {
                    viewHolder.mStatus.setText("Relationship Status: In a Relationship");
                }
            }
        };

        // data observer
        mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                int userCount = mFirebaseAdapter.getItemCount();
                int lastVisiblePosition = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisiblePosition == -1 || (positionStart >= (userCount - 1) && lastVisiblePosition == (positionStart -1))) {
                    mRecyclerView.scrollToPosition(positionStart);
                }


            } // onItemRangeInserted ends

        }); // registerDataObserver ends

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mFirebaseAdapter);

        return v;
    }





}
