package by.it.tsiamruk.project.java.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by waldemar on 05/11/2016.
 */
@WebFilter(urlPatterns = {"/*"}, initParams = {@WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding param")})
public class FilterUTF8 implements Filter {
    private String code;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String codeResponse = servletResponse.getCharacterEncoding();
        if (code != null && !code.equalsIgnoreCase(codeResponse))
            servletResponse.setCharacterEncoding(code);

        String codeRequest = servletRequest.getCharacterEncoding();
        if (code != null && !code.equalsIgnoreCase(codeRequest))
            servletRequest.setCharacterEncoding(code);

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        code = null;
    }
}
