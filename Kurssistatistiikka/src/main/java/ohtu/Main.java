package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("opiskelijanumero " + studentNr + "\n");

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        int exercisesTotal = 0;
        int hoursTotal = 0;
        
        for (Submission submission : subs) {
            exercisesTotal += submission.getExercises().size();
            hoursTotal += submission.getHours();
            System.out.println(submission);
        }
        
        System.out.println("\nyhteensä: " + exercisesTotal + " tehtävää " + hoursTotal + " tuntia");
    }
}