import java.util.Scanner;

public class UniqueCharacters {

    // Method to find length without using length()
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // will throw error when index is out
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // nothing, just end of string
        }
        return count;
    }

    // Method to find unique characters using charAt()
    public static char[] findUniqueChars(String text) {
        int len = getLength(text);
        char[] temp = new char[len];
        int uCount = 0;

        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            boolean found = false;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[uCount++] = c;
            }
        }

        char[] result = new char[uCount];
        for (int i = 0; i < uCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String str = sc.nextLine();

        char[] uniq = findUniqueChars(str);

        System.out.println("\nUnique chars:");
        for (char ch : uniq) {
            System.out.print(ch + " ");
        }

        sc.close();
    }
}
