package cn.commandoptionesc.big;

import java.math.BigInteger;

public class BigIntegerDemo {
    public static void main(String[] args) {

        BigInteger b1 = new BigInteger("234234256325345325325");
        BigInteger b2 = new BigInteger("3435352345234642341234252345");
        BigInteger r = b1.multiply(b2);
        System.out.println(r);
    }
}
