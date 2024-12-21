import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        boolean actual1 = palindrome.isPalindrome("cat");
        assertEquals(false, actual1);

        boolean actual2 = palindrome.isPalindrome("BooB");
        assertEquals(true, actual2);

        boolean actual3 = palindrome.isPalindrome("B");
        assertEquals(true, actual3);

        boolean actual4 = palindrome.isPalindrome("");
        assertEquals(true, actual4);
    }

    @Test
    public void testIsPalindrome1() {
        CharacterComparator cc = new OffByOne();

        boolean actual1 = palindrome.isPalindrome("cat",cc);
        assertEquals(false, actual1);

        boolean actual2 = palindrome.isPalindrome("dfi2hge",cc);
        assertEquals(true, actual2);

        boolean actual3 = palindrome.isPalindrome("abb",cc);
        assertEquals(true, actual3);

        boolean actual4 = palindrome.isPalindrome("",cc);
        assertEquals(true, actual4);
    }

    @Test
    public void testIsPalindromeN() {
        CharacterComparator cc = new OffByN(5);

        boolean actual1 = palindrome.isPalindrome("cat",cc);
        assertEquals(false, actual1);

        boolean actual2 = palindrome.isPalindrome("1946",cc);
        assertEquals(true, actual2);

        boolean actual3 = palindrome.isPalindrome("abf",cc);
        assertEquals(true, actual3);

        boolean actual4 = palindrome.isPalindrome("",cc);
        assertEquals(true, actual4);
    }



}
