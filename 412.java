/**
412. Fizz Buzz
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output ¡°Fizz¡± instead of the number and for the multiples of five output ¡°Buzz¡±. For numbers which are multiples of both three and five output ¡°FizzBuzz¡±.
*/
public class Solution {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = FIZZ+BUZZ;
    public List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<>();
        for(int i = 1; i<=n;i++)
        {
            final boolean multi3 = (i%3==0);
            final boolean multi5 = (i%5==0);
            if(multi3)
            {
                output.add(multi5?FIZZBUZZ:FIZZ);
            }
            else if(multi5)
            {
                output.add(BUZZ);
            }
            else
            {
                output.add(i+"");
            }
        }
        return output;
    }
}