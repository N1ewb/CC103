import java.util.Scanner;

public class LoginSystem {
    public  static Scanner input = new Scanner(System.in);
    public static String usernameDB;
    public static String passwordDB;
    public static boolean isLoggedIn = false;

    public static void createAccount(){
        System.out.print("Enter Username: ");
        String inpUsername = input.nextLine();
        System.out.print("Enter Password: ");
        String inpPassword = input.nextLine();
        System.out.print("Confirm Password: ");
        String inpConfirmPassword = input.nextLine();

        if(inpUsername.length() <= 3 || inpUsername.length() >= 20){
            System.out.println("Username length must be between 3 and 20");
            return;
        }
        if(inpPassword.length() < 7){
            System.out.println("Password length must be greater than 7");
            return;
        }

        if(!inpPassword.equals(inpConfirmPassword)){
            System.out.println("Password does not match");
            return;
        }
        System.out.println("ACCOUNT CREATED SUCCESSFULLY");
        usernameDB = inpUsername;
        passwordDB = inpPassword;
    }

    public static void login(){
        System.out.print("Enter Username: ");
        String inpUsername = input.nextLine();
        System.out.print("Enter Password: ");
        String inpPassword = input.nextLine();
        if(inpUsername.equals(usernameDB) && inpPassword.equals(passwordDB)){
            isLoggedIn = true;
            System.out.println("WELCOME");
        }
    }

    public static void main(String[] args){
        Scanner userChoice = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("[1]LOGIN\n[2]CREATE ACCOUNT\n[0]EXIT\nENTER ACTION: ");
            int choice = userChoice.nextInt();
            switch (choice){
                case 1:
                    login();
                    break;
                case 2:
                    createAccount();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("INVALID INPUT");
                    break;
            }

        }
    }
}
