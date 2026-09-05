class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count={}
        for n in nums:
            count[n] = count.get(n, 0) + 1
        answer=[]
        
        # now sort by frequency
        sorted_items = sorted(count.items(), # turns dict into [(key,value),(key,value)]
        key=lambda x: x[1], # sorts by 2nd element which is frequency
        reverse=True #larges to smallest
        )

        start = 0
        for i in range(k):
            answer.append(sorted_items[start][0])
            start+=1
        return answer
            

        