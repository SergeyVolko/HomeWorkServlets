package ru.productstar.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.productstar.servlets.enums.TypeTransaction;
import ru.productstar.servlets.utils.ServletUtil;

import java.io.IOException;


public class ExpensesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletUtil.addTransaction(req, resp, TypeTransaction.EXPENSE);
    }
}
