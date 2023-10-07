import java.util.*;
public class Container_with_most_water {

    public static int waterArea(ArrayList<Integer> height){
        int maxWater = 0;

        //brute force - O(n^2)
        // for(int i = 0; i < height.size(); i++){
        //     for(int j = i+1; j < height.size(); j++){
        //         int h = Math.min(height.get(i),height.get(j));
        //         int w = j-i;
        //         int water = h*w;
        //         if(water>maxWater){
        //             maxWater = water;
        //         }
        //     }
        // }

        //optimized sol - O(n)
        //2 pointer approach

        int lp = 0;
        int rp = height.size()-1;
        while(lp<rp){
            //calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp-lp;
            int currWater = ht*width;
            maxWater = Math.max(maxWater,currWater);

            //update values
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }

        }
        return maxWater;
        
    }
    
    public static void main(String args[]){
        ArrayList<Integer> height = new ArrayList<>();
        // 1 8 6 2 5 4 8 3 7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        int res = waterArea(height);
        System.out.println(res);
    }
}
