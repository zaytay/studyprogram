/**
 * Created with IntelliJ IDEA.
 * User: zhengxuetong
 * Date: 14-10-22
 * Time: 下午4:49
 * Desc:
 */
public class Tree {
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        TreeNode n7=new TreeNode(7);
        TreeNode n8=new TreeNode(8);
        root.left=n2;
        root.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        n4.left=n8;
        int depth=getDepthOfTree(root);
        System.out.println(depth);


    }

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }

    /**
     * 求树的高度
     * @param root
     * @return
     */
    private static int getDepthOfTree(TreeNode root ){
        if(root == null){
            return 0;
        }
        int leftDepth=getDepthOfTree(root.left);
        int rightDepth=getDepthOfTree(root.right);
        int depth=Math.max(leftDepth,rightDepth)+1;
        return depth;
    }


    /**
     * 平衡二叉树判断
     * @param root
     * @return
     */
    private boolean avlJudge(TreeNode root){
        if(root==null){
            return true;
        }
        int leftDepth=getDepthOfTree(root.right);
        int rightDepth=getDepthOfTree(root.left);
        if(Math.abs(leftDepth-rightDepth)>1){
            return false;
        }
        return avlJudge(root.right) && avlJudge(root.left);


    }
















}
