package ru.productstar.servlets.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ExpensesFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        if (servletRequest.getSession(false) == null) {
            response.getWriter().println("No authorized");
            return;
        }
        var context = request.getServletContext();
        context.log("[ExpensesFilter] doFilter");
        int freeMoney = (int) context.getAttribute("freeMoney");
        for (var k : request.getParameterMap().keySet()) {
            freeMoney -= Integer.parseInt(request.getParameter(k));
            if (freeMoney < 0) {
                response.getWriter().println("Not enough money");
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
