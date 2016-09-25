package by.it.tsydzik.mathlab.vars;

import by.it.tsydzik.mathlab.error.Error;
import by.it.tsydzik.mathlab.interfaces.IOperable;

/**
 * @author Eugene Tsydzik
 * @since 09/24/16.
 */
public abstract class Var implements IOperable {
	@Override
	public Var sub(Var var) {
		new Error("Substraction is impossible");
		return null;
	}

	@Override
	public Var add(Var var) {
		new Error("Addition is impossible");
		return null;
	}

	@Override
	public Var div(Var var) {
		new Error("Division is impossible");
		return null;
	}

	@Override
	public Var mul(Var var) {
		new Error("Multiplication is impossible");
		return null;
	}
}
