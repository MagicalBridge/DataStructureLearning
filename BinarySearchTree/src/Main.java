public class Main {

    public static void main(String[] args) {
        System.out.println("学习二分搜索树");
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};

        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrder();
    }
}
