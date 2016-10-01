package by.it.savelyeva.jd_01_13.matlab.interfaces;

import by.it.savelyeva.jd_01_13.matlab.vars.Var;

/**
 * Created by nato on 9/16/16.
 */
public interface IVariable {
	String toString();
	Var fromString(String s);
}