//方法ArrayList需要提前引入；

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
    public static void main(String[] args) {
        //ArrayList的优势在于它的size是动态变化的；
        //故它在节省储存空间的同时，能够在不清楚数组长度的情况下对该数组开辟存储空间；


        //ArrayList后面<>里头是基本类型的包装类型：
        //比方说，int-Integer，char-Character（俩特殊），double-Double（除俩特殊之外首字母变成大写）；
        //这里相当于创建一个对象叫做numbers，此对象可以调用类名ArrayList下的若干方法；
        ArrayList<Integer> numbers = new ArrayList<>();


        //isEmpty方法，判断是否为空？
        System.out.println(numbers.isEmpty());
        //size方法，给出数组长度！
        System.out.println(numbers.size());


        //add方法，在list的末尾给数组加上指定元素；
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        numbers.add(9);
        //在指定下标前加上特定元素；
        //注意插入到该下标位置前面而不是后面；
        numbers.add(0, 11);


        //get方法，获取指定元素并输出；
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();


        //set方法，将特定下标位置处元素进行替换；
        numbers.set(0, 13);
        for (int e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();


        //remove方法，将下标为2的元素抹除掉，即元素5被删去；
        numbers.remove(numbers.size() / 2);
        System.out.println(numbers);
        //这里输出结果为[1, 3, 7, 9]；
        //numbers相当于numbers.toString();


        //Collections.sort将元素按照升序的顺序依次排列；
        Collections.sort(numbers);
        System.out.println(numbers);
        //输出[1, 3, 7, 9, 13]；
        //numbers相当于numbers.toString();


        //Collections.reverse方法，将ArrayList头尾翻转过来；
        Collections.reverse(numbers);
        System.out.println(numbers);
        //输出[13, 9, 7, 3, 1];


        //clear方法，将数组numbers里的元素全部清空；
        numbers.clear();
        System.out.println(numbers.isEmpty());


        //toArray方法，将ArrayList转换为数组；
        //当方法中返回类型为数组时，有必要将ArrayList转换为数组形式进行返回；
        ArrayList<Integer> intList=new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(5);
        intList.add(7);
        int length=intList.size();
        int[] intArray=new int[length];
        for(int i=0;i<length;i++){
            intArray[i]=intList.get(i);
        }
        for(int e:intArray){
            System.out.print(e+" ");
        }
    }
}
