package dsProject1;

/**
 * @author akhila vuppalapati
 *
 */
public class Demo<T> {
	private T phoneBook1;
	private T phoneBook2;

	public Demo(T phoneBook1, T phoneBook2) {
		this.phoneBook1 = phoneBook1;
		this.phoneBook2 = phoneBook2;
	}

	// this removes any duplicates with the people for PhBArrayList
	// overloading
	public static void removeDuplicates(PhBArrayList phoneBook1, PhBArrayList phoneBook2) {
		for (int i = 0; i < phoneBook1.size(); i++) {
			for (int j = 0; j < phoneBook2.size(); j++) {
				if (phoneBook1.lookup(i).equals(phoneBook2.lookup(j))) {
					phoneBook1.remove(i);
				}
			}
		}
	}
	// runtime: O(n^3)

	// this removes any duplicates with the people for PhBLinkedList
	// overloading
	public static void removeDuplicates(PhBLinkedList phoneBook1, PhBLinkedList phoneBook2) {
		for (int i = 0; i < phoneBook1.size(); i++) {
			for (int j = 0; j < phoneBook2.size(); j++) {
				if (phoneBook1.lookup(i).equals(phoneBook2.lookup(j))) {
					phoneBook1.remove(i);
				}
			}
		}
	}
	// runtime: O(n^3)

	public static void main(String[] arg) {
		// i know that this is not done but I would implement my iterators here
		// this is where I would test my code
		PhBArrayList pb1 = new PhBArrayList();
		PhBLinkedList pb2 = new PhBLinkedList();

		Person p0 = new Person("Manju", "6306420386");
		Person p1 = new Person("Akhila", "6307314352");
		Person p2 = new Person("Rohan", "6306921941");
		Person p3 = new Person("Krishna", "6306420384");
		Person p4 = new Person("Seshu", "3129094610");
		Person p5 = new Person("Venu", "6306420385");
		Person p6 = new Person("Gopi", "6306420387");

		pb1.insert(0, p0);
		pb1.insert(1, p1);
		pb1.insert(2, p2);
		pb1.insert(3, p3);
		pb1.insert(4, p4);
		pb1.insert(5, p5);
		pb1.insert(6, p6);
		pb2.insert(0, p0);
		pb2.insert(1, p1);
		pb2.insert(2, p2);
		pb2.insert(3, p3);
		pb2.insert(4, p4);
		pb2.insert(5, p5);
		pb2.insert(6, p6);
	}

}
