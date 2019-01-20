package net.consensys.mikuli.crypto;

import org.apache.milagro.amcl.RAND;
import org.apache.milagro.amcl.BLS381.BIG;
import org.apache.milagro.amcl.BLS381.ECP;
import org.apache.milagro.amcl.BLS381.ECP2;
import org.apache.milagro.amcl.BLS381.ROM;
import net.consensys.mikuli.crypto.group.G1Point;
import net.consensys.mikuli.crypto.group.Scalar;

public final class KeyPairFactory {

  static public KeyPair createKeyPair() {
    G1Point g1Generator = SystemParameters.g1Generator;
    RAND rng = new RAND();

    Scalar secret = new Scalar(BIG.randomnum(SystemParameters.curveOrder, rng));

    PrivateKey privateKey = new PrivateKey(secret);
    G1Point g1Point = g1Generator.mul(secret);
    PublicKey publicKey = new PublicKey(g1Point);
    return new KeyPair(privateKey, publicKey);
  }
}
