package by.it.tsiamruk.jd03_02;

import java.util.Scanner;

/**
 * Created by waldemar on 30/10/2016.
 */
public class Run {
    public static void main(String[] args) {
        //Task A
        //Программа поиска
        Scanner scanner = new Scanner(System.in);
        String searchReq;
        while ((searchReq=scanner.nextLine()) !=null){
            RoleSearch.roleSearch(searchReq);
        }
//        CRUDProgramm.crudProgramm();

    }
}
