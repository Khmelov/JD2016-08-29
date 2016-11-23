package by.it.artiuschik.project_Testing_system.java.filtres;

import by.it.artiuschik.project_Testing_system.java.beans.User;
import by.it.artiuschik.project_Testing_system.java.shifr.EncoderDecoder;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Artiuchik Elena
 */

public class FilterCookie implements Filter {
    /**
     *
     * @param filterConfig filter configuration
     * @throws ServletException exception
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     *
     * @param servletRequest request
     * @param servletResponse response
     * @param filterChain  chain of filters
     * @throws IOException input-output exception
     * @throws ServletException servlet exception
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest req = (HttpServletRequest) servletRequest;
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
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    /**
     *
     * @param sessionUser user in session
     * @return array of cookies, contains login and password
     */
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
