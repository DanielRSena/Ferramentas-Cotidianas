package objsCodificador;
import java.util.Scanner;

public class Morse {

    static Scanner entrada = new Scanner(System.in);

    // alfanuméricos em morse
    static String morse[] = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",  "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", ".-.-.-", "--..--", "..--..", "-.-.--", "-.-.-.", "---...", ".-.-.", "-....-", "-..-.", "-...-" };

    // alfanuméricos em símbolos
    static char simbolos[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', ',', '?', '!', ';', ':', '+', '-', '/', '=' };

    // importante a String morse[] ter seu respectivo símbolo na mesma posição do char simbolo[]


    // tradução letras --> morse
    public static String letrasParaMorse() {

        char lTraduzida;
        String palavra, mensagem = "";
        int tamanho;

        // coleta e trata a frase
        System.out.print("\nColoque a frase: ");
        palavra = entrada.nextLine().toLowerCase(); //pega a frase e já a deixa minúscula
        tamanho = palavra.length();

        // transforma a frase(String) em um vetor de char(letra)
        char letra[] = new char[tamanho];
        for (int cont = 0; cont < tamanho; cont++) { letra[cont] = palavra.charAt(cont); }

        //busca a letra no vetor de símbolos morse e armazena na mensagem
        for (int i = 0; i < tamanho; i++) { // pega cada símbolo da palavra digitada...
            lTraduzida = letra[i]; // e o atribui para a variável lTraduzida.
            for (int j = 0; j < morse.length; j++) { // a lTraduzida é comparada com todos os símbolos de simbolos[]
                if (lTraduzida == simbolos[j]) mensagem += morse[j]; 
                // se a lTraduzida for correspondente a um símbolo, o código correspondente no vetor morse[] é armazenado na mensagem.
            }

            if (lTraduzida == ' ')  mensagem += "/ "; // separa palavras
            else mensagem += "  "; // separa letras
        }

        return mensagem;
    }

    // tradução morse --> letras
    public static String paraLetras() {

        String codMorse, ditOuDah = "", mensagem = ""; //dit e dah são os nomes que damos, no morse, aos pontos e traços, respectivamente

        System.out.print("\n1. separe as letras com a tecla espaço;\n2. separe palavras com a tecla '/' e a tecla espaço ( / );\n3. quando terminar o código, encerre com a tecla espaço.\n\nCódigo em morse: ");

        codMorse = entrada.nextLine();

        for (int i = 0; i < codMorse.length(); i++) { //percorre cada dígito que o usuário colocou

            if(codMorse.charAt(i) == '/') mensagem += " "; //se o usuário coloca o '/', entende-se que é uma separação de palavras
            else if (codMorse.charAt(i) != ' ' && codMorse.charAt(i) != '/') ditOuDah += codMorse.charAt(i); //se não é um espaço ou uma barra (/) é adicionado na frase.
            else { //se o caractere é um espaço, ela cai nesse aqui

                for (int j = 0; j < morse.length; j++) { //como a variável 'ditOuDah' já está com alguns dits e dahs do else if, já temos uma letra que pode ser procurada no vetor 'morse'

                    if (ditOuDah.equals(morse[j])) {
                        mensagem += simbolos[j];
                        break; // se o código correspondente foi achado, não há necessidade de continuar o for
                    }
                }
                ditOuDah = ""; //depois que todo o processo é feito, ditOuDah é zerado para dar espaço à um possível próximo caractere
            }

        }
        return mensagem;
    }
}