package by.it.savelyeva.jd_02_04;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by nato on 10/12/16.
 */
public class MainTest {
    @Test
    public void testEmptyHex() {
        String line = "";
        String res = Main.findAllJavaHexNumbers(line);
        assertTrue(res.length() == 0);
    }

    @Test
    public void testOneHex() {
        String line = "0xAfd";
        String res = Main.findAllJavaHexNumbers(line);
        assertTrue(res.indexOf(line) >= 0);
    }

    @Test
    public void testNoHex() {
        String line = "0xAfds";
        String res = Main.findAllJavaHexNumbers(line);
        assertTrue(res.indexOf(line) == -1);
    }

    @Test
    public void testSomeHex() {
        String[] hex = {"0xAB", "0X1111", "0xfffff"};
        String line = hex[0] + " asd 0AB " + hex[1] + " " + hex[2] + " ABC";
        String res = Main.findAllJavaHexNumbers(line);
        for (String h: hex) {
            assertTrue(res.indexOf(h) >= 0);
        }
    }

    @Test
    public void testAllHex() {
        String[] hex = {"0xAB", "0X1111", "0xfffff"};
        StringBuilder line = new StringBuilder("");
        for (String h: hex) line.append(h).append(" ");
        String res = Main.findAllJavaHexNumbers(line.toString());
        for (String h: hex) {
            assertTrue(res.indexOf(h) >= 0);
        }
    }

}
