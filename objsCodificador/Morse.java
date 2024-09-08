package objsCodificador;
import java.util.Scanner;

public class Morse {

    static String morse[] = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",  "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", ".-.-.-", "--..--", "..--..", "-.-.--", "-.-.-.", "---...", ".-.-.", "-....-", "-..-.", "-...-" };

    static char simbolos[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', ',', '?', '!', ';', ':', '+', '-', '/', '=' };

    public static String codificar(Scanner entrada) { // letras --> morse

        char lTraduzida;
        String palavra, mensagem = "";

        // coleta e trata a frase
        System.out.print("\nColoque a frase: ");
        palavra = entrada.nextLine().toLowerCase();

        //busca a letra no vetor de símbolos morse e armazena na mensagem
        for (char letra: palavra.toCharArray()) { 
            lTraduzida = letra;
            for (int j = 0; j < morse.length; j++)
                if (lTraduzida == simbolos[j]) mensagem += morse[j]; 

            if (lTraduzida == ' ')  mensagem += "/ "; // separa palavras
            else mensagem += "  "; // separa letras
        }
        return mensagem;
    }
 
    public static String decodificar(Scanner entrada) { // morse --> letras

        String codMorse, ditOuDah = "", mensagem = "";

        System.out.print("\n1. separe as letras com a tecla espaço;\n2. separe palavras com a tecla '/' e a tecla espaço ( / ).\n\nCódigo em morse: ");

        codMorse = entrada.nextLine().toLowerCase();
        codMorse += " ";

        for (char simbolo: codMorse.toCharArray()) { //percorre cada dígito que o usuário colocou

            if(simbolo == '/') mensagem += " ";
            else if (simbolo == '.' || simbolo == '-') ditOuDah += simbolo;
            else { //logo, o dígito é um espaço
                for (int j = 0; j < morse.length; j++) { //como a variável 'ditOuDah' já está com alguns dits e dahs do else if, já temos uma letra que pode ser procurada no vetor 'morse'
                    if (ditOuDah.equals(morse[j])) {
                        mensagem += simbolos[j];
                        break;
                    }
                }
                ditOuDah = ""; //depois que todo o processo é feito, ditOuDah é zerado para dar espaço à um possível próximo caractere
            }
        }
        return mensagem;
    }
}