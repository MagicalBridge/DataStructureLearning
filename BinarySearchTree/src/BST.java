/*
 * 二分搜索树并不是支持所有的数据，因此需要继承Comparable这个接口 当然这个接口也是支持泛型
 *
 */

public class BST<E extends Comparable<E>> {
    /**
     * 内部类 节点类
     */
    private class Node {
        // 1、内部类初始化两个成员变量

        public E e;
        // 指向左孩子和右孩子
        public Node left, right;

        // 2、给这个内部类添加一个Node这个内部类的构造函数

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    // BST的成员变量 根节点 和存储多少个元素变量

    private Node root;
    private int size;

    /**
     * BST 的构造函数
     * 初始化的构造函数 根节点是 null size 是0
     */
    public BST() {
        root = null;
        size = 0;
    }

    /**
     * BST 的成员函数
     */
    public int size() {
        return size;
    }

    /**
     * BST 的成员函数
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加元素
     */
    public void add(E e) {
        // 如果我们的根节点本身就是空的 元素直接赋值在根节点上
        root = add(root, e);
    }

    /**
     * 向以node为根二分搜索树中插入元素E 递归算法
     * 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e) {
        // 如果 node 是空的 创建一个节点
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 看二分搜索树是否包含元素e
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素 e 递归算法
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树 ，递归算法
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的中序遍历
     *
     * @return
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树，递归算法
     *
     * @return
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 二分搜索树的后续遍历
     *
     * @return
     */

    public void postOrder() {
        postOrder(root);
    }

    /**
     * 二分搜索树的后续遍历 递归算法
     *
     * @return
     */

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

}
