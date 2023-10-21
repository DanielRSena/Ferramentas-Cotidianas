import java.util.Scanner;

public class morse {

    static Scanner entrada = new Scanner(System.in, "latin1");

    // alfanuméricos em morse
    static String morse[] = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", ".-.-.-", "--..--",
            "..--..", "-.-.--", "-.-.-.", "---...", ".-.-.", "-....-", "-..-.", "-...-" };

    // alfanuméricos em símbolos
    static char simbolos[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', ',', '?',
            '!', ';', ':', '+', '-', '/', '=' };

    // importante a String morse[] ter seu respectivo símbolo na mesma posição do
    // char simbolo[]

    static char lTraduzida;
    static int taman = morse.length;

    // tradução letras --> morse
    static void traduzParaMorse() {

        // coleta e tratamento da frase
        System.out.print("\nColoque a frase: ");
        entrada.nextLine();
        String palavra = entrada.nextLine();
        palavra = palavra.toLowerCase();
        int tamanho = palavra.length();

        // tranformando a String em um vetor de char
        char letra[] = new char[tamanho];
        for (int cont = 0; cont < tamanho; cont++) {
            letra[cont] = palavra.charAt(cont);
        }

        // envio de dados para o tradutor e início da tela final
        System.out.println("\n\n\t\t--- Tradução letras --> morse ---");
        System.out.print("\nCódigo: " + palavra + "\n\nEm morse: ");

        for (int i = 0; i < tamanho; i++) { // pega cada símbolo da palavra digitada...
            lTraduzida = letra[i]; // e o atribui para a variável lTraduzida.
            for (int j = 0; j < taman; j++) { // a lTraduzida é comparada com todos os símbolos de simbolos[]
                if (lTraduzida == simbolos[j]) // se a lTraduzida for correspondente a um símbolo...
                    System.out.print(morse[j]); // o código correspondente no vetor morse[] é printado
            }

            if (lTraduzida == ' ') { // separa palavras
                System.out.print("/ ");
            } else
                System.out.print("  "); // separa letras
        }
        System.out.println("\n");
    }

    // tradução morse --> letras
    static void traduzParaLetras() {

        String codMorse, letra = "";

        System.out.print("\n\t\t--- Tradução morse --> letras ---\n\n1. separe as letras com a tecla espaço;\n2. separe palavras com a tecla '/' e a tecla espaço ( / );\n3. quando terminar o código, encerre com a tecla espaço.\n\nCódigo em morse: ");
        entrada.nextLine();
        codMorse = entrada.nextLine();

        System.out.print("\nMensagem decodificada: ");

        for (int i = 0; i < codMorse.length(); i++) {

            if(codMorse.charAt(i) == '/')
                System.out.print(" ");
            else if (codMorse.charAt(i) != ' ' && codMorse.charAt(i) != '/') 
                    letra += codMorse.charAt(i);
            else {
                for (int j = 0; j < taman; j++) {
                    if (letra.equals(morse[j]))
                        System.out.print(simbolos[j]);
                }
                letra = "";
            }

        }
        System.out.println("\n");

    }

    // tela inicial
    public static void main(String[] args) {

        int opcao;

        // menu
        System.out.println("\n\n\t\t\t--- Tradutor letras -> morse ---\n");
        System.out.println("1. Morse --> letras\n2. Letras --> morse\n");
        do {
            System.out.print("\tSua escolha: ");
            opcao = entrada.nextInt();
        } while (opcao != 1 && opcao != 2);

        if (opcao == 1)
            traduzParaLetras();

        if (opcao == 2)
            traduzParaMorse();

        entrada.close();
    }
}