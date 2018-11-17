package ohtu;

import java.util.List;

public class Submission {

    private int week;
    private int hours;
    private List<String> exercises;
    private String course;

    public String getCourse() {
        return course;
    }

    public List<String> getExercises() {
        return exercises;
    }

    public int getHours() {
        return hours;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setExercises(List<String> exercises) {
        this.exercises = exercises;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return course + ", viikko " + week + " tehtyjä tehtäviä yhteensä " + exercises.size() + " aikaa kului " + hours + " tehdyt tehävät: " + exercises.toString();
    }

}
