import java.util.HashMap;

public class test
{
    HashMap<Integer, Boolean> memo = new HashMap<>();
    private boolean canSum(int targetSum, int[] numbers)
    {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (int number : numbers)
        {
            int remainder = targetSum - number;
            if (canSum(remainder, numbers))
            {
                memo.put(targetSum, true);
                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }

    public static void main(String...args)
    {
        test ob = new test();
        System.out.println(ob.canSum(7, new int[]{5,3,4,7})); // true
        ob.memo.clear();
        System.out.println(ob.canSum(7, new int[]{2,4})); // false
        ob.memo.clear();
        System.out.println(ob.canSum(8, new int[]{2,3,5})); // true
        ob.memo.clear();
        System.out.println(ob.canSum(300, new int[]{7,14})); // false
        ob.memo.clear();
    }
}
