public class Array<E> {

    /**
     * 不希望用户在外部可见
     */
    private E[] data;
    private int size;

    /**
     * 构造函数 传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
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
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在所有元素的前一个位置添加一个元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在数组中是否存在某一个元素
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e 所在的索引 如果不存在元素e 则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除 index 位置的元素 返回删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed, index is illegal");
        }
        E ret = data[index];

        // 从想要删除的位置找到后一个位置
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        // 如果数组中的元素已经没有
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素 返回删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     */
    public void removeElement(E e) {
        // 如果能够找到
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 在第index位置插入一个新的元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        // 还需要判断 index 索引的合法性 index 大于零很好理解 index > size 说明不是在第一个没有元素的位置添加了
        // 这样数组就是不连续的了
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index>= 0 or index<=size full");
        }

        // size 从0 开始 data。length 从1 开始 两者相等的时候 数组满了
        if (size == data.length) {
            resize(2 * data.length);
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
    public E get(int index) {
        // 同时也要保证用户访问是不会越界的
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed Index is illegal ");
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return  get(size-1);
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 修改指定位置的元素为e
     *
     * @param index
     * @param e
     */
    void set(int index, E e) {
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

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


}
