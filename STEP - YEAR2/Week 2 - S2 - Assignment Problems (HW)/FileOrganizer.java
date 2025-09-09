import java.util.*;
public class FileOrganizer {
    // a. Extract file components without split()
    public static String[][] extractFiles(String[] files) {
        String[][] info = new String[files.length][3]; // [filename, extension, valid?]
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            int dotIndex = file.lastIndexOf('.');

            if (dotIndex > 0 && dotIndex < file.length() - 1) {
                info[i][0] = file.substring(0, dotIndex);  // filename
                info[i][1] = file.substring(dotIndex + 1).toLowerCase(); // extension
            } else {
                info[i][0] = file;
                info[i][1] = "unknown";
            }

            // iii. validate filename (only letters, numbers, _- allowed)
            if (info[i][0].matches("[a-zA-Z0-9_-]+")) {
                info[i][2] = "valid";
            } else {
                info[i][2] = "invalid";
            }
        }
        return info;
    }

    // b. Categorize files by extension
    public static String[] categorizeFiles(String[][] info) {
        String[] categories = new String[info.length];
        for (int i = 0; i < info.length; i++) {
            String ext = info[i][1];
            if (ext.equals("txt") || ext.equals("doc")) categories[i] = "Document";
            else if (ext.equals("jpg") || ext.equals("png")) categories[i] = "Image";
            else if (ext.equals("mp3") || ext.equals("wav")) categories[i] = "Audio";
            else if (ext.equals("mp4") || ext.equals("avi")) categories[i] = "Video";
            else categories[i] = "Unknown";
        }
        return categories;
    }

    // Count categories (without hashmap)
    public static void countCategories(String[] categories) {
        int doc = 0, img = 0, aud = 0, vid = 0, unk = 0;
        for (String c : categories) {
            switch (c) {
                case "Document": doc++; break;
                case "Image": img++; break;
                case "Audio": aud++; break;
                case "Video": vid++; break;
                default: unk++;
            }
        }
        System.out.println("\n--- Category Counts ---");
        System.out.println("Documents: " + doc);
        System.out.println("Images   : " + img);
        System.out.println("Audio    : " + aud);
        System.out.println("Video    : " + vid);
        System.out.println("Unknown  : " + unk);
    }

    // c. Generate new names with StringBuilder
    public static String[] generateNewNames(String[][] info, String[] categories) {
        String[] newNames = new String[info.length];
        int[] counters = {0, 0, 0, 0, 0}; // doc, img, aud, vid, unk

        for (int i = 0; i < info.length; i++) {
            StringBuilder sb = new StringBuilder();
            String cat = categories[i];
            int index = 4; // default unknown

            switch (cat) {
                case "Document": index = 0; break;
                case "Image": index = 1; break;
                case "Audio": index = 2; break;
                case "Video": index = 3; break;
            }

            counters[index]++;
            sb.append(cat.substring(0, 3).toUpperCase());
            sb.append("_2025_").append(counters[index]);
            sb.append(".").append(info[i][1]);
            newNames[i] = sb.toString();
        }
        return newNames;
    }

    // d. Simulate content analysis
    public static String[] analyzeContent(String[][] info, String[] categories) {
        String[] subs = new String[info.length];
        for (int i = 0; i < info.length; i++) {
            if (categories[i].equals("Document")) {
                String name = info[i][0].toLowerCase();
                boolean asciiValid = true;
                for (char c : name.toCharArray()) {
                    if (c < 32 || c > 126) asciiValid = false;
                }

                if (!asciiValid) subs[i] = "InvalidContent";
                else if (name.contains("resume")) subs[i] = "Resume";
                else if (name.contains("report")) subs[i] = "Report";
                else if (name.contains("code")) subs[i] = "Code";
                else subs[i] = "GeneralDoc";
            } else {
                subs[i] = "N/A";
            }
        }
        return subs;
    }

    // e. Display report
    public static void displayReport(String[] files, String[][] info, String[] categories, String[] newNames, String[] subs) {
        System.out.println("\n=== FILE ORGANIZATION REPORT ===");
        System.out.printf("%-20s %-12s %-10s %-20s %-15s %-10s\n", "Original", "Extension", "Category", "New Name", "Subcategory", "Valid?");
        for (int i = 0; i < files.length; i++) {
            System.out.printf("%-20s %-12s %-10s %-20s %-15s %-10s\n",
                    files[i], info[i][1], categories[i], newNames[i], subs[i], info[i][2]);
        }
    }

    // f. Generate batch rename commands
    public static void generateRenameCommands(String[] files, String[] newNames, String[][] info) {
        System.out.println("\n--- Batch Rename Commands ---");
        for (int i = 0; i < files.length; i++) {
            if (info[i][2].equals("valid")) {
                System.out.println("rename " + files[i] + " -> " + newNames[i]);
            } else {
                System.out.println("skip " + files[i] + " (invalid)");
            }
        }
    }

    // MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of files: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] files = new String[n];
        System.out.print("Enter file name: \n");
        for (int i = 0; i < n; i++) {
            files[i] = sc.nextLine();
        }

        String[][] info = extractFiles(files);
        String[] categories = categorizeFiles(info);
        String[] newNames = generateNewNames(info, categories);
        String[] subs = analyzeContent(info, categories);

        displayReport(files, info, categories, newNames, subs);
        countCategories(categories);
        generateRenameCommands(files, newNames, info);

        sc.close();
    }
}
