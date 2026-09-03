class Solution {
    public boolean isAnagram(String s, String t) {

        
		 Hashtable<Character, Integer> tableS = new Hashtable<>();
		 Hashtable<Character, Integer> tableT = new Hashtable<>();
		 
		 
		 if (s.length() != t.length()) {
			 return false;
		 }
		 else {
			 for (int i=0;i<s.length();i++) {
				 char c = s.charAt(i);
				 
				 if (tableS.containsKey(c)==false) {
					 tableS.put(c, 1);
				 }
				 else {
					 int value=tableS.get(c);
					 tableS.put(c, value+1);
				 }
				 
				 //repeat for 2nd word
				 c = t.charAt(i);
				 if (tableT.containsKey(c)==false) {
					 tableT.put(c, 1);
				 }
				 else {
					 int value=tableT.get(c);
					 tableT.put(c, value+1);
				 }	 
			 }
			 for (Character c : tableS.keySet()) {
				 if (tableT.containsKey(c)==false) {
					 return false;
				 }
				 else {
					 if (!tableS.get(c).equals(tableT.get(c))) {
						 return false;
					 }
				 }
			 }
			return true; 
		 }
    }
}
