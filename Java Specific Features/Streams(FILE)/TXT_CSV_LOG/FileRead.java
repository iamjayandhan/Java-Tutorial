import java.io.BufferedReader;
import java.io.FileReader;

public class FileRead {
    public static void main(String args[]){
        //"textfile.txt" or "industry.csv" or "app.log"
        try(BufferedReader br = new BufferedReader(new FileReader("app.log"))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(Exception e){
            System.out.println("Some error occured.");
        }
    }    
}
