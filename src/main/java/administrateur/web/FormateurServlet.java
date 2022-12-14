package administrateur.web;

import administrateur.dao.FormateurDaoImpl;
import administrateur.dao.PromoDaoImpl;
import entity.Formateurs;
import entity.Promos;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class FormateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        String check= (String) session.getAttribute("role");
        if(path.equals("/addFormateur.fr")){
            if(check != null && check.equals("admin")){
                PromoDaoImpl promoDao = new PromoDaoImpl();
                ArrayList<Promos> promos = promoDao.getAllPromos();
                request.setAttribute("promos",promos);
                request.getRequestDispatcher("administrateur/addFormateur.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } else if (path.equals("/listFormateur.fr")) {
            if(check != null && check.equals("admin")){
                FormateurDaoImpl formateurDao = new FormateurDaoImpl();
                ArrayList<Formateurs> formateurs = formateurDao.getAllFormateure();
                request.setAttribute("listformateur",formateurs);
                request.getRequestDispatcher("administrateur/ListFormat.jsp").forward(request,response);
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
        if(action.equals("addFormateur")){
            if(check != null && check.equals("admin")) {
                System.out.println("Entre");
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                int idPr = Integer.parseInt(request.getParameter("niveau"));

                PromoDaoImpl promoDao = new PromoDaoImpl();
                Promos promos = promoDao.getPromosById(idPr);

                Formateurs formateurs = new Formateurs();
                formateurs.setNom(nom);
                formateurs.setPrenom(prenom);
                formateurs.setEmail(email);
                formateurs.setPassword(password);
                formateurs.setPromosByIdpr(promos);
                System.out.println(formateurs.toString());

                FormateurDaoImpl formateurDao = new FormateurDaoImpl();
                formateurDao.save(formateurs);
                response.sendRedirect("listFormateur.fr");
            }
        }
    }
}
