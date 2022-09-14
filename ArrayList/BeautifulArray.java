import java.util.ArrayList;

public class BeautifulArray {
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i=2; i<=n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();    
            // odd elements
            for(Integer el : ans) {
                if(2*el-1 <= n) {
                    temp.add(2*el-1);
                }
            }
            // even elements
            for(Integer el : ans) {
                if(2*el <= n) {
                    temp.add(2*el);
                }
            }
            ans = temp;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(beautifulArray(4));
    }
}
