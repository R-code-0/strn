import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void write() {
        try (FileWriter w = new FileWriter("file.txt")) {
            for (int i = 0, n = 65; i < 26; i++, n++) {
                w.write("%s %s\n".formatted((char) n, (char) (n + 32)));
            }
            for (int i = 0, n = 48; i < 9; i++, n++) {
                w.write("%s\n".formatted((char) n));
            }
            w.write((char) 57);
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private static void read() {
        try (FileReader read = new FileReader("file.txt")) {
            Scanner sc = new Scanner(read);
            for (int i = 1; sc.hasNextLine(); i++) {
                System.out.printf("%d: %s\n", i, sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}