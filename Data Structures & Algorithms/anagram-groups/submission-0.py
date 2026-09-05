class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        #myMap={}
        myMap = defaultdict(list)
        
        for word in strs:
            curArr= [0] * 26 # arr of 26 0's
            for c in word:
                #curArr[c-'a'] +=1
                curArr[ord(c)-ord('a')]+=1
            # now add that arr to the dict of arr -> lists
            key = tuple(curArr)# cast to a tuple so its immutable unlike list and can be key of dict
            value_list = myMap[key]
            value_list.append(word) #lists are mutable so no need to save back
        
        return list(myMap.values())

        