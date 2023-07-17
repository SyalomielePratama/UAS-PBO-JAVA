package Child;
public class ManipulasiString {
    public static String capitalizeFirstLetter(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split(" ");

        for (String word : words) {
            if (!word.isEmpty()) {
                String firstLetter = word.substring(0, 1);
                String restLetters = word.substring(1);
                result.append(firstLetter.toUpperCase()).append(restLetters).append(" ");
            }
        }

        return result.toString().trim();
    }
}