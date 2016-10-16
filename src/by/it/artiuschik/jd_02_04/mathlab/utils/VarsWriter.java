package by.it.artiuschik.jd_02_04.mathlab.utils;

import by.it.artiuschik.jd_02_04.mathlab.data.Vars;
import by.it.artiuschik.jd_02_04.mathlab.vars.Var;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class VarsWriter {
    public static void writeToFile(String fileName) throws IOException {
        String path = System.getProperty("user.dir") +
                "/src/by/it/artiuschik/jd_02_04/mathlab/data/" + fileName;
        try (PrintWriter printer = new PrintWriter(new FileWriter(path))) {
            for (Map.Entry<String, Var> entry : Vars.vars.entrySet()) {
                printer.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            throw new IOException("Not write " + fileName, e);
        }
    }

    public static void writeToConsole() {
        for (Map.Entry<String, Var> entry : Vars.vars.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
