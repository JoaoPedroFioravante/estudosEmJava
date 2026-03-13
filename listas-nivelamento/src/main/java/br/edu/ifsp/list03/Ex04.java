package br.edu.ifsp.list03;

/*
Dada duas Strings A e B, faça um programa que imprima “Sim” se A e B são anagramas e “Nao”, caso contrário.
Um anagrama é a transposição de letras de palavra ou frase para formar outra palavra ou frase diferente.
Por exemplo, as palavras “roma” e “amor” são anagramas. Considere como entrada apenas palavras com letras minúsculas.
 */

public class Ex04 {
    public static void main(String[] args) {
        //Leia o ‘input’
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
    }

    String compute(String wordA, String wordB) {
    if(wordA == null || wordB==null || wordA.isEmpty() || wordB.isEmpty() || wordA.length() != wordB.length()) return "Nao";
    int tamanho = wordA.length();
    char [] a = new char[tamanho];
    char [] b = new char[tamanho];
    a = wordA.toCharArray();
    b = wordB.toCharArray();
    java.util.Arrays.sort(a);
    java.util.Arrays.sort(b);
    for(int i = 0; i<tamanho; i++){
        System.out.printf("%c %c \n", a[i], b[i]);
        if(a[i]!=b[i])return "Nao";
    }
    return "Sim";

    }
}
