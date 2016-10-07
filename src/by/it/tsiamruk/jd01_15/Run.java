package by.it.tsiamruk.jd01_15;

/**
 * Created by waldemar on 07/10/2016.
 */
public class Run {
    public static void main(String[] args) {
        System.out.printf("Task A%n%n");
        TaskA.taskA();
        System.out.printf("%nTask B%n%n");
        StringBuilder task = TaskB.readToStringBuilder();
        //get lines
        StringBuilder getindex = TaskB.indexator(task);
        TaskB.consolePrint(getindex);
        TaskB.filePrint(TaskB.filePath(), getindex);
        System.out.printf("%nTask C%n%n");
        TaskC.console(TaskC.pathToStartCat());

    }
}
