package sort;

import collection.MyArrayList;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@NoArgsConstructor

@Getter
@ToString
@EqualsAndHashCode
@Slf4j
/**
 *  *  This class sort array of type MyArrayList<T> used by quick sort algorithm
 */
public class QuickSort {


    private static <T extends Comparable<T>> Integer partition(T[] arr, Integer low, Integer high) {

        Integer border = (int) (low + Math.round(Math.random() * (high - low)));
        T pivot = arr[border];


        T temp = arr[border];
        arr[border] = arr[high];
        arr[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * This method sort array of type T used by quick sort algorithm
     * @param arr type of T[]
     * @param low type of int
     * @param high type of int
     * @param <T> extend Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] arr, int low, int high) {
        if (low < high) {


            Integer border = partition(arr, low, high);
            sort(arr, low, border - 1);
            sort(arr, border + 1, high);
        }
    }

    /**
     *  This method sort array of type MyArrayList<T> used by quick sort algorithm
     * @param list of type MyArrayList<T>
     * @param <T> extend Comparable
     */

    public static <T extends Comparable<T>> void sortMyArrayList(MyArrayList<T> list) {
        sort(list.getArrayOfObjects(), 0, list.getArrayOfObjects().length-1);
    }
}



