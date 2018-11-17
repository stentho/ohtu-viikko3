package ohtu;

import java.util.List;

public class Course {
    
    private String name;
    private int week;
    private String term;
    private int year;
    private String fullName;
    private List<Integer> exercises;

    public String getName() {
        return name;
    }

    public List<Integer> getExercises() {
        return exercises;
    }
    
    public int getExercisesFromWeek(int wk) {
        return exercises.get(wk);
    }
    
    public int getExercisesTotal() {
        int i = 0;
        for (Integer e : exercises) {
            i += e;
        }
        return i;
    }
    
    public int getWeek() {
        return week;
    }

    public String getFullName() {
        return fullName;
    }

    public String getTerm() {
        return term;
    }

    public int getYear() {
        return year;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExercises(List<Integer> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return fullName + " " + term + " " + year;
    }

}
