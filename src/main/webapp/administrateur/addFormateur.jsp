<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter formateur</title>
    <link rel="stylesheet" href="administrateur/css/sidebare.css" />
    <link rel="stylesheet" href="administrateur/css/head.css" />
    <link rel="stylesheet" href="administrateur/css/style.css"/>
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
</head>
<body>
<input type="checkbox" id="nav-toggle">
<div class="sidebar">
    <div class="sidebar-brand">
        <h2><span class="lab la-accusoft"></span> <span>Holiday</span></h2>
    </div>

    <div class="sidebare-menu" id="sidebare-menu">
        <ul>
            <li>
                <a href="#">
                    <span class="las la-igloo"></span>
                    <span>DashBoard</span>
                </a>
            </li>
            <li>
                <a href="/listPromo.do">
                    <span class="las la-clipboard-list"></span>
                    <span>List promo</span>
                </a>
            </li>
            <li>
                <a href="/addPromo.do">
                    <span class="las la-clipboard-list"></span>
                    <span>Crée une promo</span>
                </a>
            </li>
            <li>
                <a href="/addFormateur.fr" class="active">
                    <span class="las la-clipboard-list"></span>
                    <span>Crée compte formateur</span>
                </a>
            </li>
            <li>
                <a href="/listFormateur.fr">
                    <span class="las la-clipboard-list"></span>
                    <span>List formateur</span>
                </a>
            </li>
            <li>
                <a href="/addApprenant.app" >
                    <span class="las la-clipboard-list"></span>
                    <span>Crée compte apprenant</span>
                </a>
            </li>
            <li>
                <a href="/listApp.app" >
                    <span class="las la-clipboard-list"></span>
                    <span>List apprenant</span>
                </a>
            </li>
        </ul>
    </div>
</div>
<div class="main-content">
    <%@include file="components/header.jsp"%>
</div>
<div class="con">
    <div class="contain">
        <div class="contact-box">
            <form action="../listPromo.fr" method="post">
                <input type="hidden" name="event" value="addFormateur"/>
                <input type="text" class="field" name="nom" placeholder="Nom" id="nom">
                <input type="text" class="field" name="prenom" placeholder="Prenom">
                <input type="email" class="field" name="email" placeholder="Email">
                <input type="text" class="field" name="password" placeholder="Mot de Passe" >
                <select name="niveau" id="" class="field">
                    <option selected disabled>Promo</option>
                    <c:forEach items="${promos}" var="p">
                        <option value="${p.id}">${p.nom}</option>
                    </c:forEach>
                </select><br>
                <button type="submit" >Crée</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
