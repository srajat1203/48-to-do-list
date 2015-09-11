import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Tdlist;

import org.junit.Test;


public class ToDoListtest {

	@Test
	public void test() {
		String email = "tony@stark.com";
		String qString = "select l from Tdlist l where l.useremail = '" + email + "' and l.status = 'no'"; 
		Utils<Tdlist> dbl = new Utils<Tdlist>();
		List<Tdlist> tdlist = new ArrayList<Tdlist>(); 
		try{
			tdlist = dbl.getList(qString);
			
			

			Tdlist entry = new Tdlist();
			entry.setDuedate("07/07/2017");
			entry.setId(28);
			entry.setStatus("no");
			entry.setTask("buy chips");
			entry.setUseremail("tony@stark.com");
			entry.setUserid(1);
			
			
			
			for(Tdlist cur: tdlist)
			{
				assertEquals(cur.getDuedate(), entry.getDuedate());
				assertEquals(cur.getId(), entry.getId());
				assertEquals(cur.getStatus(), entry.getStatus());
				assertEquals(cur.getTask(), entry.getTask());
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("list is empty");
		}
	}

}
