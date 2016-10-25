package by.it.savelyeva.jd_02_10.TaskA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by nato on 10/22/16.
 */
public class TaskA {

    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static String marshalling() {
        String[] books = {"A Connecticut Yankee in King Arthur's Court", "The Prince and the Pauper",
                "The Adventures of Tom Sawyer", "Adventures of Huckleberry Finn"};
        Author author = new Author("Mark Twain", books);

        String jsonStr = gson.toJson(author);
        return jsonStr;
    }

    public static void unmarshalling(String jsonStr) {
        Author author = gson.fromJson(jsonStr, Author.class);
        System.out.printf("\nAuthor POJO = %s\n\n", author.toString());
        }
    }




