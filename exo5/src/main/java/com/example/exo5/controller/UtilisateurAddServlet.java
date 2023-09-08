package com.example.exo5.controller;


import com.example.exo5.data.FakeData;
import com.example.exo5.models.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UtilisateurAddServlet", value = "/Utilisateur/Add")
public class UtilisateurAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = new Utilisateur("", " ", 0L, " ");

        req.setAttribute("name", utilisateur);
        req.setAttribute("email", utilisateur);
        req.setAttribute("password", utilisateur);
        req.setAttribute("mode", "add");

        req.getRequestDispatcher("/WEB-INF/UtilisateurForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Long id = req.getContentLengthLong();
        String password =req.getParameter("password");

        Utilisateur newUtilisateur = new Utilisateur(
                name,
                email,
                0L,
                password
        );

        FakeData.utilisateurs.add(newUtilisateur);

    }
}
