package by.it.vashukevich.jd01_09.mathlab;

import java.util.Arrays;

/**
 * Created by Admin on 16.09.16.
 */
public class VarV extends Var{
    private double[]vec;

      VarV(double[]vec) {
        this.vec = new double[vec.length];
        System.arraycopy(vec,0,this.vec,0,vec.length);
    }

    @Override
    public String toString() {
        return  Arrays.toString(vec) ;
    }


    @Override
    //сложение вектора со скаляром
    public Var add(Var var) {
        //сложение вектора с вектором
        if(var instanceof VarV) {//проверяем вектор ли это
            VarV resVec = new VarV(this.vec);
            VarV vc= (VarV)var;
            for (int i = 0; i<vec.length; i++) {
                resVec.vec[i] = resVec.vec[i] + vc.vec[i];
            }
            return resVec;
        }
        if(var instanceof VarF){//проверяем скаляр ли это
            VarV resVec=new VarV(this.vec);
            for(int i=0;i<vec.length;i++){
                resVec.vec[i]=resVec.vec[i]+((VarF)var).value;
            }
            return resVec;
        }
        return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        //вычитание вектора с вектором
        if(var instanceof VarV) {//проверяем вектор ли это
            VarV resVec = new VarV(this.vec);
            VarV vc= (VarV)var;
            for (int i = 0; i < vec.length; i++) {
                resVec.vec[i] = resVec.vec[i]-vc.vec[i];
            }
            return resVec;
        }
        if(var instanceof VarF){//проверяем скаляр ли это
            VarV resVec=new VarV(this.vec);
            for(int i=0;i<vec.length;i++){
                resVec.vec[i]=resVec.vec[i]-((VarF)var).value;
            }
            return resVec;
        }
        return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        if(var instanceof VarV) {//проверяем вектор ли это
            VarV resVec = new VarV(this.vec);
            VarV vc= (VarV)var;
            for (int i = 0; i < vec.length; i++) {
                resVec.vec[i] = resVec.vec[i]*vc.vec[i];
            }
            return resVec;
        }
        if(var instanceof VarF){//проверяем скаляр ли это
            VarV resVec=new VarV(this.vec);
            for(int i=0;i<vec.length;i++){
                resVec.vec[i]=resVec.vec[i]*((VarF)var).value;
            }
            return resVec;
        }
        return super.mul(var);
    }

    @Override
    public Var div(Var var) {
       /* if(var instanceof VarV) {//проверяем вектор ли это
            VarV resVec = new VarV(this.vec);
            VarV vc= (VarV)var;
            for (int i = 0; i < vec.length; i++) {
                resVec.vec[i] = resVec.vec[i]/vc.vec[i];
            }
            return resVec;
        }*/
        if(var instanceof VarF){//проверяем скаляр ли это
            VarV resVec=new VarV(this.vec);
            double v=((VarF)var).value;
            for(int i=0;i<vec.length;i++){
                resVec.vec[i]=resVec.vec[i]/v;
            }
            return resVec;
        }
        return super.div(var);
    }
}
