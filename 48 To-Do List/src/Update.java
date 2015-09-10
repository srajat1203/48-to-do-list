

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tdlist;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Long> listids = new ArrayList<Long>();
		
		String[] lids = request.getParameterValues("lid");
		for(String s: lids)
		{
			long tmp = Long.parseLong(s);
			listids.add(tmp);
		}
		
		
		Utils<Tdlist> db = new Utils<Tdlist>();
		for(long id: listids)
		{
			String nString = "Select l from Tdlist l where l.id = " + id;
			Tdlist entry = db.getResult(nString);
			entry.setStatus("yes");
			db.update(entry);
		}
		
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
