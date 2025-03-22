public class Message {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;  // ArithmeticException
        } catch (Exception e) {
            System.out.println("Using e.getMessage(): " + e.getMessage());
            System.out.println("Using e.printStackTrace():");
            e.printStackTrace();
        }
    }
}
