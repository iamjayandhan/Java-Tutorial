public class StringBufferClass{
	public static void main(String args[]){
		//mutable sequence of characters!
		StringBuffer sb = new StringBuffer();

		System.out.println(sb.capacity()); //16 by default!

		// sb.append("1234567890");
		// sb.append("123456");
		//16 16

		//upto 16 chars it is ok, if reaches above it
		//then it will double buffer size 16 to 34.

		/*
			* Capacity Expansion Rule (Java's internal logic):
			* When StringBuffer exceeds its current capacity, the new capacity is calculated as:
			* New Capacity = ( Old Capacity × 2) + 2
		*/

		sb.append("1234567890");
		sb.append("1234567");
		//16 34

		sb.insert(2,"Rolex");

		// System.out.println(sb.capacity());
		System.out.println(sb);

		// StringBuffer vs StringBuilder
		// StringBuffer is thread safe while StringBuilder is not.
		// StringBuffer is synchronized (thread-safe) but slower, while StringBuilder is not synchronized (not thread-safe)
		// but faster.  Use `StringBuffer` for multi-threading and `StringBuilder` for better performance in single-threaded programs.
	}
}