/* Checked Javadoc output, everything OK */

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

    /** Add e as this Bee's mother.
     * Precondition: this Bee's mother is unknown and e is female.
     */
    public void addMom(Bee e){
    	assert mother == null; // Check that this Bee's mother is unknown
    	assert e.isMale() == false; //Check that e is female.
    	
    	mother= e; // Set e as the mother of this Bee.
    	e.numChildren= e.numChildren + 1; // Number of children of e increases by 1
    }
    
    /** Add e as this Bee's father.
     * Precondition: this Bee's father is unknown and e is male.
     */
    public void addDad(Bee e){
    	assert father == null; // Check that this Bee's father is unknown
    	assert e.isMale() == true; //Check that e is male.
    	
    	father= e; // Set e as the father of this Bee.
    	e.numChildren= e.numChildren + 1; // Number of children of e increases by 1
    }
    
    /** Constructor: a male Bee with nickname n, hatch year y, 
     * hatch month m, and mother ma.
     * Precondition: n has at least 1 character, y>=2000, m is in 1..12, 
     * and ma is a female.
     */
    public Bee(String n, int y, int m, Bee ma){
    	assert n.length()>0; // Length of string n is greater than 0
        assert y >= 2000;
        assert 1 <= m && m <= 12;
        assert ma.isMale() == false;
        nickname= n;
        hatchYear= y;
        hatchMonth= m;
        gender= 'M'; // Set gender of bee to be male.
        /* Add only mother to this Bee */
        addMom(ma);
    }
    
    /** Constructor: a female Bee with nickname n, hatch year y, 
     * hatch month m, mother ma, and father pa.
     * Precondition: n has at least 1 character, y>=2000, m is in 1..12, 
     * ma is a female and pa is a male.
     */
    public Bee(String n, int y, int m, Bee ma, Bee pa){
    	assert n.length()>0; // Length of string n is greater than 0
        assert y >= 2000;
        assert 1 <= m && m <= 12;
        assert ma.isMale() == false;
        assert pa.isMale() == true;
        nickname= n;
        hatchYear= y;
        hatchMonth= m;
        gender= 'F'; // Set gender of bee to be female.
        /* Add father and mother to this Bee */
        addMom(ma);
        addDad(pa);
    }
    
    /** Return the value of "This Bee is younger than e" *
     * Precondition: e is not null. *
     */
    public boolean isYounger(Bee e){
    	assert e != null;
    	return hatchYear > e.getYear() || (hatchYear == e.getYear() && hatchMonth > e.getMonth());
    }
    
    
    /** Return the value of "this Bee and e are siblings." *
     * Note: if e is null, they can't be siblings, so false is returned.
     */
    public boolean isSibling(Bee e){
    	/* Boolean procedure: Return TRUE IFF:
    	 * 1) e is not null, AND
    	 * 2) this bee is not the same bee as e, AND
    	 * 3) EITHER this bee and e share the same non-null father
    	 * 4) OR this bee and e share the same non-null mother
    	 */
    	return (e != null) && (this != e) &&
    			((father != null) && (father == e.getDad()) ||
    			(mother != null) && (mother == e.getMom()));
    }
        
}
