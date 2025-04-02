
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ReadKV2{
    public static void main(String args[]){
        
        Properties prop = new Properties();
        Map<String, String> map = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("config.txt"))){
            String line;

            while((line = br.readLine()) != null){
                if(line.contains("=")){
                    String parts[] = line.split("=",2);
                    if(parts.length == 2){
                        map.put(parts[0].trim(),parts[1].trim());
                    }

                }
            }
            prop.load(br);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        map.forEach((k,v)-> {
            System.out.println(k + " = " + v);
        });
    }
}