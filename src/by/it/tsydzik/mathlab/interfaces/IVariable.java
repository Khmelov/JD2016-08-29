package by.it.tsydzik.mathlab.interfaces;


import by.it.tsydzik.mathlab.vars.Var;

/**
 * @author Eugene Tsydzik
 * @since 09/24/16.
 */
public interface IVariable {
	String toString();

	Var fromString(String s);
}