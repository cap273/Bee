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

	@Test
	public void testSecondConstructor1(){
		/* Create two Bees using first constructor. */
		Bee mom1= new Bee("Johnny Girl", 'F', 2004, 4);
		Bee dad1= new Bee("Johnny Boy", 'M', 2046, 1);
		
		/* Create a Bee using second constructor *
		 * This bee should be male and get mom1 assigned 
		 * as its mother */
		Bee child1= new Bee("Child #1", 2010, 6, mom1);
		assertEquals("Child #1", child1.getNickname());
		assertEquals(true, child1.isMale());
		assertEquals(2010, child1.getYear());
		assertEquals(6, child1.getMonth());
		assertEquals(mom1, child1.getMom());
		assertEquals(null, child1.getDad());
		assertEquals(0, child1.getNumChildren());
		
		/* Make sure that the number of children of parents (mom1 and dad1) *
		 * are correct */
		assertEquals(1, mom1.getNumChildren());
		assertEquals(0, dad1.getNumChildren());
		
		/* Create a Bee using second constructor *
		 * This bee should be female and get mom1 assigned 
		 * as its mother and dad1 assigned as its father */
		Bee child2= new Bee("Child #2", 2008, 1, mom1, dad1);
		assertEquals("Child #2", child2.getNickname());
		assertEquals(false, child2.isMale());
		assertEquals(2008, child2.getYear());
		assertEquals(1, child2.getMonth());
		assertEquals(mom1, child2.getMom());
		assertEquals(dad1, child2.getDad());
		assertEquals(0, child2.getNumChildren());
		
		/* Make sure that the number of children of parents (mom1 and dad1) *
		 * are correct */
		assertEquals(2, mom1.getNumChildren());
		assertEquals(1, dad1.getNumChildren());	
	}
	
	@Test
	public void testYoungerAndSibling(){
		/* Make some bees */
		Bee mom1= new Bee("Mom #1", 'F', 2008, 1);
		Bee dad1= new Bee("Dad #1", 'M', 2010, 1);
		Bee mom2= new Bee("Mom #2", 'F', 2010, 2);
		Bee dad2= new Bee("Mom #2", 'M', 2010, 8);
		Bee child1= new Bee("Child #1", 2008, 1, mom1);
		Bee child2= new Bee("Child #2", 2009, 12, mom1, dad1);
		Bee child3= new Bee("Child #3", 'M', 2089, 5);
		Bee child4= new Bee("Child #4", 2019, 5, mom2, dad2);
		Bee child5= new Bee("Child #5", 2765, 6, mom2, dad1);
		Bee child6= new Bee("Child #6", 5835, 5, mom2, dad1);
		
		/* Test isSibling method */
		assertEquals(child1.isSibling(child2),true);
		assertEquals(child2.isSibling(child1), true);
		assertEquals(child3.isSibling(child1), false);
		assertEquals(child1.isSibling(child3), false);
		assertEquals(child1.isSibling(mom2), false);
		assertEquals(mom2.isSibling(child1), false);
		assertEquals(child4.isSibling(child1), false);
		assertEquals(child5.isSibling(child1), false);
		assertEquals(child1.isSibling(child5), false);
		assertEquals(child5.isSibling(child2), true);
		assertEquals(child2.isSibling(child5), true);
		assertEquals(child6.isSibling(child5), true);
		assertEquals(child5.isSibling(child6), true);
		assertEquals(child5.isSibling(child3), false);
		assertEquals(child3.isSibling(child3), false);
		assertEquals(child4.isSibling(child4), false);
		assertEquals(mom2.isSibling(mom1), false);
		assertEquals(dad1.isSibling(mom1), false);
		
		/* Test isYounger method */
		assertEquals(child5.isYounger(child4), true);
		assertEquals(dad1.isYounger(mom2), false);
		assertEquals(child1.isYounger(mom1), false);
		assertEquals(dad2.isYounger(mom2), true);
			
	}
}
