package by.it.savelyeva.jd_01_09.vars;

import by.it.savelyeva.jd_01_09.inout.Parser;
import by.it.savelyeva.jd_01_09.interfaces.IVariable;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by nato on 9/16/16.
 */
public class VarVector extends Var implements IVariable {

    private double[] value;

    public VarVector(double[] value) {
        this.value = value;
    }

    public VarVector(String s) {
        this.value = ((VarVector) fromString(s)).value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    public double[] getValue() {
        return this.value;
    }

    @Override
    public Var add(Var var) {
        if (var instanceof VarFloat) {
        	VarVector res = new VarVector(value);
            for (int i=0; i<value.length; i++) {
                res.value[i] = res.value[i] + ((VarFloat) var).getValue();
            }
            return res;
        }
        else if (var instanceof VarVector) {
        	if (((VarVector) var).value.length != value.length) return super.add(this);
        	VarVector res = new VarVector(value);
            for (int i=0; i<value.length; i++) {
                res.value[i] = res.value[i] + ((VarVector) var).value[i];
            }
            return res;
        }
        else return super.add(this);
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof VarFloat) {
        	VarVector res = new VarVector(value);
            for (int i=0; i<value.length; i++) {
                res.value[i] = res.value[i] - ((VarFloat) var).getValue();
            }
            return res;
        }
        else if (var instanceof VarVector) {
        	if (((VarVector) var).value.length != value.length) return super.sub(this);
        	VarVector res = new VarVector(value);
            for (int i=0; i<value.length; i++) {
                res.value[i] = res.value[i] - ((VarVector) var).value[i];
            }
            return res;
        } 
        else return super.sub(this);
    }
 
    @Override
    public Var mul(Var var) {
        if (var instanceof VarFloat) {
        	VarVector res = new VarVector(value);
            for (int i=0; i<value.length; i++) {
                res.value[i] = res.value[i] * ((VarFloat) var).getValue();
            }
            return res;
        }
        else if (var instanceof VarVector) {
        	if (value.length != ((VarVector) var).value.length) return super.mul(this);
           	double[] v = new double[1];
           	VarVector res = new VarVector(v);
           	for (int i=0; i<value.length; i++) {
                res.value[0] += value[i] * ((VarVector) var).value[i];
            }
            return res;     	
        }
        else if (var instanceof VarMatrix) {
        	if (value.length != ((VarMatrix) var).getValue().length) return super.mul(this);
            double[] v = new double[value.length];
            VarVector res = new VarVector(v);
           	for (int i=0; i<value.length; i++) {
           		for (int j=0; j<((VarMatrix) var).getValue().length; j++) {
           			res.value[i] += value[j] * ((VarMatrix) var).getValue()[j][i];
            	}
           	} 
           	return res; 
       } else return super.mul(this);  
    }
 
    @Override
    public Var div(Var var) {
        if (var instanceof VarFloat) {
        	VarVector res = new VarVector(value);
            for (int i=0; i<value.length; i++) {
                res.value[i] = res.value[i] / ((VarFloat) var).getValue();
            }
            return res;
        }
        else return super.div(this);
    }

    @Override
    public String toString() { return Arrays.toString(value); }

    @Override
    public Var fromString(String s) {
        String[] elems = s.split(Parser.splitterVector);
        double[] res = new double[elems.length];
        Pattern pattern = Pattern.compile(Parser.patternFloat);
        Matcher matcher;
        for (int i=0; i<elems.length; i++) {
            StringBuilder sbe = new StringBuilder(elems[i].replaceAll("[\\[{}\\]]",""));
            matcher = pattern.matcher(sbe);
            if (matcher.find()) {
                res[i] = Double.parseDouble(matcher.group());
            }
        }
        return (Var) new VarVector(res);
    }

}
