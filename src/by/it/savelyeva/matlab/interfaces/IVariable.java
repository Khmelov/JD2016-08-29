package by.it.savelyeva.matlab.interfaces;

import by.it.savelyeva.matlab.vars.Var;

/**
 * Created by nato on 9/16/16.
 */
public interface IVariable {
	String toString();
	Var fromString(String s);
}