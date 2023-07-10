package associatividade;

import java.util.Scanner;

public class Associatividade {

    public static void main(String[] args) {
        int numElementos = 0, posicaoA = 0, posicaoB = 0;
        boolean associativa = false;
        String operandoA, operandoB, resultadoB = "B", resultadoA = "A";

        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário a quantidade de elementos
        do {
            System.out.println("Número de elementos:");
            numElementos = scanner.nextInt();
            scanner.nextLine();
        } while (numElementos == 0);

        String[] elementos = new String[numElementos];

        System.out.println("Informe os elementos:");

        // Lê os elementos informados pelo usuário e os armazena em um vetor
        for (int i = 0; i < numElementos; i++) {
            System.out.println("Elemento nº" + i + ": ");
            elementos[i] = scanner.nextLine();
        }

        exibirTabela(elementos);

        String[][] tabelaResultado = new String[numElementos][numElementos];

        // Lê os resultados das operações e preenche a tabela de resultados
        for (int i = 0; i < numElementos; i++) {
            for (int j = 0; j < numElementos; j++) {
                System.out.println("Operação entre " + i + " e " + j + ":");
                tabelaResultado[i][j] = scanner.nextLine();
            }
        }

        exibirTabela(elementos, tabelaResultado);

        System.out.println("\nAnalisando...");

        // Verifica a associatividade
        for (int i = 0; i < numElementos; i++) {
            for (int j = 0; j < numElementos; j++) {
                for (int k = 0; k < numElementos; k++) {
                    System.out.println("//////////////////////////////////////////////////////\n");
                    System.out.println("(a*b)*c=a*(b*c)");
                    System.out.println("(" + elementos[i] + "*" + elementos[j] + ")*" + elementos[k] + "=" + elementos[i] + "*(" + elementos[j] + "*" + elementos[k] + ")");

                    operandoA = tabelaResultado[i][j];
                    System.out.println("a*b=" + operandoA);

                    // Busca a posição do operandoA no vetor de elementos
                    for (int w = 0; w < numElementos; w++) {
                        System.out.println(elementos[w] + "==" + operandoA);
                        if (elementos[w].equals(operandoA)) {
                            System.out.println("Posição: " + w);
                            posicaoA = w;
                            resultadoA = tabelaResultado[posicaoA][k];
                            System.out.println("Resultado A: " + resultadoA);
                            System.out.println("(a*b)*c=" + operandoA);
                        }
                    }

                    operandoB = tabelaResultado[j][k];
                    System.out.println("b*c=" + operandoB);

                    // Busca a posição do operandoB no vetor de elementos
                    for (int w = 0; w < numElementos; w++) {
                        if (elementos[w].equals(operandoB)) {
                            posicaoB = w;
                            resultadoB = tabelaResultado[i][posicaoB];
                            System.out.println("a*(b*c)=" + operandoB);
                        }
                    }

                    // Verifica se os resultados finais são diferentes
                    if (!resultadoA.equals(resultadoB)) {
                        associativa = true;
                        if ("A".equals(resultadoA) || "B".equals(resultadoB)) {
                            System.out.println("\nFalha!\n(a*b)*c =! a*(b*c) ou não pertence ao grupo\n");
                        } else {
                            System.out.println("\nFalha!\nA=" + resultadoA + "!=B=" + resultadoB + "\n");
                        }
                    }
                }
            }
        }

        // Exibe o resultado da verificação de associatividade
        if (associativa) {
            System.out.println("Não é associativa!");
        } else {
            System.out.println("É associativa!");
        }
    }

    private static void exibirTabela(String[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            if (i == 0) {
                System.out.print("|*|");
            }
            System.out.print("|" + elementos[i] + "|");
        }
        for (int i = 0; i < elementos.length; i++) {
            if (i == 0) {
                System.out.print("\n");
            }
            System.out.println("|" + elementos[i] + "|");
        }
    }

    private static void exibirTabela(String[] elementos, String[][] tabelaResultado) {
        System.out.print("|*|");
        for (int i = 0; i < elementos.length; i++) {
            System.out.print("|" + elementos[i] + "|");
        }
        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < elementos.length; j++) {
                if (j == 0) {
                    System.out.print("\n|" + elementos[i] + "|");
                }
                System.out.print("|" + tabelaResultado[i][j] + "|");
            }
        }
    }
}
