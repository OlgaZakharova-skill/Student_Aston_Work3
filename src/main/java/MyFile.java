import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static java.nio.file.Path.of;

public class MyFile {
    private final Path filePath;
    public MyFile(String filePath){
        this.filePath = of(filePath);
    }
    public void writeFile(String data) throws MyException{
        try{
            Files.writeString(filePath, data, StandardOpenOption.CREATE);
            System.out.println("Data added successfully.");
        } catch (IOException e) {
            throw new MyException("Data writing error", e);
        }
    }
    public List<String> readFile() throws MyException {
        try {
            return Files.readAllLines(filePath, StandardCharsets.UTF_8);
        } catch (NoSuchFileException e) {
            throw new MyException("File not found", e);
        } catch (IOException e) {
            throw new MyException("Error opening file", e);
        }
    }
}
