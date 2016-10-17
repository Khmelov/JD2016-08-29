package by.it.savelyeva.matlab.reporters;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by nato on 10/16/16.
 */
public class ExtendedReportBuilder extends ReportBuilder {

    private String decoration = "#################################################################";

    @Override
    public void buildHeader() {
        report.setReportHeader("\n" + decoration + "\n\t\t\t\t\tExtended Calc Report\n" + decoration + "\n");
    }

    @Override
    public void buildStartTime(Date startDate) {
        report.setStartTime("\t\t\tStarted at: " + startDate.toString() + "\n");
    }

    @Override
    public void buildOperation(ArrayList<String> operations) {
        ArrayList<String> numberedOperations = new ArrayList<>();
        Iterator<String> it = operations.iterator();
        int i = 0;
        while (it.hasNext()) {
            numberedOperations.add(++i + ") " + it.next());
        }
        report.setOperations(numberedOperations);
    }

    @Override
    public void buildEndTime(Date endDate) {
        report.setEndTime("\n\t\t\tFinished at: " + endDate.toString() + "\n" + decoration + "\n");
    }
}
