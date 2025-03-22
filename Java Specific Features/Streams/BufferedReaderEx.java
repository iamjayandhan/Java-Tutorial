
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderEx {
    //Protip: when it comes to buffered, we can use readLine() ;
    //if not, then we can only read one char at a time.
    public static void main(String[] args) {
        //1. BUFFEREDREADER WITH KEYBOARD INPUT

        //this accepts Reader type!
        //system.in wont work! so we convert as usual!

        //br is now a character based stream linked to keyboard!
        //byte to char stream and reading char stream.
        try(BufferedReader br = new BufferedReader(new InputStreamReader((System.in)))){ //keyboard
            //read all input but print char by char
            // System.out.println("Enter some letters: ");
            // int letter = br.read();
            // while(br.ready()){
            //     System.out.println("Letter: "+ (char)letter);
            //     letter = br.read();
            // }

            //read all input and print all once!
            System.out.println("Enter any input: ");
            String inp = br.readLine();
            System.out.println("Entered input: "+inp);

        }
        catch(Exception e){
            System.out.println("Some error found: "+ e.getMessage());
        }
        finally{
            System.out.println("Execution from finally block!\n");
        }

        //2. BUFFEREDREADER WITH FILE INPUT
        try(BufferedReader br = new BufferedReader(new FileReader("note.txt"))){
            //print char by char
            // while(br.ready()){
            //     System.out.println((char)br.read());
            // }

            //print line by line
            while(br.ready()){
                System.out.println(br.readLine());
            }
        }
        catch(Exception e){
            System.out.println("Some error occured: "+e.getMessage());
        }
        finally{
            System.out.println("Execution from finally block!\n");
        }
    }
}
