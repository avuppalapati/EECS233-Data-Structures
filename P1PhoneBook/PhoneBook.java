package dsProject1;

/**
 * @author akhila vuppalapati
 *
 */
public interface PhoneBook {
	int size();

	void insert(int i, Person person);

	Person remove(int i);

	Person lookup(int i) throws Exception;
}
