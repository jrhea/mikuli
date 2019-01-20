package net.consensys.mikuli.crypto;

import net.consensys.mikuli.crypto.group.G2Point;
import net.consensys.mikuli.crypto.group.Scalar;

public final class PrivateKey {

  private final Scalar scalarValue;

  PrivateKey(Scalar value) {
    if (value == null) {
      throw new NullPointerException("PrivateKey was not properly initialized");
    }
    this.scalarValue = value;
  }

  protected G2Point sign(G2Point message) {
    return message.mul(scalarValue);
  }
}
