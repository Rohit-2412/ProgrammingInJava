// 06-07-2022 17:38 July

package DSA.Greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
    
    }
    
    double fractionalKnapsack(int w, Item[] arr, int n) {
        Arrays.sort(arr, (Item o1, Item o2) -> {
            double r1 = (double) o1.value / o1.weight;
            double r2 = (double) o2.value / o2.weight;
            
            if (r1 < r2) {
                return 1;
            }
            else {
                return -1;
            }
        });
        
        double maxProfit = 0;
        int currentWeight = w;
        
        for (Item item : arr) {
            if (item.weight <= currentWeight) {
                maxProfit += item.value;
                currentWeight -= item.weight;
            }
            else {
                maxProfit += (double) (currentWeight * item.value) /(double) item.weight;
                break;
            }
        }
        
        return maxProfit;
    }
}

class Item {
    int value, weight;
    
    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}