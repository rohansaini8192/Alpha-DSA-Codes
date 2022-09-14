import java.util.ArrayList;
public class ContainerOfMostWater {
    public static int mostWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;

        while(lp<rp) {
            int waterHeight = Math.min(height.get(lp), height.get(rp));
            int width = rp-lp;
            int currWater = waterHeight*width;
            maxWater = Math.max(maxWater, currWater);
            if(height.get(lp) < height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(2);
        height.add(9);
        height.add(5);
        height.add(7);
        height.add(3);
        System.out.println(mostWater(height));
    }
}