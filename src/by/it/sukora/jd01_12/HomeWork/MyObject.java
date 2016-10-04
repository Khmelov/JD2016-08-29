package by.it.sukora.jd01_12.HomeWork;

public class MyObject implements Comparable<MyObject>{
    private String objectName;
    private int code;
    MyObject(String name, int code)
    {
        this.objectName=name;
        this.code=code;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "objectName='" + objectName + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public int compareTo(MyObject o) {
        return Integer.compare(code,o.code);
    }

    public String getObjectName() {
        return objectName;
    }

    public int getCode() {
        return code;
    }
}
