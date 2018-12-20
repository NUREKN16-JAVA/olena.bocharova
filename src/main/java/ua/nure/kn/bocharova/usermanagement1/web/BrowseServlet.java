package ua.nure.kn.bocharova.usermanagement1.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import ua.nure.kn.bocharova.usermanagement1.User;
import ua.nure.kn.bocharova.usermanagement1.DB.DaoFactory;
import ua.nure.kn.bocharova.usermanagement1.DB.DatabaseException;
import ua.nure.kn.bocharova.usermanagement1.DB.UserDAO;

public class BrowseServlet extends HttpServlet {
	private static final long serialVersionUID = -8149264813010090267L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("addButton")!=null) {
			add(req,resp);
		}else if(req.getParameter("editButton")!=null) {
			edit(req,resp);
		}else if(req.getParameter("deleteButton")!=null) {
			delete(req,resp);
		}else if(req.getParameter("detailsButton")!=null) {
			details(req,resp);
		}else {
		
		browse(req,resp);
		}
	}

	private void details(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
        if (idStr == null || idStr.trim().length() == 0) {
            req.setAttribute("error", "You must select an user");
            req.getRequestDispatcher("/browse.jsp").forward(req, resp);
            return;
        }
        try {
            User user = (User) DaoFactory.getInstance().getUserDao().find(new Long(idStr));
            req.getSession().setAttribute("user", user);
        } catch (Exception e) {
            req.setAttribute("error", "ERROR: " + e.toString());
            req.getRequestDispatcher("/browse.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("/details").forward(req, resp);
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String idStr = req.getParameter("id");
	        if (idStr == null || idStr.trim().length() == 0) {
	            req.setAttribute("error", "You must select an user");
	            req.getRequestDispatcher("/browse.jsp").forward(req, resp);
	            return;
	        }
	        try {
	            UserDAO userDao = DaoFactory.getInstance().getUserDao();
	            User user = (User) userDao.find(new Long(idStr));
	            userDao.delete(user);
	            req.setAttribute("message", "User with id= " + user.getId()+" was deleted");    
	            resp.sendRedirect("./browse");            
	        } catch (Exception e) {
	            req.setAttribute("error", "ERROR: " + e.toString());
	            req.getRequestDispatcher("/browse.jsp").forward(req, resp);
	            return;
	        }      
		
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		if(idStr==null || idStr.trim().length()==0) {
			req.setAttribute("error", "You must select a user");
			req.getRequestDispatcher("/browse.jsp").forward(req,resp);
			return;
		}
		try {
			User user = DaoFactory.getInstance().getUserDao().find(new Long(idStr));
			req.getSession().setAttribute("user", user);
		}catch(Exception e) {
			req.setAttribute("error", "ERROR:"+e.toString());
			req.getRequestDispatcher("/browser.jsp").forward(req,resp);
		}
		req.getRequestDispatcher("/edit").forward(req, resp);
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/add").forward(req, resp);
		
	}

	private void browse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection users;
		try {
			users = DaoFactory.getInstance().getUserDao().findAll();
			req.getSession().setAttribute("users", users);
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
		} catch (DatabaseException e) {
			throw new ServletException(e);
		}
		
	}

}
