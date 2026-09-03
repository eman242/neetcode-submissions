class Solution {
    public boolean isPalindrome(String s) {
        String cleanStr = "";

        for (int i=0;i<s.length();i++){
            if (Character.isLetterOrDigit(s.charAt(i))){
                cleanStr+= Character.toLowerCase(s.charAt(i));
            }
        }
        if (cleanStr.length()<=1){
            return true;
        }
            
        //System.out.println(cleanStr);
        return palindromeHelper(cleanStr,0,cleanStr.length()-1);
        
    }

    public boolean palindromeHelper(String str,int start,int end) {
        char c1 = Character.toLowerCase(str.charAt(start));
        char c2 = Character.toLowerCase(str.charAt(end));

        if (start>=end){
            return true;
        }
        else if (c1!=c2){
            return false;
        }
        else {
            return palindromeHelper(str,start+1,end-1);
        }

        
    }
}
