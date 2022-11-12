package formateurs.web;

import entity.Apprenants;
import entity.Briefs;
import entity.Promos;
import formateurs.dao.ApprenantDaoImpl;
import formateurs.dao.IBriefsDaoImpl;
import formateurs.dao.IPromosDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class AppServlete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        String check= (String) session.getAttribute("role");
        if(path.equals("/addApprenant.tech")){
            if(check != null && check.equals("formateur")){
                ApprenantDaoImpl apprenantDao = new ApprenantDaoImpl();
                ArrayList<Apprenants> apprenants = apprenantDao.getAppWithoutPromo();
                request.setAttribute("listApp",apprenants);
                request.getRequestDispatcher("formateur/AddApp.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } else if (path.equals("/listApp.tech")) {
            if(check != null && check.equals("formateur")){
                int idPromo = (int) session.getAttribute("idPromos");
                int idFormat = (int) session.getAttribute("idFormateur");
                System.out.println(",Id Promo "+idPromo+",idFormat "+idFormat);
                ApprenantDaoImpl apprenantDao = new ApprenantDaoImpl();
                ArrayList<Apprenants> apprenants = apprenantDao.appOfMyPromo(idPromo);
                for (Apprenants a:apprenants ) {
                    System.out.println(a.toString());
                }
                request.setAttribute("listApprenants",apprenants);
                request.getRequestDispatcher("formateur/ListMyApp.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } else if (path.equals("/AddBrife.tech")) {
            if(check != null && check.equals("formateur")){
                request.getRequestDispatcher("formateur/AddBrief.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } else if (path.equals("/listBrief.tech")) {
            if(check != null && check.equals("formateur")){
                int idPromo = (int) session.getAttribute("idPromos");
                IBriefsDaoImpl iBriefsDao = new IBriefsDaoImpl();
                IPromosDaoImpl iPromosDao = new IPromosDaoImpl();
                Promos p = iPromosDao.getPromosById(idPromo);
                ArrayList<Briefs> briefs = iBriefsDao.getMyBrief(p);

                request.setAttribute("Brief",briefs);
                request.getRequestDispatcher("formateur/ListBrief.jsp").forward(request,response);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("event");
        HttpSession session = request.getSession();
        if(action.equals("addApp")){
            int idApp = Integer.parseInt(request.getParameter("idApp"));
            int idPromo = (int) session.getAttribute("idPromos");
            int idFormat = (int) session.getAttribute("idFormateur");
            System.out.println("Id Apprenante "+idApp+",Id Promo "+idPromo+",Id Formateur"+idFormat);
            ApprenantDaoImpl apprenantDao = new ApprenantDaoImpl();
            apprenantDao.addAppToMyPromo(idPromo,idApp);
            request.getRequestDispatcher("formateur/ListMyApp.jsp").forward(request,response);
        }else if (action.equals("addBrief")){
            String nom = request.getParameter("nom");
            String description = request.getParameter("desc");
            int idPromo = (int) session.getAttribute("idPromos");
            IPromosDaoImpl iPromosDao = new IPromosDaoImpl();
            Promos promos = iPromosDao.getPromosById(idPromo);
            IBriefsDaoImpl iBriefsDao = new IBriefsDaoImpl();
            Briefs briefs = new Briefs();
            briefs.setNom(nom);
            briefs.setStatus(false);
            briefs.setDescription(description);
            briefs.setPromosByIdpr(promos);
            System.out.println(briefs.toString());
            iBriefsDao.saveBriefs(briefs);
            response.sendRedirect("listBrief.tech");
        } else if (action.equals("distribuer")) {
            int idPromos = Integer.parseInt(request.getParameter("idPromo"));
            IBriefsDaoImpl iBriefsDao = new IBriefsDaoImpl();
            iBriefsDao.distribuerBrief(idPromos);
            response.sendRedirect("listBrief.tech");
        }
    }
}
