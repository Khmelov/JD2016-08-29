package by.it.savelyeva.matlab.reporters;

import java.util.ArrayList;

/**
 * Created by nato on 10/16/16.
 */
public class Report {
    private String reportHeader = "";
    private String startTime = "";
    private String endTime = "";
    private ArrayList<String> operations = new ArrayList<>();

    public void setReportHeader(String reportHeader) {
        this.reportHeader = reportHeader;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setOperations(ArrayList<String> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        for (String operation: operations) {
            sb.append(operation + "\n");
        }
        String reportStr = reportHeader + "\n" + startTime + sb.toString() + endTime + "\n";
        return reportStr;
    }
}
