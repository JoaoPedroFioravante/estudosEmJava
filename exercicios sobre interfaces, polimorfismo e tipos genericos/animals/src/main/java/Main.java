public class Main {
    public static void main(){
        Animal[] animals = new Animal[10];
        for(int i = 0; i<9; i+=3){
            animals[i] = new Wolf();
            animals[i+1] = new Owl();
            animals[i+2] = new Lion();
        }
        animals[9] = new Wolf();

        Zoo myzoo = Zoo.createZoo(animals);
        myzoo.displayAnimalsInZoo();
    }
}
