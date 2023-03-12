/**
 * Data storage for the person Yannis.
 * Includes this persons properties.
 * @author ytack
 *
 */
public class Person {

	
	private static final String NAME = "Tack";
	private static final String FIRSTNAME = "Yannis";
	private static final String SEX = "M";
	private static final String EMAIL = "yannis.tack@ctg.com";
	private static final String TELEPHONE = "0486273623";
	private static final String COMPANY = "CTG";
	private static final String SSU = "Testing";
	private static final String SENIORITY = "Experienced";
	
	
	/**
	 * Gets the name of this person.
	 */
	public static String getName() {return NAME;}
	/**
	 * Gets the first name of this person.
	 */
	public static String getFirstName() {return FIRSTNAME;}
	public static String getSex() {return SEX;}
	public static String getEmail() {return EMAIL;}
	public static String getTelephone() {return TELEPHONE;}
	public static String getCompany() {return COMPANY;}
	public static String getSSU() {return SSU;}
	public static String getSeniority() {return SENIORITY;}

}
