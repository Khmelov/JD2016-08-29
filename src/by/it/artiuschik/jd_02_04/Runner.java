package by.it.artiuschik.jd_02_04;

import by.it.artiuschik.jd_02_04.mathlab.errors.IncorrectBracketsException;
import by.it.artiuschik.jd_02_04.mathlab.utils.Parser;
import by.it.artiuschik.jd_02_04.mathlab.utils.VarsReader;
import by.it.artiuschik.jd_02_04.mathlab.utils.VarsWriter;
import by.it.artiuschik.jd_02_04.mathlab.vars.Var;

import java.io.IOException;
import java.util.Scanner;

class Runner {
    public static void main(String[] args) {
        try {
            VarsReader.readFromFile("vars.txt");//значения переменных в  hashmap
            Parser parser = new Parser();
            System.out.println("Введите выражение или end");
            while (true) {
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                if (str.toLowerCase().equals("end")) {
                    VarsWriter.writeToFile("vars.txt");

                    break;
                } else {
                    Var var = parser.calc(str);
                    System.out.println(var);
                    VarsWriter.writeToFile("vars.txt");//сохранение
                }

            }
        } catch (IOException|IncorrectBracketsException e) {
            System.out.println(e.getMessage());
        }

    }
}
