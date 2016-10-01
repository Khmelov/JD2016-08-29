package by.it.artiuschik.jd_01_13;

import by.it.artiuschik.jd_01_08.IncorrectBookPageException;
import by.it.artiuschik.jd_01_08.ReferenceBook;

public class TaskC {
    public static void main(String[] args)
    {
        try {
            ReferenceBook book = new ReferenceBook("Справочник по математике", 2005, 500, "Математика", "Иванов В.С.");
            book.open(-1);
        }
        catch(IncorrectBookPageException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
