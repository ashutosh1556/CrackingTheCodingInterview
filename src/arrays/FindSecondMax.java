package strings;

public class FindSecondMax {

    public static void main(String[] args) {
        FindSecondMax d = new FindSecondMax();
        int[] arr = {1};;
        System.out.println(d.findSecondMAx(arr));
    }

    public int findSecondMAx(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) arr[i] = Integer.MIN_VALUE;
        }

        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }
}
