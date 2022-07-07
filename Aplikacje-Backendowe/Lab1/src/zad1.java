
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class zad1 {

    //Napisz program konsolowy za pomocą, którego można wyświetlić plik w konsoli (użyj: FileInputStream, try

    public static void main(String[] args) throws IOException {
        String text = "updated text";


        try (
                FileOutputStream stream= new FileOutputStream("file.txt");
                OutputStreamWriter writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8);
        ) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}