

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import model.Us;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private int choice = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		System.out.println(email);
		
		if(email != null)
		{
			if(!email.isEmpty())
			{
				String qString = "Select u from Us u where u.email = '" + email + "'";
				Utils<Us> db = new Utils<Us>();
				Us user = new Us();
				try{
					user = db.getResult(qString);	
				}
				catch(Exception e){
					System.out.println("No user");
				}
				
				
				if(user.getEmail() == null)
				{
					choice = 1;
					System.out.println("No user found");
				}
				else
				{
					choice = 2;
					System.out.println("User found");
					HttpSession session = request.getSession();
					session.setAttribute("curuser", user);
				}
			
			}
		}
		
		String des = "";
		if(choice == 1)
		{
			des = "/LoginDisp.jsp";
		}
		else
		{
			des = "/ToDoList";
		}
		
		
		response.setContentType("text/html");		
		getServletContext().getRequestDispatcher(des)
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
