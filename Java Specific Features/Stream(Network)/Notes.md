When it comes to **URL, URI, and URN**, these concepts exist in **networking and resource identification**, rather than traditional file I/O. However, Java provides ways to handle them through specific classes in the `java.net` package. Here's how they relate:

Rsources: 
https://www.geeksforgeeks.org/difference-between-url-uri-and-urn-in-java/

### **1. URI (Uniform Resource Identifier)**
   - A **general** way to identify any resource, which can be a URL, URN, or any other form.
   - Can be **absolute** (full path) or **relative** (depends on base URI).
   - Java provides the `java.net.URI` class.

   **Example:**
   ```java
   import java.net.URI;

   public class URIDemo {
       public static void main(String[] args) throws Exception {
           URI uri = new URI("https://example.com/path/resource?query=1#fragment");
           System.out.println("Scheme: " + uri.getScheme());
           System.out.println("Host: " + uri.getHost());
           System.out.println("Path: " + uri.getPath());
           System.out.println("Query: " + uri.getQuery());
           System.out.println("Fragment: " + uri.getFragment());
       }
   }
   ```
   - Output:
     ```
     Scheme: https
     Host: example.com
     Path: /path/resource
     Query: query=1
     Fragment: fragment
     ```

### **2. URL (Uniform Resource Locator)**
   - A **specific type of URI** that also provides a way to **locate** a resource (i.e., has a network address).
   - It includes **protocol (scheme), domain, port, path, query parameters**.
   - Java provides `java.net.URL`.

   **Example:**
   ```java
   import java.net.URL;

   public class URLDemo {
       public static void main(String[] args) throws Exception {
           URL url = new URL("https://www.google.com/search?q=java+networking");
           System.out.println("Protocol: " + url.getProtocol());
           System.out.println("Host: " + url.getHost());
           System.out.println("Port: " + url.getPort());  // -1 means default port
           System.out.println("Path: " + url.getPath());
           System.out.println("Query: " + url.getQuery());
       }
   }
   ```
   - Output:
     ```
     Protocol: https
     Host: www.google.com
     Port: -1
     Path: /search
     Query: q=java+networking
     ```

### **3. URN (Uniform Resource Name)**
   - A **unique identifier** for a resource, but it doesn't specify **where** to find it.
   - Example: ISBN numbers, DOI for academic papers.
   - Java doesn't have a separate `URN` class, but a `URI` can be a URN.

   **Example:**
   ```java
   URI urn = new URI("urn:isbn:0451450523");
   System.out.println("Scheme: " + urn.getScheme());
   System.out.println("Specific Part: " + urn.getSchemeSpecificPart());
   ```
   - Output:
     ```
     Scheme: urn
     Specific Part: isbn:0451450523
     ```

### **How They Relate to I/O?**
- **Reading from a URL** (e.g., web pages, APIs):
  ```java
  import java.io.BufferedReader;
  import java.io.InputStreamReader;
  import java.net.URL;

  public class URLReader {
      public static void main(String[] args) throws Exception {
          URL url = new URL("https://www.example.com");
          BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

          String line;
          while ((line = br.readLine()) != null) {
              System.out.println(line);
          }
          br.close();
      }
  }
  ```
- **Writing to a URL (POST request) requires `HttpURLConnection`** instead of plain streams.
