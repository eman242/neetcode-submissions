class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        countA={}
        countB={}
        # quick check
        if (len(s)!=len(t)):
            return False

        # dict for s
        for c in s:
            if c in countA:
                countA[c]+=1
            else:
                countA[c]=1
        # dict for t
        for c in t:
            if c in countB:
                countB[c]+=1
            else:
                countB[c]=1
        # do comparison
        for c in s:
            if (countA[c]!= countB.get(c,0)):# python gives keyErr is key doesn't exist so check first
                return False
        return True
    
    # TIP can use countB.get(c,0) because it returns 0 as default if not found
    # OLD: if (c not in countB) or (countA[c]!= countB[c]):
            
        

        


        