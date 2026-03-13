public class Main {
    static void main() {
        Baralho b1 = new Baralho();


        for(int i = 0; i<36; i+=4){
            Card[] teste = b1.pegarCartas(4);
            System.out.printf("%s \n%s \n%s \n%s \n", teste[0].getCard(), teste[1].getCard(), teste[2].getCard(), teste[3].getCard());
        }
    }
}
