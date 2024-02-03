package objsCodificador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CesarCifra {

    static Scanner entrada = new Scanner(System.in);
    
    public static int findKey(){

        int key = 0;

        while (true) {
            try {

                do{

                    System.out.print("\nDigite o número: ");
                    key = entrada.nextInt();
                    if (key > 25 || key < 0) System.err.println("\nDigite um número entre 1 e 25");
                } while (key > 25 || key < 0);      
                break;     

            } catch (InputMismatchException e) {
                System.err.println("Apenas números são permitidos\n");
                entrada.nextLine();
            }
            
        }
        return key;
    }

    public static String traduza(int tipoTraduz, int numFixo){

        String base, mensagem = "";
        char letra, alfabeto[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u', 'v', 'w', 'x', 'y', 'z'};

        System.out.println("\nDigite a mensagem (apenas letras): ");
        entrada.nextLine();
        base = entrada.nextLine();

        for (int i = 0; i < base.length(); i++) {
            letra = base.charAt(i);

            //se for de letras para cesar, ele avança casas
            if (tipoTraduz == 1) {
                for (int j = 0; j < alfabeto.length; j++) {
                    if(letra == alfabeto[j]){
                        if (alfabeto[j] + numFixo > alfabeto.length) letra = alfabeto[(alfabeto[j] + 3) - alfabeto.length];
                        else letra = alfabeto[j + 3];
                    }
                }
            }
            else{ //se for de cesar para letras, retorna letras
                for (int j = 0; j < alfabeto.length; j++) {
                    if(letra == alfabeto[j]){
                        if (alfabeto[j] - numFixo < 0) letra = alfabeto[alfabeto.length - (alfabeto[j] - numFixo)];
                        else letra = alfabeto[j - 3];
                    }
                }
            }

            mensagem += letra;
        }

        return mensagem;
    }

}
