import java.util.*;

//Crie um programa que leia um número arbitrário de palavras digitadas pelo usuário no console e
//imprima na sequência:
//❖ Todas as palavras digitadas
//❖ As palavras digitadas sem repetição e em ordem alfabética
//❖ A frequência de cada palavra digitada
//Tente realizar a implementação sem ordenar as palavras ou contar manualmente a frequência que
//elas aparecem.
public class Main {
    void main() {
        List<String> words = new ArrayList<>();

        //TODO, se não for atributo, defina a variável próxima de onde ela é usada.
        Set<String> wordsNoRepetition = new HashSet<>();
        Map<String, Integer> frequencyOfWords = new HashMap<>();
        String word;
        Scanner scanner = new Scanner(System.in);

        do {
            word = scanner.nextLine();
            if (word.isBlank()) {
                break;
            }
            words.add(word);
        }
        while (true);


        wordsNoRepetition.addAll(words);        //TODO, se não for atributo, defina a variável próxima de onde ela é usada.

        //TODO simplifique com map.merge() https://medium.com/@AlexanderObregon/javas-map-merge-method-explained-a2f0b5de9c8a
        for (int i = 0; i < words.size(); i++) {
            if (!frequencyOfWords.containsKey(words.get(i))) {
                frequencyOfWords.put(words.get(i), 1);
            } else {
                int valor = frequencyOfWords.get(words.get(i));
                frequencyOfWords.replace(words.get(i), valor + 1);
            }
        }


        System.out.println("============== words print =============");
        for (var element : words) {
            System.out.println(element); // TODO pode usar forEach
        }

        System.out.println("============== set print ===============");
        wordsNoRepetition.forEach(e -> System.out.println(e));

        System.out.println("============== map print ===============");
        frequencyOfWords.forEach((key, value) -> System.out.printf("%s %d \n", key, value)); // GOOD
    }
}
