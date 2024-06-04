import collection.MyArrayList;
import sort.QuickSort;

public class Main {
    public static void main(String[] args) throws Exception {
        MyArrayList<String> strArr2 = new MyArrayList(String::new);
        //String[] stringList = {"hello", "this", "is", "a", "test", "ab", "aaa", "aba"};
        //Integer[] stringList = {10, 2, 11, 12, 1};
        strArr2.addElement("ab");
        strArr2.addElement("ba");
        strArr2.addElement("baa");
        strArr2.addElement("abc");
        Comparable[] stringList = strArr2.getArrayOfObjects();


        //QuickSort.sort(stringList, 0, stringList.length - 1);
        QuickSort.sortMyArrayList(strArr2);
        //System.out.println(stringList.toString());
        System.out.println(strArr2);
       /* ArrayList<Integer> list = new ArrayList();
        list.add(5);
        list.add(4);
        list.add(7);
        list.sort((v,z) ->v.compareTo(z));
        MyArrayList<String> strArr = new MyArrayList();
        MyArrayList<String> strArr2 = new MyArrayList();
        MyArrayList<String> strArr3 = new MyArrayList();
        MyArrayList<String> strArr4 = new MyArrayList();
        //QuickSort<String> qs = new QuickSort();
        strArr2.addElement("he");
        strArr2.addElement("hel");
        strArr2.addElement("hell");
        strArr2.addElement("hello");
        strArr3.addElement("hello3");
        strArr3.addElement("hello4");
        strArr4.addElement("hello5");
        strArr4.addElement("hello6");*/

        //strArr.addElementByIndex("hh",0);
        //strArr.addElementByIndex("hh1",1);
        //strArr.addElementByIndex("hh2",2);
        //strArr.addElementByIndex("hh3",3);
        //strArr.addElementByIndex("hh4",4);
        //strArr.addElementByIndex("hh00",0);
        //strArr.addElementByIndex("hh11",1);
        //strArr.addElementByIndex("hh2",1);
        //strArr.addElementByIndex("h3",2);

        //System.out.println(strArr);
       /* System.out.println(strArr2);
        strArr.addArrayByIndex(strArr2,0);
        System.out.println(strArr);
        strArr.addArrayByIndex(strArr3,1);
        System.out.println(strArr);
        strArr.addArrayByIndex(strArr4,3);
        System.out.println(strArr);
        strArr.deleteElement(0);
        System.out.println("delete 1 "+strArr);
        strArr.deleteElement(0);
        System.out.println("delete 2 "+strArr);
        strArr.deleteElement(0);
        System.out.println("delete 3 "+strArr);
        strArr.deleteElement(0);
        System.out.println("delete 4 "+strArr);
        strArr.deleteElement(0);
        System.out.println("delete 5 "+strArr);
        strArr.addArrayByIndex(strArr2,1);
        System.out.println(strArr);*/


    }
}

