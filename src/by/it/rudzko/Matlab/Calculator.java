package by.it.rudzko.Matlab;

import by.it.rudzko.Matlab.Interfaces.*;
import by.it.rudzko.Matlab.Vars.VarMat;
import by.it.rudzko.Matlab.Vars.VarNum;
import by.it.rudzko.Matlab.Vars.VarVec;


class Calculator implements IAdd, IDiv, IMul, ISub {

    @Override
    public IVar div(IVar v1, IVar v2) {
        try {
            if (v1 instanceof VarNum && v2 instanceof VarNum) {
                if (((VarNum) v2).toNum()!=0){
                double res = ((VarNum) v1).toNum() / ((VarNum) v2).toNum();
                return new VarNum(res);
                } else throw new ArithmeticException();
            }

            if (v1 instanceof VarVec && v2 instanceof VarNum) {
                if (((VarNum) v2).toNum()!=0){
                double[] vec = ((VarVec) v1).toVec();
                for (int i = 0; i < vec.length; i++) {
                    vec[i] = vec[i] / ((VarNum) v2).toNum();
                }
                return new VarVec(vec);
                } else throw new ArithmeticException();
            }

            if (v1 instanceof VarVec && v2 instanceof VarVec) {
                if (((VarVec) v1).toVec().length == ((VarVec) v2).toVec().length) {
                    double[] vec1 = ((VarVec) v1).toVec();
                    double[] vec2 = ((VarVec) v2).toVec();
                    for (int i = 0; i < vec1.length; i++) {
                        if (vec2[i]!=0)
                        vec1[i] /= vec2[i];
                        else throw new ArithmeticException();
                    }
                    return new VarVec(vec1);
                }
            }

            if (v1 instanceof VarMat && v2 instanceof VarNum) {
                if (((VarNum) v2).toNum()!=0){
                double[][] mat = ((VarMat) v1).toMat();
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[0].length; j++) {
                        mat[i][j] /= ((VarNum) v2).toNum();
                    }
                }
                return new VarMat(mat);
                } else throw new ArithmeticException();
            } else throw new IllegalArgumentException();

        } catch (ArithmeticException e) {
            Logger.printError(IMessages.NULL);
            System.out.println(IMessages.NULL);
        } catch (IllegalArgumentException e) {
            Logger.printError(IMessages.IMPOSSIBLE_DIV);
            System.out.println(IMessages.IMPOSSIBLE_DIV);
        }
        return new VarNum(0);
    }

    @Override
    public IVar mul(IVar v1, IVar v2) {
        try {
            if (v1 instanceof VarNum && v2 instanceof VarNum) {
                double res = ((VarNum) v1).toNum() * ((VarNum) v2).toNum();
                return new VarNum(res);
            }

            if ((v1 instanceof VarNum && v2 instanceof VarVec) || (v1 instanceof VarVec && v2 instanceof VarNum)) {
                if (v1 instanceof VarNum) {
                    IVar a = new VarNum(((VarNum) v1).toNum());
                    v1 = v2;
                    v2 = a;
                }
                double[] vec = ((VarVec) v1).toVec();
                for (int i = 0; i < vec.length; i++) {
                    vec[i] = vec[i] * ((VarNum) v2).toNum();
                }
                return new VarVec(vec);
            }

            if (v1 instanceof VarVec && v2 instanceof VarVec) {
                if (((VarVec) v1).toVec().length == ((VarVec) v2).toVec().length) {
                    double[] vec1 = ((VarVec) v1).toVec();
                    double[] vec2 = ((VarVec) v2).toVec();
                    double res = 0;
                    for (int i = 0; i < vec1.length; i++) {
                        res += vec1[i] * vec2[i];
                    }
                    return new VarNum(res);
                }
            }

            if ((v1 instanceof VarNum && v2 instanceof VarMat) || (v1 instanceof VarMat && v2 instanceof VarNum)) {
                if (v1 instanceof VarNum) {
                    IVar a = new VarNum(((VarNum) v1).toNum());
                    v1 = v2;
                    v2 = a;
                }
                double[][] mat = ((VarMat) v1).toMat();
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[0].length; j++) {
                        mat[i][j] *= ((VarNum) v2).toNum();
                    }
                }
                return new VarMat(mat);
            }

            if (v1 instanceof VarMat && v2 instanceof VarVec) {
                double[][] mat = ((VarMat) v1).toMat();
                double[] vec = ((VarVec) v2).toVec();
                if (mat[0].length == vec.length) {
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

            if (v1 instanceof VarVec && v2 instanceof VarMat) {
                double[][] mat = ((VarMat) v2).toMat();
                double[] vec = ((VarVec) v1).toVec();
                if (mat.length == vec.length) {
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

            if (v1 instanceof VarMat && v2 instanceof VarMat) {
                double[][] mat1 = ((VarMat) v1).toMat();
                double[][] mat2 = ((VarMat) v2).toMat();
                if (mat1[0].length == mat2.length) {
                    double[][] mat = new double[mat1.length][mat2[0].length];
                    for (int s = 0; s < mat.length; s++) {
                        for (int j = 0; j < mat[0].length; j++) {
                            double sum = 0;
                            for (int i = 0; i < mat2.length; i++) {
                                sum += mat1[s][i] * mat2[i][j];
                            }
                            mat[s][j] = sum;
                        }
                    }
                    return new VarMat(mat);
                }
            } else throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            Logger.printError(IMessages.IMPOSSIBLE_MUL);
            System.out.println(IMessages.IMPOSSIBLE_MUL);
        }
        return new VarNum(0);
    }

    @Override
    public IVar sub(IVar v1, IVar v2) {
        try {
            if (v1 instanceof VarNum && v2 instanceof VarNum) {
                double res = ((VarNum) v1).toNum() - ((VarNum) v2).toNum();
                return new VarNum(res);
            }

            if (v1 instanceof VarVec && v2 instanceof VarNum) {
                double[] vec = ((VarVec) v1).toVec();
                for (int i = 0; i < vec.length; i++) {
                    vec[i] = vec[i] - ((VarNum) v2).toNum();
                }
                return new VarVec(vec);
            }

            if (v1 instanceof VarNum && v2 instanceof VarVec) {

                double[] vec = ((VarVec) v2).toVec();
                for (int i = 0; i < vec.length; i++) {
                    vec[i] = vec[i] * (double) (-1) + ((VarNum) v1).toNum();
                }
                return new VarVec(vec);
            }

            if (v1 instanceof VarVec && v2 instanceof VarVec) {
                if (((VarVec) v1).toVec().length == ((VarVec) v2).toVec().length) {
                    double[] vec1 = ((VarVec) v1).toVec();
                    double[] vec2 = ((VarVec) v2).toVec();
                    for (int i = 0; i < vec1.length; i++) {
                        vec1[i] = vec1[i] - vec2[i];
                    }
                    return new VarVec(vec1);
                }
            }

            if (v1 instanceof VarMat && v2 instanceof VarNum) {
                double[][] mat = ((VarMat) v1).toMat();
                if (mat.length == mat[0].length) {
                    for (int i = 0; i < mat.length; i++) {
                        mat[i][i] -= ((VarNum) v2).toNum();
                    }
                    return new VarMat(mat);
                }
            }

            if (v1 instanceof VarNum && v2 instanceof VarMat) {
                double[][] mat = ((VarMat) v2).toMat();
                if (mat.length == mat[0].length) {
                    for (int i = 0; i < mat.length; i++) {
                        for (int j = 0; j < mat.length; j++) {
                            mat[i][j] *= (double) (-1);
                            if (i == j) {
                                mat[i][j] = mat[i][i] + ((VarNum) v1).toNum();
                            }
                        }

                    }
                    return new VarMat(mat);
                }
            }

            if (v1 instanceof VarMat && v2 instanceof VarMat) {
                double[][] mat = ((VarMat) v1).toMat();
                double[][] mat2 = ((VarMat) v2).toMat();
                if (mat.length == mat2.length && mat[0].length == mat2[0].length) {
                    for (int i = 0; i < mat.length; i++) {
                        for (int j = 0; j < mat[0].length; j++) {
                            mat[i][j] -= mat2[i][j];
                        }
                    }
                    return new VarMat(mat);
                }
            } else throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            Logger.printError(IMessages.IMPOSSIBLE_SUB);
            System.out.println(IMessages.IMPOSSIBLE_SUB);
        }
        return new VarNum(0);
    }

    @Override
    public IVar add(IVar v1, IVar v2) {
        try {
            if (v1 instanceof VarNum && v2 instanceof VarNum) {
                double res = ((VarNum) v1).toNum() + ((VarNum) v2).toNum();
                return new VarNum(res);
            }

            if ((v1 instanceof VarNum && v2 instanceof VarVec) || (v1 instanceof VarVec && v2 instanceof VarNum)) {
                if (v1 instanceof VarNum) {
                    IVar a = new VarNum(((VarNum) v1).toNum());
                    v1 = v2;
                    v2 = a;
                }
                double[] vec = ((VarVec) v1).toVec();
                for (int i = 0; i < vec.length; i++) {
                    vec[i] = vec[i] + ((VarNum) v2).toNum();
                }
                return new VarVec(vec);
            }

            if (v1 instanceof VarVec && v2 instanceof VarVec) {
                if (((VarVec) v1).toVec().length == ((VarVec) v2).toVec().length) {
                    double[] vec1 = ((VarVec) v1).toVec();
                    double[] vec2 = ((VarVec) v2).toVec();
                    for (int i = 0; i < vec1.length; i++) {
                        vec1[i] = vec1[i] + vec2[i];
                    }
                    return new VarVec(vec1);
                }
            }

            if ((v1 instanceof VarNum && v2 instanceof VarMat) || (v1 instanceof VarMat && v2 instanceof VarNum)) {
                if (v1 instanceof VarNum) {
                    IVar a = new VarNum(((VarNum) v1).toNum());
                    v1 = v2;
                    v2 = a;
                }
                double[][] mat = ((VarMat) v1).toMat();
                if (mat.length == mat[0].length) {
                    for (int i = 0; i < mat.length; i++) {
                        mat[i][i] += ((VarNum) v2).toNum();
                    }
                    return new VarMat(mat);
                }
            }

            if (v1 instanceof VarMat && v2 instanceof VarMat) {
                double[][] mat = ((VarMat) v1).toMat();
                double[][] mat2 = ((VarMat) v2).toMat();
                if (mat.length == mat2.length && mat[0].length == mat2[0].length) {
                    for (int i = 0; i < mat.length; i++) {
                        for (int j = 0; j < mat[0].length; j++) {
                            mat[i][j] += mat2[i][j];
                        }
                    }
                    return new VarMat(mat);
                }
            } else throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            Logger.printError(IMessages.IMPOSSIBLE_ADD);
            System.out.println(IMessages.IMPOSSIBLE_ADD);
        }
        return new VarNum(0);
    }
}
