public class Baralho {
    private final Card[] cards;
    private int indice;
    public Baralho(){
        cards = new Card[36];
        gerarBaralho();
    }
    private void gerarBaralho() {
        String[] naipes = {"paus", "ouro", "espadas", "copas"};
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean virado = false;
        indice = 0;
        for (int i = 0; i < naipes.length; i++) {
            String naipe = naipes[i];
            for (int j = 0; j < numeros.length; j++) {
                int numero = numeros[j];
                if (virado == false) virado = true;
                else virado = false;
                Card temp = new Card(naipe, numero, virado);
                cards[indice++] =  temp;
            }
        }
        indice--;
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
