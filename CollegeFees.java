import java.util.*;
import java.text.DecimalFormat;

class CollegeFee{
    // Defining variables
    String[] courses = {"Computer Science", "Information Technology", 
    "Cyber Safety and Laws", "Machine Learning", "Data Science"};
    double[] tuitionFees = new double[5], totals = new double[5];
    double roomFee = 7860;
    Scanner input = new Scanner(System.in);
    // Used to display all double values to 2 decimal places
    DecimalFormat df = new DecimalFormat("0.00");
    // User inputs all the tuition fees for the listed courses
    void inputDetails(){
        for(int i=0; i<courses.length; i++){
            System.out.print("Enter the tuition fee for the '"+courses[i]+"' course: ");
            tuitionFees[i] = input.nextDouble();
        }
    }
    // User confirms if they'd like to update fees and asked for the percentages(if they say yes)
    void updateFee(){
        System.out.print("\nWould you like to update the fees for this year? Press y for yes: ");
        if(input.next().toLowerCase().charAt(0) == 'y'){
            System.out.print("Enter the percentage for the tuition fees: ");
            double tperc = input.nextDouble();
            System.out.print("Enter the percentage for the room and board fee: ");
            double rperc = input.nextDouble();
            for(int i=0; i<tuitionFees.length; i++){
                tuitionFees[i] *= 1+tperc/100;
            }
            roomFee *= 1+rperc/100;
        }
    }
    // Calculates total by adding room fee to every tuition fee
    void calcTotal(){
        for(int i=0; i<totals.length; i++){
            totals[i] = tuitionFees[i]+roomFee;
        }
    }
    // Displays the current cost of room fee, course names, tuition fees, and totals
    void displayDetails(){
        System.out.println("The room and board fee (in US dollars): $"+df.format(roomFee));
        System.out.println("Course fee (in US dollars):");
        System.out.println("Course                   Tuition Fees    Total Amount");
        for(int i=0; i<courses.length; i++){
            // Looks super confusing but just prints the course, tuition fee, and total with a bunch of formatting
            System.out.println(formatSpacing(new String[]{courses[i], "$"+df.format(tuitionFees[i]), "$"+df.format(totals[i])}, new int[]{25,41}));
        }
    }
    // Function used to make sure the details are displayed properly under the headers
    String formatSpacing(String[] details, int[] indexes){
        String str = details[0];
        for(int i=0; i<indexes.length; i++){
            int spaces = indexes[i]-str.length();
            while(spaces>0){
                str += " ";
                spaces--;
            }
            str += details[i+1];
        }
        return str;
    }
    // Where all the action(function calling) happens
    public static void main(String[] args){
        CollegeFee collegeFees = new CollegeFee();
        collegeFees.inputDetails();
        collegeFees.calcTotal();
        System.out.println("\nExisting Fee Details");
        collegeFees.displayDetails();
        collegeFees.updateFee();
        System.out.println("\nUpdated Fee Details");
        collegeFees.calcTotal();
        collegeFees.displayDetails();
    }
}
