public class WordCounter {

    public static int timesInSentence(String word, String sentence) {
        String sentenceInUse = sweepSimbolsOf(sentence.toLowerCase());
        String wordInUse = word.toLowerCase();

        String[] wordsInSentence = sentenceInUse.split(" ");

        return counter(wordInUse, wordsInSentence);
    }


    //TODO para que isso aqui? Para trocar caracteres? Que tal usar replace. Método complicado de entender ...
    private static String sweepSimbolsOf(String sentence) {
        String simbols = "!.%&?,;:/°[]{}=+-)(*&$#@";
        StringBuilder stringReturn = new StringBuilder();
        char character, lastChar = ' ';
        for (int i = 0; i < sentence.length(); i++) {
            character = sentence.charAt(i);
            if (!simbols.contains(String.valueOf(character))) {
                if (character != ' ' && i > 0 && simbols.contains(String.valueOf(lastChar))) {
                    stringReturn.append(lastChar);
                }
                stringReturn.append(character);

            }
            lastChar = character;

        }
        System.out.println(stringReturn);
        return stringReturn.toString();
    }

    private static int counter(String word, String[] sentence) {
        int counter = 0;
        //TODO você pode usar loop de coleções, já que o index é irrelevante ( for(String s: sentence) )
        for (int i = 0; i < sentence.length; i++) {
            if (word.equals(sentence[i]))
                counter++;
        }
        return counter;
    }
}
