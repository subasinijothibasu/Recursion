/*Permutation in sorted order - String input
Given a string, print all its permutation in sorted order.
Example:

Input

eat

Output

aet

ate

eat

eta

tae

tea  */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] characters = input.toCharArray();
        Arrays.sort(characters);

        generateSortedPermutations(characters, new boolean[characters.length], new StringBuilder());

        scanner.close();
    }

    public static void generateSortedPermutations(char[] characters, boolean[] used, StringBuilder current) {
        if (current.length() == characters.length) {
            System.out.println(current.toString());
            return;
        }

        for (int i = 0; i < characters.length; i++) {
            if (used[i] || (i > 0 && characters[i] == characters[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            current.append(characters[i]);

            generateSortedPermutations(characters, used, current);

            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }
}
