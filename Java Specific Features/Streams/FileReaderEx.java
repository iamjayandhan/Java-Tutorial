
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) {
        //Opens note.txt for reading
        //try-with-resources!
        //ensuring automatic closure of the FileReader after the try block completes (even if an exception occurs).
        try(FileReader fr = new FileReader("note.txt")){ // now this resources will be automatically closed!
            
            //read() returns int (so we convert char to int and then vice versa to print it)
            int letter = fr.read(); //one letter from note.txt (ASCII format)
            
            //display input until buffer has it.
            while(fr.ready()){
                System.out.print((char)letter);
                letter = fr.read(); // read letter one by one from input buffer!
            }

            System.out.println();
        }   
        catch(FileNotFoundException e){
            System.out.println("Missing File!\nError found: "+ e.getMessage());
        }
        catch(IOException e){
            System.out.println("IO Exception occured! : "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Exception occured: "+ e.getMessage());
        }
        finally{
            System.out.println("Execution from Finally block!");
        }
    }
}
