package towSum1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(currentNum, i);
        }
        throw new IllegalArgumentException("No se encontró una solución Two Sum válida.");
    }
}

public class twosunsolution{

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] numeros = {3, 2, 4};
        int objetivo = 6;
        int[] resultado = sol.twoSum(numeros, objetivo);
        System.out.println("Resultado: " + Arrays.toString(resultado));
    }
}