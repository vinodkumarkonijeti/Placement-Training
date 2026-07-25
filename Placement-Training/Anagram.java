import java.util.*;

public class Anagram {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        for(char c : arr)
            System.out.print(c + " ");
    }
}
