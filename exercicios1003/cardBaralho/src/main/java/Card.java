public class Card {
    private final String naipe;
    private final int valor;
    private boolean praCima; //TODO add uma quebra de linha entre contextos (declaração de atributos e construtores, por exemplo)
    public Card( String naipe, int valor, boolean praCima){
        this.naipe = naipe; // TODO posso ter um naipe chamado capivara? ***
        this.valor = valor; // TODO posso ter uma carta que vale 1000?
        this.praCima = praCima;
    }//TODO aqui também
    String getCard(){  // TODO uma carta não retorna uma card, mas seu estado como String. Algo como getAsString() resolve. Além disso, faltou o "public"
        return String.format("%s %d %b", naipe, valor, praCima); // tente formatar a String para facilitar a legibilidade "3 de ouros aberto ou 4 de paus encoberto"
    }
    //TODO As provocações em *** são para destacar a utilidade dos enuns (enumerações de coisas que tem categorias finitas e bem definidas (A, 2, 3, 4 ... Q, J ) ou (OURO, ESPADA, COPAS e PAUS)

    //TODO faltou adicionar os getters para que seja possível compreender o estado do objeto de fora (o getAsString acima não substitui os getters)
}
