import java.util.*;

/* class A extends Thread{
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.print("i : "+i + ", ");
        }
        System.out.println("Exit From Thread A");
    }
}

class B extends Thread{
    public void run(){
        for(int j=1;j<=10;j++){
            System.out.print("j : "+j + ", ");
        }
        System.out.println("Exit From Thread B");
    }
}

class C extends Thread{
    public void run(){
        for(int k=1;k<=10;k++){
            System.out.print("k : "+k + ", ");
        }
        System.out.println("Exit From Thread C");
    }
}

public class P1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        A a = new A();
        B b = new B();
        C c = new C();
        a.start();
        b.start();
        c.start();
        
    }
} */



/* 
Thread Life Cycle
1. New Born
2. Runnable
3. Running
4. Blocked
5. Kill
*/

// Reporter Publish News etc


/* class Reporter{
    synchronized void printReporter(int n, String s){
        for(int i=1;i<=5;i++){
            System.out.println(s+" - "+i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
class News extends Thread{
    Reporter t;
    public News(Reporter t){
        this.t = t;
    }
    public void run(){
        t.printReporter(5, "News");
    }
}
class Publish extends Thread{
    Reporter t;
    public Publish(Reporter t){
        this.t = t;
    }
    public void run(){
        t.printReporter(5, "Publish");
    }
}
public class P1{
    public static void main(String args[]){
        Reporter obj = new Reporter();
        News t1 = new News(obj);
        Publish t2 = new Publish(obj);
        t1.start();
        t2.start();
    }
} */

/* 
Array : Can Store same Datatypes & Fixed Size
Collecion : Can store different datatype in different Node

Maximum Collection classes are stored in java.util package

class extends class
class implements interface
interface extends interface
interface implements class - Invalid



*/


