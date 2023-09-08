package com.example.exo5.controller;

import com.example.exo5.data.FakeData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name= "UtilisateurListSelvet", value = "/utilisateur/list")
public class UtilisateurListSelvet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("utilisateur", FakeData.utilisateurs);

        req.getRequestDispatcher("/WEB-INF/utilisateur/list.jsp").forward(req, resp);
    }
}
