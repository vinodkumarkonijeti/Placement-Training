import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    int leftCount;  
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
	this.leftCount = 0;  
    }
}

class Main {
    int sum, max = 0, min = 0; 
    
    public TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);   

        if (val < root.val)             
       {
	root.leftCount++; 
        root.left = insert(root.left, val);
       }
        else if (val > root.val)       
            root.right = insert(root.right, val);

        return root;                   
    } 

   private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
 
   public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper1(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        helper1(root.left, res);
        helper1(root.right, res);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper1(root, res);
        return res;
    }

    private void helper2(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper2(root.left, res);
        helper2(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper2(root, res);
        return res;
    }

public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.remove();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null)
                    queue.add(currentNode.left);

                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
            result.add(currentLevel);
        }
        return result;
    }

   public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return 1 + left + right;
    }
 public void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return;

        // Leaf node check
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            System.out.print(root.val + " ");
            return;
        }

        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }
 public void getNonLeaves(TreeNode root, List<Integer> nonLeaves) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        // Non-leaf node
        nonLeaves.add(root.val);
        getNonLeaves(root.left, nonLeaves);
        getNonLeaves(root.right, nonLeaves);
    }

    public int SumValues(TreeNode root) {       
        if (root == null) {    return 0;    }
        sum+=root.val;
         int left= SumValues(root.left );
        int right= SumValues(root.right);
        return sum;
    }

 public void maxminValues(TreeNode root) {       
        if (root == null) {      return; }
        if(root.val>max) max=root.val;
        if(root.val<min) min=root.val;

       maxminValues(root.left );
       maxminValues(root.right); 
    }

    public void leftview(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                TreeNode temp = q.poll();
                if (i == 1) System.out.print(temp.val + " ");
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
    }
    
    public void rightview(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                TreeNode temp = q.poll();
                if (i == n) System.out.print(temp.val + " ");
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
    }
void leftBoundary(TreeNode node) {
    if (node == null) return;
    if (node.left != null) {
        System.out.print(node.val + " ");
        leftBoundary(node.left);
    }  
}

void getLeaves(TreeNode node) {
    if (node == null) return;
    getLeaves(node.left);
    if (node.left == null && node.right == null)
        System.out.print(node.val + " ");
    getLeaves(node.right);
}

void rightBoundary(TreeNode node) {
    if (node == null) return;
    if (node.right != null) {
        rightBoundary(node.right);
        System.out.print(node.val + " ");
    }  
}
 
void boundarynodes(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " ");
    leftBoundary(root.left);
    getLeaves(root.left);
    getLeaves(root.right);
    rightBoundary(root.right);
}

    /* ================= LCA (BST OPTIMIZED) ================= */

    // ✅ NEW: LCA optimized for BST
    public TreeNode lcs(TreeNode root, int n1, int n2) {
        if (root == null) return null;

        if (n1 < root.val && n2 < root.val)     // ✅ NEW
            return lcs(root.left, n1, n2);

        if (n1 > root.val && n2 > root.val)     // ✅ NEW
            return lcs(root.right, n1, n2);

        return root;                            
    }

     public void zigzagTraversal(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int[] level = new int[size];

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                int index = flag ? i : size - 1 - i;
                level[index] = temp.val;

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }

            for (int v : level)
                System.out.print(v + " ");

            flag = !flag;
        }
    }

public boolean isValidBST(TreeNode root) 
{
    return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

private boolean validate(TreeNode root, int min, int max) {
    if (root == null) return true;

    if (root.val <= min || root.val >= max)
        return false;

    return validate(root.left, min, root.val) && validate(root.right, root.val, max);
}

 int count = 0, smallresult = -1;

public int kthSmallest(TreeNode root, int k) {
    while (root != null) {
        if (k == root.leftCount + 1)
            return root.val;
        else if (k <= root.leftCount)
            root = root.left;
        else {
            k = k - (root.leftCount + 1);
            root = root.right;
        }
    }
    return -1;   // invalid k
}

public TreeNode sortedArrayToBST(int[] nums) 
{
        return build(nums, 0, nums.length - 1);
}

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high)
            return null;

        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Number of elements on left side
        root.leftCount = mid - low;
        root.left = build(nums, low, mid - 1);
        root.right = build(nums, mid + 1, high);

        return root;
    }
 
     public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            root.leftCount--;                 // 🔥 maintain leftCount
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {            
            if (root.left == null) // Case 1: No left child
                return root.right;
            
            if (root.right == null) // Case 2: No right child
                return root.left;
           
            TreeNode successor = getMin(root.right);  // Case 3: Two children
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
 
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        Queue<Integer> q = new ArrayDeque<>();
        for (String s : data.split(","))
            q.add(Integer.parseInt(s));

        return buildBST(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildBST(Queue<Integer> q, int min, int max) {
        if (q.isEmpty()) return null;

        int val = q.peek();
        if (val < min || val > max)     return null;

        q.poll();
        TreeNode root = new TreeNode(val);

        root.left = buildBST(q, min, val);
        root.right = buildBST(q, val, max);

        return root;
    }
 
    public static void main(String[] args) {
        Main sol = new Main();
        Scanner sc = new Scanner(System.in);
        int no,i;
        List<Integer> result;
        System.out.print("Enter Root Value: ");
        TreeNode root = new TreeNode(sc.nextInt());
        int choice;
        String data=null;
        do {
 System.out.println("\nMenuuuuuu:\n.............");
 System.out.println("\n1.Insert , 2.Inorder , 3.Preorder , 4.Postorder, 5. Level Order Traversal,  6.Count , 7. Leaf Nodes, 8. Non Leaf Nodes, 9.Sum 10.MinMax, 11.LeftView , 12.RightView,13. Boundary View, 14.LCA ,15.Zigzag ,16. Validate BST , 17. Kth Smallest , 18. ArrayToBST , 19. Delete Node , 20. Serialize , 21. Deserialize , 22.Exit\n");
 System.out.print("\tEnter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                  System.out.println("Insert Node: "); 
		    System.out.print("Enter No of Nodes: ");
		    no=sc.nextInt();
		    for(i=1;i<=no;i++)
		    {
		    System.out.print("Enter Value " + i + " : " ); 
		    sol.insert(root, sc.nextInt());		
		    }    
                    System.out.println("Nodes Inserted Successfully" );		    
                    break;
 	     case 2:
                    System.out.print("Inorder: "); 
 		    result = sol.inorderTraversal(root); 
                    System.out.println(result);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Preorder: "); 
		    result = sol.preorderTraversal(root); 
                    System.out.println(result);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Postorder: "); 
		    result = sol.postorderTraversal(root); 
                    System.out.println(result);
                    System.out.println(); 
                    break;
		case 5:
    		    System.out.println("Level Order (By Level):"); 
		  List<List<Integer>> result1 = sol.levelOrder(root); 
       		  System.out.println(result1);
    		    break;                
                 case 6:
                    System.out.println("Node Count: " ); 
		    int totalNodes = sol.countNodes(root);
	            System.out.println("Total number of nodes: " + totalNodes);
		    break;
		case 7:
    		    System.out.println("Leaf Node:"); 
 		    List<Integer> leaves = new ArrayList<>();
        	    sol.getLeaves(root, leaves); 
        	   System.out.println(leaves);
    		    break;           
	        case 8:
    		    System.out.println("Non Leaf Node:"); 
   		    List<Integer> nonLeaves = new ArrayList<>();
       		    sol.getNonLeaves(root, nonLeaves); 
        	   System.out.println(nonLeaves);
    		    break;     
		case 9:
    		    System.out.println("Sum of Node Values :"+sol.SumValues(root)); 
    		    break;     
		case 10:
    		    System.out.println("Max and Min values:"); 
           	    sol.maxminValues(root); 
 		    sol.max = root.val;
                    sol.min = root.val;
                    sol.maxminValues(root);
                    System.out.println("Max: " + sol.max);
                    System.out.println("Min: " + sol.min);
                    break;     
		case 11:
    		    System.out.println("Left View : " );
                    sol.leftview(root); 
    		    break; 
	       case 12:
    		    System.out.println("Right View : " );
                    sol.rightview(root); 
    		    break;   
	      case 13:
    		    System.out.println("Boundary View : " ); 
                    sol.boundarynodes(root ); 
    		    break;    
	      case 14:
    		    System.out.println("LCS : " );
                    System.out.print("Enter No 1 : ");
                    int n1=sc.nextInt();
	            System.out.print("Enter No 2 : ");
                    int n2=sc.nextInt(); 
                    TreeNode t=sol.lcs(root,n1  ,n2);
                    System.out.println(t!=null?"LCA : " + t.val:"LCA Not Found");
                     break;
	     case 15:
                    System.out.println("Zigzag Traversal");
		     sol.zigzagTraversal(root);
                    break;
              case 16:
                    System.out.println("Validate BST : ");
     		    if (sol.isValidBST(root))
        	         System.out.println("Tree is a VALID BST");
                    else
                          System.out.println("Tree is NOT a BST");
                    break;       
		case 17:
                    System.out.println("Kth Smallest : ");
		    System.out.print("Enter k Value : ");
     		    System.out.println("Result : " +  sol.kthSmallest(root,sc.nextInt()));                    
                    break;             
	    case 18:
		  System.out.println("Sorted Array to BST : ");
        	   int[] arr = {10, 20, 30, 40, 50, 60, 70};
        	   root = sol.sortedArrayToBST(arr);
		   result = sol.inorderTraversal(root); 
                   System.out.println(result);
	           break;
	    case 19:
	           System.out.println("Delete Node : ");
	           System.out.print  ("Enter Key to Delete : "); 
        	    root = sol.deleteNode(root, sc.nextInt());
        	   System.out.println("After deleting  :");
                   result = sol.inorderTraversal(root); 
                   System.out.println(result);
		  break;
	    case 20:
                    System.out.println("Serialize : ");
		    data = sol.serialize(root);
		    System.out.println("Serialized BST:");
		    System.out.println(data);
                    break;
 	    case 21:
                    System.out.println("Deserialize : ");
		    root = sol.deserialize(data);
	           System.out.println("Inorder after deserialization:");
	           System.out.println(sol.inorderTraversal(root)); 
                    break;
 	  case 22:
                    System.out.println("Exiting...");
		    System.exit(0);
                    break;
              default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 22);
}}



