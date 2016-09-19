package by.it.akhmelev.jd01_10.matlab_v2.vars;

public class VarM extends Var {
    //это просто пример ;)
    //класс создается по аналогии с VarV и VarF

    @Override
    public Var add(Var var) {
        System.out.println("Тест. Работает позднее связывание с VarM->ADD");
        return null;
    }
}
