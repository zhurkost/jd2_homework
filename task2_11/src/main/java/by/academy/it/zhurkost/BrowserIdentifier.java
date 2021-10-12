package by.academy.it.zhurkost;

import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class BrowserIdentifier extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String userAgent = request.getHeader("user-agent");
        String browserName;
        if (userAgent != null) {
            if (userAgent.contains("Chrome")) {
                String substring = userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0];
                browserName = substring.split("/")[0];
            } else if (userAgent.contains("Firefox")) {
                String substring = userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0];
                browserName = substring.split("/")[0];
            } else {
                browserName = "undefined browser";
            }
            out.println("Hello " + browserName + " user");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}