package br.edu.ifsp.list03;

/*
Implemente um programa que gere senhas provisórias a partir do nome do usuário, seguindo o mesmo
padrão dos exemplos a seguir:

EXEMPLO 1 Entrada: Java | Saída: J*Ja*Jav*Jav*Ja* J
EXEMPLO 2 Entrada: POOS3 | Saída: P*PO*POO*POOS*POOS*POO*PO*P
EXEMPLO 3 Entrada: KO | Saída: K*K
EXEMPLO 4 Entrada: O | Saída: Invalido
EXEMPLO 5 Entrada: | Saída: Invalido
*/
public class Ex01 {
    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
    }

    String compute(String input) {
        String output = null;
        if( input == null) return "Invalido";
        if(input.length() < 2) return "Invalido";
        output = "";
        int tamanho = input.length();
        String add = "";
        //
        for(int i = 1; i<tamanho; i++){
            for(int j = 0; j<i; j++){
                output += input.charAt(j);
            }
            output += "*";
        }
      // 3 . 0 1 2 ; 2. 0 1; 1 . 0; 0
        for(int i = tamanho-1; i>0; i--){
            for(int j = 0; j<i; j++){
                output+= input.charAt(j);
            }
            if(i!=1){
                output+="*";
                System.out.printf("%d", i);
            }
        }
        return output;
    }
}
