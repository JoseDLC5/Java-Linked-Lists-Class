package linkedlist;

public class SLList<E extends Comparable<E>> {
	
	public static class Node<F> {
		// data fields
		private F data;
		private Node<F> next;
		
		// Constructor

		public Node(F data, Node<F> next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		public Node(F data) {
			super();
			this.data = data;
			this.next = null;
		}
		
		// Methods
		
	}
	
	// date fields
	private Node<E> head;
	private int size;
	
	// Constructor
	SLList() {
		head=null;
		size=0;
	}
	
	// Methods
	
	public E addFirst(E item) {
		head = new Node<E>(item,head);
		size++;
		return item;
	}
	
	
	public E add(int index, E item) {
		if (index<0 || index>size) {
			throw new IllegalArgumentException();
		}
		Node<E> current = head;
		for (int i = 0; i<index-1;i++) {
			current=current.next;
		}
		Node<E> thing = new Node<E>(item,current.next);
		current.next = thing;
		return null;
		
	}
	
	public E addLast(E item) {
		if (head==null) {
			return this.addFirst(item);
		}
		Node<E> current = head;
		while (current.next!=null) {
			current = current.next;
		}
		
		current.next = new Node<E>(item);
		size++;
		return item;
		
	}
	
	public E removeFirst() {
		if(head==null) {
			throw new IllegalStateException();
		}
		E temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
	
	
	
	
	public E remove(int index) {
		return null;

	}
	
	public E removeLast() {
		return null;

	}
	
	public void removeAdjecentDuplicates() {
		Node<E> current = head;
		while(current != null && current.next != null) {
			if(current.data == current.next.data) {
				current.next = current.next.next;
				size--;
			}
			else {
			current = current.next;
			}
		}
	}
	
	private void remAdH(Node<E> current, Node<E> next){
		if(current == null || next == null) {
			return;
		}
		else if (current.data == next.data) {
			size--;
			current.next = next.next;
			remAdH(current, current.next);
		}
		else {
			remAdH(next,next.next);
		}
	}
	public void remAdDupR() {
		remAdH(head,head.next);
	}
	
	public SLList<E> stutter() {
		SLList<E> temp = new SLList<E>();
		return temp;
	}
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		Node<E> current = head;
		s.append("[");
		while (current!=null) {
			s.append(current.data.toString()+",");
			current = current.next;
		}
		s.append("]");
		return s.toString();
	}
	
	public SLList<E> clone() {
		SLList<E> temp = new SLList<E>();
		Node<E> current = head;
		Node<E> newHead = head;
		Node<E> dummy = newHead;
		while(current!=null) {
			newHead.data = current.data;
			newHead.next = current.next;
			newHead = newHead.next;
			current = current.next;
		}
		temp.head = dummy;
		return temp;
	}
	
	public void take(int n) {
		int i = 0;
		Node<E> current = head;
		
		if (n==0) {
			head = null;
			size = 0;
			return;
		}
		while(i < n - 1 && current!=null) {
			current=current.next;
			i++;
		}
		if (current!=null) {
			current.next = null;
			size = i + 1; 
		}
	}
	
	public void drop(int n) {
		int i = 0;
		Node<E> current = head;
		
		if (n==0) {
			return;
		}
		while(i < n  && current!=null) {
			current=current.next;
			i++;
		}
		if (current!=null) {
			head = current;
			size = size - n;
		}
		else {
			head = null;
		}
	}
	
	public boolean hasCycle() {
		Node<E> slow = head;
		Node<E> fast = head;
		while(fast != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		SLList<Integer> l = new SLList<>();
		SLList<Integer> v = new SLList<>();
		
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2,n1);
		Node<Integer> n3 = new Node<Integer>(3,n2);
		for(int i = 0;i<10;i++) {
			l.addFirst(i);
		}
		//l.head = n3;
		n1.next = n3;
		System.out.println(v.hasCycle());
		
		
	}
	
}