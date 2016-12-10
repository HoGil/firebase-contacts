package com.example.gilho.buildthree;

/**
 * Created by gilho on 24/11/16.
 */
public class Person {

    private String id;
    private String name;
    private String age;
    private boolean single;

    public Person() {}

    public Person(String id, String name, String age, boolean single) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.single = single;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
