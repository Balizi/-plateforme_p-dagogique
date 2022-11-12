<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Apprenat</title>
    <link rel="stylesheet" href="administrateur/css/sidebare.css" />
    <link rel="stylesheet" href="administrateur/css/head.css" />
    <link rel="stylesheet" href="administrateur/css/listpromo.css"/>
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
                <a href="/addApprenant.tech">
                    <span class="las la-clipboard-list"></span>
                    <span>Ajouter Apprenants</span>
                </a>
            </li>
            <li>
                <a href="/listApp.tech" class="active">
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
    <main>
        <div class="recent-grid">
            <div class="projects">
                <div class="card">
                    <div class="card-header">
                        <h3>List des promos</h3>
                        <button>See all <span class="las la-arrow-right"></span></button>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table width="80%" class="content-table">
                                <thead>
                                <tr>
                                    <th>Nom</th>
                                    <th>Prenom</th>
                                    <th>Email</th>
                                    <th width="10px">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listApprenants}" var="ap">
                                        <tr>
                                            <td data-label="Nom">${ap.nom}</td>
                                            <td data-label="Nom">${ap.prenom}</td>
                                            <td data-label="Nom">${ap.email}</td>
                                            <td>
                                                <span class="action_btn">
                                                    <a href="#">Modifier</a>
                                                    <form action="delete.do" method="post">
                                                        <input type="hidden" name="event" value="delete"/>
                                                        <input type="hidden" name="idCh" value=""/>
                                                        <input onclick="return confirm('Do you want to delete this room?')" type="submit" value="Delete" style="background-color: #FF1F1F;padding: 15px 32px;border-radius: 5px; border: none;color: white;font-size: 16px;cursor: pointer"/>
                                                    </form>
                                                </span>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>

</body>
</html>
