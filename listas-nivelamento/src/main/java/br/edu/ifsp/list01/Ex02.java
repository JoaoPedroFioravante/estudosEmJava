package br.edu.ifsp.list01;

/*
    Sejam a, b e c os três lados de um triângulo. Elabore um algoritmo que verifica se o triângulo é:

    Escaleno (todos os lados diferentes)
    Isósceles (possui dois lados iguais)
    Equilátero (todos os lados iguais)
    Não forma triângulo (a soma de dois lados deve ser maior que o terceiro lado)
    Os três números devem ser inteiros positivos e lidos na mesma linha (Ex: 3 4 5) Exemplos de entrada e saída esperada:

    Exemplo 1: Entrada = 2 3 2 | Saída = Isosceles
    Exemplo 2: Entrada = 2 2 2 | Saída = Equilatero
    Exemplo 3: Entrada = 1 2 4 | Saída = Nao forma triangulo
    Exemplo 4: Entrada = -1 2 4 | Saída = Erro
    Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
*/

import java.util.Scanner;

public class Ex02 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int[] triangulo = new int[3];
        for(int i = 0; i<3; i++){
            triangulo[i] = scanner.nextInt();
        }
        Ex02 checkTriangulo = new Ex02();
        System.out.println(checkTriangulo.compute(triangulo[0], triangulo[1], triangulo[2]));

    }

    String compute(int a, int b, int c) {
        String output = null;
        int tipo = 0;
        if(a <= 0 || b <= 0 || c <= 0){
            output = "Erro";
        }
        else{
            int ab =a+b, bc =b+c, ac =a+c;
            if(ab > c && bc > a && ac > b){
                if(a==b)tipo++;
                if(a==c)tipo++;
                if(c==b)tipo++;
                if(tipo == 3){
                    output = "Equilatero";
                }
                else if(tipo == 1){
                    output = "Isosceles";
                }
                else output = "Escaleno";
            }
            else{
                output = "Nao forma triangulo";
            }
        }
        return output;
    }
}
