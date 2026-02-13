package br.edu.ifsp.list01;

import java.util.Scanner;

/*
    A avenida principal da cidade de Algoritmopolis possui limite de velocidade de L km/h.
    Se o motorista ultrapassar essa velocidade, é aplicado uma multa de R$ M, mais R$ A
    por cada km acima do limite. Faça um programa que leia o limite L, o valor da multa M,
    o valor adicional A e a velocidade V captada pelo radar e informe o valor total da multa.
    Considere L e V sempre como números inteiros. Apresente a resposta com duas casas decimais.

    Exemplos de entrada e saída:
    Entrada	    Saída
    60          200.00
    150.00
    10.00
    65

    Entrada	    Saída
    60          0.00
    150.00
    10.00
    50
*/
public class Ex05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex05 radar = new Ex05();
        double[] valores = new double[2];
        int velocidadeMaxima = scanner.nextInt();
        for(int i = 0; i<2; i++)valores[i] = scanner.nextDouble();
        int velocidadeCapturada = scanner.nextInt();
        System.out.println(radar.compute(velocidadeMaxima, valores[0], valores[1], velocidadeCapturada));
    }

    String compute(int L, double m, double a, int v) {
        String output =  "0.00";
        if(v>L){
            double taxaAdicional = (v-L)*a;
            double multa =  ( m + taxaAdicional);
            output = String.format("%.2f",multa);
        }
        return output;
    }
}
