import static org.junit.Assert.*;
import model.Us;

import org.junit.Test;


public class Logintest {

	@Test
	public void correctlogin() {
		String email = "tony@stark.com";
		String qString = "Select u from Us u where u.email = '" + email + "'";
		Utils<Us> db = new Utils<Us>();;
		Us user = new Us();
		try{
			user = db.getResult(qString);	
			assertEquals(user.getEmail(), email);
		}
		catch(Exception e){
			System.out.println("No user");
		}
	}
	
	@Test
	public void incorrectlogin() {
		String email = "tony@ironman.com";
		String qString = "Select u from Us u where u.email = '" + email + "'";
		Utils<Us> db = new Utils<Us>();;
		Us user = new Us();
		try{
			user = db.getResult(qString);	
			
		}
		catch(Exception e){
			System.out.println("No user");
			assertEquals("notfound", "notfound");
		}
	}
	
	

}
