package by.it.senchenko.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;


public class TaskATest {
    @Test
    public void add() throws Exception {
        int res = TaskA.add(2, 2);
        assertEquals(4, res, 0.001);
    }

    @Test
    public void sub() throws Exception {
        int res = TaskA.sub(2, 2);
        assertEquals(0, res, 0.001);
    }

    @Test
    public void mul() throws Exception {
        int res = TaskA.mul(2,2);
        assertEquals("Ошибка умножения", 4, res);
    }

    @Test
    public void div() throws Exception {
        int res = TaskA.div(2,2);
        assertEquals("Ошибка деления", 1, res);
    }
}