package by.it.artiuschik.project2.java.filtres;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Artiuschik Elena
 */

public class FilterUTF8 implements Filter {
    private String encoding;

    /**
     *
     * @param config filter configuration
     * @throws ServletException servlet exception
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        //FilterConfig-исходные данные для фильтра
        encoding = config.getInitParameter("requestEncoding");
        if (encoding == null) {
            encoding = "UTF-8";
        }

    }

    /**
     *
     * @param servletRequest request
     * @param servletResponse response
     * @param filterChain chain of filters
     * @throws IOException input-output exception
     * @throws ServletException servlet exception
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        //запуск остальных фильтров и самого сервлета
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
     encoding=null;
    }
}
