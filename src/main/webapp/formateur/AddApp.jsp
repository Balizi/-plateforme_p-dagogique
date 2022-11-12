<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add App</title>
    <link rel="stylesheet" href="formateur/css/sidebare.css" />
    <link rel="stylesheet" href="formateur/css/head.css" />
    <link rel="stylesheet" href="formateur/css/style.css"/>
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
                <a href="/addApprenant.tech" class="active">
                    <span class="las la-clipboard-list"></span>
                    <span>Ajouter Apprenants</span>
                </a>
            </li>
            <li>
                <a href="/listApp.tech">
                    <span class="las la-clipboard-list"></span>
                    <span>List apprenant</span>
                </a>
            </li>
            <li>
                <a href="/AddBrife.tech">
                    <span class="las la-clipboard-list"></span>
                    <span>Ajouter Brief</span>
                </a>
            </li>
            <li>
                <a href="/listBrief.tech">
                    <span class="las la-clipboard-list"></span>
                    <span>List Brief</span>
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
            <form action="addApp.tech" method="post">
                <input type="hidden" name="event" value="addApp"/>
                <h1><c:out value="hello" /></h1>
                <select name="idApp" id="" class="field">
                    <c:forEach items="${listApp}" var="p">
                        <option value="${p.id}">${p.nom} ${p.prenom}</option>
                    </c:forEach>
                </select><br>
                <button type="submit">Crée</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
