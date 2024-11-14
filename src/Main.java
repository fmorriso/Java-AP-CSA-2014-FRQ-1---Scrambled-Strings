public class Main {
    public static void main(String[] args) {

        System.out.format("Java version: %s%n", getJavaVersion());
        System.out.println("\nTesting Part (a):\n");

        String[] words =
                {
                        "TAN", "ABRACADABRA", "WHOA", "AARDVARK", "EGGS", "A", ""
                };

        for (String word : words) {
            System.out.format("word = '%s'%n",word);
            System.out.format("Working solution:              '%s' becomes '%s'%n", word, scrambleWordSolution(word));
            System.out.format("Student solution:              '%s' becomes '%s'%n", word, scrambleWordStudent(word));
            System.out.format("Sample solution (while-loop):  '%s' becomes '%s'%n", word, scrambleWordWhileLoop(word));
            System.out.format("Sample solution (for-loop):    '%s' becomes '%s'%n", word, scrambleWordForLoop(word));
            System.out.println("=".repeat(50));
        }

    }

    public static String scrambleWordWhileLoop(String word) {
        String scrambledWord = word;
        String current, previous;
        int i = 1;
        while(i < scrambledWord.length())
        {
            previous = scrambledWord.substring(i - 1, i);
            current = scrambledWord.substring(i, i + 1);

            if("A".equals(previous) && ! "A".equals(current))
            {
                // swap needed
                scrambledWord =
                        scrambledWord.substring(0, i - 1) +
                        current + previous +
                        scrambledWord.substring(i + 1);
                // jump past the two characters we just swapped
                i += 2;
            }
            else
                // no swap needed, so advance one character
                i++;
        }

        return scrambledWord;
    }

    /**
     * @param word - the word to be scrambled
     * @return String containing the original word, scrambled.
     */
    public static String scrambleWordForLoop(String word) {

        String scrambledWord = word;
        String current, previous;
        //NOTE: notice the increment part of the for-loop header is empty.
        //      That is deliberate so we can have fine-grain control over when and,
        //      more important, HOW MUCH to increment the loop counter, depending on circumstances.
        for(int i = 1; i < scrambledWord.length(); ) {

            previous = scrambledWord.substring(i - 1, i);
            current = scrambledWord.substring(i, i + 1);

            if("A".equals(previous) && ! "A".equals(current))
            {
                // swap needed
                scrambledWord =
                        scrambledWord.substring(0, i - 1) +
                                current + previous +
                                scrambledWord.substring(i + 1);
                // jump past the two characters we just swapped
                i += 2;
            }
            else
                // no swap needed, so advance one character
                i++;
        }

        return scrambledWord;
    }

    public static String scrambleWordStudent(String word) {
        // WARNING: this student's attempted solution fails to check for word being null, the empty string
        //         or just 1 character long.
        // SUGGESTION: if(word.length() <= 1) return word;
        String originalWord = word;
        /* to be implemented in part a */
        String finword = word;
        int digit = -1;
        while (digit < word.length()) {
            digit++;
            if ((word.indexOf("A") == digit) && ((digit + 1) <= word.length())) {

                // First point of failure in student's attempted solution
                try {
                    word = word.substring(0, digit - 1) + "a" + word.substring(digit + 1);
                } catch (Exception e) {
                    System.out.format("1. Student code failed for word '%s': %s%n", originalWord, e.getMessage());
                    break;
                }

                // Second point of failure in student's attempted solution
                try {
                finword = word.substring(0, digit - 1) + word.substring(digit + 1);
                } catch (Exception e) {
                    System.out.format("2. Student code failed for word '%s': %s%n", originalWord, e.getMessage());
                    break;
                }

                digit++;

                // Third point of failure in student's attempted solution
                try {
                    finword = word.substring(0, digit - 1) + "A" + word.substring(digit + 1);
                } catch (Exception e) {
                    System.out.format("3. Student code failed for word '%s': %s%n", originalWord, e.getMessage());
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
        return scrambleWord;
    }

    /** get the java version that is running the current program
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion()
    {
        Runtime.Version rtv = Runtime.version();
        return String.format("%s.%s.%s.%s", rtv.feature(), rtv.interim(), rtv.update(), rtv.patch());
    }
}