
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {
    public static void main(String args[]){
        try (InputStreamReader isr = new InputStreamReader(System.in)){ //where to read? keyboard
            //this converts Byte to Character stream, that's Why the name StreamReader
            //Stream(Byte) -> Reader(Character)

            //InputStreamReader converts byte streams (InputStream) to character streams (Reader), 
            //making it possible to read character input from the keyboard (System.in).

            //System.in is a byte stream (from InputStream).
            //InputStreamReader acts as a bridge, converting bytes into characters using the default character encoding.
            
            System.out.println("Enter some letters: ");
            //If the user types "Hello", it will first read 'H' (72 in ASCII).
            int letters = isr.read();

            while(isr.ready()){ //checks if more input is available.
                System.out.println((char)letters);
                letters = isr.read(); //remaining chars present in input buffer.
            }   

            isr.close(); //releasing system resources.
            //above line is automatically added in New java7 latest verisons!
            //resources are closed after use automatically! this is done by try block internally.
            System.out.println();
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
