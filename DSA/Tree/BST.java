class Node{
    public int data;
    public Node left;
    public Node right;

    Node(int value){
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

public class BST{

    static void preOrder(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.data+" ");
        preOrder(head.left);
        preOrder(head.right);
    }

    static void inOrder(Node head){
        if(head == null){
            return;
        }
        inOrder(head.left);
        System.out.print(head.data+" ");
        inOrder(head.right);
    }

    static void postOrder(Node head){
        if(head == null){
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.data+" ");
    }

    static boolean Search(Node head,int target){
        if(head==null){
            return false;
        }
        else if(head.data == target){
            return true;
        }
        else if (head.data>target){
            return Search(head.left,target);
        }
        else{
            return Search(head.right,target);
        }
        
    }

   

    static int Size(Node head){
        if(head==null){
            return 0;
        }
        return 1+ Size(head.left) + Size(head.right);
    }

    static int Height(Node head){
        if(head==null){
            return -1;
        }
        return 1+(Math.max(Height(head.left), Height(head.right)));
    }

    static int SumTree(Node head){
        if(head==null){
            return 0;
        }

        int sumLeft = SumTree(head.left);
        int sumRight = SumTree(head.right);
        return head.data+ sumLeft+ sumRight;
    }


    static void leafNodes(Node head){
        if(head==null){
            return;
        }
        if(head.left == null && head.right == null){
            System.out.print(head.data+" ");
        }
        leafNodes(head.left);
        leafNodes(head.right);
    }

    static void leftView(Node head){
        if(head==null){
            return;
        }
        System.out.print(head.data + " ");
        leftView(head.left);
        if(head.left == null){
            leftView(head.right);
        }
    }


    static void rightView(Node head){
        if(head==null){
            return;
        }
        System.out.print(head.data + " ");
        rightView(head.right);
        if(head.left == null){
            rightView(head.left);
        }
    }
    static Node LCA(Node root){
        
    }

    public static void main(String[] args) {
        Node node10 = new Node(10);
        Node node7 = new Node(7);
        Node node12 = new Node(12);
        Node node9 = new Node(9);
        Node node8 = new Node(8);

        node10.left = node7;
        node10.right = node12;
        node7.right = node9;
        node9.left = node8;

        System.out.print("Pre Order: ");
        preOrder(node10);
        System.out.println();

        System.out.print("In Order: ");
        inOrder(node10);
        System.out.println();

        System.out.print("Post Order: ");
        postOrder(node10);
        System.out.println();
        System.out.println();

        System.out.println("Search: "+Search(node10,11));
        System.out.print("Size: "+Size(node10));
        System.out.println();

        System.out.print("Height: "+Height(node10));
        System.out.println();

        System.out.print("Sum of Tree: "+SumTree(node10));
        System.out.println();

        System.out.print("Leaf Nodes of Tree: ");
        leafNodes(node10);
        System.out.println();

        System.out.print("Left View of Tree: ");
        leftView(node10);
        System.out.println();

        System.out.print("Right View of Tree: ");
        rightView(node10);
        System.out.println();



        
    }
}