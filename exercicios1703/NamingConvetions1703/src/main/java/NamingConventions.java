public class NamingConventions {
    public enum Convention {
        CONSTANT, VARIABLE, CLASS, METHOD
    }

    private NamingConventions() {
    }

    public static boolean isFollowingConvention(String string, Convention convention) {
        boolean isFollowingConvention = false;
        char firstChar = string.charAt(0);
        if (Character.isLetter(firstChar) && !string.contains(String.valueOf(' '))) {
            if (convention == Convention.VARIABLE || convention == Convention.METHOD) {
                isFollowingConvention = checkMethodAndVariable(string, firstChar);
            } else if (convention == Convention.CLASS) {
                isFollowingConvention = checkClass(string, firstChar);
            } else {
                isFollowingConvention = isValidConstant(string);
            }
        }
        return isFollowingConvention;

    }

    private static boolean checkMethodAndVariable(String string, char firstChar) {
        if (Character.isLowerCase(firstChar)) {
            return isValid(string, 0);
        }
        return false;
    }

    private static boolean checkClass(String string, char firstChar) {
        if (Character.isUpperCase(firstChar)) {
            return isValid(string, 1);
        }
        return false;
    }

    private static boolean isValid(String string, int upperCaseCounter) {
        char character;

        for (int i = 1; i < string.length(); i++) {
            character = string.charAt(i);
            if (!Character.isLetter(character) && !Character.isDigit(character) || upperCaseCounter == 2)
                break;
            if (Character.isUpperCase(character))
                upperCaseCounter++;
            else
                upperCaseCounter = 0;
            if (i == string.length() - 1)
                return true;
        }
        return false;
    }

    private static boolean isValidConstant(String string){
        char character;

        for(int i = 0; i<string.length(); i++){
            character = string.charAt(i);
            if(!Character.isUpperCase(character) && character!='_' || i == string.length()-1 && character == '_'){
                return false;
            }
        }
        return true;
    }
}

