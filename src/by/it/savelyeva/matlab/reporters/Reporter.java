package by.it.savelyeva.matlab.reporters;

import java.util.Date;
import java.util.ArrayList;
/**
 * Created by nato on 10/16/16.
 */
public class Reporter {

    private ReportBuilder reportBuilder;

    public void setReportBuilder(ReportBuilder rb) {
        reportBuilder = rb;
    }

    public Report getReport() {
        return reportBuilder.getReport();
    }

    public void constructReport(Date startDate, ArrayList<String> operations, Date endDate) {
        Report report = reportBuilder.createNewReport();
        reportBuilder.buildHeader();
        reportBuilder.buildStartTime(startDate);
        reportBuilder.buildOperation(operations);
        reportBuilder.buildEndTime(endDate);
        System.out.println(report);
    }
}
