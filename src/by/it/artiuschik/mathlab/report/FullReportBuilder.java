package by.it.artiuschik.mathlab.report;

import by.it.artiuschik.mathlab.Runner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class FullReportBuilder extends ReportBuilder {
    @Override
    public void writeReport() {
        try (PrintWriter printer = new PrintWriter(new FileWriter(report.getPathToFile()))) {
            printer.println("Start: " + report.getStart());
            for (Map.Entry<String, String> entry : report.getOperationsResults().entrySet()) {
                printer.println("Operation: " + entry.getKey() + "\nResult: " + entry.getValue());

            }
            printer.println("End: " + report.getEnd());
            printer.println("Amount of operations: " + report.getOperationsResults().keySet().size());
        } catch (IOException e) {
            Runner.logger.writeToLogfile("Error during Report writing", "log.txt");
        }
    }

    @Override
    public void createReportName() {
        report.setReportName("It is full version of report about mathlab version 1.0 working");
    }

    @Override
    public void setReportStart() {
        report.setStart(Runner.start.toString());


    }

    @Override
    public void setReportEnd() {
        report.setEnd(Runner.end.toString());

    }

    @Override
    public void setReportOperations() {
        report.setOperationsResults(Runner.operResults);

    }

}
