
package studentgrades_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author samueljoseph
 */
public class StudentGrades_1 {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String sid="";
        System.out.println("Welcome to the grade calculator");
        
        
        sid = getStudentID();
        while (!sid.equalsIgnoreCase("quit")){
            calcGrade(sid);
            sc.nextLine();
            sid = getStudentID();
        }//end of while
        System.out.println("Thanks for using the grade calculator");
    }//end of main 
    
    public static String getStudentID() {
        String id;
        boolean goodval = false;
        
        do {
            System.out.print("STudent ID (quit to exit): ");
            id = sc.nextLine();
            //validation id: 
            try {
                if (id.isEmpty()) {
                    System.out.println("Please enter an ID or 'quit'");
                } else if (id.equalsIgnoreCase("QUIT")) {
                    goodval = true;
                } else if (!id.substring(0,1).equals("A")) {
                    System.out.println("First character not 'A'");
                } else if (id.length() !=9) {
                    System.out.println("'A' must be followed by 8 digits");
                } else {
                    long d = Long.parseLong(id.substring(1));
                    if (d <= 0) {
                        System.out.println("Numeric component must be >0");
                    } else {
                        goodval = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Value after 'A' must be numeric");
            }
        } while (!goodval);
        return id;
    } //end of getStudentID
    
    public static void calcGrade(String sid) {
        double q1,q2,q3,q4,q5,qm,mt,pr,fe, qavg,cavg;
        String lgrade;
        
        q1 = getScore("Quiz 1 Score: ");
        q2 = getScore("Quiz 2 Score: ");
        q3 = getScore("Quiz 3 Score: ");
        q4 = getScore("Quiz 4 Score: ");
        q5 = getScore("Quiz 5 Score: ");
        qm = getScore("Quiz make-up Score: ");
        mt = getScore("Midterm Score: ");
        pr = getScore("Problems Score: ");
        
        
        double [] q = { q1,q2,q3,q4,q5,qm };
        Arrays.sort(q);
        qavg = (q[2] + q[3] + q[4] + q[5]) / 4.0;
        
        System.out.print("Student " + sid + 
                         " has a quiz average of: " + qavg);
        
    }
    
    public static double getScore(String prompt) {
        //final version of method must be 'robust'
        double score;
        System.out.print(prompt);
        score = sc.nextDouble();
        return score; 
    }
    
    
}
