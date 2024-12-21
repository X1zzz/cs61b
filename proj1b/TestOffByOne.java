import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalChars() {
        boolean actual1 = offByOne.equalChars('a', 'b');
        boolean expected1 = true;
        assertEquals(expected1, actual1);

        boolean actual2 = offByOne.equalChars('a', 'd');
        boolean expected2 = false;
        assertEquals(expected2, actual2);
    }




}






