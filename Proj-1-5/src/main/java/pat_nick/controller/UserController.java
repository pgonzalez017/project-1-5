package pat_nick.controller;

import com.google.gson.Gson;
import pat_nick.model.User;
import pat_nick.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController {

    UserService us;

    public UserController(UserService us) {this.us = us;}




    public void getUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //int id = Integer.parseInt(req.getParameter("id"));
        User u = us.getUserById(1);

        Gson gson = new Gson();

        res.getWriter().println(gson.toJson(u));

    }

}
