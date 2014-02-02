import static org.junit.Assert.*;

import org.junit.Test;

public class BeeTester {

	@Test
	public void testFirstConstructor1() {
		/* Create new instance of Bee */
		Bee b= new Bee("Johnny Girl", 'F', 2014, 6);
		
		// assertEquals statements
		assertEquals("Johnny Girl",b.getNickname());
		assertEquals(false,b.isMale());
		assertEquals(2014,b.getYear());
		assertEquals(6,b.getMonth());
		assertEquals(null,b.getMom());
		assertEquals(null,b.getDad());
		assertEquals(0,b.getNumChildren());
		
		/* Create second instance of Bee, this time male */
		Bee b2= new Bee("Johnny Boy", 'M', 2013, 4);
		
		// assertEquals statements
		assertEquals("Johnny Boy",b2.getNickname());
		assertEquals(true,b2.isMale());
		assertEquals(2013,b2.getYear());
		assertEquals(4,b2.getMonth());
		assertEquals(null,b2.getMom());
		assertEquals(null,b2.getDad());
		assertEquals(0,b2.getNumChildren());
	}

}
