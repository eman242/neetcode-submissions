class Solution {
    public int findDuplicate(int[] nums) {
        int fp = 0;
		int sp = 0;
		//doing first iteration outside so not equal
		sp=nums[sp];
		fp=nums[fp];
		fp=nums[fp];
		
		while (nums[fp] != nums[sp] ) {
			sp=nums[sp];
			fp=nums[fp];
			fp=nums[fp];
		}
		//now after 1st pass 2nd intersection gives start of cycle
		
		int sp2 = 0;
		
		while (nums[sp2] != nums[sp] ) {
			sp=nums[sp];
			sp2=nums[sp2];
		}
		
		return nums[sp2];
    }
}
