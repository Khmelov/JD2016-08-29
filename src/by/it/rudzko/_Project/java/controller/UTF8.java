package by.it.rudzko._Project.java.controller;


import javax.servlet.*;
import java.io.IOException;


public class UTF8 implements Filter {
    private String code;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String codeResp = servletResponse.getCharacterEncoding();
        if (code != null && !code.equalsIgnoreCase(codeResp)) {
            servletResponse.setCharacterEncoding(code);
        }
        String codeReq = servletRequest.getCharacterEncoding();
        if (code != null && !code.equalsIgnoreCase(codeReq)) {
            servletRequest.setCharacterEncoding(code);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        code = null;
    }
}
