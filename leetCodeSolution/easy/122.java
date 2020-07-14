// 1) 
// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxProfit = 0;
//         int i = 0;
//         int valley = prices[0];
//         int peak = prices[0];
        
        
//         while ( i < prices.length - 1){
            
//             while ( i < prices.length - 1 && prices[i] >= prices[i+1] )
//                 i++;
            
//             valley = prices[i];
            
//             while ( i < prices.length - 1 && prices[i] <= prices[i+1] )
//                 i++;
//             peak = prices[i];
            
//             maxProfit += peak - valley;            
//         }
        
//         return maxProfit;
//     }
// }

// 2) 
// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxProfit = 0;
       
//         for ( int i = 0; i < prices.length - 1; i++)
//             if( prices[i] < prices[i+1] )
//                 maxProfit += prices[i+1] - prices[i];
        
//         return maxProfit;
//     }
// }


class Solution {
    public int maxProfit(int[] prices) {
        int max_pro=0;
        for(int i=prices.length-1;i>0;i--)
            if(prices[i]-prices[i-1]>0) max_pro+=prices[i]-prices[i-1];
        
    return max_pro;
    }
}


