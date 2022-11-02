<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="./css/style.css" />
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>
<body style="background-image: url('./img/bg.jpg')">

<div class="main">
    <input type="checkbox" id="chk" aria-hidden="true">

    <div class="signup">
        <form action="index.html" method="post">
            <label for="chk" aria-hidden="true" >Connexion</label>
            <label class="inf">Adresse email </label>
            <input type="email" name="email" required="">
            <label class="inf">Mot de passe</label>
            <input type="password" name="pswd" required="">
            <label class="inf">Role</label>
            <select>
                <option value="">Administrateur</option>
                <option value="">Formateur</option>
            </select>
            <button>Se connecter</button>
        </form>
    </div>
</div>
</body>
</html>