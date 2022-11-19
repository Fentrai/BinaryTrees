package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        BinaryTrees Node = new BinaryTrees(null,null, 50);
        BinaryTrees.setRoot(Node);
        BinaryTrees.insertNode(75, Node);
        BinaryTrees.insertNode(100, Node);
        BinaryTrees.insertNode(60, Node);
        BinaryTrees.insertNode(25, Node);
        BinaryTrees.insertNode(10, Node);
        BinaryTrees.insertNode(40, Node);
        //BinaryTrees.InOrder(Node);
        //BinaryTrees.preOrder(Node);
        //BinaryTrees.postOrder(Node);
        //System.out.println(BinaryTrees.Successor(Node));
        //System.out.println(BinaryTrees.Predecessor(Node));
        //BinaryTrees.deleteNode(50, Node);
        //System.out.println();
        //BinaryTrees.InOrder(Node);
        BFS(Node);
    }

    public static void BFS(BinaryTrees Node){
        Queue<BinaryTrees> Queue = new LinkedList<BinaryTrees>();

        Queue.add(Node);
        while (!Queue.isEmpty()){
            BinaryTrees CNode = Queue.poll();
            System.out.print(CNode.getValue() + " ");
            if (CNode.getLeft() != null){
                Queue.add(CNode.getLeft());
            }
            if (CNode.getRight() != null){
                Queue.add(CNode.getRight());
            }
        }
        return;
    }
}
