package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url1 = "https://studies.cs.helsinki.fi/courses/students/" + studentNr + "/submissions";
        String url2 = "https://studies.cs.helsinki.fi/courses/courseinfo";
        String url3 = "https://studies.cs.helsinki.fi/courses/ohtu2018/stats";
        String url4 = "https://studies.cs.helsinki.fi/courses/rails2018/stats";

        String submissionsText = Request.Get(url1).execute().returnContent().asString();
        String coursesText = Request.Get(url2).execute().returnContent().asString();
        String ohtuResponse = Request.Get(url3).execute().returnContent().asString();
        String railsResponse = Request.Get(url4).execute().returnContent().asString();

        JsonParser parser = new JsonParser();
        JsonObject ohtuData = parser.parse(ohtuResponse).getAsJsonObject();
        JsonObject railsData = parser.parse(railsResponse).getAsJsonObject();

        System.out.println("opiskelijanumero " + studentNr + "\n");

        Gson mapper = new Gson();
        Course[] courses = mapper.fromJson(coursesText, Course[].class);
        Submission[] subs = mapper.fromJson(submissionsText, Submission[].class);

        ArrayList<Stats> ohtuStats = new ArrayList<>();
        ArrayList<Stats> railsStats = new ArrayList<>();

        for (Entry<String, JsonElement> s : ohtuData.entrySet()) {
            Stats stat = mapper.fromJson(s.getValue().toString(), Stats.class);
            ohtuStats.add(stat);
        }

        for (Entry<String, JsonElement> s : railsData.entrySet()) {
            Stats stat = mapper.fromJson(s.getValue().toString(), Stats.class);
            railsStats.add(stat);
        }

        for (Course course : courses) {

            System.out.println(course);

            int exercisesDone = 0;
            int exercisesTotal = course.getExercisesTotal();
            int hoursTotal = 0;

            for (Submission submission : subs) {
                if (!submission.getCourse().equals(course.getName())) {
                    continue;
                }
                submission.setAttachedCourse(course);

                exercisesDone += submission.getExercises().size();
                hoursTotal += submission.getHours();
                System.out.println(submission);
            }
            System.out.println("\nyhteensä: " + exercisesDone + "/" + exercisesTotal + " tehtävää " + hoursTotal + " tuntia\n");

            int students = 0;
            int exercises = 0;
            double hours = 0;

            if (course.getName().equals("ohtu2018")) {

                for (Stats stat : ohtuStats) {
                    students += stat.getStudents();
                    exercises += stat.getExercise_total();
                    hours += stat.getHour_total();
                }
            }

            if (course.getName().equals("rails2018")) {

                for (Stats stat : railsStats) {
                    students += stat.getStudents();
                    exercises += stat.getExercise_total();
                    hours += stat.getHour_total();
                }
            }
            
            System.out.println("kurssilla yhteensä " + students + " palautusta, palautettuja tehtäviä " + exercises + " kpl, aikaa käytetty yhteensä " + hours + " tuntia\n");
        }
    }
}
