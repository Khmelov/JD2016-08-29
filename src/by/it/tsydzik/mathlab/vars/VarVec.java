package by.it.tsydzik.mathlab.vars;


import by.it.tsydzik.mathlab.interfaces.IVariable;
import by.it.tsydzik.mathlab.patterns.Patterns;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eugene Tsydzik
 * @since 09/24/16.
 */
public class VarVec extends Var implements IVariable {

	private double[] value;

	public VarVec(double[] value) {
		this.value = value;
	}

	public VarVec(String s) {
		this.value = ((VarVec) fromString(s)).value;
	}

	public void setValue(double[] value) {
		this.value = value;
	}

	public double[] getValue() {
		return this.value;
	}

	@Override
	public Var sub(Var var) {
		if (var instanceof VarFloat) {
			VarVec res = new VarVec(value);
			for (int i = 0; i < value.length; i++) {
				res.value[i] = res.value[i] - ((VarFloat) var).getValue();
			}
			return res;
		} else if (var instanceof VarVec) {
			if (((VarVec) var).value.length != value.length) {
				return super.sub(this);
			}
			VarVec res = new VarVec(value);
			for (int i = 0; i < value.length; i++) {
				res.value[i] = res.value[i] - ((VarVec) var).value[i];
			}
			return res;
		} else return super.sub(this);
	}

	@Override
	public Var add(Var var) {
		if (var instanceof VarFloat) {
			VarVec res = new VarVec(value);
			for (int i = 0; i < value.length; i++) {
				res.value[i] = res.value[i] + ((VarFloat) var).getValue();
			}
			return res;
		} else if (var instanceof VarVec) {
			if (((VarVec) var).value.length != value.length) {
				return super.add(this);
			}
			VarVec res = new VarVec(value);
			for (int i = 0; i < value.length; i++) {
				res.value[i] = res.value[i] + ((VarVec) var).value[i];
			}
			return res;
		} else return super.add(this);
	}


	@Override
	public Var mul(Var var) {
		if (var instanceof VarFloat) {
			VarVec res = new VarVec(value);
			for (int i = 0; i < value.length; i++) {
				res.value[i] = res.value[i] * ((VarFloat) var).getValue();
			}
			return res;
		} else if (var instanceof VarVec) {
			if (value.length != ((VarVec) var).value.length) {
				return super.mul(this);
			}
			double[] v = new double[1];
			VarVec res = new VarVec(v);
			for (int i = 0; i < value.length; i++) {
				res.value[0] += value[i] * ((VarVec) var).value[i];
			}
			return res;
		} else return super.mul(this);
	}

	@Override
	public Var div(Var var) {
		if (var instanceof VarFloat) {
			VarVec res = new VarVec(value);
			for (int i = 0; i < value.length; i++) {
				res.value[i] = res.value[i] / ((VarFloat) var).getValue();
			}
			return res;
		} else return super.div(this);
	}

	@Override
	public String toString() {
		return Arrays.toString(value);
	}

	@Override
	public Var fromString(String s) {
		String[] elem = s.split(Patterns.SPLITTER);
		double[] res = new double[elem.length];
		Matcher m = Pattern.compile(Patterns.PATTERN_FLOAT).matcher(s);
		int i = 0;
		while (m.find()) {
			res[i] = Double.parseDouble(m.group());
			i++;
		}
		return new VarVec(res);
	}
}
