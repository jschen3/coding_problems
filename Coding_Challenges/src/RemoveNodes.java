package problem20;

public class Problem20 {
	public static class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int val){
			this.val=val;
			this.next=null;
		}
	}
	public static void main(String args[]){
		int[] list={1,1,2};
		ListNode head=setupLinkedList(list);
		System.out.println(printList(head));
		head=iterativeRemoveNodes(head, 1);
		System.out.println(printList(head));
	}
	public static String printList(ListNode head){
		String s = "";
		while(head!=null){
			s+=""+head.val+",";
			head=head.next;
		}
		return s;
	}
	public static ListNode setupLinkedList(int[] list){
		ListNode head = new ListNode(list[0]);
		ListNode temp=head;
		for (int i=1;i<list.length;i++){
			ListNode temp2 = new ListNode(list[i]);
			temp.next=temp2;
			temp=temp.next;
		}
		temp.next=null;
		return head;
	}
	public static ListNode recursiveRemoveNodes(ListNode head, int val){
		if (head==null){
			return null;
		}
		head.next=recursiveRemoveNodes(head.next,val);
		if (head.val==val)
			return head.next;
		else
			return head;
	}
	public static ListNode iterativeRemoveNodes(ListNode head, int val){
		while (head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;
	}
}
