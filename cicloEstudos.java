import java.util.Scanner;

public class cicloEstudos {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int qtdMaterias, horas = 0, cont = 0;
        double totalDificuldade = 0;

        //  Entrada
        System.out.println("\n\n\t\t--- Ciclo de Estudos ---\n\nEsse programa tem a finalidade de criar uma organização simples para seus estudos. Vamos começar?");

        //  Matérias
        System.out.print("\nDigite a quantidade de matérias: ");
        qtdMaterias = entrada.nextInt();
        String materias[] = new String[qtdMaterias]; //vetor com as materias
        double dificuldade[] = new double[qtdMaterias]; //vetor com a dificuldade das materias

        //  Digitando as matérias e dificuldades
        System.out.println("\n\n\t--- Matérias de estudo ---\n\nGrau de dificuldade(1, 2, ou 3)\n\n1 - Pouco importante ou fácil\n2 - Meio termo\n3 - Importante ou difícil\n");

        //  Registrando matérias e dificuldades
        for (cont = 0; cont < qtdMaterias; cont++) {
            System.out.print("\nMatéria: ");
            entrada.nextLine();
            materias[cont] = entrada.nextLine();
            do {
                System.out.print("Dificuldade: ");
                dificuldade[cont] = entrada.nextInt();
            } while (dificuldade[cont] < 1 || dificuldade[cont] > 3);

            totalDificuldade += dificuldade[cont]; //salva a quantidade total de "pontos de dificuldade
        }

        //  Tempo de estudos por dia
        System.out.println("\n\n\t---Tempo de estudos (em horas)---");
        System.out.print("\nSegunda: ");
        horas += entrada.nextInt();
        System.out.print("\nTerça: ");
        horas += entrada.nextInt();
        System.out.print("\nQuarta: ");
        horas += entrada.nextInt();
        System.out.print("\nQuinta: ");
        horas += entrada.nextInt();
        System.out.print("\nSexta: ");
        horas += entrada.nextInt();
        System.out.print("\nSábado: ");
        horas += entrada.nextInt();
        System.out.print("\nDomingo: ");
        horas += entrada.nextInt();

        totalDificuldade = horas / totalDificuldade; //agora cada ponto de dificuldade tem um tempo igual de estudo (hora/dificuldade)


        //  Organização de estudos
        System.out.println("\n\n\t--- Organização dos estudos ---\n");
        for (cont = 0; cont < qtdMaterias; cont++) {

            dificuldade[cont] = dificuldade[cont] * totalDificuldade; //O tempo de cada matéria é o produto de seus pontos de diculdade com a (hora/dificuldade)
            System.out.printf("%s: %.1f horas\n\n", materias[cont], dificuldade[cont]);

        }
        
        System.out.println("\n\nOBS: Como dica extra, você pode fazer um quadrado para cada hora, e conforme estuda, os risca. \nVale lembrar que se alguma matéria não tiver mais quadrados, deve-se estudar outra, até que todos estejam completos e o ciclo se reinicie\n\n\tMuito obrigado por usar esta ferramenta, aceito sugestões :)\n");

        entrada.close();
    }

}