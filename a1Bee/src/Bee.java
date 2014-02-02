/** An instance (i.e. object) maintains information about a bee. */
public class Bee {
	/* Name of this Bee, length>0 */
	private String nickname; 
	
	/* year of hatching of this Bee, >=2000 */
	private int hatchYear;
	
	/* month of hatching of this Bee,
	 * 1..12 where 1 is January and 12 is December
	*/
	private int hatchMonth;
	
	/* gender of this Bee, where 'M' is male 
	 * and 'F' is female. If male, bee has no father
	 */
	private char gender;
	
	/* Name of mother of this Bee. 
	 * Null if unknown.
	 */
	private Bee mother;
	
	/* Name of father of this Bee. 
	 * Null if unknown.
	 */
	private Bee father;
	
	/* Number of children of this Bee.*/
	private int numChildren;
	
	
	/** Constructor: an instance with nickname n, gender g, 
	 * birth year y, and birth month m.
	 * Its parents are unknown, and it has no children.
	 * Precondition: n has at least 1 character, y>=2000, m is in 1..12,
	 * and g is 'M' for male or 'F' for female.
	 */
    public Bee(String n, char g, int y, int m) {
        assert n.length()>0; // Length of string n is greater than 0
        assert y >= 2000;
        assert 1 <= m && m <= 12;
        assert 'M' == g || 'F' == g;
        nickname= n;
        hatchYear= y;
        hatchMonth= m;
        gender= g;
        
    }
    
    /** Return this Bee's nickname */
    public String getNickname(){
    	return nickname;
    }
    
    /** Return the year this Bee hatched from its egg */
    public int getYear(){
    	return hatchYear;
    }
    
    /** Return the month this Bee hatched from its egg */
    public int getMonth(){
    	return hatchMonth;
    }
    
    /** Return the value of "This Bee is male." */
    public boolean isMale(){
    	return 'M' == gender;
    }
    
    /** Return this Bee's mother (null if unknown) */
    public Bee getMom(){
    	return mother;
    }
    
    /** Return this Bee's father (null if unknown) */
    public Bee getDad(){
    	return father;
    }
    
    /** Return the number of children of this Bee */
    public int getNumChildren(){
    	return numChildren;
    }


}
