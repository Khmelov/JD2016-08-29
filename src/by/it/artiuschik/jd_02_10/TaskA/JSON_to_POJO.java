package by.it.artiuschik.jd_02_10.TaskA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSON_to_POJO {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String[] skills = {"meow", "catch mouse", "jump"};
        Cat cat = new Cat("Fluffy", "black",2, skills);
        //маршаллизация
        String json = gson.toJson(cat);
        System.out.print(json);
        //демаршаллизация
        Cat cat2 = gson.fromJson(json, Cat.class);
        System.out.print(System.lineSeparator()+cat2.toString());
    }
}
