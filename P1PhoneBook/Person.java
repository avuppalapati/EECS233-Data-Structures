/**
 * 
 */
package dsProject1;

/**
 * @author akhila vuppalapati
 *
 */
public class Person {
	public final String personID;
	public final String phoneNum;
	
	public Person(String personID, String phoneNum) {
		this.personID = personID;
		this.phoneNum = phoneNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	//runtime: O(c)

	public String getPersonID() {
		return personID;
	}
	//runtime: O(c)

	public boolean equals(Person person1) {
		if (person1.getPersonID().equals(this.personID)) {
			return true;
		}
		else
			return false;
	}
	//runtime: O(c)
}
