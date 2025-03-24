import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterEx {
    public static void main(String args[]){
        // OutputStream os = System.out;

        // os.write(😍);

        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)) { //where to write? console!
            osw.write("Hello JD");  // Prints: Hello JD
            osw.write(97);          // 97 is 'a' → Prints: a
            osw.write(10);          // 10 is '\n' → Moves to a new line (nothing visible)
            osw.write('A');         // Prints: A (on a new line)
            osw.write('\n');        // Moves to a new line
            char arr[] = new char[]{'a','b','c'};
            
            // osw.write("😍".toCharArray()); //? , write(byte[]) handles only single byte, but that emoji is 2 bytes long!
            osw.write("😍");

            osw.write(arr);         // Prints: abc (on the new line)
        } 
        catch (Exception e) {
            System.out.println("Error occured!");
        }
        
    }
}
