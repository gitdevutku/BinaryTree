import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean visited;

        TreeNode(int x) {
            val = x;
            visited = false;
        }

        void printNode() {
            System.out.print(val + "->");
        }
    }

    static class BinaryTree {
        TreeNode root;

        BinaryTree(TreeNode root) {
            this.root = root;
        }

        private TreeNode recursiveInsert(TreeNode root, int x) {
            if (root == null) {
                return new TreeNode(x);
            }
            if (x < root.val) {
                root.left = recursiveInsert(root.left, x);
            } else if (x > root.val) {
                root.right = recursiveInsert(root.right, x);
            }
            return root;
        }

        void add(int x) {
            root = recursiveInsert(root, x);
        }

        void preorder(TreeNode root) {
            if (root == null) {
                return;
            }
            root.printNode();
            preorder(root.left);
            preorder(root.right);
        }

        void postorder(TreeNode root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            root.printNode();
        }

        void breadthFirst(TreeNode root) {
            if (root == null) {
                return;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                node.printNode();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        void depthFirst(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (!node.visited) {
                    node.printNode();
                    node.visited = true;
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(null);
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(2);
        tree.add(4);
        tree.add(7);
        tree.add(9);
        tree.add(1);
        tree.add(6);
        tree.add(10);
        System.out.print("Preorder Traversal: ");
        tree.preorder(tree.root);
        System.out.println();
        System.out.print("BFS Traversal: ");
        tree.breadthFirst(tree.root);
        System.out.println();
        System.out.print("Postorder Traversal: ");
        tree.postorder(tree.root);
        System.out.println();
        System.out.print("DFS Traversal: ");
        tree.depthFirst(tree.root);
    }
}
