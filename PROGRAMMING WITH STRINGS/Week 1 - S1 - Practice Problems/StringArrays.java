public class StringArrays {
    // TODO : Create a method that takes a string array of names and returns the longest name
    public static String findLongestName(String[] names) {
        // Code
        if (names == null || names.length == 0) {
            return null; // No names provided
        }

        String longestName = names[0];
        for (String name : names) {
            if (name != null && name.length() > longestName.length()) {
                longestName = name;
            }
        }
        return longestName;
    }

    // TODO : Create a method that counts how many names start with a given letter (case insensitive)
    public static int countNamesStartingWith(String[] names, char letter) {
        // Code
         int count = 0;
        letter = Character.toLowerCase(letter);
        for (String name : names) {
            if (!name.isEmpty() && Character.toLowerCase(name.charAt(0)) == letter) {
                count++;
            }
        }
        return count;
    }

    // TODO : Create a method that formats all names to  "Last, First" format.
    // Assume names are given as "First Last"
    public static String[] formatNames(String[] names){
        //Code
        String[] formattedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length == 2) {
                formattedNames[i] = parts[1] + ", " + parts[0];
            } else {
                formattedNames[i] = names[i]; // If not "First Last", keep original
            }
        }
        return formattedNames;
    }

    public static void main(String[] args) {
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown", "Carol Davis", "David Wilson"};
        //TODO : Test all your methods and display results
        // Test findLongestName
        System.out.println("Longest name: " + findLongestName(students));

        // Test countNamesStartingWith
        char letter = 'D';
        System.out.println("Number of names starting with '" + letter + "': " + countNamesStartingWith(students, letter));

        // Test formatNames
        System.out.println("Formatted names:");
        String[] formatted = formatNames(students);
        for (String name : formatted) {
            System.out.println(name);
    }
    }
}

