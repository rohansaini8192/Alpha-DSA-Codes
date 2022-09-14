public class SubsetsOfString {
    public static void subsets(String str,String ans, int i) {
        if(i==str.length()) {
            if(ans.length()==0) {
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return;
        }
        subsets(str,ans+str.charAt(i), i+1);
        subsets(str,ans, i+1);
    }
    public static void main(String args[]) {
        subsets("abc","", 0);
    }
}