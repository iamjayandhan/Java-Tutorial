### Tree Data Structure

1. The Tree data structure is similar to Linked Lists in that each node contains data and can be linked to other nodes.
2. Trees are made up of Nodes & Edges.
3. Top Node is called Root node.

### Terminologies

1. **Node** - Holds data and address of child nodes.
2. **Root Node** - Starting point of a tree.
3. **Parent Node** - Node that has children nodes.
4. **Slibling Node** - Children of same parent node.
5. **Height** - 1 + (Max no of edges from root node to any leaf node)
6. **Leaf Node** - Node that has no child.
7. **Tree Size** - Number of nodes in the tree.
8. **Ancestor of a Node** - Any predecessor nodes on the path of the root to that node are called Ancestors of that node.

### Sample Tree
![Tree-Structure](https://media.geeksforgeeks.org/wp-content/uploads/20240424125622/Introduction-to-tree-.webp)

### Tree Traversal (Basic)
1. **Pre Order** - Root Left Right
2. **In Order** - Left Root Right
3. **Post Order** - Left Right Root

### N-Array Tree
**Condition** - Node can have any number of childrens. Implemented using array of Node Objects.

### Structure
![](https://www.scaler.com/topics/images/n-ary%20tree.webp)

### Binary Tree
**Condition** - Node's Left will be smaller than that Node, Right will be larger than that Node.

### Structure
![](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20221215114732/bst-21.png)

### Note!
1. Given a BST, if u **perform InOrder** Traversal => It will give answer in **sorted manner!**
2. To **check if given Tree is BST**, Calc InOrder, if sorted then declare it as BST or else NOT!
3. Position of Root node in PreOrder -> First place
4. Position of Root node in PostOrder -> Last Place.

### BST 
1. All nodes must be strictly Inc or Dec, No equality!
2. Node's left nodes should be strictly lower that it. Similarly for right side.
3. That is, all nodes are UNIQUE!
4. 
### Searching in BST
1. When target > Node's data, move right
2. When target < Node's data, move left
3. When target == Node's data, return true
4. If head == null, return false! 
5. Sometimes we might required to return that node & null if present or absent! return accordingly either node or null.

### Calculate size of Tree

1. Size of tree == no of nodes present in that tree.
2. We get Left,Right and then we return! So Post Order Traversal is the logic.