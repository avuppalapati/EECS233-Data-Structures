package dsProject1;

/**
 * @author akhila vuppalapati
 *
 */
public class ArrayListIterator implements PhBIterator {
	private PhBArrayList array = new PhBArrayList();
	private Person[] iteratorArrayList;

	@Override
	public boolean hasNext() {
		if (iteratorArrayList[array.getHowManyElements() + 1] != null) {
			return true;
		} else {
			return false;
		}
	}
	// runtime: O(c)

	@Override
	public Person next() {
		if (iteratorArrayList[array.getHowManyElements() + 1] == null) {
			throw new IllegalArgumentException("Falling off the list end");
		}
		Person next = iteratorArrayList[array.size()];
		iteratorArrayList[array.size()] = iteratorArrayList[array.size() + 1];
		return next;
	}

	// runtime: O(c)
}
