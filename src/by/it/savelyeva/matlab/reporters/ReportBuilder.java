package by.it.savelyeva.matlab.reporters;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nato on 10/16/16.
 */
public abstract class ReportBuilder {
    Report report;

    Report getReport() {
        return report;
    }

    public Report createNewReport() {
        report = new Report();
        return report;
    }

    public abstract void buildHeader();
    public abstract void buildStartTime(Date startDate);
    public abstract void buildOperation(ArrayList<String> operations);
    public abstract void buildEndTime(Date endDate);

}
