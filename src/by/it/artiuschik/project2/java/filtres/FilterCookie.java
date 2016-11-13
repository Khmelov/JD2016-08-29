package by.it.artiuschik.project2.java.filtres;

import by.it.artiuschik.project2.java.beans.User;
import by.it.artiuschik.project2.java.shifr.EncoderDecoder;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterCookie implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       /* HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute("user");
        //Если  user  есть в сессии
        if (sessionUser != null) {
            //если произошел переход на другую страницу , т.е. запрос  get, то обновление cookie
            if (req.getMethod().equalsIgnoreCase("get")) {
                Cookie[] cookies = createCookies(sessionUser);
                resp.addCookie(cookies[0]);
                resp.addCookie(cookies[1]);
            }
        }*/
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private Cookie[] createCookies(User sessionUser) {
        Cookie[] cookies = new Cookie[2];
        Cookie login = new Cookie("Login", sessionUser.getLogin());
        Cookie password = new Cookie("Password", EncoderDecoder.decode(sessionUser.getPassword().getBytes(), "key"));
        login.setMaxAge(30);
        password.setMaxAge(30);
        cookies[0] = login;
        cookies[1] = password;
        return cookies;
    }
}
