
public class SinglyLinkedListReverseK {
	public static class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int val){
			this.val=val;
		}
		public String toString(){
			String toString = this.val+"";
			ListNode temp=next;
			while(temp!=null){
				toString+=" --> "+temp.val;
				temp=temp.next;
			}
			return toString;
		}
	}
	public static ListNode createList(int[] list){	
		if (list.length<1)
			return null;
		else{
			ListNode head = new ListNode(list[0]);
			ListNode temp=head;
			for(int i=1;i<list.length;i++){			
				ListNode next = new ListNode(list[i]);
				temp.next=next;
				temp=temp.next;
			}
			return head;
		}
	}
	public static void main(String args[]){
		int[] list = {1,2,3,4,5,6,7};
		ListNode listNodes = createList(list);
		ListNode reverseK = reverseK(3, listNodes);
		System.out.println(reverseK);
	}
	public static ListNode reverseK(int k,ListNode head){
		ListNode temp=head;
		ListNode headPointer=null;
		ListNode tailPointer=null;
		while(getKNodes(k, temp,headPointer, tailPointer)!=-1){
			ListNode next=tailPointer;
			reverse(k, temp, headPointer, tailPointer);
			headPointer=next;
		}
		return head;
	}
	public static int getKNodes(int k, ListNode head, ListNode headPointer, ListNode tailPointer){
		headPointer=head;
		ListNode temp=head;
		int count=1;
		while(temp!=null && count<k){
			temp=temp.next;
			count++;
		}
			
		if (temp==null){
			return -1;
		}
		else{
			tailPointer=temp;
			return 0;
		}
		
	}
	public static void reverse(int nodes, ListNode head, ListNode headPointer, ListNode tailPointer){
		ListNode prev = null;
		ListNode current=head;
		ListNode next=null;
		int count=0;
		while(count<nodes){
			if (count==0){
				tailPointer=current;
			}
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			count++;
		}
		head=prev;
		headPointer=prev;
	}
}
