class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int[] customer : accounts)
        {
            int customerWealth = 0;

            for(int bank : customer)
            {
                customerWealth +=bank;
            }
            maxWealth = Math.max(maxWealth, customerWealth);
        }
        return maxWealth;
    }
}
