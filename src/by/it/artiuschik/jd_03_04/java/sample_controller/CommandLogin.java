package by.it.artiuschik.jd_03_04.java.sample_controller;

import javax.servlet.http.HttpServletRequest;

class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        //DO SOMETHING;
        //USE DAO
        //&ETC
        return Actions.LOGIN.jsp;
    }
}