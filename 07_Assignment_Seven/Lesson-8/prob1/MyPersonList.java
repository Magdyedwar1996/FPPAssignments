package w3l8;

import java.util.Objects;

// Common task : Make sure to check your code should not throw any run time exception
public class MyPersonList {
	private final int INITIAL_LENGTH = 3;
	private Person[] PersonArray;
	private int size;

	// Default Constructor
	public MyPersonList() {
		PersonArray = new Person[INITIAL_LENGTH];
		size = 0;
	}


	// 1. Implement method to Add as last element, make sure you have enough room else call resize()
	public void add(Person s) {
		if(s == null) return ;
		if(size == PersonArray.length)
			resize();
		PersonArray[size] = s ;
		size++;
	}


	// 2. get person information by passing index
	public Person get(int i) {
		if(i > size || i < 0)
			return null;
		return PersonArray[i];
		//return null;
	}


	// 3. Find the Person object using lastname
	public boolean find(String lastName) {
		if(lastName == null) return false;
		for (Person p : PersonArray) {
			if (Objects.equals(p.getLast(), lastName)) {
				return true;
			}
		}
		return false;
	}


  	// 4. Remove the person object by passing its lastname
	public boolean remove(String lastName) {
		for (int i = 0; i < size; i++) {
			if(size== 0 ) return false;
			if (Objects.equals(PersonArray[i].getLast(), lastName)) {
				for (int j = i; j < size - 1; j++) {
					PersonArray[j] = PersonArray[j + 1];
				}
				size--;
				return true;
			}
		}
		return false;
	}



  	// 5. Resizing the list
	private void resize() {

	Person[] NewArray = new Person[PersonArray.length * 2 ];
	System.arraycopy(PersonArray, 0 , NewArray, 0 , PersonArray.length);
	PersonArray = NewArray;
	}


   // To display all the persons list
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size - 1; ++i) {
			sb.append(PersonArray[i] + ", \n");
		}
		sb.append(PersonArray[size - 1] + "]");
		return sb.toString();
	}



   // Return the size
	public int size() {
		return size;
	}



	public static void main(String[] args) {
		MyPersonList list = new MyPersonList();
		list.add(new Person("Bruce", "Tom", 36));
		list.add(new Person("Paul", "Corozza", 51));
		list.add(new Person("Joe", "Lermon", 53));
		list.add(new Person("Anne", "Dow", 55));
		//System.out.println("\nSize() : " + list.size() + "\n" + list);
		list.remove("Bruce");
		System.out.println(list);
//		list.remove("Corozza");
//		System.out.println("\nSize() : " + list.size() + "\n" + list);
//		System.out.println("\nSearching of Lermon: " + list.find("Joe"));
//		System.out.println(list.get(2));
	}
}