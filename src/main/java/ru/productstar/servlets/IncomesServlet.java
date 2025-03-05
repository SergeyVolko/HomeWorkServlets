package ru.productstar.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.productstar.servlets.enums.TypeTransaction;
import ru.productstar.servlets.utils.ServletUtil;
import java.io.IOException;

@WebServlet(value = "/incomes/add")
public class IncomesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtil.addTransaction(req, resp, TypeTransaction.INCOME);
    }
}
