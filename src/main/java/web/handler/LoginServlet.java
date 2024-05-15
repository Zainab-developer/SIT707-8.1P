package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import web.service.LoginService;

/**
 * HTTP end-point to handle login service.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("[LoginServlet] POST");

        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String dob = req.getParameter("dob");

        System.out.println("Username/password: " + username + ", " + password);

        String loginStatus = "fail";

        if (LoginService.login(username, password, dob)) {
            loginStatus = "success";
        }

        // Create JSON object to represent the login status
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("loginStatus", loginStatus);
        // Set content type and write JSON response
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.println(jsonResponse.toJSONString());
    }
}
