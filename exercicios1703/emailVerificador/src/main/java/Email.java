public class Email {

    public static boolean isValid(String email) {
        String emailWithoutCase = email.toLowerCase();
        String body = cutBody(emailWithoutCase);
        if (!body.isEmpty()) {
            String domain = cutDomain(emailWithoutCase);
            boolean bodyValid = isBodyValid(body);
            boolean domainValid = isDomainValid(domain);
            if (bodyValid && domainValid) //TODO nunca use um if-else pare tornar o boolean. Retorne a própria condição de guarda
                return true; // TODO o mesmo que "return bodyValid && domainValid;"
        }

        return false;
    }

    //TODO muito mais direto usando email.split()
    private static String cutBody(String email) {
        StringBuilder body = new StringBuilder();
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                return body.toString();
            }
            body.append(email.charAt(i));
        }
        return "";
    }

    //TODO idem
    private static String cutDomain(String email) {
        StringBuilder domain = new StringBuilder();
        int indexSign = email.indexOf('@');
        for (int i = indexSign + 1; i < email.length(); i++) {
            domain.append(email.charAt(i));
        }
        return domain.toString();
    }

    private static boolean isBodyValid(String body) {
        String charAllowed = "0123456789abcdefghijklmnopqrstuvwxyz_-";
        body = body.toLowerCase();
        int dotCounter = 0;
        char character, firstCharacter = body.charAt(0), lastCharacter = body.charAt(body.length() - 1);
        boolean isBodyValid = true;

        // TODO dá para extrair em um método, que usa outro método contendo "irstCharacter != '?' && lastCharacter != '?'" onde ? é o parâmetro.
        if (firstCharacter != '.' && lastCharacter != '.' &&
            firstCharacter != '-' && lastCharacter != '-' &&
            firstCharacter != '_' && lastCharacter != '_') {
            for (int i = 0; i < body.length(); i++) {
                character = body.charAt(i);
                if (character == '.') {
                    dotCounter++;
                    if (dotCounter == 2) {
                        isBodyValid = false;
                        break;
                    }
                } else if (!charAllowed.contains(String.valueOf(character))) {
                    isBodyValid = false;
                    break;
                } else {
                    dotCounter = 0;
                }
            }
            return isBodyValid;
        }
        return false;
    }

    //TODO não conferi tudo bonitinho, a ideia era práticar Strings mais do que o resultado. Exatamente o que você fez.
    private static boolean isDomainValid(String domain) {
        String charAllowed = "0123456789abcdefghijklmnopqrstuvwxyz-";
        int dotCounter = 0;
        char character, firstCharacter = domain.charAt(0), lastCharacter = domain.charAt(domain.length() - 1);
        boolean isDomainValid = true;
        if (firstCharacter != '.' && lastCharacter != '.' &&
            firstCharacter != '-' && lastCharacter != '-' && domain.contains(String.valueOf('.'))) {
            for (int i = 0; i < domain.length(); i++) {
                character = domain.charAt(i);

                if (character == '.') {
                    dotCounter++;
                    if (dotCounter == 2 || domain.charAt(i - 1) == '-') {
                        isDomainValid = false;
                        break;
                    }
                } else if (!charAllowed.contains(String.valueOf(character))) {
                    isDomainValid = false;
                    break;
                } else if (dotCounter == 1 && character == '-') {
                    isDomainValid = false;
                    break;
                } else {
                    dotCounter = 0;
                }
            }
            return isDomainValid;
        }

        return false;
    }
}
