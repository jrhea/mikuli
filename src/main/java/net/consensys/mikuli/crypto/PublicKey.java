package net.consensys.mikuli.crypto;

import net.consensys.mikuli.crypto.group.G1Point;

public final class PublicKey {

  private final G1Point point;

  PublicKey(G1Point point) {
    if (point == null) {
      throw new NullPointerException("PublicKey was not properly initialized");
    }
    this.point = point;
  }

  public PublicKey combine(PublicKey pk) {
    return new PublicKey(point.add(pk.point));
  }

  /**
   * Public key serialization
   * 
   * @return byte array representation of the public key
   */
  public byte[] encode() {
    return point.toBytes();
  }

  public static PublicKey decode(byte[] bytes) {
    G1Point point = G1Point.fromBytes(bytes);
    return new PublicKey(point);
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((point == null) ? 0 : point.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PublicKey other = (PublicKey) obj;
    if (point == null) {
      if (other.point != null)
        return false;
    } else if (!point.equals(other.point))
      return false;
    return true;
  }

  public G1Point g1Point() {
    return point;
  }
}
