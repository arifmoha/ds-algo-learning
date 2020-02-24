package algo.dp;

public class MagicIndex {
    public static void main(String[] args) {
        int[] array = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println("Magic Index: "+magicIndex(array, 0, array.length));

        int[] array2 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println("Magic Index: "+magicIndex2(array2, 0, array2.length));
    }

    private static int magicIndex(int[] array, int start, int end) {
        if (end < start) return -1;
        int mid = start + (end - start) / 2;
        int magicVal = array[mid];
        if (magicVal == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicIndex(array, start, mid - 1);
        } else {
            return magicIndex(array, mid + 1, end);
        }
    }

    private static int magicIndex2(int[] array, int start, int end) {
        if (end < start) return -1;

        int mid = start + (end - start) / 2;

        int magicVal = array[mid];

        if (magicVal == mid) return mid;

        // search left
        int leftInd = Math.min(magicVal, mid - 1);

        int left = magicIndex2(array, start, leftInd);

        if (left >= 0) return left;

        // search right
        int rightInd = Math.max(magicVal, mid + 1);
        int right = magicIndex2(array, rightInd, end);

        if (right < array.length) return right;

        return -1;
    }
}
