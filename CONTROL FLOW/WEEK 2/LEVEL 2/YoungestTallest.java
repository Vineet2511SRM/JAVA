import java.util.*;

public class YoungestTallest {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        
        System.out.println("\n===== Enter Details of Friends =====\n");
        
        System.out.print("Enter the age of Amar: ");
        int amarAge = obj.nextInt();
        System.out.print("Enter the height of Amar (in cm): ");
        double amarHeight = obj.nextDouble();
        
        System.out.print("Enter the age of Akbar: ");
        int akbarAge = obj.nextInt();
        System.out.print("Enter the height of Akbar (in cm): ");
        double akbarHeight = obj.nextDouble();
        
        System.out.print("Enter the age of Anthony: ");
        int anthonyAge = obj.nextInt();
        System.out.print("Enter the height of Anthony (in cm): ");
        double anthonyHeight = obj.nextDouble();
        
        int youngestAge = amarAge;
        String youngest = "Amar";
        if (akbarAge < youngestAge) {
            youngestAge = akbarAge;
            youngest = "Akbar";
        }
        if (anthonyAge < youngestAge) {
            youngestAge = anthonyAge;
            youngest = "Anthony";
        }
        
        double tallestHeight = amarHeight;
        String tallest = "Amar";
        if (akbarHeight > tallestHeight) {
            tallestHeight = akbarHeight;
            tallest = "Akbar";
        }
        if (anthonyHeight > tallestHeight) {
            tallestHeight = anthonyHeight;
            tallest = "Anthony";
        }
        
        System.out.println("\n===== Results =====");
        System.out.println(youngest + " is the youngest (Age: " + youngestAge + " years)");
        System.out.println(tallest + " is the tallest (Height: " + tallestHeight + " cm)");
        
        obj.close();
    }
}
