package com.example.cue;



public class Course {

    // [EDIT]
    private String name;
    private String description;
    private String uni;
    private String location;
    private boolean topuni;
    private boolean dis;
    private boolean scholar;
    private boolean saved;

    private boolean expanded;

    public Course(String name, String uni, String description, String location, boolean topuni, boolean dis, boolean scholar, boolean saved){
        this.name = name;
        this.uni = uni;
        this.description = description;
        this.location = location;
        this.topuni = topuni;
        this.dis = dis;
        this.scholar = scholar;
        this.saved = saved;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public String getLocation(){
        return location;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isScholar() {
        return scholar;
    }

    public void setScholar(boolean scholar) {
        this.scholar = scholar;
    }

    public boolean isDis() {
        return dis;
    }

    public void setDis(boolean dis) {
        this.dis = dis;
    }

    public boolean isTopuni() {
        return topuni;
    }

    public void setTopuni(boolean topuni) {
        this.topuni = topuni;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public void setName(String name){
        this.name=name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

}
