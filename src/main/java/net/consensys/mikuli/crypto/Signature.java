package net.consensys.mikuli.crypto;

import net.consensys.mikuli.crypto.group.G2Point;

public final class Signature {
  private final G2Point point;

  Signature(G2Point point) {
    if (point == null) {
      throw new NullPointerException("Signature was not properly initialized");
    }
    this.point = point;
  }

  @Override
  public String toString() {
    return "Signature [ecpPoint=" + point + "]";
  }

  public Signature combine(Signature sig) {
    return new Signature(point.add(sig.point));
  }

  /**
   * Signature serialization
   * 
   * @return byte array representation of the signature, not null
   */
  public byte[] encode() {
    return point.toBytes();
  }

  public static Signature decode(byte[] bytes) {
    G2Point point = G2Point.fromBytes(bytes);
    return new Signature(point);
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
    Signature other = (Signature) obj;
    if (point == null) {
      if (other.point != null)
        return false;
    } else if (!point.equals(other.point))
      return false;
    return true;
  }

  G2Point g2Point() {
    return point;
  }
}
