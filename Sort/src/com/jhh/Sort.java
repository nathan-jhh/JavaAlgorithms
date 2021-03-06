package com.jhh;

public class Sort {

    public Sort() {
    }

    //交换元素
    private void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //打印排序后的数组
    public static void print(String sortName, int[] a) {
        System.out.print("sorted array by " + sortName + ": ");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    //选择排序
    public int[] selectSort(int[] a) {
        int[] array = new int[a.length];
        System.arraycopy(a, 0, array, 0, a.length);
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            exchange(array, min, i);
        }
        return array;
    }

    //插入排序
    public int[] insertSort(int[] a) {
        int[] array = new int[a.length];
        System.arraycopy(a, 0, array, 0, a.length);
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    exchange(array, j - 1, j);
                }
            }
        }
        return array;
    }

    //归并排序
    public int[] mergeSort(int[] a, int[] temp) {
        int[] array = new int[a.length];
        System.arraycopy(a, 0, array, 0, a.length);
        mergeSortUpToDown(array, 0, a.length - 1, temp);
        return array;
    }

    //自顶向下的归并排序
    private void mergeSortUpToDown(int[] a, int low, int high, int[] temp) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSortUpToDown(a, low, mid, temp);
        mergeSortUpToDown(a, mid + 1, high, temp);
        merge(a, low, mid, high, temp);
    }

    //将a[low...mid]与a[mid+1...high]合并,假装两部分已经是有序的。
    private void merge(int[] a, int low, int mid, int high, int[] temp) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
                k++;
            } else {
                temp[k] = a[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }
        while (j <= high) {
            temp[k] = a[j];
            j++;
            k++;
        }
        for (int t = 0; t < k; t++) {  //这里是k，不是k+1，也不是k-1
            a[t + low] = temp[t];
        }
    }
    //快速排序
    public void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int k = partition(a, low, high);
        quickSort(a, low, k - 1);
        quickSort(a, k + 1, high);
    }

    /*将数组切分成a[low...j-1],a[j],a[j+1...high]三部分，
      a[j]大于左边数组中所有元素，小于右边数组中所有元素，
      双指针法*/
    private int partition(int[] a, int low, int high) {
        int pivot = a[low]; // 此处误写成a[0], debug好久...
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && a[j] >= pivot) {
                j--;
            }
            while (i < j && a[i] <= pivot) {
                i++;
            }
            if (i < j) {
                exchange(a, i, j);
            }
        }
        a[low] = a[i];  // 此时i或者j位置的元素和pivot交换
        a[i] = pivot;

        return i;   //返回i或者j都可以，因为最后退出循环后i==j
    }
}
