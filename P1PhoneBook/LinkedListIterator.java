package dsProject1;

/**
 * @author akhila vuppalapati
 *
 */
public class LinkedListIterator implements PhBIterator {

	private PNode<Person> nextNode;
	private PNode<Person> currentNode;

	// is there a node after this one or not
	@Override
	public boolean hasNext() {
		if (nextNode != null) {
			return true;
		} else {
			return false;
		}
	}
	// runtime: O(c)

	// this points the pointer to the next element
	// ie this moves the iterator onto the next node
	@Override
	public Person next() {
		currentNode = nextNode;
		nextNode = nextNode.getNext();
		return currentNode.getElement();
	}
	// runtime: O(c)
}
