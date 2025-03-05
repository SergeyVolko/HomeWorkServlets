package ru.productstar.servlets.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.productstar.servlets.enums.TypeTransaction;
import ru.productstar.servlets.model.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServletUtil {
    public static void addTransaction(HttpServletRequest req, HttpServletResponse resp,
                                      TypeTransaction typeTransaction) throws IOException {
        var context = req.getServletContext();
        context.log("[ExpensesServlet] doGet");
        int freeMoney = (int)context.getAttribute("freeMoney");
        var transactions = new ArrayList<Transaction>((List)context.getAttribute("transactions"));
        for (var k : req.getParameterMap().keySet()) {
            var value = Integer.parseInt(req.getParameter(k));
            freeMoney = (TypeTransaction.EXPENSE.equals(typeTransaction)? freeMoney - value : freeMoney + value);
            transactions.add(new Transaction(k, value, typeTransaction));
        }
        context.setAttribute("freeMoney", freeMoney);
        context.setAttribute("transactions", transactions);
        resp.sendRedirect("/summary");

    }

    public static void showDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getSession(false) == null) {
            resp.getWriter().println("No authorized");
            return;
        }
        var context = req.getServletContext();
        resp.getWriter().println("Transactions: ");
        for (Transaction e : (List<Transaction>)context.getAttribute("transactions")) {
            resp.getWriter().println(String.format("- %s(%d,%s)", e.getName(), e.getSum(), e.getTypeTransaction()));
        }
        resp.getWriter().println("\n");
    }

}
