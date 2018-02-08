package org.writing.jumpstart.jumpstart2017;

public class Project {
    private String title;
    private String deadline;
    private int percent;

    public Project() {}

    public Project(String name, String numOfSongs, int percent) {
        this.title = name;
        this.deadline = numOfSongs;
        this.percent = percent;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
    public String getDeadline(){return deadline;}
    public void setDeadline(String deadline){
        this.deadline = deadline;
    }
}
