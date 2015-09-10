

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tdlist;
import model.Us;

/**
 * Servlet implementation class AddTask
 */
@WebServlet("/AddTask")
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Us curuser = (Us) session.getAttribute("curuser");
		String email = curuser.getEmail();
		long userid = curuser.getId();
		
		
		String taskname = request.getParameter("taskname");
		String taskdate = request.getParameter("taskdate");
		
		
		Tdlist nentry = new Tdlist();
		nentry.setDuedate(taskdate);
		nentry.setTask(taskname);
		nentry.setUseremail(email);
		nentry.setUserid(userid);
		nentry.setStatus("no");
		
		Utils<Tdlist> db = new Utils<Tdlist>();
		db.insert(nentry);
		
		
		response.setContentType("text/html");
		
		getServletContext().getRequestDispatcher("/ToDoList")
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
