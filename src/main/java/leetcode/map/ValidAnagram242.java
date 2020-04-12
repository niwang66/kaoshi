package leetcode.map;

public class ValidAnagram242 {
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        boolean res=isAnagram(s,t);
        System.out.println(res);
    }
    public static boolean isAnagram(String s, String t) {
        int len = s.length();
        if(t.length()!=len){
            return false;
        }
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            t = t.replaceFirst(String.valueOf(c),"");
        }
        return t.length()==0;
    }
}
