/*
    calculate Maximum number of chocolates can eat and Number of wrappers left in hand.
    Money: Total money one has to spend.
    Price: price per chocolate.
    wrappers: minimum number of wrappers for exchange choco: number of chocolate for wrappers.
    Max visit: Maximum number of times one can visit the shop.(if zero consider it infinite)

    example: 
    input: Money:40 Price:1 wrappers:3 choco:1 Max visit:1 
    Output: total chocolate can eat: 53 wrappers left in hand:14
 */
class Solution{
    public void calc(int Money,int Price, int wrappers,int choco,int Max_visit){
        int tot = 0;
        int wrappersleft = 0;

        tot += Money/Price;
        wrappersleft = tot;

        while(Max_visit !=0 ){

            if(wrappersleft>=wrappers){
                tot+=wrappersleft/wrappers;
                wrappersleft = wrappersleft/wrappers;
                wrappersleft +=wrappersleft%wrappers;
            }else{
                return;
            }

            Max_visit--;
        }


        System.out.println("Total chocolate can eat: "+tot);
        System.out.println("Wrappers left in hand: "+wrappersleft);
    }
}

public class Chocolates{
    public static void main(String args[]){
        Solution sol = new Solution();

        int Money=40, Price=1, wrappers=3, choco=1, Max_visit=1;
        sol.calc(Money, Price, wrappers, choco, Max_visit);
    }
}