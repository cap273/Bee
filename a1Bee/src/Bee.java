/** An instance (i.e. object) maintains information about a bee. */
public class Bee {
	private String nickname; // Name of this Bee, length>0
	private int hatchYear; // year of hatching of this Bee, >=2000
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

}
