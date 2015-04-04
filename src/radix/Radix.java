package radix;
import radix.RadixException;

public class Radix {
  private String alphabet;
  private long base;

  public Radix(String alphabet) {
    this.alphabet = alphabet;
    this.base = alphabet.length();
  }

  public String fromDecimal(long number) {
    int numDigits;
    String result = "";

    if(number == 0) {
      numDigits = 1;
    } else {
      numDigits = (int) Math.floor(Math.log(number) / Math.log(base)) + 1;
    }

    for(int i = 0; i < numDigits; i++) {
      Double n = number / Math.pow(base, i);
      Long digit = n.longValue() % base;
      result = alphabet.charAt(digit.intValue()) + result;
    }
    return result;
  }

  public long toDecimal(String encoded) throws RadixException {
    long accum = 0L;
    String revEncoded = new StringBuilder(encoded).reverse().toString();
    for (int i =  0; i < revEncoded.length(); i++) {
      char c = revEncoded.charAt(i);
      int index = alphabet.indexOf(c);
      if(index == -1) {
        throw new RadixException("Character not in alphabet: " + c);
      }
      accum += ((Math.pow(base, i)) * alphabet.indexOf(c));
    }
    return accum;
  }
}
