package br.edu.ifsp.list03;

/*
Faça um programa que, dada uma String, encontra a primeira e a última substrings de tamanho K de acordo com a ordem
alfabética. Por exemplo, para a String “welcometojava” e K = 3; A substring “ava” é a primeira substring de tamanho
3 e “wel” é a última, considerando a ordem alfabética (saída: "ava wel"). Para dados de entrada inválidos, o programa
deverá imprimir uma String vazia.
 */
public class Ex02 {
    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
    }

    String compute(String word, int number) {
        String output = null;
        if(number == 0 || number>word.length()) return null;
        else if(number == word.length()) return word += " " + word;
            String ultima= "", primeira= "";
            char ultimaC = word.charAt(0), primeiraC = word.charAt(0);
            int ultPos = 0, priPos = 0;
            for(int i = 0; i<word.length(); i++){
                    if(word.charAt(i)>ultimaC && (i+number-1)<word.length()){
                        ultimaC = word.charAt(i);
                        ultPos = i;
                    }
                    else if(word.charAt(i)<primeiraC && (i+number-1)<word.length()){
                        primeiraC = word.charAt(i);
                        priPos = i;
                    }

                }


            for(int i = 0; i<number; i++){
                primeira += word.charAt(priPos+i);
                ultima += word.charAt(ultPos+i);
            }
            primeira+=" "+ultima;
            return primeira;



    }
}
