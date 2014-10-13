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

    //遍历
    public static Node reverseList(Node head){
          return head;
    }

}
