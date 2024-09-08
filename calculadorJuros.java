import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class calculadorJuros {
    // Função juros simples
    static double calcularJuros(Scanner entrada, int operacao) {

        double valorFinal = 0.0, capital, taxaJuros;
        int tempo;

        while (true) { //captura apenas números válidos para o valor inicial
           try {
             do {
                 System.out.print("\nDigite o valor inicial: ");
                 capital = entrada.nextDouble();
             } while (capital < 0);
             break;
           } catch (InputMismatchException e) { entrada.nextLine();}
        }

        while (true) { //captura apenas números válidos para a porcentagem de juros
            try {
                do {
                    System.out.print("\nDigite a taxa de juros por mês, em porcentagem: ");
                    taxaJuros = entrada.nextDouble();
                } while (taxaJuros < 0);
              break;
            } catch (InputMismatchException e) { entrada.nextLine();}
        }

        while (true) { //captura apenas números válidos para o tempo de vigor do juros (em meses)
            try {
                do {
                    System.out.print("\nDigite o tempo, em meses: ");
                    tempo = entrada.nextInt();
                } while (tempo < 0);
              break;
            } catch (InputMismatchException e) { entrada.nextLine();}
        }

        if(operacao == 1) valorFinal = capital + capital * (taxaJuros / 100) * tempo;  
        else valorFinal = capital * Math.pow((1 + (taxaJuros / 100)), tempo);           

        BigDecimal resJuros = BigDecimal.valueOf(valorFinal).setScale(2, RoundingMode.HALF_UP); 
        valorFinal = resJuros.doubleValue();

        return valorFinal;
    }

    static char continuarOpcao(Scanner entrada, String msg) {
        
        String sRepetir;
        char repete = ' ';

        try {
            do {
                System.out.print(msg);
                sRepetir = entrada.nextLine().toLowerCase();
                repete = sRepetir.charAt(0);
            } while(repete != 's' && repete != 'n');
        } catch (Exception e) { 
            entrada.nextLine(); 
        }
        return repete;
    }

    // Calculadora de Juros
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char menu = 's';

        // Programa
        while (menu == 's') {

            int opcao = 0;
            char repetir = 's';
            double valorFinal = 0;
            
            System.out.println("\n\n\t\t--- Calculador de juros ---\n\nDigite o tipo de juros que quer calcular\n\n1. Juros simples\n2. Juros compostos\n");

            // Escolha da operação
            while (true) {
                try {
                    do {
                        System.out.print("\tSua escolha: ");
                        opcao = entrada.nextInt();
                    } while (opcao != 1 && opcao != 2);
                    break; //se tudo der certo, sai do while(true)
                } catch (InputMismatchException e) { entrada.nextLine(); }
            }

            // Lógica de juros
            while (repetir == 's') {
                valorFinal = calcularJuros(entrada, opcao); 
                System.out.println("\n\tValor final: R$ " + valorFinal + "\n");
                entrada.nextLine();
                repetir = continuarOpcao(entrada, "Deseja fazer novamente? (s/n): ");
                System.out.println();
            }
            menu = continuarOpcao(entrada, "Deseja voltar ao menu? (s/n): ");
        }
        System.out.println("\n\tMuito obrigado por usar essa ferramenta, aceito sugestões :)\n\n");
        entrada.close();
    }
}