/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package ch.demo.gpietro.schema;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EventPatientPlanned extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2660420529331254258L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EventPatientPlanned\",\"namespace\":\"ch.demo.gpietro.schema\",\"fields\":[{\"name\":\"patientId\",\"type\":\"long\"},{\"name\":\"episodeOfCareId\",\"type\":\"long\"},{\"name\":\"wardId\",\"type\":\"long\"},{\"name\":\"date\",\"type\":{\"type\":\"long\",\"connect.version\":1,\"connect.name\":\"org.apache.kafka.connect.data.Timestamp\",\"logicalType\":\"timestamp-millis\"}}],\"version\":\"1\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();
static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<EventPatientPlanned> ENCODER =
      new BinaryMessageEncoder<EventPatientPlanned>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EventPatientPlanned> DECODER =
      new BinaryMessageDecoder<EventPatientPlanned>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EventPatientPlanned> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EventPatientPlanned> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EventPatientPlanned> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EventPatientPlanned>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EventPatientPlanned to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EventPatientPlanned from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EventPatientPlanned instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EventPatientPlanned fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private long patientId;
   private long episodeOfCareId;
   private long wardId;
   private java.time.Instant date;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EventPatientPlanned() {}

  /**
   * All-args constructor.
   * @param patientId The new value for patientId
   * @param episodeOfCareId The new value for episodeOfCareId
   * @param wardId The new value for wardId
   * @param date The new value for date
   */
  public EventPatientPlanned(java.lang.Long patientId, java.lang.Long episodeOfCareId, java.lang.Long wardId, java.time.Instant date) {
    this.patientId = patientId;
    this.episodeOfCareId = episodeOfCareId;
    this.wardId = wardId;
    this.date = date.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return patientId;
    case 1: return episodeOfCareId;
    case 2: return wardId;
    case 3: return date;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: patientId = (java.lang.Long)value$; break;
    case 1: episodeOfCareId = (java.lang.Long)value$; break;
    case 2: wardId = (java.lang.Long)value$; break;
    case 3: date = (java.time.Instant)value$; break;
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
   * Gets the value of the 'date' field.
   * @return The value of the 'date' field.
   */
  public java.time.Instant getDate() {
    return date;
  }


  /**
   * Sets the value of the 'date' field.
   * @param value the value to set.
   */
  public void setDate(java.time.Instant value) {
    this.date = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Creates a new EventPatientPlanned RecordBuilder.
   * @return A new EventPatientPlanned RecordBuilder
   */
  public static ch.demo.gpietro.schema.EventPatientPlanned.Builder newBuilder() {
    return new ch.demo.gpietro.schema.EventPatientPlanned.Builder();
  }

  /**
   * Creates a new EventPatientPlanned RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EventPatientPlanned RecordBuilder
   */
  public static ch.demo.gpietro.schema.EventPatientPlanned.Builder newBuilder(ch.demo.gpietro.schema.EventPatientPlanned.Builder other) {
    if (other == null) {
      return new ch.demo.gpietro.schema.EventPatientPlanned.Builder();
    } else {
      return new ch.demo.gpietro.schema.EventPatientPlanned.Builder(other);
    }
  }

  /**
   * Creates a new EventPatientPlanned RecordBuilder by copying an existing EventPatientPlanned instance.
   * @param other The existing instance to copy.
   * @return A new EventPatientPlanned RecordBuilder
   */
  public static ch.demo.gpietro.schema.EventPatientPlanned.Builder newBuilder(ch.demo.gpietro.schema.EventPatientPlanned other) {
    if (other == null) {
      return new ch.demo.gpietro.schema.EventPatientPlanned.Builder();
    } else {
      return new ch.demo.gpietro.schema.EventPatientPlanned.Builder(other);
    }
  }

  /**
   * RecordBuilder for EventPatientPlanned instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EventPatientPlanned>
    implements org.apache.avro.data.RecordBuilder<EventPatientPlanned> {

    private long patientId;
    private long episodeOfCareId;
    private long wardId;
    private java.time.Instant date;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(ch.demo.gpietro.schema.EventPatientPlanned.Builder other) {
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
      if (isValidValue(fields()[3], other.date)) {
        this.date = data().deepCopy(fields()[3].schema(), other.date);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing EventPatientPlanned instance
     * @param other The existing instance to copy.
     */
    private Builder(ch.demo.gpietro.schema.EventPatientPlanned other) {
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
      if (isValidValue(fields()[3], other.date)) {
        this.date = data().deepCopy(fields()[3].schema(), other.date);
        fieldSetFlags()[3] = true;
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
    public ch.demo.gpietro.schema.EventPatientPlanned.Builder setPatientId(long value) {
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
    public ch.demo.gpietro.schema.EventPatientPlanned.Builder clearPatientId() {
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
    public ch.demo.gpietro.schema.EventPatientPlanned.Builder setEpisodeOfCareId(long value) {
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
    public ch.demo.gpietro.schema.EventPatientPlanned.Builder clearEpisodeOfCareId() {
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
    public ch.demo.gpietro.schema.EventPatientPlanned.Builder setWardId(long value) {
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
    public ch.demo.gpietro.schema.EventPatientPlanned.Builder clearWardId() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'date' field.
      * @return The value.
      */
    public java.time.Instant getDate() {
      return date;
    }


    /**
      * Sets the value of the 'date' field.
      * @param value The value of 'date'.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.EventPatientPlanned.Builder setDate(java.time.Instant value) {
      validate(fields()[3], value);
      this.date = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'date' field has been set.
      * @return True if the 'date' field has been set, false otherwise.
      */
    public boolean hasDate() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'date' field.
      * @return This builder.
      */
    public ch.demo.gpietro.schema.EventPatientPlanned.Builder clearDate() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EventPatientPlanned build() {
      try {
        EventPatientPlanned record = new EventPatientPlanned();
        record.patientId = fieldSetFlags()[0] ? this.patientId : (java.lang.Long) defaultValue(fields()[0]);
        record.episodeOfCareId = fieldSetFlags()[1] ? this.episodeOfCareId : (java.lang.Long) defaultValue(fields()[1]);
        record.wardId = fieldSetFlags()[2] ? this.wardId : (java.lang.Long) defaultValue(fields()[2]);
        record.date = fieldSetFlags()[3] ? this.date : (java.time.Instant) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EventPatientPlanned>
    WRITER$ = (org.apache.avro.io.DatumWriter<EventPatientPlanned>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EventPatientPlanned>
    READER$ = (org.apache.avro.io.DatumReader<EventPatientPlanned>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










