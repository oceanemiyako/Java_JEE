package com.example.exo5.models;
/*
Réaliser une application Jakarta EE permettant à des utilisateurs de s'enregistrer et / ou de se connecter pour accéder à un contenu privé.

L'application proposera un servlet gérant les enregistrement via une méthode POST. Cette méthode devra vérifier dans une fausse base de données si l'utilisateur est déjà existant de sorte à informer l'utilisateur que cet username / email n'est pas disponible le cas échéant. Si l'ensemble n'est pas pré-existant, l'utilisateur se verra automatiquement connecté et visualisera une page secrète.Il y aura également un servlet permettant de gérer la connexion. Cette fois-ci, au moment de la récéption d'une requête POST, la servlet ira regarder dans la fausse base de données si l'ensemble username / email et mot de passe est existant. Dans le cas échant, l'utilisateur se verra connecté et accèdera à la page secrète. La page secrète devra n'être accessible que par les utilisateurs connectés et redirigera les indésirables vers le formulaire de connexion. Si la page est accessible, alors elle devra montrer un message de bienvenue spécifique à l'utilisateur (lui rappellant par exemple son nom ou son email)Pour gérer les utilisateurs, pensez à réaliser une variable statique dans une classe de fausse base de données. Cette variable pourra ainsi être accessible à l'ensemble des servlets de votre application
 */

public class Utilisateur {

    private static Long count = 0L;

    private final Long id;

    private String name;
    private String email;


    public Utilisateur() {
        this.id = ++count;
    }

    public Utilisateur(String name, String email, Long id) {
        this.name = name;
        this.email = email;
        this.id =  ++count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
