package objsCodificador;

import java.util.Scanner;

public class CifraDeCesar {
    public static String traduzir(Scanner entrada, int tipoTraduz, int chave) {

        String base, mensagem = "";
        char alfabeto[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

        System.out.print("\nDigite a mensagem: ");
        base = entrada.nextLine().toLowerCase();

        for (char letra : base.toCharArray()) {
            for (int j = 0; j < 26; j++) { 
                if (letra == alfabeto[j]) { 
                    if (tipoTraduz == 1) letra = (j - chave < 0) ? alfabeto[26 + (j - chave)] : alfabeto[j - chave];
                    else letra = (j + chave >= 26) ? alfabeto[j + chave - 26] : alfabeto[j + chave];
                    break;
                }
            }
            mensagem += letra;
        }
        return mensagem;
    }
}