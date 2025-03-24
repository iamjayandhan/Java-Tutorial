
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

public class BufferedWriterEx {
    public static void main(String args[]){
        //BufferedWriter for a file
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("buffWrite.txt",true))) { //to the file,append:true
            bw.write("Hello");
            bw.append("ok check!");
        }
        catch (Exception e) {
            System.out.println("Error occured!");
        }

        //BufferedWriter for a console
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) { //to the console
            bw.write("Hello");
            bw.append("ok check!");
        }
        catch (Exception e) {
            System.out.println("Error occured!");
        }
    }    
}
