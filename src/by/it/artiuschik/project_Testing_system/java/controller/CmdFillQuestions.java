package by.it.artiuschik.project_Testing_system.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdFillQuestions extends Action
{
    @Override
    Action execute(HttpServletRequest req) {
        req.setAttribute("questions",req.getSession().getAttribute("questions"));
        return null;
    }
}
