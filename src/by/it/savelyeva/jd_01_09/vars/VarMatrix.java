package by.it.savelyeva.jd_01_09.vars;

import by.it.savelyeva.jd_01_09.inout.Parser;
import by.it.savelyeva.jd_01_09.interfaces.IVariable;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by nato on 9/16/16.
 */
public class VarMatrix extends Var implements IVariable {

	private double[][] value;

    public VarMatrix(double[][] value) {
        this.value = value;
    }

    public VarMatrix(String s) { this.value = ((VarMatrix) fromString(s)).value; }

    public void setValue(double[][] value) { this.value = value; }

    public double[][] getValue() { return this.value; }

    @Override
    public Var add(Var var) {
        if (var instanceof VarFloat) {
        	VarMatrix res = new VarMatrix(value);
            for (int i=0; i<value.length; i++) {
            	for (int j=0; j<value[0].length; j++) {
            		res.value[i][j] = res.value[i][j] + ((VarFloat) var).getValue();
            	}
            }
            return res;
        }
        else if (var instanceof VarMatrix) { 
        	if (((VarMatrix) var).value.length != value.length ||
        		((VarMatrix) var).value[0].length != value[0].length) return super.add(this);
        	VarMatrix res = new VarMatrix(value);
            for (int i=0; i<value.length; i++) {
            	for (int j=0; j<value[0].length; j++) {
            		res.value[i][j] = res.value[i][j] + ((VarMatrix) var).value[i][j];
            	}
            }
            return res;
        }
        else return super.add(this);
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof VarFloat) {
        	VarMatrix res = new VarMatrix(value);
            for (int i=0; i<value.length; i++) {
            	for (int j=0; j<value[0].length; j++) {
            		res.value[i][j] = res.value[i][j] - ((VarFloat) var).getValue();
            	}
            }
            return res;
        }
        else if (var instanceof VarMatrix) { 
            if (((VarMatrix) var).value.length != value.length ||
        		((VarMatrix) var).value[0].length != value[0].length) return super.sub(this);
        	VarMatrix res = new VarMatrix(value);
            for (int i=0; i<value.length; i++) {
            	for (int j=0; j<value[0].length; j++) {
            		res.value[i][j] = res.value[i][j] - ((VarMatrix) var).value[i][j];
            	}
            }
            return res;
        }
        else return super.sub(this);
    }
 
    @Override
    public Var mul(Var var) {
        if (var instanceof VarFloat) {
        	VarMatrix res = new VarMatrix(value);
            for (int i=0; i<value.length; i++) {
            	for (int j=0; j<value[0].length; j++) {
            		res.value[i][j] = res.value[i][j] * ((VarFloat) var).getValue();
            	}
            }
            return res;
        }
        else if (var instanceof VarVector) {
            if (value[0].length != ((VarVector) var).getValue().length) return super.mul(this);
            double[] v = new double[value.length];
            VarVector res = new VarVector(v);
            for (int i=0; i<value.length; i++) {
             	for (int k=0; k<value[0].length; k++)
            		res.getValue()[i] += value[i][k] * ((VarVector) var).getValue()[k];
            }
            return res;     	
        }
        else if (var instanceof VarMatrix) {
            if (value[0].length != ((VarMatrix) var).value.length) return super.mul(this);
            double[][] v = new double[value.length][((VarMatrix) var).value[0].length];
            VarMatrix res = new VarMatrix(v);
            for (int i=0; i<value.length; i++) {
                for (int j=0; j<((VarMatrix) var).value[0].length; j++) {
                	for (int k=0; k<value[0].length; k++)
                		res.value[i][j] += value[i][k] * ((VarMatrix) var).value[k][j];
                }
            }
            return res;     	
        }
        else return super.mul(this);
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarFloat) {
        	VarMatrix res = new VarMatrix(value);
            for (int i=0; i<value.length; i++) {
            	for (int j=0; j<value[0].length; j++) {
            		res.value[i][j] = res.value[i][j] / ((VarFloat) var).getValue();
            	}
            }
            return res;
        }
        else return super.div(this);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for (int i=0; i<value.length; i++) {
            res.append(Arrays.toString(value[i]));
            if (i<value.length-1) res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    @Override
    public Var fromString(String s) {
        String[] rows = s.split(Parser.splitterMatrix);
        double[][] res = new double[rows.length][rows[0].split(Parser.splitterVector).length];
        Pattern pattern = Pattern.compile(Parser.patternFloat);
        Matcher matcher;
        for (int i=0; i<rows.length; i++) {
            String[] elems = rows[i].split(Parser.splitterVector);
            for (int j=0; j<elems.length; j++) {
                StringBuilder sbe = new StringBuilder(elems[j].replaceAll("[\\[{}\\]]",""));
                matcher = pattern.matcher(sbe);
                if (matcher.find()) {
                    res[i][j] = Double.parseDouble(matcher.group());
                }
            }
        }
        return (Var) new VarMatrix(res);
    }

}
