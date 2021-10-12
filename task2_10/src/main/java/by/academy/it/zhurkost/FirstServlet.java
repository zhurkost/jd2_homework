package by.academy.it.zhurkost;

import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String fio = request.getParameter("fio");

        if (!inputCheck(fio)) {
            out.print("error name input");
        } else {
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            if (!inputCheck(phoneNumber) && !inputCheck(email)) {
                out.print("error phoneNumber and email input");
            } else {
                out.println("Name: " + fio + "<br>");
                out.println("Phone Number: " + phoneNumber + "<br>");
                out.println("email: " + email);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private boolean inputCheck(String input) {
        return input != null && !input.isEmpty() && !input.isBlank();
    }
}