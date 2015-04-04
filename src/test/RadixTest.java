package test.radix;

import radix.Radix;
import radix.RadixException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RadixTest {
  @Test
  public void testBaseTen() throws RadixException {
    String alphabet = "abcdefghij"; // 10

    Radix radix = new Radix(alphabet);
    assertEquals("ba", radix.fromDecimal(10L));
    assertEquals(10L, radix.toDecimal("ba"));

    assertEquals("bab", radix.fromDecimal(101L));
    assertEquals(101L, radix.toDecimal("bab"));
  }

  @Test
  public void testBaseThirtySix() throws RadixException {
    String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 36

    Radix radix = new Radix(alphabet);
    assertEquals("CRE66I9S", radix.fromDecimal(1000000000000L));
    assertEquals(1000000000000L, radix.toDecimal("CRE66I9S"));
  }

  @Test
  public void testHexadecimal() throws RadixException {
    String alphabet = "0123456789ABCDEF"; // 

    Radix radix = new Radix(alphabet);
    assertEquals("3CC3", radix.fromDecimal(15555));
    assertEquals(15555, radix.toDecimal("3CC3"));
  }

  @Test
  public void testBinary() throws RadixException {
    String alphabet = "01";  

    Radix radix = new Radix(alphabet);
    assertEquals("111000011000101001100111000000", radix.fromDecimal(945985984));
    assertEquals(945985984, radix.toDecimal("111000011000101001100111000000"));
  }
}
