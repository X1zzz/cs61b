/**
 *  Tests the Planet constructor.
 */
public class TestPlanetConstructor {

    /**
     *  Tests the Planet constructor to make sure it's working correctly.
     */
    public static void main(String[] args) {
        checkPlanetConstructor();
    }

    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     */
    private static void checkEquals(double expected, double actual, String label) {
        if (expected == actual) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     *  Checks whether or not two Strings are equal and prints the result.
     *  @param  expected    Expected String
     *  @param  actual      String received
     *  @param  label       Label for the 'test' case
     */
    private static void checkStringEquals(String expected, String actual, String label) {
        if (expected.equals(actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     *  Checks Planet constructors to make sure they are setting instance
     *  variables correctly.
     */
    private static void checkPlanetConstructor() {
        System.out.println("Checking first Planet constructor...");

        double xxPos = 1.0,
               yyPos = 2.0,
               xxVel = 3.0,
               yyVel = 4.0,
               mass = 5.0;

        String imgFileName = "jupiter.gif";

        Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);

        checkEquals(xxPos, p.xxPos, "xxPos");
        checkEquals(yyPos, p.yyPos, "yyPos");
        checkEquals(xxVel ,p.xxVel, "xxVel");
        checkEquals(yyVel, p.yyVel, "yyVel");
        checkEquals(mass, p.mass, "mass");
        checkStringEquals(imgFileName, p.imgFileName, "path to image");

        System.out.println("Checking second Planet constructor...");

        Planet pCopy = new Planet(p);
        checkEquals(p.xxPos, pCopy.xxPos, "xxPos");
        checkEquals(p.yyPos, pCopy.yyPos, "yyPos");
        checkEquals(p.xxVel, pCopy.xxVel, "xxVel");
        checkEquals(p.yyVel, pCopy.yyVel, "yyVel");
        checkEquals(p.mass, pCopy.mass, "mass");
        checkStringEquals(p.imgFileName, pCopy.imgFileName, "path to image");
    }
}





//class Planet {
//    public double xxPos;    // Its current x position
//    public double yyPos;    // Its current y position
//    public double xxVel;    // Its current velocity in the x direction
//    public double yyVel;    // Its current velocity in the y direction
//    public double mass;     // Its mass
//    // The name of the file that corresponds to the image that depicts the planet
//    // (for example, jupiter.gif)
//    public String imgFileName;
//
//    public Planet(double xP, double yP, double xV,
//                  double yV, double m, String img) {
//        xxPos = xP;
//        yyPos = yP;
//        xxVel = xV;
//        yyVel = yV;
//        mass = m;
//        imgFileName = img;
//    }
//
//    // copy constructor
//    public Planet(Planet p)
//    {
//        xxPos = p.xxPos;
//        yyPos = p.yyPos;
//        xxVel = p.xxVel;
//        yyVel = p.yyVel;
//        mass = p.mass;
//        imgFileName = p.imgFileName;
//    }
//
//
//
//}