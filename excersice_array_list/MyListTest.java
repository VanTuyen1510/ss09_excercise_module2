package excercise_ss09_dsa_list.excersice_array_list;

import excercise_ss09_dsa_list.excersice_array_list.MyList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(0,11);
        list.remove(1);
//        System.out.println(list.contains(9));
//        System.out.println("Độ dài của mảng " + list.size);
//        System.out.println("So sánh 2 chuỗi " + list.indexOf(2));
//        list.clear();
//        System.out.println(list.toString());

        list.clone();
        System.out.println("Mảng đã được clone " + list);
        for (int i = 0; i < list.size; i++) {
            System.out.println(list.get(i));
        }
    }
}
