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
	
	@Test
	public void testSetterMethods1(){
		/* Create new instances of Bee */
		Bee child1= new Bee("Johnny Girl", 'F', 2004, 4);
		Bee child2= new Bee("Johnny Boy", 'M', 2046, 1);
		Bee father1= new Bee("Paco", 'M', 2003, 4);
		Bee mother1= new Bee("Carmen", 'F', 2001, 6);
		
		/* Use setter methods. 
		 * child1 and child2 share the same mother, 
		 * but child2's father is unknown 
		 */
		child1.addMom(mother1);
		child1.addDad(father1);
		child2.addMom(mother1);
		
		/* Test for expected child-parent relationships */
		assertEquals(mother1,child1.getMom());
		assertEquals(mother1,child2.getMom());
		assertEquals(father1,child1.getDad());
		assertEquals(null,child2.getDad());
		
		/* Test for expected number of children */
		assertEquals(2,mother1.getNumChildren());
		assertEquals(1,father1.getNumChildren());
		assertEquals(0,child1.getNumChildren());
		assertEquals(0,child2.getNumChildren());
				
	}

}
