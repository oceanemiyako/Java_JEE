package com.example.exo5.controller;

import com.example.exo5.models.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "privatePageServlet", value = "/private/profile")

public class Private extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("user");

        if (utilisateur != null) {
            req.setAttribute("user", utilisateur);
            req.getRequestDispatcher("/WEB-INF/private/profile.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth/signIn");
        }
    }
}
