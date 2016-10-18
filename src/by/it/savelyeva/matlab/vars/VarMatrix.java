package by.it.savelyeva.matlab.vars;

import by.it.savelyeva.matlab.VarDimensionException;
import by.it.savelyeva.matlab.inout.Parser;
import by.it.savelyeva.matlab.interfaces.IVariable;

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
    public Var add(Var var) throws VarDimensionException {
        if (var instanceof VarFloat) {
        	for (int i=0; i<this.value.length; i++) {
            	for (int j=0; j<this.value[0].length; j++) {
            		this.value[i][j] = this.value[i][j] + ((VarFloat) var).getValue();
            	}
            }
            return this;
        }
        else if (var instanceof VarMatrix) {
        	if (((VarMatrix) var).value.length != this.value.length ||
        		((VarMatrix) var).value[0].length != this.value[0].length)
        	    throw new VarDimensionException("Cannot add matrices: dimensions not match.");

        	for (int i=0; i<this.value.length; i++) {
            	for (int j=0; j<this.value[0].length; j++) {
            		this.value[i][j] = this.value[i][j] + ((VarMatrix) var).value[i][j];
            	}
            }
            return this;
        }
        else return super.add(this);
    }

    @Override
    public Var sub(Var var) throws VarDimensionException {
        if (var instanceof VarFloat) {
        	for (int i=0; i<this.value.length; i++) {
            	for (int j=0; j<this.value[0].length; j++) {
            		this.value[i][j] = this.value[i][j] - ((VarFloat) var).getValue();
            	}
            }
            return this;
        }
        else if (var instanceof VarMatrix) {
            if (((VarMatrix) var).value.length != this.value.length ||
        		((VarMatrix) var).value[0].length != this.value[0].length)
                throw new VarDimensionException("Cannot subtract matrices: dimensions not match.");

        	for (int i=0; i<this.value.length; i++) {
            	for (int j=0; j<this.value[0].length; j++) {
            		this.value[i][j] = this.value[i][j] - ((VarMatrix) var).value[i][j];
            	}
            }
            return this;
        }
        else return super.sub(this);
    }
 
    @Override
    public Var mul(Var var) throws VarDimensionException {
        if (var instanceof VarFloat) {
        	for (int i=0; i<this.value.length; i++) {
            	for (int j=0; j<this.value[0].length; j++) {
            		this.value[i][j] = this.value[i][j] * ((VarFloat) var).getValue();
            	}
            }
            return this;
        }
        else if (var instanceof VarVector) {
            if (this.value[0].length != ((VarVector) var).getValue().length)
                throw new VarDimensionException("Cannot multiply matrix*vector: dimensions not match.");

            double[] v = new double[this.value.length];
            VarVector res = new VarVector(v);
            for (int i=0; i<this.value.length; i++) {
             	for (int k=0; k<this.value[0].length; k++)
            		res.getValue()[i] += this.value[i][k] * ((VarVector) var).getValue()[k];
            }
            return res;
        }
        else if (var instanceof VarMatrix) {
            if (this.value[0].length != ((VarMatrix) var).value.length)
                throw new VarDimensionException("Cannot multiply matrices: dimensions not match.");

            double[][] v = new double[this.value.length][((VarMatrix) var).value[0].length];
            VarMatrix res = new VarMatrix(v);
            for (int i=0; i<this.value.length; i++) {
                for (int j = 0; j<((VarMatrix) var).value[0].length; j++) {
                	for (int k=0; k<this.value[0].length; k++)
                		res.value[i][j] += this.value[i][k] * ((VarMatrix) var).value[k][j];
                }
            }
            return res;
        }
        else return super.mul(this);
    }

    @Override
    public Var div(Var var) throws ArithmeticException {
        if (var instanceof VarFloat) {
            if ((int)((VarFloat) var).getValue() == 0)
                throw new ArithmeticException("Caught error: division by zero!");

            for (int i=0; i<this.value.length; i++) {
                for (int j=0; j<this.value[0].length; j++) {
                    this.value[i][j] = this.value[i][j] / ((VarFloat) var).getValue();
                }
            }
            return this;
        }
        else return super.div(this);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for (int i=0; i<value.length; i++) {
            res.append(Arrays.toString(value[i]).replace(" ",""));
            if (i<value.length-1) res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    public static Var fromString(String s) {
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
