package by.it.artiuschik.mathlab.report;

import by.it.artiuschik.mathlab.Runner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Map;


public class ShortReportBuilder extends ReportBuilder{
    @Override
    public void writeReport() {
        try (PrintWriter printer = new PrintWriter(new FileWriter(report.getPathToFile()))){
            printer.println("Start: " + report.getStart());
                for (Map.Entry<String, String> entry : report.getOperationsResults().entrySet()) {
                    printer.println(entry.getKey()+"->"+entry.getValue());

                }
            printer.println("End: " + report.getEnd());
            printer.println("Amount of operations: " + report.getOperationsResults().keySet().size());
        }
        catch (IOException e) {
            Runner.logger.writeToLogfile("Error during Report writing","log.txt");
        }
    }

    @Override
    public void createReportName() {
        report.setReportName("Short version of report about mathlab working");
    }

    @Override
    public void setReportStart() {
        report.setStart(new SimpleDateFormat("yyyy.MM").format(Runner.start));

    }

    @Override
    public void setReportEnd() {
        report.setEnd(new SimpleDateFormat("yyyy.MM").format(Runner.end));


    }

    @Override
    public void setReportOperations() {
        report.setOperationsResults(Runner.operResults);

    }
}
