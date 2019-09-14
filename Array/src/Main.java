public class Main {

    public static void main(String[] args) {
        System.out.println("这是数组数据结构");
        Array<Integer> arr = new Array(20);

        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

    }
}
