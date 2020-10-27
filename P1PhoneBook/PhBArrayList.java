package dsProject1;

/**
 * @author akhila vuppalapati
 *
 */
public class PhBArrayList implements PhoneBook {
	private Person[] phBArray;
	private int howManyElements = size();
	private int capacityOfArray = size();

	public PhBArrayList() {
		phBArray = new Person[0];
	}
	// runtime: O(c)

	@Override
	public int size() {
		return phBArray.length;
	}
	// runtime: O(c)

	public int getHowManyElements() {
		return howManyElements;
	}
	// runtime: O(c)

	@Override
	public void insert(int i, Person person) {
		// will only double the size if the array is full.
		if (howManyElements == capacityOfArray) {
			// doubles the size
			Person[] newPhBArray = new Person[size() * 2];
			// the element gets added to the end when the user wants to insert in an index
			// bigger tahn the size of the array
			if (i > size()) {
				for (int j = 0; j < size(); j++) {
					newPhBArray[j] = phBArray[j];
				}
				newPhBArray[size() + 1] = person;
			} else if (i < 0) {
				newPhBArray[i] = person;
				for (int j = 0; j < i; j++) {
					newPhBArray[j] = phBArray[j];
				}
				newPhBArray[i] = person;
			} else {
				for (int j = 0; j < i; j++) {
					newPhBArray[j] = phBArray[j];
				}
				newPhBArray[i] = person;
				for (int j = i + 1; j < size() + 1; j++) {
					newPhBArray[j] = phBArray[j - 1];
				}
			}
			phBArray = newPhBArray;
			howManyElements++;
		} else {
			Person[] newPhBArray = new Person[size()];
			if (i > size()) {
				for (int j = 0; j < size(); j++) {
					newPhBArray[j] = phBArray[j];
				}
				newPhBArray[size() + 1] = person;
			} else if (i < 0) {
				newPhBArray[i] = person;
				for (int j = 0; j < i; j++) {
					newPhBArray[j] = phBArray[j];
				}
				newPhBArray[i] = person;
			} else {
				for (int j = 0; j < i; j++) {
					newPhBArray[j] = phBArray[j];
				}
				newPhBArray[i] = person;
				for (int j = i + 1; j < size() + 1; j++) {
					newPhBArray[j] = phBArray[j - 1];
				}
			}
			phBArray = newPhBArray;
			howManyElements++;
		}
	}
	// runtime: O(n)

	@Override
	public Person remove(int i) {
		Person elementRemoved = phBArray[i];
		if (size() > i) {
			Person[] newPhBArray = new Person[size() - 1];
			for (int j = 0; j < i; j++) {
				newPhBArray[j] = phBArray[j];
			}
			// this skips over the "ith" element and copies the rest of the array
			for (int j = i + 1; j < size() + 1; j++) {
				newPhBArray[j] = phBArray[j - 1];
			}
			phBArray = newPhBArray;
		}
		// this deals with cases where the sequence has fewer than i components
		else {
			// returns null because there's nothing that was removed and the array was not
			// modified
			return null;
		}
		// shrinks the array when less than or about 60% of the array is not filled
		if (howManyElements / capacityOfArray <= 0.6) {
			Person[] resizedPhBArray = new Person[howManyElements];
			for (int j = 0; j < howManyElements; j++) {
				resizedPhBArray[j] = phBArray[j];
			}
		}
		return elementRemoved;
	}
	// runtime: O(n)

	@Override
	public Person lookup(int i) throws Exception {
		if (size() < i || i < 0) {
			throw new IndexOutOfBoundsException();
		} else
			return phBArray[i];
	}
	// runtime: O(c)
}
