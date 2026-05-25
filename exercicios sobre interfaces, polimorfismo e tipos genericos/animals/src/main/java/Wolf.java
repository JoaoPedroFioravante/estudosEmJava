public class Wolf extends Animal implements RunAnimal{
    @Override
    public void makeSound() {
        System.out.println("auuuuuuuuu");
    }

    @Override
    public void run() {
        System.out.println("wolf is running");
    }
}
