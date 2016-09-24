package by.it.rudzko.jd01_09;

import by.it.rudzko.jd01_09.Interfaces.IAdd;
import by.it.rudzko.jd01_09.Interfaces.IDiv;
import by.it.rudzko.jd01_09.Interfaces.IMul;
import by.it.rudzko.jd01_09.Interfaces.ISub;
import by.it.rudzko.jd01_09.Vars.Var;
import by.it.rudzko.jd01_09.Vars.VarMat;
import by.it.rudzko.jd01_09.Vars.VarNum;
import by.it.rudzko.jd01_09.Vars.VarVec;


/**
 * Created by Leta on 23.09.2016.
 */
public class Calculator implements IAdd, IDiv, IMul, ISub {

    @Override
    public Var div(Var v1, Var v2) {
        if ( v1 instanceof VarNum && v2 instanceof VarNum){
            double res=((VarNum) v1).toNum()/((VarNum) v2).toNum();
            return new VarNum(res);
        }

        if (v1 instanceof VarVec && v2 instanceof VarNum){
            double[] vec=((VarVec)v1).toVec();
            for (int i=0; i<vec.length; i++){
                vec[i]=vec[i]/((VarNum)v2).toNum();
            }
            return new VarVec(vec);
        }

        //некорректная процедура! Описана, т.к. требовалась по условию. Возвращает частное значений одинаковой позиции
        if (v1 instanceof VarVec && v2 instanceof VarVec){
            if (((VarVec) v1).toVec().length==((VarVec) v2).toVec().length){
                double[]vec1=((VarVec)v1).toVec();
                double[]vec2=((VarVec)v2).toVec();
                for (int i=0; i<vec1.length; i++){
                    vec1[i]/=vec2[i];
                }
                return new VarVec(vec1);
            }
        }

        if (v1 instanceof VarMat && v2 instanceof VarNum){
            double[][] mat = ((VarMat) v1).toMat();
            for (int i = 0; i < mat.length; i++) {
                for (int j=0; j<mat[0].length; j++){
                    mat[i][j]/=((VarNum) v2).toNum();
                }
            }
            return new VarMat(mat);
        }

        new Error("Деление невозможно");
        return new VarNum(0);
    }

    @Override
    public Var mul(Var v1, Var v2) {

        if ( v1 instanceof VarNum && v2 instanceof VarNum){
            double res=((VarNum) v1).toNum()*((VarNum) v2).toNum();
            return new VarNum(res);
        }

        if ((v1 instanceof VarNum && v2 instanceof VarVec)||(v1 instanceof VarVec && v2 instanceof VarNum)){
            if (v1 instanceof VarNum){
                Var a=new VarNum(((VarNum) v1).toNum());
                v1=v2;
                v2=a;
            }
            double[] vec=((VarVec)v1).toVec();
            for (int i=0; i<vec.length; i++){
                vec[i]=vec[i]*((VarNum)v2).toNum();
            }
            return new VarVec(vec);
        }

        if (v1 instanceof VarVec && v2 instanceof VarVec){
            if (((VarVec) v1).toVec().length==((VarVec) v2).toVec().length){
                double[]vec1=((VarVec)v1).toVec();
                double[]vec2=((VarVec)v2).toVec();
                double res=0;
                for (int i=0; i<vec1.length; i++){
                    res+=vec1[i]*vec2[i];
                }
                return new VarNum(res);
            }
        }

        if ((v1 instanceof VarNum && v2 instanceof VarMat)||(v1 instanceof VarMat && v2 instanceof VarNum)){
            if (v1 instanceof VarNum){
                Var a=new VarNum(((VarNum) v1).toNum());
                v1=v2;
                v2=a;
            }
            double[][] mat = ((VarMat) v1).toMat();
            for (int i = 0; i < mat.length; i++) {
                    for (int j=0; j<mat[0].length; j++){
                        mat[i][j]*=((VarNum) v2).toNum();
                    }
            }
                return new VarMat(mat);
        }

        if (v1 instanceof VarMat && v2 instanceof VarVec){
            double[][] mat=((VarMat) v1).toMat();
            double[] vec=((VarVec)v2).toVec();
            if (mat[0].length==vec.length) {
                double[] res = new double[mat.length];
                for (int i = 0; i < mat.length; i++) {
                    double sum = 0;
                    for (int j = 0; j < vec.length; j++) {
                        sum += mat[i][j] * vec[j];

                    }
                    res[i] = sum;
                }
                return new VarVec(res);
            }
        }

        if (v1 instanceof VarVec && v2 instanceof VarMat){
            double[][] mat=((VarMat) v2).toMat();
            double[] vec=((VarVec)v1).toVec();
            if (mat.length==vec.length) {
                double[] res = new double[mat[0].length];
                for (int j = 0; j < res.length; j++) {
                    double sum = 0;
                    for (int i = 0; i < mat.length; i++) {
                        sum += mat[i][j] * vec[i];

                    }
                    res[j] = sum;
                }
                return new VarVec(res);
            }
        }

        if (v1 instanceof VarMat && v2 instanceof VarMat){
            double[][] mat1 = ((VarMat) v1).toMat();
            double[][] mat2 = ((VarMat) v2).toMat();
            if (mat1[0].length==mat2.length){
                double [][] mat=new double[mat1.length][mat2[0].length];
                for(int s=0; s<mat.length; s++) {
                    for (int j = 0; j < mat[0].length; j++) {
                        double sum = 0;
                        for (int i = 0; i < mat2.length; i++) {
                            sum += mat1[s][i]*mat2[i][j];
                        }
                        mat[s][j] = sum;
                    }
                }
            return new VarMat(mat);
            }
        }

        new Error("Умножение невозможно");
        return new VarNum(0);
    }

    @Override
    public Var sub(Var v1, Var v2) {

        if ( v1 instanceof VarNum && v2 instanceof VarNum){
            double res=((VarNum) v1).toNum()-((VarNum) v2).toNum();
            return new VarNum(res);
        }

        if (v1 instanceof VarVec && v2 instanceof VarNum){
            double[] vec=((VarVec)v1).toVec();
            for (int i=0; i<vec.length; i++){
                vec[i]=vec[i]-((VarNum)v2).toNum();
            }
            return new VarVec(vec);
        }

        if (v1 instanceof VarNum && v2 instanceof VarVec){

            double[] vec=((VarVec)v2).toVec();
            for (int i=0; i<vec.length; i++){
                vec[i]=vec[i]*(double)(-1)+((VarNum)v1).toNum();
            }
            return new VarVec(vec);
        }

        if (v1 instanceof VarVec && v2 instanceof VarVec){
            if (((VarVec) v1).toVec().length==((VarVec) v2).toVec().length){
                double[]vec1=((VarVec)v1).toVec();
                double[]vec2=((VarVec)v2).toVec();
                for (int i=0; i<vec1.length; i++){
                    vec1[i]=vec1[i]-vec2[i];
                }
                return new VarVec(vec1);
            }
        }

        if (v1 instanceof VarMat && v2 instanceof VarNum){
            double[][] mat = ((VarMat) v1).toMat();
            if (mat.length==mat[0].length) {
                for (int i = 0; i < mat.length; i++) {
                    mat[i][i]-= ((VarNum) v2).toNum();
                }
                return new VarMat(mat);
            }
        }

        if (v1 instanceof VarNum && v2 instanceof VarMat){
            double[][] mat = ((VarMat) v2).toMat();
            if (mat.length==mat[0].length) {
                for (int i = 0; i < mat.length; i++) {
                    for (int j=0; j<mat.length; j++){
                        mat[i][j]*=(double)(-1);
                        if (i==j){
                            mat[i][j] = mat[i][i]+((VarNum) v1).toNum();
                        }
                    }

                }
             return new VarMat(mat);
            }
        }

        if (v1 instanceof VarMat && v2 instanceof VarMat){
            double[][] mat = ((VarMat) v1).toMat();
            double[][] mat2 = ((VarMat) v2).toMat();
            if(mat.length==mat2.length && mat[0].length==mat2[0].length){
                for (int i=0; i<mat.length; i++){
                    for (int j=0; j<mat[0].length; j++){
                        mat[i][j]-=mat2[i][j];
                    }
                }
                return new VarMat(mat);
            }
        }

        new Error("Вычитание невозможно");
        return new VarNum(0);
    }

    @Override
    public Var add(Var v1, Var v2) {

        if ( v1 instanceof VarNum && v2 instanceof VarNum){
            double res=((VarNum) v1).toNum()+((VarNum) v2).toNum();
            return new VarNum(res);
        }

        if ((v1 instanceof VarNum && v2 instanceof VarVec)||(v1 instanceof VarVec && v2 instanceof VarNum)){
            if (v1 instanceof VarNum){
                Var a=new VarNum(((VarNum) v1).toNum());
                v1=v2;
                v2=a;
             }
             double[] vec=((VarVec)v1).toVec();
             for (int i=0; i<vec.length; i++){
                 vec[i]=vec[i]+((VarNum)v2).toNum();
             }
             return new VarVec(vec);
        }

        if (v1 instanceof VarVec && v2 instanceof VarVec){
            if (((VarVec) v1).toVec().length==((VarVec) v2).toVec().length){
                double[]vec1=((VarVec)v1).toVec();
                double[]vec2=((VarVec)v2).toVec();
                for (int i=0; i<vec1.length; i++){
                    vec1[i]=vec1[i]+vec2[i];
                }
                return new VarVec(vec1);
            }
        }

        if ((v1 instanceof VarNum && v2 instanceof VarMat)||(v1 instanceof VarMat && v2 instanceof VarNum)){
            if (v1 instanceof VarNum){
                Var a=new VarNum(((VarNum) v1).toNum());
                v1=v2;
                v2=a;
            }
            double[][] mat = ((VarMat) v1).toMat();
            if (mat.length==mat[0].length) {
                for (int i = 0; i < mat.length; i++) {
                    mat[i][i]+=((VarNum) v2).toNum();
                }
            return new VarMat(mat);
            }
        }

        if (v1 instanceof VarMat && v2 instanceof VarMat){
            double[][] mat = ((VarMat) v1).toMat();
            double[][] mat2 = ((VarMat) v2).toMat();
            if(mat.length==mat2.length && mat[0].length==mat2[0].length){
                for (int i=0; i<mat.length; i++){
                    for (int j=0; j<mat[0].length; j++){
                        mat[i][j]+=mat2[i][j];
                    }
                }
             return new VarMat(mat);
            }
        }

        new Error("Сложение невозможно");
        return new VarNum(0);
    }
}
