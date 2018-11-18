package ohtu;

import java.util.List;

public class Stats {
    
    private int students;
    private double hour_total;
    private int exercise_total;
    private List<Integer> hours;
    private List<Integer> exercises;

    public Integer getStudents() {
        return students;
    }

    public double getHour_total() {
        return hour_total;
    }

    public int getExercise_total() {
        return exercise_total;
    }

    public List<Integer> getHours() {
        return hours;
    }

    public List<Integer> getExercises() {
        return exercises;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public void setHour_total(double hour_total) {
        this.hour_total = hour_total;
    }

    public void setExercise_total(int exercise_total) {
        this.exercise_total = exercise_total;
    }

    public void setHours(List<Integer> hours) {
        this.hours = hours;
    }
    
    public void setExercises(List<Integer> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return students + ", " + exercise_total + ", " + hour_total;
    }

}
