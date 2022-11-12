package apprenants.web;

import apprenants.dao.IApprenantsDaoImpl;
import entity.Briefs;
import entity.Promos;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class AppServlete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        HttpSession session = request.getSession();
        String check= (String) session.getAttribute("role");
        if (path.equals("/brief.apr")){
            if(check != null && check.equals("apprenant")){
                int idPromo = (int) session.getAttribute("idPromo");
                if(idPromo != 0){
                    System.out.println("id promo : "+session.getAttribute("idPromo"));
                    IApprenantsDaoImpl iApprenantsDao = new IApprenantsDaoImpl();
                    Promos promos = iApprenantsDao.getPromosById((Integer) session.getAttribute("idPromo"));
                    ArrayList<Briefs> briefs = iApprenantsDao.getBriefPromo(promos);
                    request.setAttribute("brief",briefs);
                }
                request.getRequestDispatcher("apprenants/home.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } else if (path.equals("/rendu.apr")) {
            request.getRequestDispatcher("apprenants/rendu.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
