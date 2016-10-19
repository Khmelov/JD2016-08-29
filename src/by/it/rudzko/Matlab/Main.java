package by.it.rudzko.Matlab;

import by.it.rudzko.Matlab.Interfaces.IMessages;
import by.it.rudzko.Matlab.ReportBuilder.FullReportBuilder;
import by.it.rudzko.Matlab.ReportBuilder.Reporter;
import by.it.rudzko.Matlab.ReportBuilder.ReportBuilder;
import by.it.rudzko.Matlab.ReportBuilder.ShortReportBuilder;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Parser p1 = new Parser("{{1,2}, {8,3}}-2");
            p1.goParse();
            Parser p2 = new Parser("{{1,2}, {8,3}}*{1,2}-{1,2}");
            p2.goParse();
            Parser p3 = new Parser("{{1,2}, {8,3}}*{{1,2}, {8,3}}");
            p3.goParse();
            Parser p4 = new Parser("{{1,2}, {8,3}}+{{1,2}, {8,3}}");
            p4.goParse();
            Parser p5 = new Parser("1+16*(39-3)/(3+3)");
            p5.goParse();
            Parser p6 = new Parser("{4,2}*{{1,3}, {2,0}}");
            p6.goParse();

            System.out.println(IMessages.ENTER_DATA);
            String s;
            while (!(s=new Scanner(System.in).nextLine().toLowerCase()).equals("end")) {
                Parser p = new Parser(s);
                p.goParse();
            }

            System.out.println(IMessages.ERRORS);
            Parser p7 = new Parser("{3,5}/{0,0}");
            p7.goParse();

            Reporter reporter=new Reporter();
            ReportBuilder rb=new ShortReportBuilder();
            reporter.setReportBuilder(rb);
            reporter.constructReport();
            ReportBuilder rb2=new FullReportBuilder();
            reporter.setReportBuilder(rb2);
            reporter.constructReport();

        } catch (RuntimeException e) {
            Logger log=Logger.getInstance();
            log.printError(IMessages.WRONG_DATA);
            System.out.println(IMessages.WRONG_DATA);
        }
    }
}



