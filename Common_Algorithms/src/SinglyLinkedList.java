
public class SinglyLinkedList {
	public class ListNode{
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
	public ListNode createList(int[] list){	
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
		SinglyLinkedList list = new SinglyLinkedList();
		int[] intList = {1,2,3,4};
		ListNode head=list.createList(intList);
		System.out.println(head);
		ListNode reverse=reverse(head);
		System.out.println(reverse);
	}
	public static ListNode reverse(ListNode head){
		ListNode prev = null;
		ListNode current=head;
		ListNode next=null;
		while(current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
		return head;
	}	
}
