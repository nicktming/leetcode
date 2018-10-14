package Solution_500_599;

public class Solution_540 {

    public static void main(String[] args) {
        Solution_540 test = new Solution_540();
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(test.singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (mid > 0 && nums[mid] == nums[mid - 1]) {
                if ((mid - i + 1) % 2 == 0) i = mid + 1;
                else j = mid - 2;
            } else if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                if ((j - mid + 1) % 2 == 0) j = mid - 1;
                else i = mid + 2;
            } else {
                return nums[mid];
            }
        }
        return nums[i];

        /*
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
        */
    }
}
