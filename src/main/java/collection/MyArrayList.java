package collection;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;


@AllArgsConstructor

@ToString
@EqualsAndHashCode
@Slf4j

/**
 * This is my implementation of ArrayList
 */
public class MyArrayList<T extends Comparable<T>> {
    private T[] arrayOfObjects;
    private Integer size = 0;
    private Integer length;


    /**
     * Constractor of class MyArrayList<T> with default length 2
     *
     * @param factory type of Supplier<T>
     */
    public MyArrayList(Supplier<T> factory) {


        arrayOfObjects = (T[]) new Comparable[2];

        for (int i = 0; i < 2; i++) {
            arrayOfObjects[i] = factory.get();
        }

        length = arrayOfObjects.length;
    }

    /**
     * Constractor of class MyArrayList<T> with  length equal len
     *
     * @param factory type of Supplier<T>
     * @param len type of Integer
     */
    public MyArrayList(Supplier<T> factory, Integer len) {
        arrayOfObjects = (T[]) new Comparable[length];

        for (int i = 0; i < len; i++) {
            arrayOfObjects[i] = factory.get();
        }

        length = len;
    }

    /**
     * This method add element into MyArrayList
     *
     * @param element of type T
     * @return T[]
     */
    public T[] addElement(T element) {
        if (arrayOfObjects.length > size) { // +1
            log.info("Метод addElement, размер массива: {} больше количества элементов в нем: {}", arrayOfObjects.length, size);
            arrayOfObjects[size] = element;
            size++;
        } else {
            arrayOfObjects = copyArray(arrayOfObjects, 0, true);
            log.info("Метод addElement, размер массива меньше количества элементов в нем: {}, увеличиваем размер до: {}", size, arrayOfObjects.length);
            length = arrayOfObjects.length;
            arrayOfObjects[size] = element;
            size++;
        }


        return arrayOfObjects;
    }

    /**
     * This method return array of T`s
     *
     * @return T[]
     */
    public T[] getArrayOfObjects() {
        for (int i = 0; i < arrayOfObjects.length; i++) {
            arrayOfObjects[i] = (T) arrayOfObjects[i];
        }
        return arrayOfObjects;
    }

    /**
     * This method delete element by index
     *
     * @param index type of Integer
     * @return return deleted element
     * @throws Exception if index > size of array or index < 0
     */
    public T deleteElement(Integer index) throws Exception {
        if (index > size) {
            throw new Exception("Индекс не может быть больше параметра size");
        }
        T element = arrayOfObjects[index];
        size = seekSize(this);
        for (int i = index; i < size - 1; i++) {
            arrayOfObjects[i] = arrayOfObjects[i + 1];
        }
        size--;
        if (size * 3 < arrayOfObjects.length) {
            arrayOfObjects = copyArray(arrayOfObjects, 0, false);
            length = arrayOfObjects.length;
        }
        return element;
    }

    /**
     * This method set empty array with length 2 on T[] arrayOfObjects
     */
    public void deleteAll() {
        arrayOfObjects = (T[]) new Comparable[2];
        size = 0;
        length = arrayOfObjects.length;
    }

    /**
     * This method get element by index
     *
     * @param index type of Integer
     * @return T
     * @throws Exception if index > size of array or index < 0
     */
    public T getElementByIndex(Integer index) throws Exception {
        if (index > size) {
            throw new Exception("Индекс не может быть больше параметра size");
        }
        if (index < 0) {
            throw new Exception("Индекс не может быть меньше 0");
        }
        return arrayOfObjects[index];
    }

    /**
     * This method add other array of MyArrayList into current array of MyArrayList by index
     *
     * @param array type of MyArrayList<T>
     * @param index type of Integer
     * @return T[]
     * @throws Exception if index > size of array, index < 0  or array == null
     */
    public T[] addArrayByIndex(MyArrayList<T> array, Integer index) throws Exception {
        if (index > size) {
            throw new Exception("Индекс не может быть больше параметра size");
        }
        if (index < 0) {
            throw new Exception("Индекс не может быть меньше 0");
        }
        if (array == null) {

            throw new Exception("Передан null,необходимо передать массив");

        }
        Integer shift = seekSize(array);
        if ((shift + seekSize(this)) < arrayOfObjects.length) { // +1
            copyArrayToItself(arrayOfObjects, index, shift);
            for (int i = index; i < index + shift; i++) {
                arrayOfObjects[i] = array.arrayOfObjects[i - index];
            }
            length = arrayOfObjects.length;
            size = seekSize(this);
        } else {
            arrayOfObjects = copyArray(arrayOfObjects, shift, true);
            copyArrayToItself(arrayOfObjects, index, shift);
            for (int i = index; i < index + shift; i++) {
                arrayOfObjects[i] = array.arrayOfObjects[i - index];
            }
            length = arrayOfObjects.length;
            size = seekSize(this);
        }
        return arrayOfObjects;

    }

    /**
     * This method add element in array by index
     *
     * @param element type T
     * @param index   type Integer
     * @return T[]
     * @throws Exception if index > size of array, index < 0
     */
    public T[] addElementByIndex(T element, Integer index) throws Exception {
        if (arrayOfObjects.length > size) { // +1
            arrayOfObjects = addElementThenIndexMoreThenSizeOrNotCases(element, index);
            size++;
            length = arrayOfObjects.length;
        } else {
            arrayOfObjects = copyArray(arrayOfObjects, 0, true);
            arrayOfObjects = addElementThenIndexMoreThenSizeOrNotCases(element, index);
            size++;
            length = arrayOfObjects.length;
        }
        return arrayOfObjects;
    }


    private T[] copyArray(T[] array, Integer shift, Boolean makeLarger) {
        T[] newArray;
        if (makeLarger) {
            newArray = (T[]) new Comparable[array.length * 3 / 2 + 1 + shift];
        } else {
            newArray = (T[]) new Comparable[array.length / 2 + 1];
        }
        for (int i = 0; i < seekSize(array); i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        return array;
    }

    private T[] copyArrayToItself(T[] array, Integer index, Integer shift) {
        if (array.length <= size + shift) { // + 1
            array = copyArray(array, shift, true);
        }
        for (int i = size; i >= index; i--) {

            array[i + shift] = array[i];
        }
        return array;
    }


    private T[] addElementThenIndexMoreThenSizeOrNotCases(T element, Integer index) throws Exception {
        if (size == index) {
            arrayOfObjects[index] = element;
        } else if (size < index) {

            throw new Exception("Индекс не может быть больше параметра size");

        } else {
            arrayOfObjects = copyArrayToItself(arrayOfObjects, index, 1);
            arrayOfObjects[index] = element;
        }
        return arrayOfObjects;
    }

    private Integer seekSize(MyArrayList array) {
        Integer size = 0;
        for (int i = 0; i < array.arrayOfObjects.length; i++) {
            if (array.arrayOfObjects[i] != null) {
                size++;
            }
        }
        array.size = size;
        return size;
    }

    private Integer seekSize(T[] array) {
        Integer sizeLocal = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                sizeLocal++;
            }
        }
        return sizeLocal;
    }
}
