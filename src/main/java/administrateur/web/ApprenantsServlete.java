package administrateur.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ApprenantsServlete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/addApprenant.app")){
            request.getRequestDispatcher("administrateur/addApprenant.jsp").forward(request,response);
        } else if (path.equals("/listApp.app")) {
            request.getRequestDispatcher("administrateur/listApp.jsp").forward(request,response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
