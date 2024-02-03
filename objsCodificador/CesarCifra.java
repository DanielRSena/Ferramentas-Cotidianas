package objsCodificador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CesarCifra {

    static Scanner entrada = new Scanner(System.in);

    public static int findKey() {

        int key = 0;

        while (true) {
            try {

                do {

                    System.out.print("\nDigite o número: ");
                    key = entrada.nextInt();
                    if (key > 25 || key < 0)
                        System.err.println("\nDigite um número entre 1 e 25");
                } while (key > 25 || key < 0);
                break;

            } catch (InputMismatchException e) {
                System.err.println("Apenas números são permitidos\n");
                entrada.nextLine();
            }

        }
        return key;
    }

    public static String traduza(int tipoTraduz, int numFixo) {

        String base, mensagem = "";
        char letra, alfabeto[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

        System.out.print("\nDigite a mensagem (apenas letras): ");
        entrada.nextLine(); // "come o enter"
        base = entrada.nextLine();

        for (int i = 0; i < base.length(); i++) { // passa por cada letra da mensagem base

            letra = base.charAt(i); // atribui a letra atual para a variável letra

            for (int j = 0; j < alfabeto.length; j++) { // percorre todo o vetor do alfabeto
                if (letra == alfabeto[j]) { // caso encontre a letra correspondente
                    if (tipoTraduz == 1) { // se decodifica, as letras "diminuem"
                        if (j - numFixo < 0) letra = alfabeto[alfabeto.length + (j - numFixo)];
                        else letra = alfabeto[j - numFixo];
                    } else { // se codifica, as letras "aumentam"
                        if (j + numFixo >= alfabeto.length) letra = alfabeto[j + numFixo - alfabeto.length];
                        else letra = alfabeto[j + numFixo];
                    }
                    break; // se achou a letra, não precisa continuar o for
                }
            }
            mensagem += letra;
        }
        return mensagem;
    }
}
