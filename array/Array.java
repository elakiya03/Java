package array;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(Arrays.toString(arr)); // Java automatically initialize all positions to 0

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        System.out.println(Arrays.toString(arr));

        // Length
        System.out.println(arr.length);

        // 1. Loop
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]);

        // 2. Loop
        for (int i : arr)
            System.out.print(i);
    }

}
