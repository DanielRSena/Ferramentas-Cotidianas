package objsCodificador;
import java.util.Scanner;

public class Geral {

    public static char voltarAoMenu(Scanner entrada){

        char letra = 's';
        String palavra;

        do {
            System.out.print("\n\tDeseja voltar para o menu? (s/n): ");
            palavra = entrada.nextLine();
            letra = palavra.charAt(0);
        } while(letra != 's' && letra != 'n');

        return letra;
    }

    public static int pedirInt(Scanner entrada, String msg) {

        int num = 0;

        while (true) {
            try {
                System.out.print(msg);
                num = entrada.nextInt();
                return num;
            } catch (Exception e) {
                entrada.nextLine();
                System.out.println("\nApenas números são permitidos");
            }
        }
    }
}