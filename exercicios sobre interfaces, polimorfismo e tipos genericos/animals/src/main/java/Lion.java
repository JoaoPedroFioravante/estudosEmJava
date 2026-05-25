public class Lion extends Animal implements RunAnimal{
    @Override
    public void makeSound(){
        System.out.println("Rrrrrwaarrr!");
    }
    @Override
    public void run(){
        System.out.println("lion is running");
    }
}
