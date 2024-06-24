class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        // 這個 Set 用來裝 nums1 裡面的東西
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // 儲存交集元素
        Set<Integer> intersection = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        // 轉為 Array
        int[] result = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            result[index++] = num;
        }

        return result;
    }
}

// Array 做只適合題目有限制數值大小
// Set 佔用空間大且速度慢