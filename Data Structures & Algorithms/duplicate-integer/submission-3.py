class Solution:

    def hasDuplicate(self, nums: List[int]) -> bool:
        count={}
        for i in range(len(nums)):
            num = nums[i]
            if num in count:
                count[num]+=1
            else:
                count[num]=1

        for value in count.values():
            if value>1:
                return True
        return False


    # brute force
    def hasDuplicate1(self, nums: List[int]) -> bool:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] == nums[j]:
                    return True
        return False
