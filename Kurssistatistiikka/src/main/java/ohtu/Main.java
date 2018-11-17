package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url1 = "https://studies.cs.helsinki.fi/courses/students/" + studentNr + "/submissions";
        String url2 = "https://studies.cs.helsinki.fi/courses/courseinfo";

        String submissionsText = Request.Get(url1).execute().returnContent().asString();
        String coursesText = Request.Get(url2).execute().returnContent().asString();

        System.out.println("opiskelijanumero " + studentNr + "\n");

        Gson mapper = new Gson();
        Course[] courses = mapper.fromJson(coursesText, Course[].class);
        Submission[] subs = mapper.fromJson(submissionsText, Submission[].class);

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

        }
    }
}
