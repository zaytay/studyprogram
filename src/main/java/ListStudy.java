/**
 * Created with IntelliJ IDEA.
 * User: zhengxuetong
 * Date: 14-9-24
 * Time: 下午3:57
 * Desc:
 */
public class ListStudy {
    public static void main(String args[]){
        System.out.println("ceshi");
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n8=new Node(8);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n8;
        printList(n1);
        Node reverNode=reverseList(n1);
        System.out.println(reverNode);
        printList(reverNode);

    }

    //链表节点结构
    private static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }

    public static void printList(Node head){
        while (head != null){
            System.out.print(head.val+"  ");
            head=head.next;
        }
        System.out.println();
    }

    //翻转链表
    public static Node reverseList(Node head){
        //如果为空或者只有一个节点，直接返回头结点
        if(head == null || head.next==null){
            return head;
        }
        //处理头结点的next指针
        Node cur=head.next;
        head.next=null;
        while (cur!=null){
            Node nextNode=cur.next;
            cur.next=head;
            head=cur;
            cur=nextNode;
        }
        return head;
    }






}
