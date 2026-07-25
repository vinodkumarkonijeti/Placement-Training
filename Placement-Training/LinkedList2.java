import java.util.*;
class Node{
    int rollno;
    String name;
    Node next;
    Node prev;
    public Node(int rollno, String name){
        this.rollno=rollno;
        this.name=name;
        this.next=null;
        this.prev=null;
    }
}
class LinkedList2{
    Node head;
    Node insertBegin(int rollno,String name, Node head){
        Node nnode = new Node(rollno,name);
        nnode.next=head;
        if(head!=null)
            head.prev=nnode;
        return nnode;
    }
    Node insertend(int rollno,String name ,Node head){
        Node nnode=new Node(rollno,name);
        if(head==null){
            head=nnode;
        }
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=nnode;
        nnode.prev=cur;
        return head;
    }
    void display(Node head){
        if(head==null)
        {
        System.out.println("No records ");
        }
        while(head!=null){
            System.out.println("Roll No : " + head.rollno + " - Name : " + head.name);
            head=head.next;
        }
    }
    public static void main(String args[]){
        LinkedList2 lst=new LinkedList2();
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Insert in beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Display records");
            System.out.print("Enter your choice : ");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("1. Insert in beginning");
                    System.out.print("Enter Rollno and Name : ");
                    lst.head=lst.insertBegin(sc.nextInt(),sc.next(),lst.head);
                    System.out.println("Record Inserted at the beginning");
                    break;
                case 2:
                    System.out.println("2. Insert at end");
                    System.out.print("Enter Rollno and Name : ");
                    lst.head=lst.insertend(sc.nextInt(),sc.next(),lst.head);
                    System.out.println("Record Inserted at the end");
                    break;
                case 3:
                    System.out.println("3. Display records");
                    lst.display(lst.head);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.print("Do you want to continue (Y/N) : ");
        }while(sc.next().equalsIgnoreCase("Y"));
        
    }

}