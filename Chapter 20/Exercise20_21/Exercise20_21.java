
/*
Author: Evie Welch
Date: 02/20/23
*/
import java.util.Comparator;

public class Exercise20_21 {
	public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
		int length = list.length;
		for (int i = 0; i < length -1; i++) {
			
			int minIndex = i;
			for(int j = i+1; j < length; j++) {
				if(comparator.compare(list[j], list[minIndex]) == -1) {
					minIndex = j;
				}
			}
			
			E temp = list[minIndex];
			list[minIndex] = list[i];
			list[i] = temp;
		}
	}

	public static void main(String[] args) {
		
		GeometricObject[] list = { new Circle(5), new Rectangle(4, 5), new Circle(5.5), new Rectangle(2.4, 5),
				new Circle(0.5), new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1), new Circle(6.5),
				new Rectangle(4, 5) };
		selectionSort(list, new GeometricObjectComparator());
		System.out.println("list: ");
		for(GeometricObject i : list) {
			System.out.println(i.getArea() + " ");
		}
		System.out.println("");
		System.out.println("list1: ");
		Circle[] list1 = { new Circle(2), new Circle(3), new Circle(2), new Circle(5), new Circle(6), new Circle(1),
				new Circle(2), new Circle(3), new Circle(14), new Circle(12) };
		selectionSort(list1, new GeometricObjectComparator());
		for (int i = 0; i < list1.length; i++)
			System.out.println(list1[i].getArea() + " ");
	}

}