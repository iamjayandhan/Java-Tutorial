
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class FileEx {
    public static void main(String args[]){
        try{
            //File does not extends Auto Closable!
            //so it cannot be given inside try-with-resources!

            // Create a File object representing the file
            File fo = new File("New_file.txt"); //fo -> file obj (not real file!)

            // Check if file exists, if not, create a new file
            if (fo.createNewFile()) { //creates new file and returns boolean!
                System.out.println("File created: " + fo.getName());

                System.out.println("File existance status: "+ fo.exists());
                System.out.println("Is File: "+ fo.isFile());
                System.out.println("Is Directory: "+ fo.isDirectory());
            } else {
                System.out.println("File already exists.");
            }
        }
        catch(IOException e){
            System.out.println("Error occured: "+e.getMessage());
        }

        //write some content
        //FileWriter can be given in try-with-resources! Auto closed.
        try (FileWriter fw = new FileWriter("New_file.txt")){
            //only writes into the buffer, not into the file!
            fw.write("ज़्ड् इस् थे चुल्प्रित्");
            System.out.println("Wrote to Buffer.");

            //write from buffer into the file!
            fw.flush();
            System.out.println("Wrote to File!");

            //close the resources
            fw.close();

        } 
        catch (Exception e) {
            System.out.println("Some error occured while writing into the file!"+e.getMessage());
        }

        //Read the same
        //note: now that New_file.txt contains sanscript language!
        //how to read it correctly?
        //this fails - not possilbe to read it via int!
        // try(FileReader fr = new FileReader("New_file.txt")){
        //     int letter = fr.read();
        //     while(fr.ready()){
        //         System.out.println((char)letter);
        //         letter = fr.read();
        //     }
        // }
        // catch(IOException e){
        //     System.out.println("IOException occured!");
        // }

        //using BufferedReader?
        try(BufferedReader br = new BufferedReader(new FileReader("New_file.txt"))){
            // int letter = br.read();
            // while(br.ready()){
            //     System.out.println((char)letter);
            //     letter = br.read();
            // }
            while(br.ready()){
                System.out.println(br.readLine());
            }
        }
        catch(IOException e){
            System.out.println("IOException occured!");
        }

        //delete a file?
        try{
            File fo = new File("Random.txt");
            fo.createNewFile();
            System.out.println("File created successfully!");
            
            //delete file
            if(fo.delete()){
                System.out.println("File deleted Successfully!");
            }
            else{
                System.out.println("File cannot be deleted!");
            }
        }
        catch(IOException e){
            System.out.println("Some IOException: "+e.getMessage());
        }
    }    
}
