public class Card {
    private final String naipe;
    private final int valor;
    private boolean praCima;
    public Card( String naipe, int valor, boolean praCima){
        this.naipe = naipe;
        this.valor = valor;
        this.praCima = praCima;
    }
    String getCard(){
        return String.format("%s %d %b", naipe, valor, praCima);
    }
}
