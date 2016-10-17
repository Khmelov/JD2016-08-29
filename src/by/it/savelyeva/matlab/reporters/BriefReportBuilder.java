package by.it.savelyeva.matlab.reporters;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nato on 10/16/16.
 */
public class BriefReportBuilder extends ReportBuilder {
    private String decoration = "----------------------------------------------";

    @Override
    public void buildHeader() {
        report.setReportHeader("\n" + decoration + "\n\t\t\tExtended Calc Report\n" + decoration + "\n");
    }

    @Override
    public void buildStartTime(Date startDate) {
        report.setStartTime("\t\t" + startDate.toString() + "\n");
    }

    @Override
    public void buildOperation(ArrayList<String> operations) {
        report.setOperations(operations);
    }

    @Override
    public void buildEndTime(Date endDate) {
        report.setEndTime("\n\t\t" + endDate.toString() + "\n" + decoration + "\n");
    }
}
