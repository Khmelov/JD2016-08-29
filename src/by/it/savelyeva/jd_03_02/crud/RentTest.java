package by.it.savelyeva.jd_03_02.crud;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

/**
 * Created by nato on 10/29/16.
 */
public class RentTest {
    @Test
    public void testCreate() {
        Rent resRent = null;
        Rent rent = new Rent(6, 3, 5, "2009-10-21", "2009-10-25", 50, true);
        RentCRUD rentCRUD = new RentCRUD();
        try {
            resRent = rentCRUD.create(rent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(resRent.equals(rent));
    }

    @Test
    public void testRead() {
        Rent resRent = null;
        Rent rent = new Rent(6, 3, 5, "2009-10-21", "2009-10-25", 50, true);
        RentCRUD rentCRUD = new RentCRUD();
        try {
            rentCRUD.create(rent);
            resRent = rentCRUD.read(rent.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(resRent.equals(rent));
    }

    @Test
    public void testUpdate() {
        Rent resRent = null;
        Rent rent = new Rent(6, 3, 5, "2009-10-21", "2009-10-25", 50, true);
        RentCRUD rentCRUD = new RentCRUD();
        try {
            rentCRUD.create(rent);
            rent.setEndDate("2009-10-30");
            resRent = rentCRUD.update(rent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(resRent.equals(rent));
    }

    @Test
    public void testDelete() {
        boolean res = false;
        Rent rent = new Rent(6, 3, 5, "2009-10-21", "2009-10-25", 50, true);
        RentCRUD rentCRUD = new RentCRUD();
        try {
            rentCRUD.create(rent);
            res = rentCRUD.delete(rent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(res);
    }
}
