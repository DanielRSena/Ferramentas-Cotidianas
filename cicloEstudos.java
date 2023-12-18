import java.util.Scanner;

public class cicloEstudos {

    static Scanner entrada = new Scanner(System.in);
    static boolean erro = false;

    static double horasEstudo(double dificuldade) {

        int horas = 0, horasDia = 0;
        String[] diasSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
        
        System.out.println("\n\n\t---Tempo de estudos (em horas)---\n");
        for (int i = 0; i < 7; i++) {
            try {
                do {
                    System.out.print(diasSemana[i] + ": ");
                    horasDia = entrada.nextInt();
                } while (horasDia < 0 || horasDia > 24);
            } catch (Exception e) {
                System.out.println("\nErro! Coloque apenas números inteiros\n");
                erro = true;
            }
            horas += horasDia;
        }
        
        dificuldade = horas / dificuldade; // agora todos os pontos de dificuldade tem um tempo igual

        if(erro == true)
            return 0;
        else
            return dificuldade;
        }

    public static void main(String[] args) {

        int qtdMaterias = 0, cont = 0, totalDificuldade = 0;

        // Entrada
        System.out.println(
                "\n\n\t\t--- Ciclo de Estudos ---\n\nEsse programa tem a finalidade de criar uma organização simples para seus estudos. Vamos começar?");

        // Matérias
        try {
            do {
                System.out.print("\nDigite a quantidade de matérias: ");
                qtdMaterias = entrada.nextInt();
            } while (qtdMaterias < 0);
        } catch (Exception e) {
            System.out.println("\nErro! Apenas números inteiros são aceitos\n");
        }

        // Se tiverem matérias para se estudar, o programa continua
        if (qtdMaterias > 0) {
            String materias[] = new String[qtdMaterias]; // vetor com as matérias
            double dificuldade[] = new double[qtdMaterias]; // vetor com a dificuldade das matérias

            // Matérias e dificuldades
            System.out.println(
                    "\n\n\t--- Matérias de estudo ---\n\nGrau de dificuldade(1, 2, ou 3)\n\n1 - Pouco importante ou fácil\n2 - Meio termo\n3 - Importante ou difícil\n");

            // Registrando matérias e dificuldades
            for (cont = 0; cont < qtdMaterias; cont++) {
                System.out.print("\nMatéria: ");
                entrada.nextLine();
                materias[cont] = entrada.nextLine();
                try {
                    do {
                        System.out.print("Dificuldade: ");
                        dificuldade[cont] = entrada.nextInt();
                    } while (dificuldade[cont] < 1 || dificuldade[cont] > 3);
                } catch (Exception e) {
                    System.out.println("\nErro! Apenas números são aceitos!\n");
                    erro = true;
                    break;
                }

                totalDificuldade += dificuldade[cont]; // salva a quantidade total de "pontos de dificuldade"
            }

            // Organização do ciclo de estudos
            if (erro == false) {

                double tDificuldade = horasEstudo(totalDificuldade); //o método serve para definir a hora fixa de cada ponto de dificuldade
                if(tDificuldade != 0) {

                    // printa o ciclo de estudos
                    System.out.println("\n\n\t--- Organização dos estudos ---\n");
                    for (cont = 0; cont < qtdMaterias; cont++) {

                        dificuldade[cont] = dificuldade[cont] * tDificuldade; // O tempo de cada matéria é o produto de seus pontos de diculdade com a (hora/dificuldade)

                        // convertendo as horas 1,5hrs para 1hr 30min (exemplo)
                        int hrs = (int) dificuldade[cont];
                        dificuldade[cont] = (dificuldade[cont] - hrs) * 60;

                        //caso as horas sejam "cravadas", não printa os minutos"
                        if (dificuldade[cont] != 0)
                            System.out.printf("%s: %d horas e %.0f minutos\n\n", materias[cont], hrs, dificuldade[cont]);
                        else
                            System.out.printf("%s: %d horas\n\n", materias[cont], hrs);
                    }

                    System.out.println("\n\nOBS: Como dica extra, você pode fazer um quadrado para cada hora, e conforme estuda, os risca.\nVale lembrar que se alguma matéria não tiver mais quadrados, deve-se estudar outra, até que todos estejam completos e o ciclo se reinicie"); // dica de estudos extra

                    System.out.println("\n\n\tMuito obrigado por usar esta ferramenta, aceito sugestões :)\n"); // mensagem final
                }
            }
        }
        entrada.close();
    }
}
