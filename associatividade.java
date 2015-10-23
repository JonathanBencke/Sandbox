package associatividade;

import java.util.Scanner;

/**
 *
 * @author Jonathan
 */
public class Associatividade {

    public static void main(String[] args) {
        
	//variaveis
        int elementos = 0, posicaoA = 0, posicaoB = 0;;
        boolean assoc = false;
        String A, B, finalB = "B", finalA = "A";
		
        Scanner s = new Scanner(System.in);

		//leitura da quantidade de numero de elementos
        do {
            System.out.println("Numero de elementos:");
            elementos = s.nextInt();
            s.nextLine();
        } while (elementos == 0);
		
		//cria vetor com a quantidade de elementos informada
        String[] vet = new String[elementos];

		//realiza a leitura dos elementos e os coloca no vetor
        System.out.println("Informe os elementos:");
        for (int x = 0; x < elementos; x++) {

            System.out.println("Elemento nº" + x + ": ");
            vet[x] = s.nextLine();

        }
		
		//mostra a tabela para o usuario preenchida
        for (int x = 0; x < elementos; x++) {
            if (x == 0) {
                System.out.print("|*|");
            }
            System.out.print("|" + vet[x] + "|");
        }
        for (int x = 0; x < elementos; x++) {
            if (x == 0) {
                System.out.print("\n");
            }
            System.out.println("|" + vet[x] + "|");
        }
		
		
		//cria um vetor bidimensional para a entrada dos resulatado entre as operaçoes
        String[][] vetResultado = new String[elementos][elementos];
        for (int x = 0; x < elementos; x++) {
            for (int y = 0; y < elementos; y++) {
                System.out.println("Operação entre " + x + " e " + y + ":");
                vetResultado[x][y] = s.nextLine();
            }
        }

		//mostra a tabela montada para o usuario
        System.out.print("|*|");
        for (int x = 0; x < elementos; x++) {
            System.out.print("|" + vet[x] + "|");
        }
        for (int x = 0; x < elementos; x++) {
            for (int y = 0; y < elementos; y++) {
                if (y == 0) {
                    System.out.print("\n|" + vet[x] + "|");
                }
                System.out.print("|" + vetResultado[x][y] + "|");

            }
        }

		//começa a vericaçao para ver se a tabela e associativa
        
		System.out.println("\nAnalisando...");
        
		
		//OPERACAO (a * b) * c = a * (b * c) 

        for (int x = 0; x < elementos; x++) {
            for (int y = 0; y < elementos; y++) {
                for (int s = 0; s < elementos; s++) {
					
					//mostra o calculo atual sendo analisada
                    System.out.println("//////////////////////////////////////////////////////\n");
                    System.out.println("(a*b)*c=a*(b*c)");
                    System.out.println("(" + vet[x] + "*" + vet[y] + ")*" + vet[s] + "=" + vet[x] + "*(" + vet[y] + "*" + vet[s] + ")");

					//coloca a busca de a * b em A
                    A = vetResultado[x][y];
					
					//mostra o resultado da operacao entra a e b para o usuario
                    System.out.println("a*b=" + A);
					
					//busca a posicao do A no vetor de elementos
                    for (int w = 0; w < elementos; w++) {
                       System.out.println(vet[w]+"=="+A);
                        if (vet[w].equals(A)) {
                            System.out.println("Posicao: "+w);
                            posicaoA = w;
                            finalA = vetResultado[posicaoA][s];
                            System.out.println("Final A: "+finalA);
                            System.out.println("(a*b)*c=" + A);
                        }
                    }
					
                    

                    B = vetResultado[y][s];
                    System.out.println("b*c=" + B);
                    
                    for (int w = 0; w < elementos; w++) {
                        if (vet[w].equals(B)) {
                            posicaoB = w;
                            finalB = vetResultado[x][posicaoB];
                            System.out.println("a*(b*c)=" + B);
                        }
                    }

                    if (!finalA.equals(finalB)) {

                        assoc = true;
                        if("A".equals(finalA) || "B".equals(finalB)){
                            System.out.println("\nFalha!\n(a*b)*c =! a*(b*c) ou nao pertence ao grupo\n");
                        }else{
                            System.out.println("\nFalha!\nA=" + finalA + "!=B=" + finalB + "\n");

                        }
                    }
                

                }
            }

        }
		
		//finaliza a busca mostrando se é ou nao associativa
        if (assoc) {
            System.out.println("Não é associativa!");
        } else {
            System.out.println("É associativa!");
        }
    }
}