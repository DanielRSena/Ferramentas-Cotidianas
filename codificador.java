import java.util.Scanner;
import objsCodificador.*;

public class codificador {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in, "latin1");
        String codigo, mensagem;
        char menu = 's';
        int opcao = 0, maneira = 0;

        while (menu == 's') {

            System.out.println("\n\n\t\t\t--- Codificador ---\n\n1. Cifra de César \n2. Morse\n");

            do {
                opcao = Geral.pedirInt(entrada, "\tSua escolha: ");
                if (opcao != 1 && opcao != 2) System.out.println("\nSelecione apenas 1 ou 2");
            } while (opcao != 1 && opcao != 2);

            codigo = (opcao == 1) ? "Cifra de César" : "Morse";

            System.out.println("\nComo usará o codificador?\n\n\t1. " + codigo + " -> Mensagem\n\t2. Mensagem -> " + codigo + " \n\n");

            do {
                maneira = Geral.pedirInt(entrada, "\tSua escolha: ");
                if (maneira != 1 && maneira != 2) System.out.println("\nSelecione apenas 1 ou 2");
            } while (maneira != 1 && maneira != 2);  

            if(opcao == 1) {
                int num = Geral.pedirInt(entrada, "\nDigite a chave: ");
                mensagem = CifraDeCesar.traduzir(entrada, maneira, num);
            }
            else mensagem = (maneira == 1) ? Morse.decodificar(entrada) : Morse.codificar(entrada);

            System.out.println("\nMensagem: " + mensagem + "\n");

            menu = Geral.voltarAoMenu(entrada);
            System.out.println("\n");
        }
        entrada.close();
    }
}