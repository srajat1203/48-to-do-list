

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tdlist;
import model.Us;

/**
 * Servlet implementation class Completed
 */
@WebServlet("/Completed")
public class Completed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String status = "";
	private String task = "";
	private String duedate = "";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Completed() {
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
		
		String nString = "Select l from Tdlist l where l.useremail = '" + email + "' and l.status = \"yes\"";
		List<Tdlist> tdlist = new ArrayList<Tdlist>();
		Utils<Tdlist> db = new Utils<Tdlist>();
		try{
			tdlist = db.getList(nString);
		}
		catch(Exception e)
		{
			System.out.println("complted list is empty");
		}
		
		if(!tdlist.isEmpty())
		{
			status = "";
			task = "";
			duedate = "";
			
			for(Tdlist cur: tdlist)
			{
				status += cur.getStatus() + "<br><br>";
				task += cur.getTask() + "<br><br>";
				duedate += cur.getDuedate() + "<br><br>";
			}
			
		}
		
		
		response.setContentType("text/html");
		request.setAttribute("status", status);
		request.setAttribute("task", task);
		request.setAttribute("duedate", duedate);
		getServletContext().getRequestDispatcher("/CompletedDisp.jsp")
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
