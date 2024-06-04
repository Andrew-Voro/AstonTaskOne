package collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyArrayListTest {
    MyArrayList<String> strArr;

    @BeforeEach
    void init() throws IOException {
        strArr = new MyArrayList(String::new);
    }

    @AfterEach
    void eraseAll() {
        strArr.deleteAll();
        strArr = null;
    }


    @Test
    void addElement() throws Exception {
        String str = "ab";
        strArr.addElement(str);
        assertEquals(strArr.getElementByIndex(0), str);
    }

    @Test
    void getArrayOfObjects() {
        Comparable[]strA = strArr.getArrayOfObjects();
        assertNotNull(strA, "Список не создан пуст.");
    }

    @Test
    void deleteElement() throws Exception {
        String str = "ab";
        strArr.addElement(str);
        assertEquals(strArr.getElementByIndex(0), str);
        String strDel = strArr.deleteElement(0);
        assertEquals(strDel,str);
        assertEquals(strArr.getElementByIndex(0),"");
        assertEquals(strArr.getElementByIndex(1),"");

    }

    @Test
    void deleteAll() throws Exception{
        String str = "ab";
        String str1 = "abc";
        strArr.addElement(str);
        assertEquals(strArr.getElementByIndex(0), str);
        strArr.deleteAll();
        assertEquals(strArr.getElementByIndex(0),null);

        final Exception exception = assertThrows(
                Exception.class,
                new Executable() {
                    @Override
                    public void execute() throws Exception{
                        strArr.getElementByIndex(1);
                    }
                });
        assertEquals("Индекс не может быть больше параметра size", exception.getMessage());
    }

    @Test
    void getElementByIndex() throws Exception{
        String str = "ab";
        strArr.addElement(str);
        assertEquals(strArr.getElementByIndex(0),str);
        final Exception exception = assertThrows(
                Exception.class,
                new Executable() {
                    @Override
                    public void execute() throws Exception{
                        strArr.getElementByIndex(-1);
                    }
                });
        assertEquals("Индекс не может быть меньше 0", exception.getMessage());

        final Exception exception2 = assertThrows(
                Exception.class,
                new Executable() {
                    @Override
                    public void execute() throws Exception{
                        strArr.getElementByIndex(7);
                    }
                });
        assertEquals("Индекс не может быть больше параметра size", exception2.getMessage());
    }

    @Test
    void addArrayByIndex() throws Exception{
        String element = "a";
        String element2 = "b";
        strArr.addElement(element);
        strArr.addElement(element2);
        MyArrayList<String> strArr2 = new MyArrayList(String::new);
        strArr2.addElement("ab");
        strArr2.addElement("bb");
        strArr.addArrayByIndex(strArr2,1);
        assertEquals(strArr.getElementByIndex(0),element);
        assertEquals(strArr.getElementByIndex(1),"ab");
        assertEquals(strArr.getElementByIndex(2),"bb");
        assertEquals(strArr.getElementByIndex(3),element2);
        MyArrayList<String> strArr3 =null;
        final Exception exception = assertThrows(
                Exception.class,
                new Executable() {
                    @Override
                    public void execute() throws Exception{
                        strArr.addArrayByIndex(strArr3,1);
                    }
                });
        assertEquals("Передан null,необходимо передать массив", exception.getMessage());
    }

    @Test
    void addElementByIndex() throws Exception{
        String element = "a";
        String element2 = "b";
        String element3 = "ab";
        strArr.addElement(element);
        strArr.addElement(element2);
        strArr.addElementByIndex(element3,1);
        assertEquals(strArr.getElementByIndex(1),element3);
    }
}