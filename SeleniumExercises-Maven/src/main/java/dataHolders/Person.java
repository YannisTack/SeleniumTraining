package dataHolders;
/**
 * Data storage for the person Yannis.
 * Includes this persons properties.
 * @author ytack
 *
 */
public class Person {

	private String firstName;
	private String lastName;
	private String sex;
	private String email;
	private String telephone;
	private String company;
	private String ssu;
	private String seniority;
	
	public Person(String firstName, String lastName, String sex, String email, String telephone, String company, String ssu, String seniority)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.email = email;
		this.telephone = telephone;
		this.company = company;
		this.ssu = ssu;
		this.seniority = seniority;
	}
	public Person()
	{
		this.firstName = "Yannis";
		this.lastName = "Tack";
		this.sex = "M";
		this.email = "yannis.tack@ctg.com";
		this.telephone = "0486273623";
		this.company = "CTG";
		this.ssu = "Testing";
		this.seniority = "Experienced";
	}
	
	/**
	 * Gets the name of this person.
	 */
	public String getName() {return lastName;}
	/**
	 * Gets the first name of this person.
	 */
	public String getFirstName() {return firstName;}
	public String getSex() {return sex;}
	public String getEmail() {return email;}
	public String getTelephone() {return telephone;}
	public String getCompany() {return company;}
	public String getSSU() {return ssu;}
	public String getSeniority() {return seniority;}

}
