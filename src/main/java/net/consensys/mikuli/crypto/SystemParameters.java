package net.consensys.mikuli.crypto;

import org.apache.milagro.amcl.BLS381.BIG;
import org.apache.milagro.amcl.BLS381.ECP;
import org.apache.milagro.amcl.BLS381.ROM;
import net.consensys.mikuli.crypto.group.G1Point;

public class SystemParameters {
  static public final G1Point g1Generator = new G1Point(ECP.generator());
  static public final BIG curveOrder = new BIG(ROM.CURVE_Order);
}
