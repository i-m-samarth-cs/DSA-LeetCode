class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> lst = new ArrayList<> ();

        for(int i =1; i<=n;i++ )
        {
            boolean div3 = i % 3 == 0;
            boolean div5 = i % 5 == 0;

            if(div3 && div5)
            {
                lst.add("FizzBuzz");
            }
            else if(div3)
            {
                lst.add("Fizz");
            }
            else if(div5)
            {
                lst.add("Buzz");
            }
            else
            {
                lst.add(String.valueOf(i));
            }
        }
        return lst;
    }
}
