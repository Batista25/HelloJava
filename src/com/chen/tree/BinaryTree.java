package com.chen.tree;

import java.util.Stack;

public class BinaryTree {  
  
    private Node root;  
      
    /** 
     *  
     * 内部节点类 
     * @author yhh 
     */  
    private class Node{  
        private Node left;  
        private Node right;  
        private int data;  
        public Node(int data){  
            this.left = null;  
            this.right = null;  
            this.data = data;  
        }  
    }  
      
    public BinaryTree(){  
        root = null;  
    }  
      
    /** 
     * 递归创建二叉树 
     * @param node 
     * @param data 
     */  
    public void buildTree(Node node,int data){  
        if(root == null){  
            root = new Node(data);  
        }else{  
            if(data < node.data){  
                if(node.left == null){  
                    node.left = new Node(data);  
                }else{  
                    buildTree(node.left,data);  
                }  
            }else{  
                if(node.right == null){  
                    node.right = new Node(data);  
                }else{  
                    buildTree(node.right,data);  
                }  
            }  
        }  
    }  
      
    /** 
     * 前序遍历 
     * @param node 
     */  
    public void preOrder(Node node){  
        if(node != null){  
            System.out.print(node.data + ",");  
            preOrder(node.left);  
            preOrder(node.right);  
        }  
    }  
      
    /** 
     * 中序遍历 
     * @param node 
     */  
    public void inOrder(Node node){  
        if(node != null){  
            inOrder(node.left);  
            System.out.println(node.data);  
            inOrder(node.right);  
        }  
    }  
      
    /** 
     * 后序遍历 
     * @param node 
     */  
    public void postOrder(Node node){  
        if(node != null){  
            postOrder(node.left);  
            postOrder(node.right);  
            System.out.println(node.data);  
        }  
    } 
    
    /**
     * 非递归先序遍历
     * @param args
     */
    public void preOrder2(Node t) {    
        Stack<Node> s = new Stack<Node>();    
        while (t != null || !s.empty()) {    
            while (t != null) {    
                System.out.print(t.data + ",");    
                s.push(t);    
                t = t.left;    
            }    
            if (!s.empty()) {    
                t = s.pop();    
                t = t.right;    
            }    
        }    
    }  
    
 // 中序遍历非递归     
    public static void InOrder2(Node t) {    
        Stack<Node> s = new Stack<Node>();    
        while (t != null || !s.empty()) {    
            while (t != null) {    
                s.push(t);    
                t = t.left;    
            }    
            if (!s.empty()) {    
                t = s.pop();    
                System.out.print(t.data);    
                t = t.right;    
            }    
        }    
    }    
    
    // 后序遍历非递归     
    public static void PostOrder2(Node t) {    
        Stack<Node> s = new Stack<Node>();    
        Stack<Integer> s2 = new Stack<Integer>();    
        Integer i = new Integer(1);    
        while (t != null || !s.empty()) {    
            while (t != null) {    
                s.push(t);    
                s2.push(new Integer(0));    
                t = t.left;    
            }    
            while (!s.empty() && s2.peek().equals(i)) {    
                s2.pop();    
                System.out.print(s.pop().data);    
            }    
    
            if (!s.empty()) {    
                s2.pop();    
                s2.push(new Integer(1));    
                t = s.peek();    
                t = t.right;    
            }    
        }    
    }    
      
    public static void main(String[] args) {  
        int[] a = {2,4,12,45,21,6,111};  
        BinaryTree bTree = new BinaryTree();  
        for (int i = 0; i < 10000; i++) {  
            bTree.buildTree(bTree.root,(int)(Math.random()*100000));
        } 
        Long start1 = System.currentTimeMillis();
        bTree.preOrder(bTree.root);
        Long end1 = System.currentTimeMillis();
        System.out.println();
        Long start2 = System.currentTimeMillis();
        bTree.preOrder2(bTree.root);
        Long end2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("递归时间：" + (end1 - start1));
        System.out.println("非递归时间：" + (end2 - start2));
//        bTree.inOrder(bTree.root);  
//        bTree.postOrder(bTree.root);  
    }  
  
} 