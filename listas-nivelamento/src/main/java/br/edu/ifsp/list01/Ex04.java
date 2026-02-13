package br.edu.ifsp.list01;

import java.util.Scanner;

/*
    Osmar adora chocolates e vai para a loja com N dinheiro no bolso. O preço de cada chocolate é C.
    A loja oferece um desconto: para cada M embalagens que ele dá para a loja, ele ganha um chocolate grátis.
    Quantos chocolates Osmar consegue comer? Por exemplo:

    Para N=10, C=2, M=5, ele pode comprar 5 chocolates por $10 e trocar as 5 embalagens por mais 1 chocolate,
    fazendo com que o número total de chocolates que ele pode comer seja 6.
    Faça um programa que leia inteiros N, C e M e imprima a quantidade de chocolates que Osmar pode comer.
    C e M são inteiros positivos.

    Entrada	Saída
    10      6
    2
    5
 */
public class Ex04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex04 qtdChocolates = new Ex04();
        int[] ncm = new int[3];
        for(int i = 0; i<3; i++)ncm[i] = scanner.nextInt();
        System.out.println(qtdChocolates.compute(ncm[0], ncm[1], ncm[2]));
    }

    int compute(int n, int c, int m) {
        int output = 0;
        if(n > 0){
            int qtd = n/c;
            int bonus = qtd/m;
            int x = bonus + qtd%m;
            int h;
            while(x >= m) {
                bonus += x/m;
                h = x%m;

                x/=m;
                x+=h;

            }
            output = bonus + qtd;
        }
        return output;
    }
}
