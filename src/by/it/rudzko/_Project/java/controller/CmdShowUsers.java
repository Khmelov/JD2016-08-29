package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DataBase;

import javax.servlet.http.HttpServletRequest;

class CmdShowUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        req.setAttribute("users", new DataBase().showUsers());
        return null;
    }
}
