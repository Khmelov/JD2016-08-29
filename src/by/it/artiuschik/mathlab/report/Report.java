package by.it.artiuschik.mathlab.report;
import java.util.Date;
import java.util.HashMap;

public class Report {
    private String reportName;
    private String start = new Date().toString();
    private String end = new Date().toString();
    private HashMap<String, String> operationsResults = null;
    private String pathToFile;
    void setPathToFile(String fileName) {
        String src = System.getProperty("user.dir");
        pathToFile = src + "/src/by/it/artiuschik/mathlab/out/"+fileName;
    }

    String getPathToFile() {
        return pathToFile;
    }

    void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    void setOperationsResults(HashMap<String, String> operationsResults) {
        this.operationsResults = operationsResults;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    HashMap<String, String> getOperationsResults() {
        return operationsResults;
    }
}
