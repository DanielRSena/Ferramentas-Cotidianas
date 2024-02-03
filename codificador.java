import java.util.InputMismatchException;
import java.util.Scanner;
import objsCodificador.*;

public class codificador {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in, "latin1");
        String codigo = "", mensagem;
        char menu = 's';
        int opcao = 0, maneira = 0;

        //funcionará enquanto o user quiser
        while (menu == 's') {

            System.out.println("\n\n\t\t\t--- Codificador ---\n\n1. Morse \n2. Cifra de César"); // menu

            //bloco para escolher qual código será usado
            while (true) {
                try {

                    do {

                        System.out.print("\n\tSua escolha: ");
                        opcao = entrada.nextInt();
                        if (opcao != 1 && opcao != 2) System.out.println("\nSelecione apenas 1 ou 2");
                    } while (opcao != 1 && opcao != 2);
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("\nErro! Apenas números são permitidos");
                    entrada.nextLine();
                }
            }

            if(opcao == 1) codigo = "Morse";
            else codigo = "Cifra de César";

            System.out.println("\nComo usará o codificador?\n\n\t1. " + codigo + " -> Mensagem\n\t2. Mensagem -> " + codigo + " \n\n");

            //bloco que verifica se quer codificar ou decodificar
            while (true) {

                try {

                    do {
                        System.out.print("\n\tSua escolha: ");
                        maneira = entrada.nextInt();
                        if (maneira != 1 && maneira != 2) System.out.println("\nSelecione apenas 1 ou 2");
                    } while (maneira != 1 && maneira != 2);
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("\nErro! Apenas números são permitidos");
                    entrada.nextLine();
                }
            }

            if (opcao == 1) { 

                if (maneira == 1) mensagem = Morse.paraLetras();
                else mensagem = Morse.letrasParaMorse();
                System.out.println("\nA mensagem codificada é: " + mensagem + "\n");
            }
            else {

                int num = CesarCifra.findKey();
                mensagem = CesarCifra.traduza(maneira, num);
                System.out.println("\nA mensagem codificada é: " + mensagem + "\n");
            }

            menu = Geral.returnOption();
            System.out.println("\n");
        }
        entrada.close();
    }
}