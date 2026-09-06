class Solution:

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefix =[1] * n
        postfix =[1] * n

        prefix[0]=nums[0]
        postfix[n-1]=nums[n-1]

        for i in range(1,len(nums)):
            prefix[i]=prefix[i-1] * nums[i]
        
        for i in range(len(nums)-2,0,-1):
            postfix[i]=postfix[i+1] * nums[i]
        
        answers=[1] * n
        for i in range(0,len(nums)):
            if (i-1)<0:
                prev=1;
            else:
                prev=prefix[i-1]
            
            if (i+1)>=n:
                next=1;
            else:
                next=postfix[i+1]
            answers[i]=prev * next
        return answers




    # FAIL
    def productExceptSelf2(self, nums: List[int]) -> List[int]:
        
        #empty case
        if (len(nums)==0):
            return []

        products=[0]* len(nums)

        # first product
        totalProd=1;
        for i in range(0,len(nums)):
            totalProd *= nums[i];
        # create sum for each
        for i in range(1,len(nums)):
            products[i]=totalProd/products[i]
        return products




        
        