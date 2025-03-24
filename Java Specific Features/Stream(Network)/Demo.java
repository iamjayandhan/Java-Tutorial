import java.net.URI;
import java.net.URL;

public class Demo {
    public static void main(String[] args) throws Exception {
        // URI uri = new URI("https://example.com/path/resource?query=1#fragment");
        URI uri = new URI("https://jdfolio.vercel.app/");
        System.out.println("Scheme: " + uri.getScheme());
        System.out.println("Host: " + uri.getHost());
        System.out.println("Path: " + uri.getPath());
        System.out.println("Query: " + uri.getQuery());
        System.out.println("Fragment: " + uri.getFragment());

        System.out.println();

        // URL url = new URL("https://www.google.com/search?q=java+networking");
        URL url = new URL("https://www.google.com/search?q=iamjayandhan");
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());  // -1 means default port
        System.out.println("Path: " + url.getPath());
        System.out.println("Query: " + url.getQuery());

        System.out.println();

        URI urn = new URI("urn:isbn:0451450523");
        System.out.println("Scheme: " + urn.getScheme());
        System.out.println("Specific Part: " + urn.getSchemeSpecificPart());
    }
}