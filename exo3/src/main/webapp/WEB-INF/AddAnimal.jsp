<%@ page import="com.example.exo3.Cat" %>
<%@ page import="com.example.exo3.FormServlet" %>
<jsp:useBean id="name" type="java.lang.String" scope="request" />
<jsp:useBean id="breed" type="java.lang.String" scope="request" />
<jsp:useBean id="favMeal" type="java.lang.String" scope="request" />
<jsp:useBean id="dateOfBirth" type="java.lang.String" scope="request" />
<jsp:useBean id="confirmation" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="errors" type="java.util.List<java.lang.String>" scope="request" />
<jsp:useBean id="cats" type="java.util.ArrayList<com.example.exo3.FormServlet>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/09/2023
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="bootstrap.html" %>
    <title>Add Animaux</title>
</head>
<body>

<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light">- Ajout Animaux -</h1>
            <hr>
            <form action="${pageContext.request.contextPath}/cats/add" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">Name:</label>
                    <input type="text" class="form-control" name="name" id="name" value="<%= name %>" required>
                </div>
                <div class="mb-3">
                    <label for="breed" class="form-label">Breed:</label>
                    <input type="text" class="form-control" name="breed" id="breed" value="<%= breed %>" required>
                </div>
                <div class="mb-3">
                    <label for="favMeal" class="form-label">Favorite meal:</label>
                    <input type="text" class="form-control" name="favMeal" id="favMeal" value="<%= favMeal %>" required>
                </div>
                <div class="mb-3">
                    <label for="dateOfBirth" class="form-label">Birth date:</label>
                    <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" value="<%= dateOfBirth %>" required>
                </div>
                <hr>
                <div class="text-end">
                    <button class="btn btn-outline-light"><i class="bi bi-send"></i> Send</button>
                </div>
            </form>
            <hr>
            <% if (confirmation) { %>
            <p>Chat ajouté avec succès !</p>
            <% } else if (!errors.isEmpty()) { %>
            <ul>
                <% for(String err : errors) { %>
                <li class="text-danger"><%= err %></li>
                <% } %>
            </ul>
            <% } %>
            <hr>
            <% if (!cats.isEmpty()) { %>
            <ul>
                <% for(FormServlet cat : cats) { %>
                <li><%= cat.getServletName() %></li>
                <% } %>
            </ul>
            <% } %>
        </div>
    </div>
</main>




</body>
</html>
