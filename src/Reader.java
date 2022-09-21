import java.util.Scanner;

//думаю, что пояснять функции этого класса и класса Writer не нужно
public class Reader {
    private final Writer writer = new Writer();

    public String read (String line){
        Scanner scanner = new Scanner(System.in);
        writer.write(line);
        return scanner.nextLine();
    }
}
