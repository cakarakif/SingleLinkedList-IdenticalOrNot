import java.util.Scanner;

public class TestSLL {

	public static void main(String[] args) {

		//
		// Node yap�s� korunarak sadece SingleLinkedList class�ndaki display ve search metodu d�zenlendi.
		// (Class yap�s� Algoritma lab�nda kullan�lan mant�kt�r.)
		//

		Scanner sc = new Scanner(System.in);
		SingleLinkedList one = new SingleLinkedList();
		SingleLinkedList two = new SingleLinkedList();

		String first, second;

		// Kullanicidan giris al�nd�.
		System.out.print("First Sentence: ");
		first = sc.nextLine();
		System.out.println();

		System.out.print("Second Sentence: ");
		second = sc.nextLine();
		System.out.println();

		for (int i = 0; i < first.length(); i++) {// SLL aktarma i�lemi yap�ld�
													// #1
			one.add(first.substring(i, i + 1));
		}

		for (int i = 0; i < second.length(); i++) {// SLL aktarma i�lemi yap�ld�
													// #2
			two.add(second.substring(i, i + 1));
		}

		if (one.size() == two.size())
			findIdentical(one, two);// e�le�tirme yap�ld�.

		else// eger uzunluk e�it de�ilse direk olarak sonuc verildi.
			System.out.println("The sentences are not identical because the lengths of sentences are not equal.");

	}

	public static void findIdentical(SingleLinkedList one, SingleLinkedList two) {
		boolean flag = true;
		Object tempone = "-", temptwo = "-";//her eleman�n node yap�s�n� kullanarak ve Sll class�nda display metodu ile templer kullan�ld�.
		flag = true;
		int search = -1;

		for (int i = 0; i < two.size(); i++) {

			tempone = one.display(i);
			temptwo = two.display(i);
			int k = -1;

			// ilk kontrol d�ng�s�
			// birincinin ikincideki kar��l�klar� kontrol edildi.
			do {
				search = one.search(tempone, k);
				if (search != -1) {
					if (!((String) temptwo).equalsIgnoreCase((String) two.display(search))) {
						flag = false;
						break;
					}
				}
				k = search;
			} while (search != -1);

			// ikinci kontrol d�ng�s�
			// bu d�ng�de ayn� harflerin kar��l�klar� ayn� olsada, farkl�
			// harflerinde ayn� de�ere e�it olma ihtimali kontrol edildi.(aba-sss...gibi)
			if (flag == true) {
				k = -1;
				do {
					search = two.search(temptwo, k);
					if (search != -1) {
						if (!((String) tempone).equalsIgnoreCase((String) one.display(search))) {
							flag = false;
							break;
						}
					}
					k = search;
				} while (search != -1);
			}

		}

		if (flag == true) {
			System.out.println("Sentences are identical.");
			printIdentical(one, two);// ekrana yazd�rma i�lemi yap�ld�.
		} else
			System.out.println("Sentences are not identical.");

	}

	public static void printIdentical(SingleLinkedList one, SingleLinkedList two) {
		System.out.println();
		System.out.println("Matched letters:");
		System.out.println("----------------");
		for (int i = 0; i < one.size(); i++) {
			if (!one.display(i).equals(" ") && !two.display(i).equals(" ")) {// bosluklar�n
																				// yazd�r�lmas�
																				// engellendi.

				boolean flag = true;
				for (int j = 0; j < i; j++) {// ayn� kar��la�t�rmalar�n tekrar
												// yaz�lmas� engellendi.
					if (((String) one.display(j)).equalsIgnoreCase((String) one.display(i)))
						flag = false;
				}
				if (flag != false) {
					System.out.print(one.display(i) + "<->" + two.display(i));
					System.out.println();
				}
			}
		}
	}
}
