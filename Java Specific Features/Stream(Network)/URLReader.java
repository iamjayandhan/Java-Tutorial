import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://jdfolio.vercel.app"); // specific URL as input
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
