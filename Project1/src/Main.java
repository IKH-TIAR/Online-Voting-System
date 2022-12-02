import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Student student = new Student();
        while(true){
            System.out.println("---------------------");
            System.out.println("1.Admin");
            System.out.println("2.Student");
            System.out.println("3.See Winner");
            System.out.println("4.Logout");
            System.out.println("----------------------");
            System.out.print("Enter Your Choice: ");
            int choice=scanner.nextInt();
            switch (choice){
                case 1: admin.login();
                       break;
                case 2: student.stMenu();
                        break;
                case 3: admin.printWinner();
                    System.out.print("Press Any Key And Enter: ");
                    scanner.next();
                        break;
                case 4:return;
            }
        }
    }
}