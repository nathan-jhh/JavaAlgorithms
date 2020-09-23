public class BinarySearch {

    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 6, 9, 10, 11, 15, 18, 20};
        System.out.println(BinarySearch.binarySearch(a, 15));
    }
    public static int binarySearch(int[] a, int target) {
        int length = a.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < target) {
                low = mid + 1;
            } else if (a[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
