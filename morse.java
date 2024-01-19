import java.util.InputMismatchException;
import java.util.Scanner;

public class morse {

    static Scanner entrada = new Scanner(System.in, "latin1");

    // alfanuméricos em morse
    static String morse[] = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",  "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", ".-.-.-", "--..--", "..--..", "-.-.--", "-.-.-.", "---...", ".-.-.", "-....-", "-..-.", "-...-" };

    // alfanuméricos em símbolos
    static char simbolos[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', ',', '?', '!', ';', ':', '+', '-', '/', '=' };

    // importante a String morse[] ter seu respectivo símbolo na mesma posição do char simbolo[]


    // tradução letras --> morse
    static void traduzParaMorse() {

        char lTraduzida;
        String palavra;
        int tamanho;

        // coleta e trata a frase
        System.out.print("\nColoque a frase: ");
        entrada.nextLine();
        palavra = entrada.nextLine().toLowerCase(); //pega a frase e já a deixa minpuscula
        tamanho = palavra.length();

        // transforma a frase(String) em um vetor de char(letra)
        char letra[] = new char[tamanho];
        for (int cont = 0; cont < tamanho; cont++) { letra[cont] = palavra.charAt(cont); }

        // envio de dados para o tradutor e início da tela final
        System.out.println("\n\n\t\t--- Tradução letras --> morse ---");
        System.out.print("\nCódigo: " + palavra + "\n\nEm morse: ");

        //faz o processo de buscar a letra no vetor de siímbolos morse e printá-la
        for (int i = 0; i < tamanho; i++) { // pega cada símbolo da palavra digitada...
            lTraduzida = letra[i]; // e o atribui para a variável lTraduzida.
            for (int j = 0; j < morse.length; j++) { // a lTraduzida é comparada com todos os símbolos de simbolos[]
                if (lTraduzida == simbolos[j]) System.out.print(morse[j]); 
                // se a lTraduzida for correspondente a um símbolo, o código correspondente no vetor morse[] é printado
            }

            if (lTraduzida == ' ')  System.out.print("/ "); // separa palavras
            else System.out.print("  "); // separa letras
        }

        System.out.println("\n");
    }

    // tradução morse --> letras
    static void traduzParaLetras() {

        String codMorse, ditOuDah = ""; //dit e dah são os nomes que damos, no morse, aos pontos e traços, respectivamente

        System.out.print("\n\t\t--- Tradução morse --> letras ---\n\n1. separe as letras com a tecla espaço;\n2. separe palavras com a tecla '/' e a tecla espaço ( / );\n3. quando terminar o código, encerre com a tecla espaço.\n\nCódigo em morse: ");

        entrada.nextLine();
        codMorse = entrada.nextLine();

        System.out.print("\nMensagem decodificada: ");

        for (int i = 0; i < codMorse.length(); i++) { //percorre cada dígito que o usuário colocou

            if(codMorse.charAt(i) == '/') System.out.print(" "); //se o usuário coloca o '/', entende-se que é uma separação de palavras

            else if (codMorse.charAt(i) != ' ' && codMorse.charAt(i) != '/') ditOuDah += codMorse.charAt(i); //se não é um espaço ou uma barra (/) é adicionado na frase.

            else { //se o caractere é um espaço, ela cai nesse aqui

                for (int j = 0; j < morse.length; j++) { //como a variável 'ditOuDah' já está com alguns dits e dahs do else if, já temos uma letra que pode ser procurada no vetor 'morse'

                    if (ditOuDah.equals(morse[j])) {
                        System.out.print(simbolos[j]);
                        break; // se o código correspondente foi achado, não há necessidade de continuar o for
                    }
                }

                ditOuDah = ""; //depois que todo o processo é feito, ditOuDah é zerado para dar espaço à um possível próximo caractere
            }

        }

        System.out.println("\n");

    }

    // tela inicial
    public static void main(String[] args) {

        int opcao = 0;

        // menu
        System.out.println("\n\n\t\t\t--- Tradutor letras -> morse ---\n");
        System.out.println("1. Morse --> letras\n2. Letras --> morse");

        while (true) {
            try {
                do {
                    System.out.print("\n\tSua escolha: "); opcao = entrada.nextInt();
                    if (opcao != 1 && opcao != 2) { System.out.println("\nSelecione apenas 1 ou 2"); }
                } while (opcao != 1 && opcao != 2);
                break;
                
            } catch ( InputMismatchException e) {
                System.out.println("\nErro! Apenas números são permitidos.");
                entrada.nextLine();
            }
        }

        if (opcao == 1) traduzParaLetras();
        else traduzParaMorse();
    }
}