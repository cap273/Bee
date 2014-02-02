/** An instance (i.e. object) maintains information about a bee. */
public class Bee {
	private String nickname; // Name of Bee, length > 0
	private int hatchYear; // year of hatching, >= 2000
	/* month of hatching, 1..12 where 1 is January 
	 * and 12 is December
	*/
	private int hatchMonth;
	/* gender of bee, where 'M' is male 
	 * and 'F' is female. If male, bee has no father
	 */
	private char gender;
	/* Name of mother of this bee. 
	 * Null if unknown.
	 */
	private Bee mother;
	/* Name of father of this bee. 
	 * Null if unknown.
	 */
	private Bee father;

}
