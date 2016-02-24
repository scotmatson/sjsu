package partA;

/**
 * Created by scot on 2/20/15.
 */
public class Assignment_Tester {

    public static void main(String[] args) {

        Assignment assn = new Assignment(100);

        assn.setScore(57);
        System.out.println(assn.getScore());
        System.out.println("Expected: 57");

        System.out.println("Score is: %" + assn.getGradeAsPercentage());

//        assn.setScore(-19);
//        System.out.println(assn.getScore());
//        System.out.println("Expected: 0");
//
//        assn.setScore(157);
//        System.out.println(assn.getScore());
//        System.out.println("Expected: 100");
    }

}
