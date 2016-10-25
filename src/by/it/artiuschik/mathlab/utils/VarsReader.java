package by.it.artiuschik.mathlab.utils;
import by.it.artiuschik.mathlab.data.*;

import by.it.artiuschik.mathlab.vars.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VarsReader {
    public static void readFromFile(String fileName) throws IOException {
        String path = System.getProperty("user.dir") +
                "/src/by/it/artiuschik/mathlab/data/" + fileName;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            String varName;
            String strVar;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\\s", "");
                varName = line.split("=")[0];
                strVar = line.split("=")[1];
                if (strVar.matches(Patterns.exMat)) {
                    ApplicationData.vars.put(varName, new VarM(strVar));
                } else if (strVar.matches(Patterns.exVec)) {
                    ApplicationData.vars.put(varName, new VarV(strVar));
                } else if (strVar.matches(Patterns.exVal)) {
                    ApplicationData.vars.put(varName, new VarF(strVar));
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File for reading not found");
        } catch (IOException e) {
            throw new IOException("Input-output error!");
        }

    }
}
