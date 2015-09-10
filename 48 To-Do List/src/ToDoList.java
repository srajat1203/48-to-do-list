

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
 * Servlet implementation class ToDoList
 */
@WebServlet("/ToDoList")
public class ToDoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String status = "";
	private String task = "";
	private String duedate = "";
	private int empty = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoList() {
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
		
		String qString = "select l from Tdlist l where l.useremail = '" + email + "' and l.status = 'no'"; 
		Utils<Tdlist> dbl = new Utils<Tdlist>();
		List<Tdlist> tdlist = new ArrayList<Tdlist>(); 
		try{
			tdlist = dbl.getList(qString);
		}
		catch(Exception e)
		{
			System.out.println("list is empty");
			empty = 1;
		}
		
		
		if(empty == 0)
		{
			int count = 0;
			status = "";
			task = "";
			duedate = "";
			for(Tdlist cur: tdlist)
			{
				//System.out.println(cur.getId());
				status += getStatusView(cur.getId()) +  "<br><br>"; 
				task += cur.getTask() + "<br><br>";
				duedate += cur.getDuedate() + "<br><br>";
			}
		}
		
		
		

		
		response.setContentType("text/html");
		request.setAttribute("status", status);
		request.setAttribute("task", task);
		request.setAttribute("duedate", duedate);
		getServletContext().getRequestDispatcher("/ToDoListDisp.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String getStatusView(long id)
	{
		
		String s = "<input type=\"checkbox\" data-toggle=\"toggle\" data-on=\"Yes\" data-off=\"No\" id=\"toggle\"> " 
		+ "<script> "
		+ " $(function() { "
		+ "  $('#toggle-two').bootstrapToggle({ "
		+     " on: 'Enabled', "
		+      "off: 'Disabled' "
		+    "}); "
		+  "}) "
		+"</script> "
		+"<input type = \"hidden\" name=\"listid\" value=" + id + "> ";
		

		
		String m =  "<input type=\"checkbox\" data-toggle=\"toggle\" data-on=\"Yes\" data-off=\"No\" id=\"toggle\" name=\"lid\" value=" + id + "> "
		+ "<script> "
		+   "$(function() { "
		+    "$('#toggle').bootstrapToggle({ "
		+      "on: 'Enabled', "
		+      "off: 'Disabled' "
		+    "}); "
		+  "}) "
		+"</script>";
		
		
		String x = "<input type=\"checkbox\" name=\"lid\" value=" + id +  "/>";
		
		return m;
	}	
}
