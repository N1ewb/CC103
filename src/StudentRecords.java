import java.util.Scanner;

public class StudentRecords {
    static Scanner input = new Scanner(System.in);
    static Scanner choice = new Scanner(System.in);
    static String[] names = new String[10];
    static int[] grades = new int[10];
    static int counter = 0;

    static void addStudents(){
        System.out.print("ENTER STUDENT NAME:");
        names[counter] = input.nextLine();
        System.out.print("ENTER STUDENT GRADE:");
        grades[counter] = input.nextInt();

        System.out.println("STUDENT CREATE SUCCESSFULLY");
        System.out.println("STUDENT DATA: " + "\n" + "NAME: " + names[counter] + "\n" + "GRADE: " + grades[counter]);
        counter++;
    }

    static void viewStudents(){
        System.out.println("STUDENTS LIST:");
        for(int i = 0; i < names.length - 1; i++){
            System.out.print("\tNAME: " + names[i] + "\tGRADE: " + grades[i] + "\n");
        }
    }

    public static void main(String[] args){
        boolean running = true;
        while(running){

                System.out.println("[1] ADD STUDENT");
                System.out.println("[2] VIEW STUDENT");
                System.out.println("[3] EXIT PROGRAM");
                System.out.print("USER ACTIONS: ");

                int userChoice = choice.nextInt();
                switch (userChoice){
                    case 1:
                        addStudents();
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        running = false;
                        System.out.println("PROGRAM EXIT");
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
        }
    }
}
