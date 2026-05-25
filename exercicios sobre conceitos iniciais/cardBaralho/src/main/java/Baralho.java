// TODO adote PT ou EN, mas evite usar ambos.
public class Baralho {
    private final Card[] cards;
    private int indice;
    public Baralho(){
        cards = new Card[36];
        gerarBaralho();
    }
    private void gerarBaralho() {
        String[] naipes = {"paus", "ouro", "espadas", "copas"};
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // TODO note que NAO tem Q, J, K, que são valores de fato.
        boolean virado = false;
        indice = 0;
        for (int i = 0; i < naipes.length; i++) {
            String naipe = naipes[i];
            for (int j = 0; j < numeros.length; j++) {
                int numero = numeros[j];
                // TODO virado é booleano, então você não precisa compará-lo com booleano. Faça apenas if(!virado).
                //  De qualquer forma, não entendi muito bem o que fez. Não existem duas cartas iguais em um baralho, seja ela virada ou nào.
                if (virado == false) virado = true;
                else virado = false;
                Card temp = new Card(naipe, numero, virado);
                cards[indice++] =  temp;
            }
        }
        indice--;
        //TODO aqui um exemplo interessante que o "princípio do encapsulamento" não é só colocar public e private.
        // De quem deveria ser a responsabilidade de garantir que um objeto de card é válido, da carta ou do baralho?
        // Card, certo? Essa responsabilidade foi "exposta" para baralho, já que card aceita qualquer int e qualquer
        // string ao invés de valores delimitados (por verificação ou por enum). Por quebra de encapsulamento, o
        // desenvolvedor do baralho DEVE saber os valores que card aceita e PODE passar acidentalmente valores
        // inválidos como "CAPIVARA 23 aberta".
    }

    public void reinicio(){
        gerarBaralho();
    }



    public Card[] pegarCartas(int x){
        Card[] temp = new Card[x];
        for(int i = 0; i<x; i++){
            temp[i]=cards[indice--];
        }
        return temp;
    }

    public Card pegarCartas() {
        return cards[indice--];
    }
}
