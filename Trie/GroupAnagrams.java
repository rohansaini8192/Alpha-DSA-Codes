import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    static class Node {
        Node child[] = new Node[26];
        boolean eow = false;
        List<String> angrms = new ArrayList<>();
        Node() {
            for(int i=0; i<26; i++) {
                child[i] = null;
            }
        }
    }
    static Node root = new Node();
    static List<List<String>> ans;
    public static List<List<String>> groupAnagrams(String strs[]) {
        ans = new ArrayList<>();
        // create trie
        for(String s : strs) {
            insert(s);
        }
        // DFS traversing
        dfs(root);
        return ans;
    }
    public static void insert(String s) {
        Node curr = root;
        char word[] = s.toCharArray();
        Arrays.sort(word);
        for(char ch : word) {
            int idx = ch - 'a';
            if(curr.child[idx]==null) {
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
        curr.eow = true;
        curr.angrms.add(s);
    }
    public static void dfs(Node root) {
        if(root.eow) {
            ans.add(root.angrms);
        }
        for(int i=0; i<26; i++) {
            if(root.child[i] != null) {
                dfs(root.child[i]);
            }
        }
    }
    public static void main(String[] args) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
