import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Tdlist;

import org.junit.Test;


public class Completedtest {

	@Test
	public void test() {
		
		String email = "tony@stark.com";
		String nString = "Select l from Tdlist l where l.useremail = '" + email + "' and l.status = \"yes\" and id=41";
		List<Tdlist> tdlist = new ArrayList<Tdlist>();
		Utils<Tdlist> db = new Utils<Tdlist>();
		try{
			tdlist = db.getList(nString);
			
			

			Tdlist entry = new Tdlist();
			entry.setDuedate("08/08/2015");
			entry.setId(41);
			entry.setStatus("yes");
			entry.setTask("bike");
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
			System.out.println("complted list is empty");
		}
	}

}
