package com.example.exo3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "formServlet", value = "/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");
        req.setAttribute("mode", mode);
        getServletContext().getRequestDispatcher("/WEB-INF/AddAnimal.jsp").forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstname = req.getParameter("firstname");
        int identification = req.getIntHeader("identification");
        Double age = Double.parseDouble(req.getParameter("age"));

        System.out.printf("firstname: %s, identification = %s, age = %f", firstname, identification, age);


    }
}
