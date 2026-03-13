import java.io.Serial;

public class Main {
    static void main() {
        Team team = new Team("macae", "rio de janeiro", "hernan");
        boolean state =  true;
        String[] names = {"ana", "pedro", "lucas", "joao", "artur", "teste1", "teste2", "teste3", "teste4", "teste5", "teste6", "teste7", "teste8", "teste9", "teste10", "teste11", "teste12", "teste13"};
        String[] position = {"go", "zc", "zc", "zc", "mei", "mei", "mei", "ata", "ata", "ata", "ca", "zc", "go", "go", "ata", "ata", "mei", "mei"};

        for(int i = 0; i<18; i++){
            Player x = new Player(names[i], position[i], i, state);
            team.addPlayer(x);
            if(i == 10) state = false;
        }
        Player[] inField = team.getFieldPlayer();
        Player[] outField = team.getOutFieldPlayer();
        System.out.println("\n ============== em campo ===================\n");
        for (int i = 0; i<inField.length; i++){
            System.out.printf("%s - \n ", inField[i].getStateAsString());
        }
        System.out.println("\n======================fora de campo=====================\n");
        for (int i = 0; i<outField.length; i++){
            System.out.printf("%s - \n", outField[i].getStateAsString());
        }
        System.out.println("\n=========================substituição em campo ==================\n");
        team.substitute( outField[1], inField[0]);
        team.substitute( outField[5], inField[4]);
        team.substitute(outField[4], inField[9]);
        System.out.println(" ============== em campo ===================\n");
        inField = team.getFieldPlayer();
        for (int i = 0; i< inField.length; i++){
            System.out.printf("%s - \n ", inField[i].getStateAsString());
        }
        outField = team.getOutFieldPlayer();
        System.out.println("\n=================fora de campo==================\n");
        for (int i = 0; i<outField.length; i++){
            System.out.printf("%s - \n ", outField[i].getStateAsString());
        }
        team.removePlayer(inField[2]);
        team.removePlayer(inField[5]);
        team.removePlayer(inField[8]);
        inField = team.getFieldPlayer();
        System.out.println("\n ============== em campo ===================\n");
        for (int i = 0; i<inField.length; i++){
            System.out.printf("%s -\n ", inField[i].getStateAsString());
        }
        outField = team.getOutFieldPlayer();
        System.out.println("\n=================fora de campo==================\n");
        for (int i = 0; i<outField.length; i++){
            System.out.printf("%s - \n ", outField[i].getStateAsString());
        }
    }
}
