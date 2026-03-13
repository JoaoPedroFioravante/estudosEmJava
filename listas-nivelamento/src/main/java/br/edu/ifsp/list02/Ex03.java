package br.edu.ifsp.list02;

import java.sql.SQLOutput;

/*
    Leia um conjunto de cinco números inteiros não repetidos em uma única linha e os armazene em um vetor de 10 posições.
    A partir daí, leia um número por vez. Se o número ainda não estiver no conjunto, faça a inclusão após o último número.
    Caso ele esteja no conjunto, remova o número e libere espaço no array. A cada iteração imprima o vetor. O programa
    acaba quando o array ficar totalmente cheio ou vazio. Veja o exemplo na imagem anexa.

    Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
 */
public class Ex03 {
    public static void main(String[] args) {
        //Leia o input
        Ex03 ex = new Ex03();
        ex.compute(new int[]{1, 2, 3, 4, 5}, new int[]{1, 6, 2, 3, 4, 5, 7, 6, 7});
    }

    String compute(int[] firstFive, int[] otherInts) {
        String output = "", h = " ";
        int[] vet = new int[10];
        int p=5, x = -1;
        for(int i = 0; i< 5; i++){
            vet[i] = firstFive[i];
            if(i == 4) h = "";
            else h=" ";
            output += String.valueOf(vet[i]) + h;
        }
        output += "\n";
        if(otherInts.length ==0) return "Erro";
        else {
            while (p != 0 && p != 10) {
                for (int i = 0; i < otherInts.length; i++) {
                    for (int j = 0; j < p; j++) {
                        if (otherInts[i] == vet[j]) {
                            for (int k = j; k < (p - 1); k++) {
                                vet[k] = vet[k+1];
                            }
                            p-=1;
                            x = j;
                            break;
                        }

                    }
                    if (x == -1) {
                        vet[p++] = otherInts[i];

                    } else x = -1;

                    for (int j = 0; j < p; j++){
                        if(j == p-1) h = "\n";
                        else if(p == 0 || p ==10) h = "";
                        else h=" ";
                        output += String.valueOf(vet[j]) + h;
                    }

                }
            }
        }

        return output;
    }
}
