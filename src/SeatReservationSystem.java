import java.util.Arrays;
import java.util.Scanner;

public class NewLogin {
    static String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String alphabetLower = "abcdefghijklmnopqrstuvwxyz";

    //AUTHENTICATION PROCESSES
    static Scanner input = new Scanner(System.in);
    static Scanner authinput = new Scanner(System.in);
    static int[] userID = new int[10];
    static int userCounter = 0;
    static String[] username = new String[10];
    static String[] password = new String[10];
    static boolean isLoggedIn = false;

    static void login(){

        System.out.print("ENTER USERNAME: ");
        String loginUserName = authinput.nextLine();
        System.out.print("ENTER PASSWORD: ");
        String loginPassword = authinput.nextLine();

        for(int i = 0; i < username.length; i++){
            if(loginUserName.equals(username[i]) && loginPassword.equals(password[i])){
                isLoggedIn = true;
                System.out.println("LOGGED IN SUCCESSFULLY");
                return;
            }
        }

    }

    static void signup(){
        boolean uppercase = false;
        boolean lowercase = false;

        System.out.print("ENTER USERNAME: ");
        String signUpUserName = authinput.nextLine();
        System.out.print("ENTER PASSWORD: ");
        String signUpPassword = authinput.nextLine();
        System.out.print("ENTER CONFIRM PASSWORD: ");
        String signUpConfirmPassword = authinput.nextLine();

        for(int i = 0; i < signUpPassword.length(); i++){
            for(int j = 0; j < alphabetUpper.length(); j++){
                if(signUpPassword.charAt(i) == alphabetUpper.charAt(j)){
                    uppercase = true;
                }
                if(signUpPassword.charAt(i) == alphabetLower.charAt(j)){
                    lowercase = true;
                }
            }
        }

        for (String s : username) {
            if (signUpUserName.equals(s)) {
                System.out.println("USERNAME ALREADY EXIST!");
                return;
            }
        }

        if(signUpUserName.length() < 3){
            System.out.println("USERNAME SHOULD BE LONGER THAN 3 CHARACTERS!");
        }

        if(signUpPassword.length() < 6){
            System.out.println("PASSWORD SHOULD BE LONGER THAN 6 CHARACTERS!");
            return;
        }

        if(!signUpPassword.equals(signUpConfirmPassword)){
            System.out.println("PASSWORD DOES NOT MATCH!");
            return;
        }

        if(!uppercase || !lowercase){
            System.out.println("PASSWORD MUST CONTAIN UPPER AND LOWER CASE CHARACTERS!");
            return;
        }

        username[userCounter] = signUpUserName;
        password[userCounter] = signUpPassword;
        System.out.println("SIGNED UP SUCCESSFULLY!");
        userID[userCounter] = userCounter;
        userCounter++;
    }

    static void logout(){
        if(isLoggedIn){
            isLoggedIn = false;
            System.out.println("LOGGED OUT SUCCESSFULLY");
        }
    }

    //RESERVATION PROCESSES
    static boolean[] seats = new boolean[10];

    static void viewSeats(){
        for(int i = 0; i < seats.length;i++){
            if(seats[i]){
                System.out.println("SEAT " + (i+1) +": AVAILABLE");
            } else {
                System.out.println("SEAT " + (i+1) +": NOT AVAILABLE");
            }
        }
    }

    static void reserveSeats(){
        System.out.println("CHOOSE A SEAT [1-10]: ");
        int choice = input.nextInt();
        if(choice > 1 && choice < 10){
            seats[choice-1] = false;
            System.out.println("SEAT RESERVED SUCCESSULLY");
        } else {
            System.out.println("SEAT DOES NOT EXIST");
        }
    }

    public static void main(String[] args){
        Arrays.fill(seats, true);
        boolean running = true;
        while (running){
            if(isLoggedIn){

                System.out.println("---------------------------------");
                System.out.println("USER ACTIONS: ");
                System.out.println("[1] View Seats \n[2] Reserve Seat\n[3] Logout\n[4] Exit");
                System.out.print("ENTER USER ACTION: ");
                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        viewSeats();
                        break;
                    case 2:
                        reserveSeats();
                        break;
                    case 3:
                        logout();
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("INVALID INPUT");
                        break;
                }
            } else {
                System.out.println("USER ACTIONS: ");
                System.out.println("[1] LOGIN \n[2] SIGNUP\n[3] Exit");
                System.out.print("ENTER USER ACTION: ");
                int choice = input.nextInt();

                switch (choice){
                    case 1:
                        login();
                        break;
                    case 2:
                        signup();
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println("INVALID INPUT");
                        break;
                }
            }
        }
    }
}
