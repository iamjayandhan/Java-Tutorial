
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ReadKV{
    public static void main(String args[]){
        
        Properties prop = new Properties();

        try(BufferedReader br = new BufferedReader(new FileReader("config.txt"))){
            prop.load(br);
            System.out.println(prop.getProperty("username"));
            System.out.println(prop.getProperty("password"));
            System.out.println(prop.getProperty("url"));

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}