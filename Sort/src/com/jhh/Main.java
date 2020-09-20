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



        System.out.println();
        System.out.println("数组a[]: " + Arrays.toString(a));
    }
}