package by.it.sukora.JD1_09.enu;

public enum PageStyle {
    Roman, Novell, Issue, Code;

    public int getMinPages() {
    // минимальное число страниц
        switch (this) {
            case Roman: return 100;
            case Novell: return 200;
            case Issue: return 5;
            case Code: return 1;
            default: return 0;
        } //switch
    } //getMinPages

} //enum
