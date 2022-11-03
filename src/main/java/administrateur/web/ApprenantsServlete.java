package administrateur.web;

import administrateur.dao.ApprenantsDaoImpl;
import entity.Apprenants;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class ApprenantsServlete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        String check= (String) session.getAttribute("role");
        if(path.equals("/addApprenant.app")){
            if(check != null && check.equals("admin")){
                request.getRequestDispatcher("administrateur/addApprenant.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } else if (path.equals("/listApp.app")) {
            if(check != null && check.equals("admin")){
                ApprenantsDaoImpl apprenantsDao = new ApprenantsDaoImpl();
                ArrayList<Apprenants> apprenants = apprenantsDao.getAllApprenant();
                request.setAttribute("listApprenants",apprenants);
                request.getRequestDispatcher("administrateur/listApp.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("event");
        HttpSession session = request.getSession();
        String check= (String) session.getAttribute("role");
        if(action.equals("addApp")){
            if(check != null && check.equals("admin")){
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                Apprenants apprenants = new Apprenants();
                apprenants.setNom(nom);
                apprenants.setPrenom(prenom);
                apprenants.setEmail(email);
                apprenants.setPassword(password);
                ApprenantsDaoImpl apprenantsDao = new ApprenantsDaoImpl();
                apprenantsDao.saveApprenants(apprenants);
                response.sendRedirect("listApp.app");
            }
        }
    }
}
