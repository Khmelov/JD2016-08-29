package by.it.rudzko.jd01_09.Vars;

import by.it.rudzko.jd01_09.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarMat extends Var {

    private double [][] mat;

    public VarMat(String str) { //конструктор из строки
        setFrom(str);
    }

    public VarMat(double[][] matrix) {
        this.mat = new double[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                this.mat [i][j]=matrix[i][j];
            }
        }
    }

    public double[][] toMat(){
        double[][]copy=new double[mat.length][mat[0].length];
        for (int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                copy[i][j]=mat[i][j];
            }
        }
        return copy;
    }

    @Override
    public void setFrom(String str) {
        String[] rows=str.trim().split("},");
        String[] cols=rows[0].split(",");
        mat=new double[rows.length][cols.length];
        Matcher m= Pattern.compile(Patterns.exVal).matcher(str);
        double [] ex=new double[rows.length*cols.length];
        int exC=0;
        while (m.find()) {
            ex[exC]=Double.parseDouble(m.group());
            exC++;
        }
            int count=0;
            for(int i=0; i<rows.length; i++) {
                for (int j = 0; j < cols.length; j++) {

                    mat[i][j] = ex[count];
                    count++;
                }
            }

    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder("{{");
        for (int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                String str=Double.toString(mat[i][j]);
                res=(j!=mat[0].length-1) ? (res.append(str).append(", ")) : (res.append(str));
            }
            res.append("}, {");
        }
        return res.delete(res.length()-3, res.length()).append('}').toString();
    }
}
