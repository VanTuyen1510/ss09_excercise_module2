package excercise_ss09_dsa_list.excersice_array_list;

import java.util.ArrayList;
import java.util.List;

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
    //destPos là vị trí phần tử bắt đầu trên mảng đích mà mảng nguồn sao chép sang( vị trí bắt đầu của mảng mới )
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
                    elements[j] = elements[j + 1];  // gán bên phải qua trái
                    index++;
                }
                elements[elements.length -1] = 0;
             break;
            }
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

    //Phương thức indexOf() trả về chỉ số của giá trị ký tự đã cho hoặc chuỗi con. Nếu không tìm thấy trả lại giá trị -1. Chỉ số (index) được đếm từ 0.
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

    public E clone(){
        E[] cloneElements = (E[]) new Object[size * 2];
        for (int i = 0; i < elements.length; i++) {
            cloneElements[i] = (E) elements[i];
        }
        return (E) cloneElements;
    }

    @Override
    public String toString() {
        String a = "a";//ko thay đổi được
        a = a + "bcd";
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(elements[i]);
            if (i < size - 1) result.append(", ");
        }

        return result.toString() + "]";
    }








}
