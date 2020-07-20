package com.example.cue;

public class Chat {

    // [EDIT]
    private String name;
    private String  course;
    private String uni;
    private String data;


    private boolean expanded;

    public Chat(String name, String uni, String course, String data, boolean expanded){
        this.name = name;
        this.uni = uni;
        this.course = course;
        this.data=data;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getUni(){
        return uni;
    }

    public void setUni(String uni){
        this.uni = uni;
    }

    public String getName(){
        return name;
    }
    public String getCourse(){
        return course;
    }
    public String getData(){
        return data;
    }



}
