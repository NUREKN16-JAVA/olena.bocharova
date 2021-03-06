package ua.nure.kn.bocharova.usermanagement1.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.xml.bind.ValidationException;

import ua.nure.kn.bocharova.usermanagement1.User;
import ua.nure.kn.bocharova.usermanagement1.DB.DaoFactory;
import ua.nure.kn.bocharova.usermanagement1.DB.DatabaseException;

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = -477633379571031102L;
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("okButton")!=null) {
			doOk(req, resp);
		} else if(req.getParameter("cancelButton")!=null) {
			doCancel(req, resp);
		}else {
			showPage(req,resp);
		}
	}

	protected void showPage(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/edit.jsp").forward(req, resp);
		
	}

	private void doCancel(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/browse").forward(req, resp);
		
	}

	private void doOk(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		User user =null;
		try {
			user = getUser(req);
		} catch (ValidationException e1) {
			req.setAttribute("error", e1.getMessage());
			showPage(req,resp);
			return;
		}
		try {
			processUser(user);
		} catch (DatabaseException e) {
			e.printStackTrace();
			new ServletException(e);
		}
		req.getRequestDispatcher("/browse").forward(req, resp);
		
	}

	private User getUser(ServletRequest req) throws ValidationException {
		User user = new User();
		String idStr =req.getParameter("id");
		String firstName =req.getParameter("firstName");
		String lastName =req.getParameter("lastName");
		String dateStr =req.getParameter("date");
		
		if(firstName == null) {
			throw new ValidationException("First name is empty");
		}
		if(lastName == null) {
			throw new ValidationException("Last name is empty");
		}
		if(dateStr == null) {
			throw new ValidationException("Date is empty");
		}
		
		if(idStr !=null) {
			user.setId(new Long(idStr));
		}
		user.setFirstName(firstName);
		user.setLastName(lastName);
		try {
			user.setDateOfBirth(DateFormat.getDateInstance().parse(dateStr));
		} catch (ParseException e) {
			
			throw new ValidationException("Date format is incorrect");
		}
		return user;
	}

	protected void processUser(User user) throws DatabaseException {
		DaoFactory.getInstance().getUserDao().update(user);
		
	}

}
