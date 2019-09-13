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
//        if (size == data.length) {
//            throw new IllegalArgumentException("AddLast failed Array is full");
//        }
//        data[size] = e;
//        size++;

        // 因为这个添加最后一个元素的行为已经封装在了 add 方法中，因此 执行一下 add 方法传入 size 和相应的
        // 的元素e 就可以了

        add(size, e);
    }

    /**
     * 在所有元素的前一个位置添加一个元素
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在第index位置插入一个新的元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        // size 从0 开始 data。length 从1 开始 两者相等的时候 数组满了
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed, Array is full");
        }

        // 还需要判断 index 索引的合法性 index 大于零很好理解 index > size 说明不是在第一个没有元素的位置添加了
        // 这样数组就是不连续的了
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index>= 0 or index<=size full");
        }

        // 从后面往前进行
        for (int i = size - 1; i >= index; i--) {
            // 让后一个位置的元素赋值前一个位置的值
            data[i + 1] = data[i];
        }

        // 此时 想要插入的位置其实也是有元素的，只不过，这个时候 可以放心的覆盖这个部分了
        data[index] = e;
        size++;
    }

    /**
     * 获取index 索引位置的元素
     *
     * @param index
     * @return
     */
    int get(int index) {
        // 同时也要保证用户访问是不会越界的
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed Index is illegal ");
        }
        return data[index];
    }

    /**
     * 修改指定位置的元素为e
     * @param index
     * @param e
     */
    void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed Index is illegal ");
        }
        data[index] = e;
    }

    /**
     * 重写父类的方法
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');

        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }

        res.append(']');

        return res.toString();
    }


}
