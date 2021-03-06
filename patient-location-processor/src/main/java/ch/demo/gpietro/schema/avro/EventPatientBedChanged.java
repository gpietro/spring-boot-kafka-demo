/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package ch.demo.gpietro.schema.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EventPatientBedChanged extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4605699666130169576L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EventPatientBedChanged\",\"namespace\":\"ch.demo.gpietro.schema.avro\",\"fields\":[{\"name\":\"patientId\",\"type\":\"long\"},{\"name\":\"episodeOfCareId\",\"type\":\"long\"},{\"name\":\"wardId\",\"type\":\"long\"},{\"name\":\"roomId\",\"type\":\"long\"},{\"name\":\"bedId\",\"type\":\"long\"}],\"version\":\"1\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EventPatientBedChanged> ENCODER =
      new BinaryMessageEncoder<EventPatientBedChanged>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EventPatientBedChanged> DECODER =
      new BinaryMessageDecoder<EventPatientBedChanged>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EventPatientBedChanged> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EventPatientBedChanged> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EventPatientBedChanged> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EventPatientBedChanged>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EventPatientBedChanged to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EventPatientBedChanged from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EventPatientBedChanged instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EventPatientBedChanged fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private long patientId;
   private long episodeOfCareId;
   private long wardId;
   private long roomId;
   private long bedId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EventPatientBedChanged() {}

  /**
   * All-args constructor.
   * @param patientId The new value for patientId
   * @param episodeOfCareId The new value for episodeOfCareId
   * @param wardId The new value for wardId
   * @param roomId The new value for roomId
   * @param bedId The new value for bedId
   */
  public EventPatientBedChanged(java.lang.Long patientId, java.lang.Long episodeOfCareId, java.lang.Long wardId, java.lang.Long roomId, java.lang.Long bedId) {
    this.patientId = patientId;
    this.episodeOfCareId = episodeOfCareId;
    this.wardId = wardId;
    this.roomId = roomId;
    this.bedId = bedId;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return patientId;
    case 1: return episodeOfCareId;
    case 2: return wardId;
    case 3: return roomId;
    case 4: return bedId;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: patientId = (java.lang.Long)value$; break;
    case 1: episodeOfCareId = (java.lang.Long)value$; break;
    case 2: wardId = (java.lang.Long)value$; break;
    case 3: roomId = (java.lang.Long)value$; break;
    case 4: bedId = (java.lang.Long)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'patientId' field.
   * @return The value of the 'patientId' field.
   */
  public long getPatientId() {
    return patientId;
  }


  /**
   * Sets the value of the 'patientId' field.
   * @param value the value to set.
   */
  public void setPatientId(long value) {
    this.patientId = value;
  }

  /**
   * Gets the value of the 'episodeOfCareId' field.
   * @return The value of the 'episodeOfCareId' field.
   */
  public long getEpisodeOfCareId() {
    return episodeOfCareId;
  }


  /**
   * Sets the value of the 'episodeOfCareId' field.
   * @param value the value to set.
   */
  public void setEpisodeOfCareId(long value) {
    this.episodeOfCareId = value;
  }

  /**
   * Gets the value of the 'wardId' field.
   * @return The value of the 'wardId' field.
   */
  public long getWardId() {
    return wardId;
  }


  /**
   * Sets the value of the 'wardId' field.
   * @param value the value to set.
   */
  public void setWardId(long value) {
    this.wardId = value;
  }

  /**
   * Gets the value of the 'roomId' field.
   * @return The value of the 'roomId' field.
   */
  public long getRoomId() {
    return roomId;
  }


  /**
   * Sets the value of the 'roomId' field.
   * @param value the value to set.
   */
  public void setRoomId(long value) {
    this.roomId = value;
  }

  /**
   * Gets the value of the 'bedId' field.
   * @return The value of the 'bedId' field.
   */
  public long getBedId() {
    return bedId;
  }


  /**
   * Sets the value of the 'bedId' field.
   * @param value the value to set.
   */
  public void setBedId(long value) {
    this.bedId = value;
  }

  /**
   * Creates a new EventPatientBedChanged RecordBuilder.
   * @return A new EventPatientBedChanged RecordBuilder
   */
  public static ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder newBuilder() {
    return new ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder();
  }

  /**
   * Creates a new EventPatientBedChanged RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EventPatientBedChanged RecordBuilder
   */
  public static ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder newBuilder(ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder other) {
    if (other == null) {
      return new ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder();
    } else {
      return new ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder(other);
    }
  }

  /**
   * Creates a new EventPatientBedChanged RecordBuilder by copying an existing EventPatientBedChanged instance.
   * @param other The existing instance to copy.
   * @return A new EventPatientBedChanged RecordBuilder
   */
  public static ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder newBuilder(ch.demo.gpietro.schema.avro.EventPatientBedChanged other) {
    if (other == null) {
      return new ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder();
    } else {
      return new ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder(other);
    }
  }

  /**
   * RecordBuilder for EventPatientBedChanged instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EventPatientBedChanged>
    implements org.apache.avro.data.RecordBuilder<EventPatientBedChanged> {

    private long patientId;
    private long episodeOfCareId;
    private long wardId;
    private long roomId;
    private long bedId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.patientId)) {
        this.patientId = data().deepCopy(fields()[0].schema(), other.patientId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.episodeOfCareId)) {
        this.episodeOfCareId = data().deepCopy(fields()[1].schema(), other.episodeOfCareId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.wardId)) {
        this.wardId = data().deepCopy(fields()[2].schema(), other.wardId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.roomId)) {
        this.roomId = data().deepCopy(fields()[3].schema(), other.roomId);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.bedId)) {
        this.bedId = data().deepCopy(fields()[4].schema(), other.bedId);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing EventPatientBedChanged instance
     * @param other The existing instance to copy.
     */
    private Builder(ch.demo.gpietro.schema.avro.EventPatientBedChanged other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.patientId)) {
        this.patientId = data().deepCopy(fields()[0].schema(), other.patientId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.episodeOfCareId)) {
        this.episodeOfCareId = data().deepCopy(fields()[1].schema(), other.episodeOfCareId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.wardId)) {
        this.wardId = data().deepCopy(fields()[2].schema(), other.wardId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.roomId)) {
        this.roomId = data().deepCopy(fields()[3].schema(), other.roomId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.bedId)) {
        this.bedId = data().deepCopy(fields()[4].schema(), other.bedId);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'patientId' field.
      * @return The value.
      */
    public long getPatientId() {
      return patientId;
    }


    /**
      * Sets the value of the 'patientId' field.
      * @param value The value of 'patientId'.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder setPatientId(long value) {
      validate(fields()[0], value);
      this.patientId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'patientId' field has been set.
      * @return True if the 'patientId' field has been set, false otherwise.
      */
    public boolean hasPatientId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'patientId' field.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder clearPatientId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'episodeOfCareId' field.
      * @return The value.
      */
    public long getEpisodeOfCareId() {
      return episodeOfCareId;
    }


    /**
      * Sets the value of the 'episodeOfCareId' field.
      * @param value The value of 'episodeOfCareId'.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder setEpisodeOfCareId(long value) {
      validate(fields()[1], value);
      this.episodeOfCareId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'episodeOfCareId' field has been set.
      * @return True if the 'episodeOfCareId' field has been set, false otherwise.
      */
    public boolean hasEpisodeOfCareId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'episodeOfCareId' field.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder clearEpisodeOfCareId() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'wardId' field.
      * @return The value.
      */
    public long getWardId() {
      return wardId;
    }


    /**
      * Sets the value of the 'wardId' field.
      * @param value The value of 'wardId'.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder setWardId(long value) {
      validate(fields()[2], value);
      this.wardId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'wardId' field has been set.
      * @return True if the 'wardId' field has been set, false otherwise.
      */
    public boolean hasWardId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'wardId' field.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder clearWardId() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'roomId' field.
      * @return The value.
      */
    public long getRoomId() {
      return roomId;
    }


    /**
      * Sets the value of the 'roomId' field.
      * @param value The value of 'roomId'.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder setRoomId(long value) {
      validate(fields()[3], value);
      this.roomId = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'roomId' field has been set.
      * @return True if the 'roomId' field has been set, false otherwise.
      */
    public boolean hasRoomId() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'roomId' field.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder clearRoomId() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'bedId' field.
      * @return The value.
      */
    public long getBedId() {
      return bedId;
    }


    /**
      * Sets the value of the 'bedId' field.
      * @param value The value of 'bedId'.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder setBedId(long value) {
      validate(fields()[4], value);
      this.bedId = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'bedId' field has been set.
      * @return True if the 'bedId' field has been set, false otherwise.
      */
    public boolean hasBedId() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'bedId' field.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.avro.EventPatientBedChanged.Builder clearBedId() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EventPatientBedChanged build() {
      try {
        EventPatientBedChanged record = new EventPatientBedChanged();
        record.patientId = fieldSetFlags()[0] ? this.patientId : (java.lang.Long) defaultValue(fields()[0]);
        record.episodeOfCareId = fieldSetFlags()[1] ? this.episodeOfCareId : (java.lang.Long) defaultValue(fields()[1]);
        record.wardId = fieldSetFlags()[2] ? this.wardId : (java.lang.Long) defaultValue(fields()[2]);
        record.roomId = fieldSetFlags()[3] ? this.roomId : (java.lang.Long) defaultValue(fields()[3]);
        record.bedId = fieldSetFlags()[4] ? this.bedId : (java.lang.Long) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EventPatientBedChanged>
    WRITER$ = (org.apache.avro.io.DatumWriter<EventPatientBedChanged>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EventPatientBedChanged>
    READER$ = (org.apache.avro.io.DatumReader<EventPatientBedChanged>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.patientId);

    out.writeLong(this.episodeOfCareId);

    out.writeLong(this.wardId);

    out.writeLong(this.roomId);

    out.writeLong(this.bedId);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.patientId = in.readLong();

      this.episodeOfCareId = in.readLong();

      this.wardId = in.readLong();

      this.roomId = in.readLong();

      this.bedId = in.readLong();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.patientId = in.readLong();
          break;

        case 1:
          this.episodeOfCareId = in.readLong();
          break;

        case 2:
          this.wardId = in.readLong();
          break;

        case 3:
          this.roomId = in.readLong();
          break;

        case 4:
          this.bedId = in.readLong();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










