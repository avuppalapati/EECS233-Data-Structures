package dsProject1;

/**
 * @author akhila vuppalapati
 *
 */
public class PNode<T> {

	// the element stored in the node
	private T element;

	// this refers to the next node on the list
	private PNode<T> next;

	// constructor
	public PNode(T element, PNode<T> next) {
		this.element = element;
		this.next = next;
	}
	// runtime: O(c)

	// Returns the element stored in the node
	public T getElement() {
		return element;
	}
	// runtime: O(c)

	// returns the next node of the list
	public PNode<T> getNext() {
		return next;
	}
	// runtime: O(c)

	// changed the node that comes after this node in the list
	public void setNext(PNode<T> next) {
		this.next = next;
	}
	// runtime: O(c)

	// returns the length after this node to the end of the list.
	public int lengthFromHere() {
		// this is the end of the list so
		if (getNext() == null)
			// there are no more nodes
			return 0;
		// this is not the end of the list so
		else
			// the length is 1 more than next's length
			return 1 + getNext().lengthFromHere(); // the length is 1 more than next's length
	}
	// runtime: O(n)

	// Insert a new node after this node in the list.
	public void insertAfter(T element) {
		PNode<T> next = new PNode<T>(element, getNext());
		this.setNext(next);
	}
	// runtime: O(c)

	// Remove the node that occurs immediately after this node in the list.
	public void deleteNext() {
		if (this.getNext() != null) {
			this.setNext(getNext().getNext());
		}
	}
	// runtime: O(c)

}
