<%@ page import="com.example.exo5.models.Utilisateur" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="utilisateurs" type="java.util.ArrayList<com.example.exo5.models.Utilisateur>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Utilisateur List</title>
</head>
<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 rounded text-bg-dark p-3">

            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>email</th>
            </tr>
            </thead>
            <tbody>
            <% for (Utilisateur d : utilisateurs) { %>
            <tr>
                <td><%= d.getId() %></td>
                <td><%= d.getName() %></td>
                <td><%= d.getEmail()%></td>

            </tr>
            <% } %>
            </tbody>
            </table>
            <% } else { %>
            <p>There is no utilisateur in the database yet!</p>
            <% } %>
            <hr>
            <div class="text-end">
                <a href="${pageContext.request.contextPath}/Utilisateur/Add" class="btn btn-outline-success"><i class="bi bi-plus-circle"></i> Add a Utilisateur</a>
            </div>

</div>
</div>
</main>
</body>
</html>
