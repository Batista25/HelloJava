package cn.chenshi.helloJava.tree;

import java.util.Stack;

public class BinaryTree {  
  
    private Node root;  
      
    /** 
     *  
     * �ڲ��ڵ��� 
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
     * �ݹ鴴�������� 
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
     * ǰ����� 
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
     * ������� 
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
     * ������� 
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
     * �ǵݹ��������
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
    
 // ��������ǵݹ�     
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
    
    // ��������ǵݹ�     
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
        System.out.println("�ݹ�ʱ�䣺" + (end1 - start1));
        System.out.println("�ǵݹ�ʱ�䣺" + (end2 - start2));
//        bTree.inOrder(bTree.root);  
//        bTree.postOrder(bTree.root);  
    }  
  
} 