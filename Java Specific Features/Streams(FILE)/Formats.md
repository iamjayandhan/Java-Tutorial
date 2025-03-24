### How to Read Different File Types in Java  

#### **1. Text Data (`.txt`, `.csv`, `.json`, `.xml`, `.properties`)**  
- **For `.txt` and `.csv`** → Use `BufferedReader`, `FileReader`, or `Scanner`.  
- **For `.json`** → Use `Jackson` (`ObjectMapper`) or `Gson`.  
- **For `.xml`** → Use `DOM Parser` or `SAX Parser`.  
- **For `.properties`** → Use `Properties` class.  

#### **2. Configuration Files (`.properties`, `.yml`, `.xml`)**  
- **For `.properties`** → Use `Properties.load(new FileReader("config.properties"))`.  
- **For `.yml` (YAML)** → Use `SnakeYAML` library.  
- **For `.xml`** → Use `DocumentBuilder` from `javax.xml.parsers`.  

#### **3. Binary Data (`.pdf`, `.ser`, `.dat`)**  
- **For `.pdf`** → Use `Apache PDFBox` or `iText`.  
- **For `.ser` (Serialized objects)** → Use `ObjectInputStream` (`readObject()`).  
- **For `.dat` (Raw binary data)** → Use `DataInputStream` (`readInt()`, `readUTF()`).  

#### **4. Streaming Files (`.mp4`, `.mp3`, `.wav`)**  
- **For media files** → Use `Java Media Framework (JMF)` or external libraries like `JLayer` for MP3, `javax.sound.sampled` for WAV.  
- **For general streaming** → Use `BufferedInputStream` or `FileInputStream`. 


Here are Java code snippets for reading different types of files:  

---

### **1. Reading Text Data (`.txt`, `.csv`, `.json`, `.xml`, `.properties`)**  

#### **Reading `.txt` and `.csv` using `BufferedReader`**  
```java
import java.io.*;

public class ReadTextFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
---

#### **Reading `.json` using Jackson (`ObjectMapper`)**  
```java
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ReadJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("data.json"));
            System.out.println(jsonNode.toPrettyString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
**Dependency for Jackson (if using Maven)**  
```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.0</version>
</dependency>
```
---

#### **Reading `.xml` using `DocumentBuilder` (DOM Parser)**  
```java
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

public class ReadXml {
    public static void main(String[] args) {
        try {
            File file = new File("data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("employee");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                System.out.println("ID: " + element.getElementsByTagName("id").item(0).getTextContent());
                System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
---

#### **Reading `.properties` file using `Properties` class**  
```java
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("config.properties")) {
            Properties properties = new Properties();
            properties.load(reader);
            System.out.println("Username: " + properties.getProperty("username"));
            System.out.println("Password: " + properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
---

### **2. Reading Configuration Files (`.yml`, `.xml`)**  

#### **Reading `.yml` using SnakeYAML**  
```java
import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class ReadYaml {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("config.yml")) {
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(fis);
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
**Dependency for SnakeYAML (if using Maven)**  
```xml
<dependency>
    <groupId>org.yaml</groupId>
    <artifactId>snakeyaml</artifactId>
    <version>2.0</version>
</dependency>
```
---

### **3. Reading Binary Data (`.pdf`, `.ser`, `.dat`)**  

#### **Reading `.pdf` using Apache PDFBox**  
```java
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

public class ReadPdf {
    public static void main(String[] args) {
        try (PDDocument document = PDDocument.load(new File("document.pdf"))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
**Dependency for PDFBox (if using Maven)**  
```xml
<dependency>
    <groupId>org.apache.pdfbox</groupId>
    <artifactId>pdfbox</artifactId>
    <version>2.0.29</version>
</dependency>
```
---

#### **Reading Serialized Object (`.ser` file) using `ObjectInputStream`**  
```java
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadSerialized {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {
            Object obj = ois.readObject();
            System.out.println("Deserialized Object: " + obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```
---

#### **Reading `.dat` file using `DataInputStream`**  
```java
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDat {
    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("data.dat"))) {
            int value = dis.readInt();
            System.out.println("Read integer: " + value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
---

### **4. Reading Streaming Files (`.mp4`, `.mp3`, `.wav`)**  

#### **Reading Media Files (`.mp3`, `.wav`) using `javax.sound.sampled`**  
```java
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReadAudio {
    public static void main(String[] args) {
        try {
            File audioFile = new File("audio.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            Thread.sleep(5000); // Play for 5 seconds
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
---

#### **Reading Large Binary Files (`.mp4`, `.mp3`) using `BufferedInputStream`**  
```java
import java.io.*;

public class ReadLargeFile {
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("video.mp4"))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                System.out.println("Read " + bytesRead + " bytes...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
---