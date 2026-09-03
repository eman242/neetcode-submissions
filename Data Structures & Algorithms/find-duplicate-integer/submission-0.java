class Solution {
    public int findDuplicate(int[] nums) {
        int size = nums.length;
		ArrayList<Integer> tracked = new ArrayList<>();
		
		for (int num: nums) {
			if (tracked.contains(num)) {
				return num;
			}
			else {
				tracked.add(num);
			}
		}
		return 5;//never happens
    }
}
