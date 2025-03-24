
import java.io.FileWriter;

public class FileWriterEx {
    public static void main(String args[]){
        try(FileWriter fw = new FileWriter("note.txt",true)){ //boolean - Append all stuff
            //overrides previous content
            //if you want to append all below stuff, then provide 'true' as second param in FileWriter above!
            fw.write("Hello Jayandhan\n");
            fw.write("abcdefghijklmnopqrstuvwxyz",5,5); // str,offset(where to start),how many char to print!

            char[] arr = new char[]{'J','D'};
            fw.write(arr);
            fw.append('a');
            fw.write("\nhello");
        } 
        catch (Exception e) {
            System.out.println("Something happend, oh i see...Error!!!");
        }
    }    
}
