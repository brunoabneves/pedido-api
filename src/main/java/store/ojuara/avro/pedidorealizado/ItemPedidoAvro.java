/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package store.ojuara.avro.pedidorealizado;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ItemPedidoAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6900093091983093925L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ItemPedidoAvro\",\"namespace\":\"store.ojuara.avro.pedidorealizado\",\"fields\":[{\"name\":\"idPedido\",\"type\":\"int\"},{\"name\":\"uuidProduto\",\"type\":{\"type\":\"string\",\"logicalType\":\"UUID\"}},{\"name\":\"quantidade\",\"type\":\"int\"},{\"name\":\"subtotal\",\"type\":{\"type\":\"string\",\"java-class\":\"java.math.BigDecimal\",\"logicalType\":\"decimal\",\"precision\":7,\"scale\":2}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ItemPedidoAvro> ENCODER =
      new BinaryMessageEncoder<ItemPedidoAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ItemPedidoAvro> DECODER =
      new BinaryMessageDecoder<ItemPedidoAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ItemPedidoAvro> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ItemPedidoAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ItemPedidoAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ItemPedidoAvro>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ItemPedidoAvro to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ItemPedidoAvro from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ItemPedidoAvro instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ItemPedidoAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int idPedido;
  private java.lang.CharSequence uuidProduto;
  private int quantidade;
  private java.math.BigDecimal subtotal;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ItemPedidoAvro() {}

  /**
   * All-args constructor.
   * @param idPedido The new value for idPedido
   * @param uuidProduto The new value for uuidProduto
   * @param quantidade The new value for quantidade
   * @param subtotal The new value for subtotal
   */
  public ItemPedidoAvro(java.lang.Integer idPedido, java.lang.CharSequence uuidProduto, java.lang.Integer quantidade, java.math.BigDecimal subtotal) {
    this.idPedido = idPedido;
    this.uuidProduto = uuidProduto;
    this.quantidade = quantidade;
    this.subtotal = subtotal;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return idPedido;
    case 1: return uuidProduto;
    case 2: return quantidade;
    case 3: return subtotal;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: idPedido = (java.lang.Integer)value$; break;
    case 1: uuidProduto = (java.lang.CharSequence)value$; break;
    case 2: quantidade = (java.lang.Integer)value$; break;
    case 3: subtotal = (java.math.BigDecimal)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'idPedido' field.
   * @return The value of the 'idPedido' field.
   */
  public int getIdPedido() {
    return idPedido;
  }


  /**
   * Sets the value of the 'idPedido' field.
   * @param value the value to set.
   */
  public void setIdPedido(int value) {
    this.idPedido = value;
  }

  /**
   * Gets the value of the 'uuidProduto' field.
   * @return The value of the 'uuidProduto' field.
   */
  public java.lang.CharSequence getUuidProduto() {
    return uuidProduto;
  }


  /**
   * Sets the value of the 'uuidProduto' field.
   * @param value the value to set.
   */
  public void setUuidProduto(java.lang.CharSequence value) {
    this.uuidProduto = value;
  }

  /**
   * Gets the value of the 'quantidade' field.
   * @return The value of the 'quantidade' field.
   */
  public int getQuantidade() {
    return quantidade;
  }


  /**
   * Sets the value of the 'quantidade' field.
   * @param value the value to set.
   */
  public void setQuantidade(int value) {
    this.quantidade = value;
  }

  /**
   * Gets the value of the 'subtotal' field.
   * @return The value of the 'subtotal' field.
   */
  public java.math.BigDecimal getSubtotal() {
    return subtotal;
  }


  /**
   * Sets the value of the 'subtotal' field.
   * @param value the value to set.
   */
  public void setSubtotal(java.math.BigDecimal value) {
    this.subtotal = value;
  }

  /**
   * Creates a new ItemPedidoAvro RecordBuilder.
   * @return A new ItemPedidoAvro RecordBuilder
   */
  public static store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder newBuilder() {
    return new store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder();
  }

  /**
   * Creates a new ItemPedidoAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ItemPedidoAvro RecordBuilder
   */
  public static store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder newBuilder(store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder other) {
    if (other == null) {
      return new store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder();
    } else {
      return new store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder(other);
    }
  }

  /**
   * Creates a new ItemPedidoAvro RecordBuilder by copying an existing ItemPedidoAvro instance.
   * @param other The existing instance to copy.
   * @return A new ItemPedidoAvro RecordBuilder
   */
  public static store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder newBuilder(store.ojuara.avro.pedidorealizado.ItemPedidoAvro other) {
    if (other == null) {
      return new store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder();
    } else {
      return new store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder(other);
    }
  }

  /**
   * RecordBuilder for ItemPedidoAvro instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ItemPedidoAvro>
    implements org.apache.avro.data.RecordBuilder<ItemPedidoAvro> {

    private int idPedido;
    private java.lang.CharSequence uuidProduto;
    private int quantidade;
    private java.math.BigDecimal subtotal;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.idPedido)) {
        this.idPedido = data().deepCopy(fields()[0].schema(), other.idPedido);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.uuidProduto)) {
        this.uuidProduto = data().deepCopy(fields()[1].schema(), other.uuidProduto);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.quantidade)) {
        this.quantidade = data().deepCopy(fields()[2].schema(), other.quantidade);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.subtotal)) {
        this.subtotal = data().deepCopy(fields()[3].schema(), other.subtotal);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing ItemPedidoAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(store.ojuara.avro.pedidorealizado.ItemPedidoAvro other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.idPedido)) {
        this.idPedido = data().deepCopy(fields()[0].schema(), other.idPedido);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.uuidProduto)) {
        this.uuidProduto = data().deepCopy(fields()[1].schema(), other.uuidProduto);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.quantidade)) {
        this.quantidade = data().deepCopy(fields()[2].schema(), other.quantidade);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.subtotal)) {
        this.subtotal = data().deepCopy(fields()[3].schema(), other.subtotal);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'idPedido' field.
      * @return The value.
      */
    public int getIdPedido() {
      return idPedido;
    }


    /**
      * Sets the value of the 'idPedido' field.
      * @param value The value of 'idPedido'.
      * @return This builder.
      */
    public store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder setIdPedido(int value) {
      validate(fields()[0], value);
      this.idPedido = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'idPedido' field has been set.
      * @return True if the 'idPedido' field has been set, false otherwise.
      */
    public boolean hasIdPedido() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'idPedido' field.
      * @return This builder.
      */
    public store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder clearIdPedido() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'uuidProduto' field.
      * @return The value.
      */
    public java.lang.CharSequence getUuidProduto() {
      return uuidProduto;
    }


    /**
      * Sets the value of the 'uuidProduto' field.
      * @param value The value of 'uuidProduto'.
      * @return This builder.
      */
    public store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder setUuidProduto(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.uuidProduto = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'uuidProduto' field has been set.
      * @return True if the 'uuidProduto' field has been set, false otherwise.
      */
    public boolean hasUuidProduto() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'uuidProduto' field.
      * @return This builder.
      */
    public store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder clearUuidProduto() {
      uuidProduto = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'quantidade' field.
      * @return The value.
      */
    public int getQuantidade() {
      return quantidade;
    }


    /**
      * Sets the value of the 'quantidade' field.
      * @param value The value of 'quantidade'.
      * @return This builder.
      */
    public store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder setQuantidade(int value) {
      validate(fields()[2], value);
      this.quantidade = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'quantidade' field has been set.
      * @return True if the 'quantidade' field has been set, false otherwise.
      */
    public boolean hasQuantidade() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'quantidade' field.
      * @return This builder.
      */
    public store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder clearQuantidade() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'subtotal' field.
      * @return The value.
      */
    public java.math.BigDecimal getSubtotal() {
      return subtotal;
    }


    /**
      * Sets the value of the 'subtotal' field.
      * @param value The value of 'subtotal'.
      * @return This builder.
      */
    public store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder setSubtotal(java.math.BigDecimal value) {
      validate(fields()[3], value);
      this.subtotal = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'subtotal' field has been set.
      * @return True if the 'subtotal' field has been set, false otherwise.
      */
    public boolean hasSubtotal() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'subtotal' field.
      * @return This builder.
      */
    public store.ojuara.avro.pedidorealizado.ItemPedidoAvro.Builder clearSubtotal() {
      subtotal = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ItemPedidoAvro build() {
      try {
        ItemPedidoAvro record = new ItemPedidoAvro();
        record.idPedido = fieldSetFlags()[0] ? this.idPedido : (java.lang.Integer) defaultValue(fields()[0]);
        record.uuidProduto = fieldSetFlags()[1] ? this.uuidProduto : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.quantidade = fieldSetFlags()[2] ? this.quantidade : (java.lang.Integer) defaultValue(fields()[2]);
        record.subtotal = fieldSetFlags()[3] ? this.subtotal : (java.math.BigDecimal) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ItemPedidoAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<ItemPedidoAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ItemPedidoAvro>
    READER$ = (org.apache.avro.io.DatumReader<ItemPedidoAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.idPedido);

    out.writeString(this.uuidProduto);

    out.writeInt(this.quantidade);

    out.writeString(this.subtotal.toString());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.idPedido = in.readInt();

      this.uuidProduto = in.readString(this.uuidProduto instanceof Utf8 ? (Utf8)this.uuidProduto : null);

      this.quantidade = in.readInt();

      this.subtotal = new java.math.BigDecimal(in.readString());

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.idPedido = in.readInt();
          break;

        case 1:
          this.uuidProduto = in.readString(this.uuidProduto instanceof Utf8 ? (Utf8)this.uuidProduto : null);
          break;

        case 2:
          this.quantidade = in.readInt();
          break;

        case 3:
          this.subtotal = new java.math.BigDecimal(in.readString());
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










