package objsCodificador;
import java.util.Scanner;

public class Geral {
    
    static Scanner scanner = new Scanner(System.in);

    public static char returnOption(){

        char letter = 's';
        String word;

        System.out.println();

        do {
            System.out.print("\n\tDo you want to return to menu? (s/n): ");
            word = scanner.nextLine();
            letter = word.charAt(0);
        } while(letter != 's' && letter != 'n');

        return letter;
    }
}
