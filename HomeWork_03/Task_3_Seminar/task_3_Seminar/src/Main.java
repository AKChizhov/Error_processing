import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static String[][] arr = new String[][] {
            { "1", "1.5" },
            { "1", "1", "1.5" },
            { "1", "1.5", "1" }
    };

    public static void main(String[] args) {

        System.out.println(sum2d(arr));
    }

    public static double sum2d(String[][] arr) {

        double sum = 0;
        if (isNotSquareArr(arr)) {
            throw new MyArraySizeException();
        }
        if (!foo(arr).isEmpty()){
            throw new MyArrayDataException( foo(arr));
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // if (!isDigit(arr[i][j])) {
                //     throw new MyArrayDataException(i, j);
                // }
                sum += Double.parseDouble(arr[i][j]);
            }
        }
        return sum;
    }

    private static boolean isNotSquareArr(String[][] arr2) {
        for (String[] ints : arr2) {
            if (arr2.length != ints.length) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDigit(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDataNotCorrect(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (!isDigit(arr[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<Goal> foo(String[][] arr) {
        List<Goal> goals = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (!isDigit(arr[i][j])) {
                    goals.add(new Goal(i, j));
                }
            }
        }
        return goals;
    }

}