package ua.nure.kn.bocharova.usermanagement1.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import ua.nure.kn.bocharova.usermanagement1.User;
import ua.nure.kn.bocharova.usermanagement1.DB.DaoFactory;
import ua.nure.kn.bocharova.usermanagement1.DB.DatabaseException;

public class AddServlet extends EditServlet {
	private static final long serialVersionUID = -1439944580914816594L;

	@Override
	protected void showPage(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/add.jsp").forward(req, resp);
	}

	@Override
	protected void processUser(User user) throws DatabaseException {
		
		DaoFactory.getInstance().getUserDao().create(user);
	}

	

}
