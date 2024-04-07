public class Main {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
        void printNode(){
            System.out.println(val);
        }
    }
    static class BinaryTree{
        TreeNode root;
        BinaryTree(TreeNode root){
            this.root = root;
        }
        void recursiveInsert(TreeNode root,int x){
           if(root == null){
               root = new TreeNode(x);
           }
           if(root.val == x){
               return;
           }
           recursiveInsert(root.left,x);
           recursiveInsert(root.right,x);
        }
        void add(TreeNode root,int x){
            BinaryTree tree = new BinaryTree(root);
            tree.recursiveInsert(root,x);
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(null);
        tree.add(tree.root,1);
        tree.add(tree.root,2);
        tree.add(tree.root,3);
        tree.add(tree.root,4);
        tree.add(tree.root,5);
        tree.add(tree.root,6);
        tree.add(tree.root,7);
        tree.add(tree.root,8);
    }
}