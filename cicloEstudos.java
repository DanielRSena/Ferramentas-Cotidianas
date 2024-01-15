import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class cicloEstudos {

    static Scanner entrada = new Scanner(System.in);

    static double horasEstudo(double dificuldade) {

        int horasTotais = 0, horasDia = 0;
        String[] diasSemana = { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo" };

        System.out.println("\n\n\t--- Tempo de estudos (em horas) ---\n");
        for (int i = 0; i < 7; i++) { //fará até fechar op 7 dias da semana
            while (true) { //enquanto não preencher as horas dos 7 dias, não sai daqui
                try {
                    do {
                        System.out.print(diasSemana[i] + ": "); //mensagem personalizada sempre que o contador muda
                        horasDia = entrada.nextInt();
                    } while (horasDia < 0 || horasDia > 18); //o mínimo recomendado para dormir são 6hrs, levei isso em conta
                    horasTotais += horasDia; //as horas do dia são adicionadas horasTotais (horas semanais)
                    System.out.println(); //dá uma linha entre os dias da semana
                    break; //caso as horas sejam digitadas corretamente, sai do while
                } catch (InputMismatchException e) { entrada.nextLine(); } //se digitar qualquer coisa além de números inteiros, limpa o Scanner e o while repete o processo
            }
        }

        dificuldade = horasTotais / dificuldade; // agora todos os pontos de dificuldade tem um tempo igual
        
        return dificuldade;
    }

    public static void main(String[] args) {

        // dados iniciais
        String verificador = "";                                //essa vString serve para um "break" quando o usuário quer parar de digitar as matérias
        int qtdMaterias = 20, i = 0, totalDificuldade = 0, horasPorMateria;
        String mat[] = new String[qtdMaterias];                // vetor com as matérias provisórias
        double dif[] = new double[qtdMaterias];                // vetor com a dificuldade das matérias provisórias      

        // Entrada
        System.out.println( "\n\n\t\t--- Ciclo de Estudos ---\n\nEsse programa tem a finalidade de criar uma organização simples para seus estudos. Vamos começar? Quando terminar, digite 'fim' na máteria \n\n\n\t--- Matérias de estudo ---\n\nGrau de dificuldade(1, 2, ou 3)\n\n1 - Pouco importante ou fácil\n2 - Meio termo\n3 - Importante ou difícil\n");

        // 1. Registrando matérias e dificuldades
        for (i = 0; i < qtdMaterias || !verificador.equalsIgnoreCase("fim"); i++) { //mesmos critérios do while anterior

            if (i > 0) entrada.nextLine(); //coisinha básica, só para não limpar antes da hora
            System.out.println("\n-- Matéria " + (i + 1) + "\n"); //separador de matérias

            while(true) { //serve para ter certeza de que os critérios do try_catch serão atendidos
                try { //Um ciclo de estudos não funciona com só uma matéria, então temos que liberar a opção "fim" apenas na "3ª matéria" 
                    System.out.print("Nome: ");
                    verificador = entrada.nextLine(); //o verificador pega antes do vetor para não salvar a opção "fim" nas matérias
                    if(verificador.equalsIgnoreCase("fim") && i < 2) throw new IllegalArgumentException(); //lança exceção se "fim" vier antes de 2 matérias
                    else break; //se não entrar no if, sai do while
                } catch (IllegalArgumentException e) {} //se esse catch pegar a exceção, o break do try não é feito e o while repete o processo
            }

            if (!verificador.equalsIgnoreCase("fim")) { //caso o usuário ainda queira colocar as matérias
                mat[i] = verificador; //como o verificador não é "fim", significa que é o nome da matéria
                while (true) { //fará enquanto o usuário colocar uma dificuldade diferente de 1, 2 ou 3
                    try { //esse try_catch serve para ter certeza de que apenas números serão aceitos
                        do {
                            System.out.print("Dificuldade: "); 
                            dif[i] = entrada.nextInt(); 
                        } while (dif[i] < 1 || dif[i] > 3); //fará do_while enquanto não for 1, 2 ou e 3
                        break; //se o usuário digitar tudo certo, sairá do try_catch e do while
                    } catch (InputMismatchException e) {
                        entrada.nextLine(); //se digitar qualquer coisa além de números inteiros, o Scanner será limpo para digitar de novo
                    }
                }
                totalDificuldade += dif[i]; // salva a quantidade total de "pontos de dificuldade"
            } 
            else {
                qtdMaterias = i; //a variável é atualizada para a quantidade de matérias digitadas pelo usuário
                break;
            }              
        }
        
        // 2. Criação dos vetores oficiais: com o for anterior, os dados pegos são atribuidos com o "Arrays.copyOfRange" para novos vetores
        String[] materias = new String[qtdMaterias]; //vetor oficial de matérias
        double[] dificuldade = new double[qtdMaterias]; //vetor oficial de dificuldade das matérias
        materias = Arrays.copyOfRange(mat, 0, qtdMaterias); //essa função da biblioteca Arrays atribui os valores de um vetor, baseados em um início e fim
        dificuldade = Arrays.copyOfRange(dif, 0, qtdMaterias); //vetor = dif, início = 0 e fim é a qtdMaterias

        // 3. Padronização dos pontos de dificuldade
        double tDificuldade = horasEstudo(totalDificuldade); //esse método serve para definir o tempo de cada ponto de dificuldade

        // 4. Atribui o tempo correto para cada matéria e as printa
        System.out.println("\n\n\t--- Organização dos estudos ---\n");
        for (i = 0; i < qtdMaterias; i++) {
    
            dificuldade[i] = dificuldade[i] * tDificuldade; // O tempo de cada matéria é o produto de seus pontos de diculdade com o tempo unitário desses pontos
    
            // convertendo as horas 1,5hrs para 1hr 30min (exemplo)
            horasPorMateria = (int) dificuldade[i];
            dificuldade[i] = (dificuldade[i] - horasPorMateria) * 60; //agora o vetor guarda só os minutos "quebrados" da matéria
    
            if (dificuldade[i] != 0) System.out.printf("%s: %d horas e %.0f minutos\n\n", materias[i], horasPorMateria, dificuldade[i]);
            else System.out.printf("%s: %d horas\n\n", materias[i], horasPorMateria);  // caso as horas sejam "cravadas", não printa os minutos"
        }
    
        //5. Dica extra e fim do programa
        System.out.println( "\n\nOBS: Como dica extra, você pode fazer um quadrado para cada hora, e conforme estuda, os risca.\nVale lembrar que se alguma matéria não tiver mais quadrados, deve-se estudar outra, até que todos estejam completos e o ciclo se reinicie"); // dica de estudos extra
    
        System.out.println("\n\n\tMuito obrigado por usar esta ferramenta, aceito sugestões :)\n"); // mensagem final

        entrada.close();
    }
}
