package br.edu.ifsp.list01;

/*
    Faça um programa que leia um conjunto de valores que correspondem as idades de pessoas de uma comunidade. Quando
    o valor fornecido for um número negativo, significa que não existem mais idades para serem lidas. Após a leitura,
    o programa deve informar:

    A média das idades das pessoas (com duas casas decimais)
    A quantidade de pessoas maiores de idade
    A porcentagem de pessoas idosas (considere quem uma pessoa idosa tem mais de 75 anos) (com duas casas decimais)

    Exemplos de entrada e saída:
    | Entrada             | Saída          |
    | -------             | ------         |
    | 10 20 30 80 -1      | 35.00 3 25.00% |
    | 25 30 45 -1         | 33.33 3 0.00%  |
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi (IFSP/SCL) e Adenilso Simão (ICMC/USP)
*/
import java.util.Scanner;
public class Ex09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int []soma = new int[100];
        int x, i = 0;
        while(true){
            x = scanner.nextInt();
            if(x <= -1) break;
            soma[i++] = x;
        }
        Ex09 teste = new Ex09();
        System.out.println(teste.compute(soma));
    }

    String compute(int[] input) {
        String output = null;
        double media = 0,idosas =0;
        int i = 0, maioresIdade= 0;
        while(input[i] > -1){
            media += input[i];
            if(input[i] >= 18) {
                maioresIdade +=1;
                if(input[i] > 75) idosas += 1;
            }
            i++;
        }
        media /= i;
        idosas = (idosas*100)/i;
        output = String.format("%.2f %d %.2f%%", media, maioresIdade, idosas);
        return output;
    }
}
