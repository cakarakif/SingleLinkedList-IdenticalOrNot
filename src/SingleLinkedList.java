
public class SingleLinkedList {

	private Node head;
	
	public SingleLinkedList() {
		head = null;
	}

	public void add(Object dataToAdd) {
		Node newNode = new Node(dataToAdd);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;

			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(newNode);
		}
	}

	public Object display(int whichone) {
		Object output=" ";
		int counter = -1;
		Node temp = head;

		while (temp != null) {
			counter++;

			if (counter == whichone && !temp.getData().equals(" ")) {
				output =temp.getData();
				break;
			}

			temp = temp.getLink();
		}
		return output;
	}

	public void remove(Object dataToRemove) {
		if (head == null)
			System.out.println("linked list is empty");

		else {
			while (head.getData() == dataToRemove) {
				head = head.getLink();
			}
			Node temp = head;
			Node prev = null;
			while (temp != null) {
				if (temp.getData() == dataToRemove) {
					prev.setLink(temp.getLink());
					temp = prev;
				} else {
					prev = temp;
					temp = temp.getLink();
				}
			}

		}
	}

	public int size() {
		if (head == null) {
			System.out.println("The Linked List is empty");
			return 0;
		} else {
			int counter = 0;
			Node temp = head;
			while (temp != null) {
				counter++;
				temp = temp.getLink();
			}
			return counter;
		}
	}

	public int search(Object dataToSearch,int morethan) {
		if (head == null) {
			return -1;
		} else {
			Node temp = head;
			int counter=-1;
			
			while (temp != null) {
				counter++;
				if (temp.getData().equals(dataToSearch) && counter>morethan) {
					return counter;
					}
				temp = temp.getLink();
			}
			return -1;
		}
	}

}
