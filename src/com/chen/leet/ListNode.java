package com.chen.leet;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	 ListNode result = new ListNode((l1.val + l2.val)%10);
		        ListNode tmp = result;
		        int sum1 = l1.val;
		        int sum2 = l2.val;
		        int x=1,y = 1;
		        ListNode l1p = l1.next;
		        ListNode l2p = l2.next;        
		        while(l1p != null){ 
		            x = x*10;
		            sum1 = sum1 + l1p.val * x;          
		            l1p = l1p.next;
		        }
		        System.out.println(sum1);
	            while(l2p != null ){ 
		            y = y*10;
		            sum2 = sum2 + l2p.val * y;
		            System.out.println(sum2);
		            l2p = l2p.next;
		        }
	            System.out.println(sum2);
		        int sum = sum1 + sum2;
		        while(sum/10 != 0){
		        	sum = sum/10;
		            tmp.next = new ListNode(sum%10);	            
		            tmp = tmp.next;
		        }
		        
		        return result;
	        
	    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
//		l1.next = new ListNode(9);
//		l1.next.next = new ListNode(9);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		l2.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		ListNode re = addTwoNumbers(l1, l2);
		while(re != null){
			System.out.println(re.val);
			re = re.next;
		}
		

	}

}
