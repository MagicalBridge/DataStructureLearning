/*
 * 二分搜索树并不是支持所有的数据，因此需要继承 比较这个接口 当然这个接口也是支持泛型
 *
 */

public class BST<E extends Comparable<E>> {
    /**
     * 内部类
     */
    private class Node {
        // 1、内部类初始化两个成员变量

        public E e;
        public Node left, right;

        // 2、给这个内部类添加一个构造函数

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    // BST的成员变量 根节点

    private Node root;
    private int size;

    /**
     * BST 的构造函数
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

}
