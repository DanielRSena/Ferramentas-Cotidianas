import java.util.Scanner;
import java.util.Arrays;

public class cicloEstudos {

    public static int pedirInt(Scanner entrada, String msg) {
        int num = 0;
        while (true) {
            try {
                System.out.print(msg);
                num = entrada.nextInt();
                return num;
            } catch (Exception e) {
                entrada.nextLine();
                System.out.println("\nApenas números são permitidos");
            }
        }
    }

    static double horasEstudo(Scanner entrada, double dificuldade) {

        int horasTotais = 0, horasDia = 0;
        String[] diasSemana = { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo" };

        System.out.println("\n\n\t--- Tempo de estudos (em horas) ---\n");
        for (String dia: diasSemana) {   
            do {
                horasDia = pedirInt(entrada, dia + ": ");
            } while (horasDia < 0 || horasDia > 18); //o mínimo recomendado para dormir são 6hrs, levei isso em conta
            horasTotais += horasDia;
            System.out.println();
        }
        dificuldade = horasTotais / dificuldade; // agora todos os pontos de dificuldade tem um tempo igual
        
        return dificuldade;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // dados iniciais
        String verificador = ""; //essa vString serve para um "break" quando o usuário quer parar de digitar as matérias
        int qtdMaterias = 20, i = 0, totalDificuldade = 0, horasPorMateria;
        String mat[] = new String[qtdMaterias]; // vetor com as matérias provisórias
        double dif[] = new double[qtdMaterias]; // vetor com a dificuldade das matérias provisórias      

        // Entrada
        System.out.println( "\n\n\t\t--- Ciclo de Estudos ---\n\nEsse programa tem a finalidade de criar uma organização simples para seus estudos. Vamos começar? Quando terminar, digite 'fim' na matéria \n\n\n\t--- Matérias de estudo ---\n\nGrau de dificuldade(1, 2, ou 3)\n\n1 - Pouco importante ou fácil\n2 - Meio termo\n3 - Importante ou difícil\n");

        // 1. Registrando matérias e dificuldades
        for (i = 0; i < qtdMaterias || !verificador.equalsIgnoreCase("fim"); i++) {

            if (i > 0) entrada.nextLine(); //coisinha básica, só para não limpar antes da hora
            System.out.println("\n-- Matéria " + (i + 1) + "\n"); //separador de matérias

            while(true) {
                try {
                    System.out.print("Nome: ");
                    verificador = entrada.nextLine(); //o verificador pega antes do vetor para não salvar a opção "fim" nas matérias
                    if(verificador.equalsIgnoreCase("fim") && i < 2) throw new IllegalArgumentException();
                    else break;
                } catch (IllegalArgumentException e) {
                    System.out.println("\tDEvem existir pelo menos 2 matérias");
                }
            }

            if (!verificador.equalsIgnoreCase("fim")) {
                mat[i] = verificador; //como o verificador não é "fim", significa que é o nome da matéria
                do {
                    dif[i] = pedirInt(entrada, "Dificuldade: "); 
                } while (dif[i] < 1 || dif[i] > 3);
                totalDificuldade += dif[i];
            } 
            else {
                qtdMaterias = i;
                break;
            }              
        }
        
        // 2. Criação dos vetores oficiais
        String[] materias = new String[qtdMaterias]; 
        double[] dificuldade = new double[qtdMaterias];
        materias = Arrays.copyOfRange(mat, 0, qtdMaterias);
        dificuldade = Arrays.copyOfRange(dif, 0, qtdMaterias);

        // 3. Padronização dos pontos de dificuldade
        double tDificuldade = horasEstudo(entrada, totalDificuldade); //define o tempo de cada ponto de dificuldade

        // 4. Atribui o tempo correto para cada matéria e as printa
        System.out.println("\n\n\t--- Organização dos estudos ---\n");
        for (i = 0; i < qtdMaterias; i++) {
    
            dificuldade[i] = dificuldade[i] * tDificuldade; //tempo de cada matéria
    
            // convertendo as horas 1,5hrs para 1hr 30min (exemplo)
            horasPorMateria = (int) dificuldade[i];
            dificuldade[i] = (dificuldade[i] - horasPorMateria) * 60; //agora o vetor guarda só os minutos "quebrados" da matéria
    
            if (dificuldade[i] != 0) System.out.printf("%s: %d horas e %.0f minutos\n\n", materias[i], horasPorMateria, dificuldade[i]);
            else System.out.printf("%s: %d horas\n\n", materias[i], horasPorMateria);  // caso as horas sejam "cravadas", não printa os minutos"
        }
    
        //5. Dica extra e fim do programa
        System.out.println( "\n\nOBS: Como dica extra, você pode fazer um quadrado para cada hora, e conforme estuda, os risca.\nVale lembrar que se alguma matéria não tiver mais quadrados, deve-se estudar outra, até que todos estejam completos e o ciclo se reinicie\n\n\n\tMuito obrigado por usar esta ferramenta, aceito sugestões :)\n");
        
        entrada.close();
    }
}