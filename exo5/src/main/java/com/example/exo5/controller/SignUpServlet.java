package com.example.exo5.controller;

import com.example.exo5.data.FakeData;
import com.example.exo5.models.Utilisateur;
import com.example.exo5.models.UtilisateurDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


@WebServlet(name = "signUpServlet", value = "/auth/signUp")
public class SignUpServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UtilisateurDTO dto = new UtilisateurDTO();
        ArrayList<String> errors = new ArrayList<>();

        req.setAttribute("utilisateur", dto);
        req.setAttribute("errors", errors);
        req.setAttribute("mode", "signUp");

        req.getRequestDispatcher("/WEB-INF/auth/signForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> errors = new ArrayList<>();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        Optional<Utilisateur> foundUser = FakeData.utilisateurs.stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst();

        if (!foundUser.isPresent()) {
            Utilisateur newUtilisateur = new Utilisateur("name", "email", 0L," ");
            FakeData.utilisateurs.add(newUtilisateur);
            req.getSession().setAttribute("user", newUtilisateur);
            resp.sendRedirect(req.getContextPath() + "/private/profile");
        } else {
            errors.add("User already exists!");
            UtilisateurDTO dto = new UtilisateurDTO();
            dto.setEmail(email);
            dto.setPassword(password);
            req.setAttribute("utilisateur", dto);
            req.setAttribute("errors", errors);
            req.setAttribute("mode", "signUp");
            req.getRequestDispatcher("/WEB-INF/auth/signForm.jsp").forward(req, resp);
        }
    }







}
