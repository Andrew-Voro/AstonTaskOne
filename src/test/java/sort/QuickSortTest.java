package sort;

import collection.MyArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {


    @Test
    void sortMyArrayList() throws Exception{
        MyArrayList<String> strArr2 = new MyArrayList(String::new);
        strArr2.addElement("ab");
        strArr2.addElement("ba");
        strArr2.addElement("baa");
        strArr2.addElement("abc");
        QuickSort.sortMyArrayList(strArr2);
        assertEquals(strArr2.getElementByIndex(0),"ab");
        assertEquals(strArr2.getElementByIndex(1),"abc");
        assertEquals(strArr2.getElementByIndex(2),"ba");
        assertEquals(strArr2.getElementByIndex(3),"baa");
    }
}