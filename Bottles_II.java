class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int t=numBottles;
        while(numBottles>=numExchange){
            numBottles-=numExchange;
            numExchange++;
            t++;numBottles++;
        }
        return t;
    }
}
