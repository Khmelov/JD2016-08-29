package by.it.savelyeva.matlab.interfaces;

import by.it.savelyeva.matlab.vars.Var;

/**
 * Created by nato on 9/16/16.
 */
public interface IVariable {
	String toString();

	/**
	 * @since Java 1.8 (static methods are supported in interfaces in Java 1.8)
	 */
	static Var fromString(String s) {
		return null;
	}
}