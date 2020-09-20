package com.jhh;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 1, 8, 4, 9, 6, 3, 7}; //要排序的数组,不能破坏此数组

        int[] temp = new int[a.length]; //归并排序临时辅助数组

        Sort sort = new Sort();

        Sort.print("Select Sort Algorithm", sort.selectSort(a));
        System.out.println();
        Sort.print("Insert Sort Algorithm", sort.insertSort(a));
        System.out.println();
        Sort.print("Merge Sort Algorithm", sort.mergeSort(a, temp));
        System.out.println();

        //先把a数组复制到array中
        int[] array = new int[a.length];
        System.arraycopy(a, 0, array, 0, a.length);
        sort.quickSort(array, 0, array.length - 1);
        Sort.print("Quick Sort Algorithm", array);

        System.out.println();
        System.out.println("a[]: " + Arrays.toString(a));
    }
}