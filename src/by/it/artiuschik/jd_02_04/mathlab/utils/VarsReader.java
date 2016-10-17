package by.it.artiuschik.jd_02_04.mathlab.utils;

import by.it.artiuschik.jd_02_04.mathlab.data.Vars;
import by.it.artiuschik.jd_02_04.mathlab.vars.VarF;
import by.it.artiuschik.jd_02_04.mathlab.vars.VarM;
import by.it.artiuschik.jd_02_04.mathlab.vars.VarV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VarsReader {
    public static void readFromFile(String fileName) throws IOException {
        String path = System.getProperty("user.dir") +
                "/src/by/it/artiuschik/jd_02_04/mathlab/data/" + fileName;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            String varName;
            String strVar;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\\s", "");
                varName = line.split("=")[0];
                strVar = line.split("=")[1];
                if (strVar.matches(Patterns.exMat)) {
                    Vars.vars.put(varName, new VarM(strVar));
                } else if (strVar.matches(Patterns.exVec)) {
                    Vars.vars.put(varName, new VarV(strVar));
                } else if (strVar.matches(Patterns.exVal)) {
                    Vars.vars.put(varName, new VarF(strVar));
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File for reading not found");
        } catch (IOException e) {
            throw new IOException("Input-output error!");
        }

    }
}
