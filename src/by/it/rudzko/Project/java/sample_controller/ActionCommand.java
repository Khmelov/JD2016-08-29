package by.it.rudzko.Project.java.sample_controller;

import javax.servlet.http.HttpServletRequest;

interface ActionCommand {
    String execute(HttpServletRequest request);
}