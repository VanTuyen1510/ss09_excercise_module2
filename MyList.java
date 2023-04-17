package excercise_ss09_dsa_list;

import ss09_dsa_list.MyArrayList;

public class MyList<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    //arraycopy(Object src, int srcPos,Object dest, int destPos, int length)
    //src là mảng nguồn muốn sao chép
    //srcPos là vị trí phần tử bắt đầu sẽ sao chép trên mảng nguồn
    //dest là mảng đích muốn sao chép từ mảng nguồn sang mảng đích
    //destPos là vị trí phần tử bắt đầu trên mảng đích mà mảng nguồn sao chép sang
    //length là số phần tử muốn sao chép từ mảng nguồn sang mảng đích

    private void ensureCapacity(){
        if(size >= elements.length){
            E[] newData = (E[]) new Object[size * 2 + 1];
            System.arraycopy(elements,0,newData,0,size);
            elements = newData;

        }
    }
    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
        return true;
    }

    public void add(int index , E e){
        ensureCapacity();
        for (int i = size - 1; i >= index ; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = e;
        size++;

    }

    public E get(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index " + index + " , Size " + index);
        }
        return (E) elements[index];
    }

    public void remove(int index){

        for (int i = 0; i < elements.length; i++) {
            if(i == index){
                for (int j = index; j < elements.length - 1; j++) {
                    elements[j] = elements[j + 1];
                    index++;
                }
                elements[elements.length -1] = null;

            }
            size--;
            break;
        }
    }
    public int size(){
        ensureCapacity();
        return size;
    }

    // Phương thức contains tìm kiếm chuỗi đúng trả về true,sai trả về false
    //Phương thức equals() so sánh hai chuỗi đưa ra dựa trên nội dung của chuỗi. Nếu hai chuỗi khác nhau nó trả về false. Nếu hai chuỗi bằng nhau nó trả về true.
    public boolean contains(E o){
        for (int i = 0; i < elements.length; i++) {
            if(o.equals(elements[i])){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E o){
        for (int i = 0; i < elements.length; i++) {
            if(o.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }
    public void clear(){
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
            size = 0;
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(elements[i]);
            if (i < size - 1) result.append(", ");
        }

        return result.toString() + "]";
    }








}
