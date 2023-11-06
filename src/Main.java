public class Main {
    // 1. parenthesesCheck

    public static boolean parenthesesCheck(String a) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '(') {
                count += 1;
            }
            if (a.charAt(i) == ')') {
                count -= 1;
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }

    // 2. reverseInteger
    public static String reverseInteger(int a) {
        String returnvariable = "";
        String b = "" + a;

        for (int i = 0; i<b.length(); i++){
            if (i == b.length()-1){
                returnvariable += b.substring(0,1);
            }else{
                returnvariable += b.substring(b.length()-i-1,b.length()-i);
            }
        }
        return returnvariable;
    }

    // 3. encryptThis
    public static String encryptThis(String a) {
        //String result = "";
        String[] words = a.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            char[] chars = word.toCharArray();
            if (chars.length >= 2) {
                char secondChar = chars[1];
                chars[1] = chars[chars.length - 1];
                chars[chars.length - 1] = secondChar;
            }

            chars[0] = (char) chars[0];

            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(chars);
        }
        String newsentence = result.toString();

        String[] words2 = newsentence.split(" ");
        StringBuilder result2 = new StringBuilder();

        for (String word : words2) {
            if (word.isEmpty()) {
                continue;
            }

            char firstChar = word.charAt(0);
            int asciiValue = (int) firstChar;

            String modifiedWord = asciiValue + word.substring(1);

            if (result2.length() > 0) {
                result2.append(" ");
            }
            result2.append(modifiedWord);
        }

        return result2.toString();
    }

    // 4. decipherThis

    public static String decipherThis(String message) {
        String[] words = message.split(" ");
        String result = "";

        for (String word : words) {
            if (word.isEmpty()) {
                continue;  // Skip empty words
            }

            int length = 0;
            while (length < word.length() && Character.isDigit(word.charAt(length))) {
                length++;
            }

            if (length > 0) {
                String asciiStr = word.substring(0, length); // Extract the ASCII value part
                int asciiValue = Integer.parseInt(asciiStr); // Convert it to an integer
                char firstChar = (char) asciiValue; // Convert the integer back to a character

                // Replace the first character with its character
                String chars = "";
                if (word.length() >= 3) {
                    for (int i = 0; i<word.length(); i++){
                        if (i<length){
                            chars += firstChar;
                            i+= length-1;
                        }else{
                            chars += word.charAt(i);
                        }
                    }
                }
                String ret = "";
                // Swap the second and last characters
                if (word.length() >= 3) {
                    for (int i = 0; i<chars.length(); i++){
                        if (i == 1){
                            ret += chars.charAt(chars.length() - 1);
                        }
                        else if (i == chars.length()-1){
                            ret += chars.charAt(1);
                        }else{
                            ret += chars.charAt(i);
                        }
                    }


                }
                result += ret + " ";
            }
        }
        result = result.substring(0,result.length()-1);
        return result;
    }

}

