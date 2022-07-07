import java.io.IOException;


public class zad6 {
//Napisz program rozbijający plik na osobne linie. Wypisz je w konsoli,
// dodając numery. (https://dirask.com/posts/JavaScript-split-string-by-new-line-character-k1wEQp)
    public static void main(String[] args) throws IOException {

        String string = "line/line2";
        String[] parts = string.split("/");

        for (int i = 0; i < parts.length; i++) {
            System.out.println( "Line " +  Integer.toString(i) + ":" + parts[i]);
        }
    }
}