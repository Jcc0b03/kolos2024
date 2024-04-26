# Zbiór materiałów na kolosa 2024

- https://github.com/michaldziuba03/java
- https://github.com/mdpiekarz/java_lab_2024
- https://github.com/rvabka/java
- https://github.com/Kacperr4/Kolos2022
- https://github.com/Tomki2258/Repozytorium-OOP-2024
- https://github.com/kurzynam/OOP2024
- https://github.com/kdmitruk/java_lab_2024
- https://github.com/Jcc0b03/Kolos2022
- https://github.com/G0bi74/Kolos2023

## Odczytywanie pliku (klasa Scanner)

```
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
```

## Tworzenie customowego Exception

```
public class ExceptionName extends Exception { 
    public ExceptionName(String errorMessage) {
        super(errorMessage);
    }
}

```

# Przydatne klasy

- StringBuilder - https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
- Stream - https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
- ArrayList - https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html