public class Zoo {
    private final Animal[] animals;
    // TODO geralmente array é melhor final, já que o conteúdo muda, mas a referência para o array (cabeça) na memória não.

    //TODO nesse caso, é melhor o Zoo controlar a inserção de animais, ao invés de passar o array. Isso evita violar
    //TODO o princípio do encapsulamento. Deixa um construtor comum padrão público apenas. Adiciona um método addAnimal.
    private Zoo(Animal[] animals){
        this.animals  = new Animal[10];
    }

    //TODO pode tirar isso aqui
    public static Zoo createZoo(Animal[] animals){
        if(!isFull(animals)) return null;
        return new Zoo(animals);
    }

    private static boolean isFull(Animal[] animals){
        for(int i = 0; i<animals.length; i++){
            if(animals[i] == null){
                return false;
            }
        }
        return true;
    }

    //exatamente.
    public void displayAnimalsInZoo(){
        for(int i = 0; i<10; i++){
            animals[i].makeSound();
            if(animals[i] instanceof Runner runAnimal){
                runAnimal.run();
            }
        }
    }
}
