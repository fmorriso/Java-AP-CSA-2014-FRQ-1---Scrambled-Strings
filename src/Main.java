public class Main {
    public static void main(String[] args) {


        System.out.println("\nTesting Part (a):\n");

        String[] words =
                {
                        "TAN", "ABRACADABRA", "WHOA", "AARDVARK", "EGGS", "A", ""
                };

        for (String word : words) {
            System.out.println("Working solution: '" + word + "' becomes 1" + scrambleWordSolution(word) + "'");
            System.out.format("Student solution: '%s' becomes '%s'%n", word, scrambleWordStudent(word));
        }

    }

    public static String scrambleWordWhileLoop(String word) {
        String scrambled = "";


        return scrambled;
    }

    public static String scrambleWordStudent(String word) {
        System.out.format("Student solution: attempting to scramble word: '%s'%n", word);
        /* to be implemented in part a */
        String finword = word;
        int digit = -1;
        while (digit < word.length()) {
            digit++;
            if ((word.indexOf("A") == digit) && ((digit + 1) <= word.length())) {
                try {
                    word = word.substring(0, digit - 1) + "a" + word.substring(digit + 1);
                } catch (Exception e) {
                    System.err.format("1. Student code failed: %s%n", e.getMessage());
                    break;
                }

                try {
                finword = word.substring(0, digit - 1) + word.substring(digit + 1);
                } catch (Exception e) {
                    System.err.format("2. Student code failed: %s%n", e.getMessage());
                    break;
                }

                digit++;
                try {
                    finword = word.substring(0, digit - 1) + "A" + word.substring(digit + 1);
                } catch (Exception e) {
                    System.err.format("3. Student code failed: %s%n", e.getMessage());
                    break;
                }
            }
        }
        return finword;
    }

    public static String scrambleWordSolution(String word) {
        int i = 0;
        String scrambleWord = "";
        while (i < word.length()) {
            if (word.substring(i, i + 1).equals("A") && i + 1 != word.length()) {
                if (word.substring(i + 1, i + 2).equals("A")) {
                    scrambleWord = scrambleWord + word.substring(i, i + 1) + word.substring(i + 2, i + 3) + word.substring(i + 1, i + 2);
                    i = i + 3;
                } else {
                    scrambleWord = scrambleWord + word.substring(i + 1, i + 2) + word.substring(i, i + 1);
                    i = i + 2;
                }
            } else {
                scrambleWord = scrambleWord + word.substring(i, i + 1);
                i++;
            }

        }
        return (scrambleWord);
    }
}