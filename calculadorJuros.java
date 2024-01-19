import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class calculadorJuros {

    static Scanner entrada = new Scanner(System.in, "latin1"); //deixei estático pois há dois locais que é usado

    // Função juros simples
    static double calculaJuros(int operacao) {

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

        if(operacao == 1) valorFinal = capital + capital * (taxaJuros / 100) * tempo;   //se for juros simples faz essa conta
        else valorFinal = capital * Math.pow((1 + (taxaJuros / 100)), tempo);           //faz caso seja juros compostos

        BigDecimal resJuros = BigDecimal.valueOf(valorFinal).setScale(2, RoundingMode.HALF_UP); //arredonda o valor pra duas casas
        valorFinal = resJuros.doubleValue(); //atribui o valor arredondado para o valor final

        return valorFinal;
    }

    static char continuaOpcao(){
        
        String sRepetir;
        char repetir;

        do {
            System.out.print("Deseja fazer novamente? (s/n): ");
            entrada.nextLine();
            sRepetir = entrada.nextLine();
            repetir = sRepetir.charAt(0);
        } while (repetir != 's' && repetir != 'n');
        System.out.println();
        
        return repetir;
    }

    // Calculadora de Juros
    public static void main(String[] args) {

        char menu = 's';

        // Programa
        while (menu == 's') { //fará enquanto o usuário quiser usa a calculadora

            int opcao = 0;
            char repetir = 's';
            double valorFinal = 0;
            
            System.out.println("\n\n\t\t--- Calculador de juros ---\n\nDigite o tipo de juros que quer calcular\n\n1. Juros simples\n2. Juros compostos\n"); // Home

            // Escolha da operação
            while (true) { //fará enquanto não escolher 1 ou 2
                try {
                    do {
                        System.out.print("\tSua escolha: ");
                        opcao = entrada.nextInt();
                    } while (opcao != 1 && opcao != 2);
                    break; //se tudo der certo, sai do while(true)
                } catch (InputMismatchException e) { entrada.nextLine(); }
            }

            // Lógica de juros
            while (repetir == 's') { //fará enquanto o usuário quiser continuar a operação

                valorFinal = calculaJuros(opcao); //manda a opção para o método juros retornar o valor final correspondente
                    
                System.out.println("\n\tValor final: R$ " + valorFinal + "\n"); //printa o montante

                repetir = continuaOpcao(); //verifica se o usuário quer repetir a operação
            }

            // Voltar para o menu ou encerrar o programa
            do {
                System.out.print("Deseja voltar ao menu? (s/n) ");
                String sMenu = entrada.nextLine(); 
                menu = sMenu.charAt(0);
            } while (menu != 's' && menu != 'n');

        }

        System.out.println("\n\n\tMuito obrigado por usar essa ferramenta, aceito sugestões :)\n"); // Mensagem de fim da calculadora

        entrada.close();
    }
}