import java.util.*;

class Node{
	int rollno;
	String name;
	Node prev;
	Node next;
	
	public Node(int rollno, String name){
		this.rollno = rollno;
		this.name = name;
		this.prev = null;
		this.next = null;
	}
}

class LinkedList1{
	Node head;
	Node insertBegin(int rollno,String name, Node head){
		Node nnode = new Node(rollno,name);
		nnode.next = head;
		if(head != null){
			head.prev = nnode;
		}
		return nnode;
	}
	
	Node insertEnd(int rollno,String name, Node head){
		Node nnode = new Node(rollno,name);
		if(head==null)
			return nnode; 

		Node cur=head;
		while(cur.next!=null)
		{
			cur=cur.next;
		}
		cur.next=nnode;
		nnode.prev = cur;
		return head;
	}
	
	Node insertPos(int rollno,String name, Node head,int pos){
		Node nnode = new Node(rollno,name);
		if(head==null || pos<=1){
			if(head != null){
				head.prev = nnode;
			}
			nnode.next = head;
			return nnode;
		}

		Node temp=head;
		for(int i=1;temp!=null && i<pos-1;i++){
			temp=temp.next;
		}

		if(temp!=null){
			nnode.next=temp.next;
			nnode.prev=temp;
			temp.next=nnode;
			if(nnode.next != null){
				nnode.next.prev = nnode;
			}
		}
		return head;
	}

void display(Node head){
	if(head==null){
		System.out.println("No records ");
		return;
	}
	while(head!=null){
		System.out.println("Roll No : " + head.rollno + " - Name : " + head.name);
		head=head.next;
	}
}

Node delete(int pos, Node head){
	if(head==null){
		System.out.println("List is empty!");
		return head;
	}
	
	if(pos==1)	{
		head = head.next;
		if(head != null){
			head.prev = null;
		}
		System.out.println("Record deleted from position 1");
		return head;
	}
	
	Node temp = head;
	for(int i=1; temp!=null && i<pos-1; i++)	{
		temp = temp.next;
	}
	
	if(temp==null || temp.next==null)	{
		System.out.println("Position out of range!");
		return head;
	}
	
	Node toDelete = temp.next;
	temp.next = toDelete.next;
	if(temp.next != null){
		temp.next.prev = temp;
	}
	System.out.println("Record deleted from position " + pos);
	return head;
}

int length(Node head){
	int count = 0;
	while(head!=null)	{
		count++;
		head = head.next;
	}
	return count;
}

Node reverse(Node head){
	if(head==null || head.next==null)	{
		System.out.println("List reversed (or empty)");
		return head;
	}
	
	Node current = head;
	Node temp = null;
	
	while(current!=null){
		temp = current.prev;
		current.prev = current.next;
		current.next = temp;
		current = current.prev;
	}

	if(temp != null){
		head = temp.prev;
	}
	
	System.out.println("List reversed successfully");
	return head;
}

int sumOfElements(Node head){
	int sum = 0;
	while(head!=null)	{
		sum += head.rollno;
		head = head.next;
	}
	return sum;
}

boolean search(int rollno, Node head){
	while(head!=null){
		if(head.rollno == rollno){
			return true;
		}
		head = head.next;
	}
	return false;
}

void findMinMax(Node head){
	if(head==null){
		System.out.println("List is empty!");
		return;
	}
	
	int min = head.rollno;
	int max = head.rollno;
	
	while(head!=null){
		if(head.rollno < min)
			min = head.rollno;
		if(head.rollno > max)
			max = head.rollno;
		head = head.next;
	}
	
	System.out.println("Minimum Roll No: " + min);
	System.out.println("Maximum Roll No: " + max);
}

Node sort(Node head){
	if(head==null || head.next==null){
		System.out.println("List sorted (or empty)");
		return head;
	}
	
	Node current = head;
	while(current!=null){
		Node next = current.next;
		while(next!=null){
			if(current.rollno > next.rollno){
				int tempRoll = current.rollno;
				String tempName = current.name;
				current.rollno = next.rollno;
				current.name = next.name;
				next.rollno = tempRoll;
				next.name = tempName;
			}
			next = next.next;
		}
		current = current.next;
	}
	
	System.out.println("List sorted successfully");
	return head;
}
    public static void main(String args[]){
        LinkedList1 lst=new LinkedList1();
        Scanner sc=new Scanner(System.in);
        boolean exit = false;
        
        do{
            System.out.println("\n\t\t\t------ Menu ------");
            System.out.println("1. Insert in beginning");
            System.out.println("2. Insert at the end");
            System.out.println("3. Insert in the position");
            System.out.println("4. Display");
            System.out.println("5. Delete");
            System.out.println("6. Length");
            System.out.println("7. Reverse");
            System.out.println("8. Sum of elements");
            System.out.println("9. Search");
            System.out.println("10. Min and Max");
            System.out.println("11. Sort ");
            System.out.println("12. Exit");
            
            System.out.print("Choose Option :");
            String n=sc.next();
            switch(n){
                case "1":
                    System.out.print("Enter Rollno and Name : ");
                    lst.head=lst.insertBegin(sc.nextInt(),sc.next(),lst.head);
                    System.out.println("Record Inserted at the beginning");
                    break;
                case "2":
                    System.out.print("Enter Rollno and Name : ");
                    lst.head=lst.insertEnd(sc.nextInt(),sc.next(),lst.head);
                    System.out.println("Record Inserted at the end");
                    break;
                case "3":
                    System.out.print("Enter Position : ");
                    int pos=sc.nextInt();
                    System.out.print("Enter Rollno and Name : ");
                    lst.head=lst.insertPos(sc.nextInt(),sc.next(),lst.head,pos);
                    System.out.println("Record Inserted at the Position");
                    break;
                case "4":
                    lst.display(lst.head);
                    break;
                case "5":
                    System.out.print("Enter Position to delete : ");
                    int delPos = sc.nextInt();
                    lst.head = lst.delete(delPos, lst.head);
                    break;
                case "6":
                    int len = lst.length(lst.head);
                    System.out.println("Length of the list : " + len);
                    break;
                case "7":
                    lst.head = lst.reverse(lst.head);
                    break;
                case "8":
                    int sum = lst.sumOfElements(lst.head);
                    System.out.println("Sum of all Roll Numbers : " + sum);
                    break;
                case "9":
                    System.out.print("Enter Roll No to search : ");
                    int searchRoll = sc.nextInt();
                    if(lst.search(searchRoll, lst.head))
                        System.out.println("Record found!");
                    else
                        System.out.println("Record not found!");
                    break;
                case "10":
                    lst.findMinMax(lst.head);
                    break;
                case "11":
                    lst.head = lst.sort(lst.head);
                    break;
                case "12":
                    System.out.println("Thank you for using the program!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }while(!exit);
        
        sc.close();
    }
}