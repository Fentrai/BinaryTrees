package com.company;

public class BinaryTrees {
    private BinaryTrees left;
    private BinaryTrees right;
    private int value;
    private static BinaryTrees root = null;

    public BinaryTrees(BinaryTrees left, BinaryTrees right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public BinaryTrees(){
        this.left = null;
        this.right = null;
        this.value = 0;
    }

    public static void setRoot(BinaryTrees Node){
        BinaryTrees.root = Node;
        return;
    }

    public static BinaryTrees getRoot(){
        return root;
    }

    public int getValue() {
        return value;
    }

    public BinaryTrees getRight() {
        return right;
    }

    public void setRight(BinaryTrees right) {
        this.right = right;
    }

    public BinaryTrees getLeft() {
        return left;
    }

    public void setLeft(BinaryTrees left) {
        this.left = left;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void insertNode(int key, BinaryTrees root){
        if (root == null){
            BinaryTrees Node = new BinaryTrees(null, null, key);
            setRoot(Node);
            return;
        }
        if (key < root.value && root.left == null){
            BinaryTrees Node = new BinaryTrees(null, null, key);
            root.left = Node;
        }else if(key < root.value && root.left != null){
            insertNode(key, root.left);
        } else if (key > root.value && root.right != null){
            insertNode(key, root.right);
        }else{
            BinaryTrees Node = new BinaryTrees(null, null, key);
            root.right = Node;
        }
    }

    public static void InOrder(BinaryTrees Node){
        if (Node == null){
            return;
        }
        InOrder(Node.getLeft());
        System.out.print(Node.getValue() + ", ");
        InOrder(Node.getRight());
    }

    public static void preOrder(BinaryTrees Node){
        if (Node == null){
            return;
        }
        System.out.print(Node.getValue() + ", ");
        preOrder(Node.getLeft());
        preOrder(Node.getRight());
    }

    public static void postOrder(BinaryTrees Node){
        if (Node == null){
            return;
        }
        preOrder(Node.getLeft());
        preOrder(Node.getRight());
        System.out.print(Node.getValue() + ", ");
    }

    public static int Successor(BinaryTrees Node){
        if (Node == null){
            return 0;
        }
        Node = Node.getRight();
        while (Node.getLeft() != null){
            Node = Node.getLeft();
        }
        return Node.value;
    }

    public static int Predecessor(BinaryTrees Node){
        if (Node == null){
            return 0;
        }
        Node = Node.getLeft();
        while (Node.getRight() != null){
            Node = Node.getRight();
        }
        return Node.value;
    }

    public static BinaryTrees deleteNode(int key, BinaryTrees Node){
        if (Node == null){
            return null;
        }
        if (key > Node.value){
            Node.right = deleteNode(key, Node.right);
        }else if(key < Node.value){
            Node.left = deleteNode(key, Node.left);
        }else{
            if (Node.left == null && Node.right == null){
                Node = null;
            }else if (Node.right != null){
                Node.value = Successor(Node);
                Node.right = deleteNode(Node.value, Node.right);
            }else if (Node.left != null){
                Node.value = Predecessor(Node);
                Node.left = deleteNode(Node.value, Node.left);
            }
        }
        return Node;
    }
}
