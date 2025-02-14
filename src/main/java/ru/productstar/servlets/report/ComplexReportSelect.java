package ru.productstar.servlets.report;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/complex-report", asyncSupported = true)
public class ComplexReportSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession(false) == null) {
            resp.getWriter().println("No authorized");
            return;
        }

        long start = System.currentTimeMillis();

        final AsyncContext asyncContext = req.startAsync();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                asyncContext.getResponse().getWriter().println("Success");
                asyncContext.complete();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();


        req.getServletContext().log(String.format("[ComplexReportSelect] Thread %s, %d",
                Thread.currentThread().getName(),
                System.currentTimeMillis() - start));
    }
}
