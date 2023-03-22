// Author: Evie Welch
// date: 21/02/23

public class Exercise24_5 {
	public static void main(String[] args) {
		GenericQueue<String> gq = new GenericQueue<>();
		
		gq.add("1");
		gq.add("2");
		System.out.println("initial " + gq);
		
		
		gq.enqueue("3");
		System.out.println("enqueue " + gq);
		
		String x = gq.dqueue();
		
		System.out.print("dequeue " + gq);
		System.out.print(", dequeued item: " + x + "\n");
		
		
		
	}
}
