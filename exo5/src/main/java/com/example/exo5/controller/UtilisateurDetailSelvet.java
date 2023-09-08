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
import java.util.Optional;


@WebServlet(name = "utilisateurDetailServlet", value = "/utilisateur/detail/*")

public class UtilisateurDetailSelvet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long utilisateurId = Long.parseLong(req.getPathInfo().substring(1));

        Optional<Utilisateur> utilisateurFound = FakeData.utilisateurs.stream().filter(d -> d.getId() == utilisateurId).findFirst();

        if(utilisateurFound.isPresent()) {
            UtilisateurDTO utilisateurDetails = new UtilisateurDTO(
                    utilisateurFound.get().getId(),
                    utilisateurFound.get().getName(),
                    utilisateurFound.get().getEmail(),
                    utilisateurFound.get().getPassword()
            );

            req.setAttribute("utilisateur", utilisateurDetails);
            req.setAttribute("mode", "view");

            req.getRequestDispatcher("/WEB-INF/UtilisateurForm.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/utilisateur/list");
        }
    }
}
