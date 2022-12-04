
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Student extends Methods{
    Scanner scanner = new Scanner(System.in);
    HashMap<String, String> stLogin = new HashMap<>();
    ArrayList<String> ch =new ArrayList<>();
    Candidate candidate = new Candidate();
    void stMenu(){
        while (true){
            System.out.println("----------------------");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Main Menu");
            System.out.println("-----------------------");
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice==1){
                register();
                System.out.print("Press Any Key And Enter: ");
                scanner.next();
            }else if(choice==2){
                login();
                //scanner.next();
            } else if (choice==3) {
                return;
            }else System.out.println("Invalid Input");
        }
    }
    void register(){
        System.out.print("Enter Username: ");
        String username=scanner.nextLine();
        if(stLogin.containsKey(username)){
            System.out.println("Username Is Already Taken");
            return;
        }
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        stLogin.put(username,password);
        System.out.println("Registration Complete");
        System.out.println("Login To Vote");
        ch.add(username);
    }
    void login(){
        System.out.print("Enter Username: ");
        String username=scanner.nextLine();
        if(stLogin.containsKey(username)) {
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            if(stLogin.get(username).equals(password)){
                studentMenu(username);
            }else System.out.println("Wrong PassWord");
        }else System.out.println("Wrong Username");
    }
    void studentMenu(String username){
        while (true) {
            System.out.println("-----------------------");
            System.out.println("1.View Candidate");
            System.out.println("2.Vote");
            System.out.println("3.Logout");
            System.out.println("------------------------");
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            if(choice==1){
               candidate.view();
                System.out.print("Press Any Key And Enter: ");
                scanner.next();
            }else if(choice==2){
                vote(username);
                System.out.print("Press Any Key And Enter: ");
                scanner.next();
            } else if (choice==3)return;
            else System.out.println("Invalid Input");
        }
    }
    void vote(String username){
        if(candidate.serial.isEmpty()){
            System.out.println("Nor Candidate Is Selected");
            return;
        }
        scanner.nextLine();
        if(!ch.contains(username)){
            System.out.println("Your Already Voted");
            return;
        }
        System.out.print("Enter the Serial No: ");
        String serial =scanner.nextLine();
        candidate.count(serial);
        System.out.println("Vote Complete");
        ch.set(ch.indexOf(username),"0");

    }
}
