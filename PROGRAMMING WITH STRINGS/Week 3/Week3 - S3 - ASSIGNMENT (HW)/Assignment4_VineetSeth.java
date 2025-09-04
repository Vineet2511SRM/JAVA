/**
 * Assignment4_VineetSeth.java
 * Author: Vineet Seth
 * Description: Student Grade Management System demonstrating static vs instance members,
 * grading, GPA calculation, report cards, class and school level reporting.
 */

import java.util.*;

/**
 * Represents a Subject in the school.
 */
class Subject {
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String instructor;

    /**
     * Constructs a Subject object.
     *
     * @param subjectCode unique code (non-empty)
     * @param subjectName name of the subject (non-empty)
     * @param credits     credit weight (positive)
     * @param instructor  instructor name
     * @throws IllegalArgumentException if inputs invalid
     */
    public Subject(String subjectCode, String subjectName, int credits, String instructor) {
        if (subjectCode == null || subjectCode.isEmpty())
            throw new IllegalArgumentException("subjectCode cannot be empty");
        if (subjectName == null || subjectName.isEmpty())
            throw new IllegalArgumentException("subjectName cannot be empty");
        if (credits <= 0)
            throw new IllegalArgumentException("credits must be positive");

        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor == null ? "Unknown" : instructor;
    }

    public String getSubjectCode() { return subjectCode; }
    public String getSubjectName() { return subjectName; }
    public int getCredits() { return credits; }
    public String getInstructor() { return instructor; }
}

/**
 * Represents a Student and contains static school-level settings and reporting.
 */
class Student {
    // Instance attributes
    private String studentId;
    private String studentName;
    private String className; // e.g., "10A"

    // As required: subjects as String array (names)
    private String[] subjects;

    // Use Subject[] to store credits and instructor information
    private Subject[] subjectObjects;

    // marks[subjectIndex][assessmentIndex]
    private double[][] marks;
    private double gpa;

    // Static (school-level)
    public static int totalStudents = 0;
    public static String schoolName = "Default High School";
    public static String[] gradingScale = new String[] {"A", "B", "C", "D", "F"};
    public static double passPercentage = 40.0; // pass if percentage >= this

    // Internal thresholds for mapping percentage to grades (descending order)
    private static double[] gradeThresholds = new double[] {90.0, 75.0, 60.0, 40.0, 0.0};

    /**
     * Constructs a Student.
     *
     * @param studentId   unique id
     * @param studentName student full name
     * @param className   class/batch name
     * @param subjectObjects array of Subject objects (non-empty)
     * @param assessmentsPerSubject number of assessment columns per subject (>=1)
     * @throws IllegalArgumentException if inputs invalid
     */
    public Student(String studentId, String studentName, String className,
                   Subject[] subjectObjects, int assessmentsPerSubject) {
        if (studentId == null || studentId.isEmpty())
            throw new IllegalArgumentException("studentId cannot be empty");
        if (studentName == null || studentName.isEmpty())
            throw new IllegalArgumentException("studentName cannot be empty");
        if (className == null || className.isEmpty())
            throw new IllegalArgumentException("className cannot be empty");
        if (subjectObjects == null || subjectObjects.length == 0)
            throw new IllegalArgumentException("At least one subject required");
        if (assessmentsPerSubject <= 0)
            throw new IllegalArgumentException("assessmentsPerSubject must be >= 1");

        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.subjectObjects = Arrays.copyOf(subjectObjects, subjectObjects.length);

        this.subjects = new String[subjectObjects.length];
        for (int i = 0; i < subjectObjects.length; i++) subjects[i] = subjectObjects[i].getSubjectName();

        this.marks = new double[subjectObjects.length][assessmentsPerSubject];
        // initialize marks with -1 to indicate not yet set
        for (int i = 0; i < subjectObjects.length; i++) Arrays.fill(this.marks[i], -1.0);

        this.gpa = 0.0;
        totalStudents++;
    }

    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getClassName() { return className; }
    public double getGpa() { return gpa; }

    /**
     * Adds marks for a subject by name. If multiple assessments, it fills the first empty slot.
     *
     * @param subjectName name of subject
     * @param mark value (0-100)
     * @throws IllegalArgumentException if subject not found or mark out of range
     */
    public void addMarks(String subjectName, double mark) {
        if (subjectName == null) throw new IllegalArgumentException("subjectName cannot be null");
        if (mark < 0.0 || mark > 100.0) throw new IllegalArgumentException("mark must be between 0 and 100");

        int idx = -1;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equalsIgnoreCase(subjectName)) { idx = i; break; }
        }
        if (idx == -1) throw new IllegalArgumentException("Subject not found: " + subjectName);

        // find first empty assessment slot (denoted by -1)
        boolean placed = false;
        for (int j = 0; j < marks[idx].length; j++) {
            if (marks[idx][j] < 0) {
                marks[idx][j] = mark;
                placed = true;
                break;
            }
        }
        if (!placed) {
            // if full, replace the oldest (shift left)
            for (int j = 1; j < marks[idx].length; j++) marks[idx][j-1] = marks[idx][j];
            marks[idx][marks[idx].length - 1] = mark;
        }
    }

    /**
     * Calculates GPA based on subject averages and credits. Stores result in instance gpa.
     *
     * @throws IllegalStateException if there are no marks recorded for any subject
     * @return computed GPA (0.0 - 10.0 scale)
     */
    public double calculateGPA() {
        double totalWeightedPoints = 0.0;
        int totalCredits = 0;
        boolean hasAny = false;

        for (int i = 0; i < subjectObjects.length; i++) {
            double avg = averageForSubject(i);
            if (Double.isNaN(avg)) continue; // no marks for this subject
            hasAny = true;
            int credits = subjectObjects[i].getCredits();
            double gradePoint = percentageToGradePoint(avg);
            totalWeightedPoints += gradePoint * credits;
            totalCredits += credits;
        }

        if (!hasAny) throw new IllegalStateException("No marks recorded for student: " + studentName);
        if (totalCredits == 0) throw new IllegalStateException("Total credits zero -- invalid subjects setup");

        double computedGpa = totalWeightedPoints / totalCredits; // on 0-10 scale
        this.gpa = computedGpa;
        return computedGpa;
    }

    /**
     * Generates a printable report card and prints to console.
     */
    public void generateReportCard() {
        System.out.println("\n=== Report Card: " + studentName + " (" + studentId + ") ===");
        System.out.println("Class: " + className + "  | School: " + schoolName);
        System.out.printf("%-15s %-8s %-8s %-6s\n", "Subject", "Avg%", "Grade", "Credits");
        for (int i = 0; i < subjectObjects.length; i++) {
            double avg = averageForSubject(i);
            String grade = Double.isNaN(avg) ? "N/A" : percentageToGrade(avg);
            System.out.printf("%-15s %-8s %-8s %-6d\n",
                    subjectObjects[i].getSubjectName(),
                    Double.isNaN(avg) ? "--" : String.format("%.2f", avg),
                    grade,
                    subjectObjects[i].getCredits());
        }
        try {
            double computedGpa = calculateGPA();
            System.out.println("GPA (0-10): " + String.format("%.2f", computedGpa));
        } catch (IllegalStateException ex) {
            System.out.println("GPA: N/A (" + ex.getMessage() + ")");
        }
        System.out.println("====================================\n");
    }

    /**
     * Checks if student is eligible for promotion based on overall percentage or GPA.
     *
     * @return true if eligible, false otherwise
     */
    public boolean checkPromotionEligibility() {
        // use overall percentage averaged across subjects that have marks
        double totalPercent = 0.0;
        int count = 0;
        for (int i = 0; i < subjectObjects.length; i++) {
            double avg = averageForSubject(i);
            if (!Double.isNaN(avg)) { totalPercent += avg; count++; }
        }
        if (count == 0) return false; // no marks -> not eligible
        double overall = totalPercent / count;
        return overall >= passPercentage;
    }

    // ---------------- Helper methods ----------------

    // Average for subject index; returns NaN if no marks
    private double averageForSubject(int idx) {
        double[] arr = marks[idx];
        double sum = 0.0;
        int cnt = 0;
        for (double v : arr) {
            if (v >= 0) { sum += v; cnt++; }
        }
        return cnt == 0 ? Double.NaN : (sum / cnt);
    }

    // Convert percentage (0-100) to grade label
    private String percentageToGrade(double percentage) {
        for (int i = 0; i < gradeThresholds.length; i++) {
            if (percentage >= gradeThresholds[i]) return gradingScale[i];
        }
        return "F"; // fallback
    }

    // Convert percentage to grade point on 0-10 scale (simple mapping)
    private double percentageToGradePoint(double percentage) {
        // Map A -> 9, B -> 7.5, C -> 6, D -> 5, F -> 2 (example scale)
        String g = percentageToGrade(percentage);
        switch (g) {
            case "A": return 9.0;
            case "B": return 7.5;
            case "C": return 6.0;
            case "D": return 5.0;
            default: return 2.0;
        }
    }

    // ---------------- Static School-level Methods ----------------

    /**
     * Sets grading scale labels and thresholds. Arrays must be same length and descending thresholds.
     *
     * @param labels e.g., {"A","B","C","D","F"}
     * @param thresholds corresponding thresholds e.g., {90,75,60,40,0}
     * @throws IllegalArgumentException if invalid
     */
    public static void setGradingScale(String[] labels, double[] thresholds) {
        if (labels == null || thresholds == null) throw new IllegalArgumentException("labels/thresholds cannot be null");
        if (labels.length != thresholds.length) throw new IllegalArgumentException("labels and thresholds must match in length");
        // basic check: thresholds descending
        for (int i = 1; i < thresholds.length; i++) {
            if (thresholds[i] > thresholds[i-1]) throw new IllegalArgumentException("thresholds must be in descending order");
        }
        gradingScale = Arrays.copyOf(labels, labels.length);
        gradeThresholds = Arrays.copyOf(thresholds, thresholds.length);
    }

    /**
     * Calculates class average percentage across students provided.
     *
     * @param students array of students
     * @return average percentage (0-100) across students (only considers recorded marks)
     */
    public static double calculateClassAverage(Student[] students) {
        if (students == null || students.length == 0) return 0.0;
        double sum = 0.0; int count = 0;
        for (Student s : students) {
            if (s == null) continue;
            double total = 0.0; int subjectsCounted = 0;
            for (int i = 0; i < s.subjects.length; i++) {
                double avg = s.averageForSubject(i);
                if (!Double.isNaN(avg)) { total += avg; subjectsCounted++; }
            }
            if (subjectsCounted > 0) { sum += (total / subjectsCounted); count++; }
        }
        return count == 0 ? 0.0 : (sum / count);
    }

    /**
     * Returns top performers by GPA.
     *
     * @param students array of students
     * @param count number of top performers to return
     * @return array of top students (size may be less if not enough students)
     */
    public static Student[] getTopPerformers(Student[] students, int count) {
        if (students == null || students.length == 0) return new Student[0];
        List<Student> list = new ArrayList<>();
        for (Student s : students) if (s != null) list.add(s);
        // ensure GPA is calculated where possible
        for (Student s : list) {
            try { s.calculateGPA(); } catch (Exception e) { /* ignore if cannot calculate */ }
        }
        list.sort((a,b) -> Double.compare(b.getGpa(), a.getGpa()));
        if (count > list.size()) count = list.size();
        return list.subList(0, count).toArray(new Student[count]);
    }

    /**
     * Generates a school level report for multiple classes.
     * Prints to console a summary including class averages and top performers.
     *
     * @param students all students in school
     */
    public static void generateSchoolReport(Student[] students) {
        System.out.println("\n=== School Report: " + schoolName + " ===");
        if (students == null || students.length == 0) {
            System.out.println("No student data available.");
            return;
        }

        // group by className
        Map<String, List<Student>> byClass = new HashMap<>();
        for (Student s : students) {
            if (s == null) continue;
            byClass.computeIfAbsent(s.getClassName(), k -> new ArrayList<>()).add(s);
        }

        for (String cls : byClass.keySet()) {
            List<Student> list = byClass.get(cls);
            Student[] arr = list.toArray(new Student[0]);
            double avg = calculateClassAverage(arr);
            System.out.println("Class: " + cls + " | Students: " + list.size() + " | Avg%: " + String.format("%.2f", avg));
        }

        // top 3 performers overall
        Student[] top = getTopPerformers(students, 3);
        System.out.println("\nTop Performers:");
        for (int i = 0; i < top.length; i++) {
            System.out.println((i+1) + ". " + top[i].getStudentName() + " (GPA: " + String.format("%.2f", top[i].getGpa()) + ")");
        }
        System.out.println("====================================\n");
    }
}

/**
 * Driver class with console-based demonstration and testing.
 */
public class Assignment4_VineetSeth {
    public static void main(String[] args) {
        // Set school static info
        Student.schoolName = "SRM Senior Secondary";
        Student.passPercentage = 40.0; // can change as needed

        // Optionally set custom grading scale
        try {
            String[] labels = {"A","B","C","D","F"};
            double[] thresholds = {90.0,75.0,60.0,40.0,0.0};
            Student.setGradingScale(labels, thresholds);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error setting grading scale: " + ex.getMessage());
        }

        // Create subjects
        Subject math = new Subject("M01", "Mathematics", 4, "Ms. Rao");
        Subject phy = new Subject("P01", "Physics", 3, "Mr. Khan");
        Subject chem = new Subject("C01", "Chemistry", 3, "Ms. D'Souza");
        Subject eng = new Subject("E01", "English", 2, "Mrs. Iyer");

        // Create students with subjects and 3 assessments per subject
        Subject[] subjects = new Subject[] { math, phy, chem, eng };
        Student s1 = new Student("S001", "Vineet Seth", "10A", subjects, 3);
        Student s2 = new Student("S002", "Aarav Sharma", "10A", subjects, 3);
        Student s3 = new Student("S003", "Meera Patel", "10B", subjects, 3);

        // Add marks (some sample data)
        // Vineet
        s1.addMarks("Mathematics", 92);
        s1.addMarks("Mathematics", 88);
        s1.addMarks("Physics", 76);
        s1.addMarks("Chemistry", 81);
        s1.addMarks("English", 69);

        // Aarav
        s2.addMarks("Mathematics", 78);
        s2.addMarks("Physics", 71);
        s2.addMarks("Chemistry", 65);
        s2.addMarks("English", 74);

        // Meera
        s3.addMarks("Mathematics", 95);
        s3.addMarks("Physics", 89);
        s3.addMarks("Chemistry", 92);
        s3.addMarks("English", 88);

        // Generate individual report cards
        s1.generateReportCard();
        s2.generateReportCard();
        s3.generateReportCard();

        // Check promotion eligibility
        System.out.println(s1.getStudentName() + " Promotion Eligible? " + s1.checkPromotionEligibility());
        System.out.println(s2.getStudentName() + " Promotion Eligible? " + s2.checkPromotionEligibility());
        System.out.println(s3.getStudentName() + " Promotion Eligible? " + s3.checkPromotionEligibility());

        // Class average for 10A
        Student[] class10A = new Student[] { s1, s2 };
        double avg10A = Student.calculateClassAverage(class10A);
        System.out.println("\nClass 10A Average: " + String.format("%.2f", avg10A) + "%");

        // Top performers across school
        Student[] all = new Student[] { s1, s2, s3 };
        Student[] top2 = Student.getTopPerformers(all, 2);
        System.out.println("\nTop 2 performers:");
        for (Student t : top2) System.out.println(t.getStudentName() + " - GPA: " + String.format("%.2f", t.getGpa()));

        // School report
        Student.generateSchoolReport(all);
    }
}
