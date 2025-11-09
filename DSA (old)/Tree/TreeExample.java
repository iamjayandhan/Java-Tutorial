/* 
 * Here root node is head!
 * 
*/

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int value){
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

class TreeExample{
    static void PreTraverse(TreeNode root){
        if(root ==null){
            return;
        }
        System.out.println(root.data);
        PreTraverse(root.left);
        PreTraverse(root.right);
    }

    static void PostTraverse(TreeNode root){
        if(root ==null){
            return;
        }
        
        PostTraverse(root.left);
        PostTraverse(root.right);
        System.out.println(root.data);
    }

    static void InTraverse(TreeNode root){
        if(root ==null){
            return;
        }
        
        InTraverse(root.left);
        System.out.println(root.data);
        InTraverse(root.right);
    }

    static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode n = queue.poll();
            System.out.println(n.data);
            if(n.left!=null){
                queue.offer(n.left);
            }
            if(n.right!=null){
                queue.offer(n.right);
            }

        }
    }

    public static void main(String args[]){
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        six.left = seven;
        six.right = eight;

        TreeNode eleven = new TreeNode(11);
        TreeNode twelve = new TreeNode(12);

        seven.left = eleven;
        eight.right = twelve;


        //Pre Order Traversal - Root Left Right
        PreTraverse(six);
        System.out.println();
        //In Order Traversal - Left Root Right
        InTraverse(six);
        System.out.println();
        //Post Order Traversal - Left Right Root
        PostTraverse(six);
        System.out.println();

        //Level Order Traversing
        levelOrder(six);

    }
}