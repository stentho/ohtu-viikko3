package ohtu;

import java.util.List;

public class Submission {

    private int week;
    private int hours;
    private List<Integer> exercises;
    private String course;
    private Course attachedCourse;

    public String getCourse() {
        return course;
    }

    public Course getAttachedCourse() {
        return attachedCourse;
    }

    public List<Integer> getExercises() {
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

    public void setAttachedCourse(Course attachedCourse) {
        this.attachedCourse = attachedCourse;
    }

    public void setExercises(List<Integer> exercises) {
        this.exercises = exercises;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "viikko " + week + ":\n tehtyjä tehtäviä yhteensä " + exercises.size() + "/" + attachedCourse.getExercisesFromWeek(week) +" aikaa kului " + hours + " tehdyt tehävät: " + exercises.toString();
    }

}
