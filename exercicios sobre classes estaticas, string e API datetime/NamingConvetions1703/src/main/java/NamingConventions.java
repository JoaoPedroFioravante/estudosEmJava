public class NamingConventions {
    public enum Convention {
        CONSTANT, VARIABLE, CLASS, METHOD
    }

    private NamingConventions() {
    }

    public static boolean isFollowingConvention(String string, Convention convention) {
        boolean isFollowing = false;
        if (isValidJavaIdentifier(string)) {
            char firstChar = string.charAt(0);

            if (convention == Convention.VARIABLE || convention == Convention.METHOD) {
                isFollowing = checkMethodAndVariable(string, firstChar);
            } else if (convention == Convention.CLASS) {
                isFollowing = checkClass(string, firstChar);
            } else {
                isFollowing = isValidConstant(string);
            }
        }
        return isFollowing;

    }

    public static boolean isValidJavaIdentifier(String string){
        if (string.isEmpty() || string.contains(String.valueOf(' ')))
            return false;
        char character = string.charAt(0);

        if(Character.isLetter(character)  || character == '_' || character == '$') {
            for (int i = 1; i < string.length(); i++) {
                character = string.charAt(i);
                if ((!(Character.isLetterOrDigit(character)) && character != '_' && character != '$')) {
                    return false;
                }
            }
        }
        else
            return false;
        return true;
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
            if (!Character.isLetter(character) || upperCaseCounter == 2)
                break;
            if (Character.isUpperCase(character)) {
                upperCaseCounter++;
            }
            else
                upperCaseCounter = 0;
            if (i == string.length() - 1 )
                return true;
        }
        return false;
    }

    private static boolean isValidConstant(String string){
        char character;
        int underLineCounter = 0;

        for(int i = 0; i<string.length(); i++){
            character = string.charAt(i);
            if(!Character.isUpperCase(character) && character!='_' || (i == string.length()-1 && character == '_') || underLineCounter ==2){
                return false;
            }
            if(character=='_'){
                underLineCounter++;
            }
            else
                underLineCounter = 0;
        }
        return true;
    }

    public static String fromConstToVariable(String string){
        if(!isFollowingConvention(string, Convention.CONSTANT))
            return null;
        char character;
        StringBuilder stringVariable = new StringBuilder();
        int upperCase = 0;
        for(int i = 0; i<string.length(); i++){
            character = string.charAt(i);
            if(Character.isLetter(character) && upperCase == 0){
                stringVariable.append(Character.toLowerCase(character));
            } else if (upperCase == 1) {
                stringVariable.append(Character.toUpperCase(character));
                upperCase = 0;
            } else {
                upperCase=1;
            }
        }
        return stringVariable.toString();
    }

    public static String fromVariableToConst(String string){
        if(!isFollowingConvention(string, Convention.VARIABLE))
            return null;
        char character;
        StringBuilder stringConstant = new StringBuilder();
        for(int i = 0; i<string.length(); i++){
            character = string.charAt(i);
            if (Character.isLowerCase(character)){
                stringConstant.append(Character.toUpperCase(character));
            }
            else {
                stringConstant.append("_");
                stringConstant.append(character);
            }
        }
        return stringConstant.toString();
    }


}

