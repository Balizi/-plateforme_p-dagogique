package login.web;

import login.dao.ILoginDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

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
                String role = request.getParameter("role");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                System.out.println("Role " + role + ",Email : " + email + ",password : " + password);
                if ((role.equals("admin")) && (email != null && password != null)) {
                    ILoginDaoImpl loginDao = new ILoginDaoImpl();
                    int a = loginDao.login(email, password, role);
                    if (a > 0) {
                        session.setAttribute("role", "admin");
                        response.sendRedirect("listPromo.do");
                    } else {
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                } else if (role.equals("formateur")) {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }else {
                request.getRequestDispatcher("indedx.jsp").forward(request,response);
            }
        }
    }
}