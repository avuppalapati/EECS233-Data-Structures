package dsProject1;

/**
 * @author akhila vuppalapati
 *
 */
public class PhBLinkedList implements PhoneBook {
	/** the first node of the list, or null if the list is empty */
	private PNode<Person> frontNode;
	private int lengthSoFar;

	public PhBLinkedList() {
		PNode<Person> frontNode = null;
		int lengthSoFar = 0;
	}
	// runtime: O(c)

	protected PNode<Person> getFront() {
		return frontNode;
	}
	// runtime: O(c)

	// changes the front node
	protected void setFront(PNode<Person> node) {
		this.frontNode = node;
	}
	// runtime: O(c)

	// Add an element to the front of the linked list
	public void addToFront(Person element) {
		setFront(new PNode<Person>(element, getFront()));
	}
	// runtime: O(c)

	@Override
	public int size() {
		return lengthSoFar;
	}
	// runtime: O(c)

	@Override
	public void insert(int i, Person person) {
		if (i <= 0) {
			i = 0;
			addToFront(person);
		} else {
			PNode<Person> currentNode = getFront();
			int j = 0;
			while (currentNode.getNext() != null && j < i) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(new PNode<Person>(person, currentNode.getNext()));
		}

		lengthSoFar++;
	}
	// runtime: O(n^2)

	@Override
	public Person remove(int i) {
		if (i < size() && i >= 0) {
			PNode<Person> currentNode = getFront();
			int j = 0;
			while (currentNode.getNext() != null && j < i) {
				currentNode = currentNode.getNext();
				j++;
			}
			PNode<Person> nodeRemoved = currentNode.getNext();
			// the pointer skips the element
			currentNode.setNext(currentNode.getNext().getNext());
			lengthSoFar--;
			return nodeRemoved.getElement();
		}
		// i is not in the list
		else {
			return null;
		}
	}
	// runtime: O(n)

	@Override
	public Person lookup(int i) {
		if (0 <= i && i < size()) {
			PNode<Person> currentNode = getFront();
			int j = 0;
			while (currentNode.getNext() != null && j < i) {
				currentNode = currentNode.getNext();
				j++;
			}
			return currentNode.getNext().getElement();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	// runtime: O(n)

}
