import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class calculadorJuros {

    static Scanner entrada = new Scanner(System.in, "latin1");

    // Função juros simples
    static double jSimples() {

        double valorFinal, capital, taxaJuros;
        int tempo;

        do {
            System.out.print("Valor inicial, em reais: ");
            capital = entrada.nextDouble();
        } while (capital < 0);

        do {
            System.out.print("Taxa de juros, em porcentagem: ");
            taxaJuros = entrada.nextDouble();
        } while (capital < 0);

        do {
            System.out.print("Tempo, em meses: ");
            tempo = entrada.nextInt();
        } while (capital < 0);

        valorFinal = capital + capital * (taxaJuros / 100) * tempo;
        BigDecimal resJuros = BigDecimal.valueOf(valorFinal).setScale(2, RoundingMode.HALF_UP);
        valorFinal = resJuros.doubleValue();

        return valorFinal;
    }

    // Função juros compostos
    static double jCompostos() {

        double montante, capital, taxaJuros;
        int tempo;

        do {
            System.out.print("Digite o valor inicial: ");
            capital = entrada.nextDouble();
        } while (capital < 0);

        do {
            System.out.print("Digite a taxa de juros: ");
            taxaJuros = entrada.nextDouble();
        } while (taxaJuros < 0);

        do {
            System.out.print("Digite o tempo, em meses: ");
            tempo = entrada.nextInt();
        } while (tempo < 0);

        montante = capital * Math.pow((1 + (taxaJuros / 100)), tempo);

        BigDecimal resMontante = BigDecimal.valueOf(montante).setScale(2, RoundingMode.HALF_UP);
        montante = resMontante.doubleValue();

        return montante;
    }

    // Calculadora de Juros
    public static void main(String[] args) {

        String sRepetir;
        char menu = 's';

        // Programa
        while (menu == 's') {

            int opcao = 0;
            char repetir = 's';

            // Home
            System.out.println(
                    "\n\n\t\t--- Calculador de juros ---\n\nDigite o tipo de juros que quer calcular\n\n1. Juros simples\n2. Juros compostos\n");

            // Escolha da operação
            do {
                System.out.print("\tSua escolha: ");
                opcao = entrada.nextInt();
            } while (opcao != 1 && opcao != 2);

            // Opções

            // Juros Simples
            if (opcao == 1) {
                System.out.println("\n\n\t\t--- Juros Simples ---\n");
                while (repetir == 's') {

                    double valorFinal = jSimples();
                    System.out.println("\n\tValor final: R$ " + valorFinal + "\n");

                    // Repetir a conta dos Juros Simples
                    do {
                        System.out.print("Deseja fazer novamente? (s/n): ");
                        entrada.nextLine();
                        sRepetir = entrada.nextLine();
                        repetir = sRepetir.charAt(0);
                        System.out.println(repetir + "\n\n");
                    } while (repetir != 's' && repetir != 'n');
                }

            }

            // Juros compostos

            else if (opcao == 2) {
                System.out.println("\n\n\t\t--- Juros Compostos ---\n");
                while (repetir == 's') {

                    double valorFinal = jCompostos();
                    System.out.println("\n\tValor final: R$ " + valorFinal + "\n");

                    // Repetir a conta dos Juros Compostos
                    do {
                        System.out.print("Deseja fazer novamente? (s/n): ");
                        entrada.nextLine();
                        sRepetir = entrada.nextLine();
                        repetir = sRepetir.charAt(0);
                    } while (repetir != 's' && repetir != 'n');
                }
            }

            // Voltar para o menu Encerrar o programa
            System.out.print("\nVocê deseja voltar ao menu? (s/n) ");
            String sMenu = entrada.nextLine();
            menu = sMenu.charAt(0);

        }

        // Fim da calculadora
        System.out.println("\n\n\tMuito obrigado por usar essa ferramenta, aceito sugestões :)\n");

        entrada.close();
    }
}