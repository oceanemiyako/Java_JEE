<%@ page import="com.example.exo5.models.Utilisateur" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="utilisateur" type="com.example.exo5.models.UtilisateurDTO" scope="request" />
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap.html" %>
    <title><%= mode.substring(0, 1).toUpperCase() + mode.substring(1).toLowerCase() %> a Utilisateur</title>
</head>
<body>

<main class="container">
    <div class="my-3 row">
        <div class="col-8 offset-2 p-3 rounded text-bg-dark">
            <h1 class="fw-light">-<%= mode.substring(0, 1).toUpperCase() + mode.substring(1).toLowerCase() %> a Utilisateur-</h1>
            <hr>
            <form action="<%= mode.equals("add") ? "add" : "" %>" method="post">
                <input type="number" class="d-none" name="id" readonly>
                <div class="mb-3">
                    <label for="name" class="form-label">Name:</label>
                    <input type="text" name="name" id="name" class="form-control" value="<%= utilisateur.getName() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="text" name="email" id="email" class="form-control" value="<%= utilisateur.getEmail() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">password:</label>
                    <input type="text" name="password" id="password" class="form-control" value="<%= utilisateur.getPassword() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>
                <hr>
                <div class="text-end">
                    <% if (mode.equals("add")) { %>
                    <button class="btn btn-outline-success"><i class="bi bi-plus-circle"></i> Add Utilisateur</button>
                    <% } else { %>
                    <a href="../list" class="btn btn-outline-secondary"><i class="bi bi-arrow-counterclockwise"></i> Return</a>
                    <% } %>
                </div>
            </form>
        </div>
    </div>
</main>






</body>
</html>
