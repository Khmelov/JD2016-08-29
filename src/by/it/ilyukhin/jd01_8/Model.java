package by.it.ilyukhin.jd01_8;


public class Model extends Siemens {
    @Override
    public String showState() {
        String state = "Входящий вызов";
        if (this.isAnswerCall()) {
            state = "Вы ответили на звонок";}
            if (this.isResetCall()){
                state = "Вы отклонили звонок";

        }
        return state;
    }

}
