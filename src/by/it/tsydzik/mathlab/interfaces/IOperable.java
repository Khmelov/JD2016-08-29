package by.it.tsydzik.mathlab.interfaces;

import by.it.tsydzik.mathlab.vars.Var;

/**
 * @author Eugene Tsydzik
 * @since 09/24/16.
 */
public interface IOperable {
	Var sub(Var var);

	Var add(Var var);

	Var div(Var var);

	Var mul(Var var);
}