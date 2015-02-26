
public class AdjectiveTester
{
   public static void main(String[] args)
   {
       Adjective word = new Adjective("anxious");
       System.out.println(word.superlative());
       System.out.println("Expected: most anxious");
       
       word.setAdjective("good");
       System.out.println(word.superlative());
       System.out.println("Expected: best");
       
       word.setAdjective("early");
       System.out.println(word.superlative());
       System.out.println("Expected: earliest");
       
       word.setAdjective("bad");
       System.out.println(word.superlative());
       System.out.println("Expected: worst");
       
       word.setAdjective("small");
       System.out.println(word.superlative());
       System.out.println("Expected: smallest");
       
       System.out.println(word.getAdjective());
       System.out.println("Expected: small");
   }


}
