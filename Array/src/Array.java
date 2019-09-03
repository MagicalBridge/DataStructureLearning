public class Array {

    /**
     * 不希望用户在外部可见
     */
    private int[] data;
    private int size;

    /**
     * 构造函数 传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个元素
     *
     * @param e
     */
    public void addLast(int e) {
        // size 从0 计数 data.length 从1 计数 如果两者相等 size越界了
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed Array is full");
        }
        data[size] = e;
        size++;
    }


}
