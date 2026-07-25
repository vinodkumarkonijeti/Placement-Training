import java.util.*;

public class Testing {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();

        System.out.println("Welcome "+name);
        System.out.println("You have 3 chances to guess the lucky number : ");

        for(int i=0;i<3;i++){
            int r = random.nextInt(10);
            System.out.print("Choice : "+(i+1) + " - Enter Lucky Number(1-9) : ");
            int n = sc.nextInt();
            if(n == r){
                System.out.println("Congratulations You WON!!!!");
                System.out.println( name + "WON");
                return;
            }else{
                System.out.println("Lucky Number is : "+r);   
            }
        }


        System.out.println("Sorry Mr "+name);
        System.out.println("You Didn't made it through");
    } 
}
