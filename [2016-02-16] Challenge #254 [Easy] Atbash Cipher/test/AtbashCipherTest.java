import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by marcin on 28.02.16.
 */
public class AtbashCipherTest {
    @org.junit.Test
    public void testEmptyWord() throws Exception {
        assertEquals("",AtbashCipher.ciphre(""));
    }

    @Test
    public void test_foobar() throws Exception {
        assertEquals("ullyzi",AtbashCipher.ciphre("foobar"));
    }

    @Test
    public void testStrangeWord() throws Exception {
        assertEquals("/i/wzrobkiltiznnvi",AtbashCipher.ciphre("/r/dailyprogrammer"));

    }

    @Test
    public void testSentence() throws Exception {
        assertEquals("this is an example of the atbash cipher",AtbashCipher.ciphre("gsrh rh zm vcznkov lu gsv zgyzhs xrksvi"));
    }

    @Test
    public void testBilLetters() throws Exception {
        assertEquals("UlLyzi",AtbashCipher.ciphre("FoObar"));
    }
}
