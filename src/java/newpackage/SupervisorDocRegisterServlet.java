/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author IPRC KARONGI
 */
public class SupervisorDocRegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	try (PrintWriter out = response.getWriter()) {
	    /* TODO output your page here. You may use following sample code. */
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Servlet SupervisorDocRegisterServlet</title>");	    
	    out.println("</head>");
	    out.println("<body>");
	    
	    
	    String title = request.getParameter("title");
	    String editor = request.getParameter("editor");
	    String author = request.getParameter("author");
	    
	    DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    LocalDateTime now = LocalDateTime.now();
	    
	    String createdon = dt.format(now);
	    
	    
	    
	    //make user object
	    user SupervisorDocModel = new user.supervisorDoc(title, editor, author, createdon);

	    //create a database model
	    UserDatabase regSupervisorDoc = new UserDatabase(ConnectionPro.getConnection());
	    if (regSupervisorDoc.saveSupervisorDoc(SupervisorDocModel)) {
	       response.sendRedirect("Supervisors.jsp");
	    } else {
		String errorMessage = "User Available";
		HttpSession regSession = request.getSession();
		regSession.setAttribute("RegError", errorMessage);
		response.sendRedirect("Supervisors.jsp");
		
		
	    out.println("</body>");
	    out.println("</html>");
	}
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
