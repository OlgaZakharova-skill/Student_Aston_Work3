import java.util.List;

public class Main {
    public static void main(String[] arg) {
        String data = "Data to write to file.";
        String filePath = "file1.txt";
        MyFile myFile = new MyFile(filePath);
        try{
            myFile.writeFile(data);
            List<String> lines = myFile.readFile();
            System.out.println("File сontents: ");
            lines.stream()
                    .forEach(System.out::println);
        }
        catch (MyException e){
            System.out.println("Error while working with file: "+e.getMessage());
        }
    }

}
