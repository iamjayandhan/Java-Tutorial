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

public class Tree{

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

    public static void main(String[] args) {
        Node node6 = new Node(6);
        Node node2 = new Node(2);
        Node node8 = new Node(8);
        Node node7 = new Node(7);
        Node node9 = new Node(9);

        node6.left = node2;
        node6.right = node7;
        node2.left = node8;
        node7.right = node9;

        
        preOrder(node6);
        System.out.println();

        inOrder(node6);
        System.out.println();

        postOrder(node6);
        System.out.println();
        
    }
}