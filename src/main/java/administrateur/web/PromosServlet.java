package administrateur.web;

import administrateur.dao.PromoDaoImpl;
import entity.Promos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ControleurServlet", value = "/ControleurServlet")
public class PromosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String check= (String) session.getAttribute("role");
        String path = request.getServletPath();
        if (path.equals("/listPromo.do")) {
            if(check != null && check.equals("admin")){
                PromoDaoImpl promoDao = new PromoDaoImpl();
                ArrayList<Promos> promos = promoDao.getAllPromos();
                request.setAttribute("promos", promos);
                request.getRequestDispatcher("administrateur/listPromo.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } else if (path.equals("/addPromo.do")) {
            if(check != null && check.equals("admin")){
                request.getRequestDispatcher("administrateur/addPromo.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("event");
        HttpSession session = request.getSession();
        String check= (String) session.getAttribute("role");
        if (path.equals("addChamber")){
            if(check != null && check.equals("admin")) {
                String nom = request.getParameter("nom");
                String ans = request.getParameter("ans");
                String niveau = request.getParameter("niveau");
                Promos promos = new Promos();
                promos.setNom(nom);
                promos.setAnnescolaire(ans);
                promos.setNiveau(niveau);
                PromoDaoImpl promoDao = new PromoDaoImpl();
                promoDao.save(promos);
                response.sendRedirect("listPromo.do");
            }
        }
    }
}
