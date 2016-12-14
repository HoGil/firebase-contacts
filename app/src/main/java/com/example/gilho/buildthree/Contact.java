package com.example.gilho.buildthree;

/**
 * Created by gilho on 24/11/16.
 */
public class Contact {

    private int id;
    private String name;
    private String age;
    private boolean single;

    public Contact() {}

    public Contact(int id, String name, String age, boolean single) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.single = single;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }
}
