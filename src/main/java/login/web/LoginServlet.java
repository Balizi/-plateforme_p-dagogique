package login.web;

import apprenants.dao.IApprenantsDaoImpl;
import entity.Apprenants;
import entity.Briefs;
import entity.Formateurs;
import entity.Promos;
import login.dao.ILoginDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("logeed");
        HttpSession session = request.getSession();
        String path = request.getServletPath();
        if(path.equals("/logout")){
            System.out.println(path);
            session.removeAttribute("role");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        String check = (String) session.getAttribute("role");

        if (action.equals("login")) {
            if(check == null) {
                System.out.println("Entre");
                String role = request.getParameter("role");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                System.out.println("Role " + role + ",Email : " + email + ",password : " + password);
                if ((role.equals("admin")) && (email != null && password != null)) {
                    System.out.println("addddmin1");
                    ILoginDaoImpl loginDao = new ILoginDaoImpl();
                    int a = loginDao.login(email, password, role);
                    if (a > 0) {
                        System.out.println("addddmin2");
                        session.setAttribute("role", "admin");
                        response.sendRedirect("listPromo.do");
                    } else {
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                } else if ((role.equals("formateur")) && (email != null && password != null)) {
                    System.out.println("foooooooor1");
                    ILoginDaoImpl loginDao = new ILoginDaoImpl();
                    ArrayList<Formateurs> formateurs = loginDao.getFormateureLogeed(email,password,role);
                    if(formateurs != null){
                        System.out.println("foooooooor2");
                        session.setAttribute("role", "formateur");
                        int Idformateure = formateurs.get(0).getId();
                        int IdPromos = formateurs.get(0).getPromosByIdpr().getId();
                        session.setAttribute("idFormateur", Idformateure);
                        session.setAttribute("idPromos", IdPromos);
                        response.sendRedirect("addApprenant.tech");
                    }else {
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                } else if ((role.equals("apprenant")) && (email != null && password != null)) {
                    System.out.println("Apppp1");
                    ILoginDaoImpl loginDao = new ILoginDaoImpl();
                    ArrayList<Apprenants> apprenants = loginDao.getApprenantsLogeed(email,password,role);
                    if(apprenants != null){
                        if(apprenants.get(0).getIdpr() != null){
                            System.out.println("Appppppp2");
                            session.setAttribute("role","apprenant");
                            session.setAttribute("idPromo",apprenants.get(0).getIdpr());
                            IApprenantsDaoImpl iApprenantsDao = new IApprenantsDaoImpl();
                            Promos promos = iApprenantsDao.getPromosById(apprenants.get(0).getIdpr());
                            ArrayList<Briefs> briefs = iApprenantsDao.getBriefPromo(promos);
                            response.sendRedirect("brief.apr");
                        }else {
                            session.setAttribute("idPromo",0);
                            response.sendRedirect("brief.apr");
                        }
                    }else {
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                } else{
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }else {
                request.getRequestDispatcher("indedx.jsp").forward(request,response);
            }
        }
    }
}