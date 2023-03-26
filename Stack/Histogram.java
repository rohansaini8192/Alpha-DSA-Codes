import java.util.Stack;

public class Histogram {
    public static int maxArea(int heights[]) {
        int maxArea = 0;
        int nsl[] = new int[heights.length];
        int nsr[] = new int[heights.length];
        // next smaller left
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<heights.length; i++) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            }
            else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        // next smaller right
        s = new Stack<>();
        for(int i=heights.length-1; i>=0; i--) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = heights.length;
            }
            else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // area
        for(int i=0; i<heights.length; i++) {
            int height = heights[i];
            int width = nsr[i]-nsl[i]-1;
            int currArea = height*width;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int heights[] = {2,1,5,7,2,3};
        System.out.println("Max area of rectangle is " + maxArea(heights));
    }
}