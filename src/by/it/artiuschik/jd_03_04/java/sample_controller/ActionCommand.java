package by.it.artiuschik.jd_03_04.java.sample_controller;

import javax.servlet.http.HttpServletRequest;
interface ActionCommand {
    String execute(HttpServletRequest request);
}