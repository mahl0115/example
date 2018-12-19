///**
// * Autogenerated by Thrift Compiler (0.9.3)
// *
// * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
// *  @generated
// */
//package com.thrift.thrift;
//
//import org.apache.thrift.scheme.IScheme;
//import org.apache.thrift.scheme.SchemeFactory;
//import org.apache.thrift.scheme.StandardScheme;
//
//import org.apache.thrift.scheme.TupleScheme;
//import org.apache.thrift.protocol.TTupleProtocol;
//import org.apache.thrift.protocol.TProtocolException;
//import org.apache.thrift.EncodingUtils;
//import org.apache.thrift.TException;
//import org.apache.thrift.async.AsyncMethodCallback;
//import org.apache.thrift.server.AbstractNonblockingServer.*;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.EnumMap;
//import java.util.Set;
//import java.util.HashSet;
//import java.util.EnumSet;
//import java.util.Collections;
//import java.util.BitSet;
//import java.nio.ByteBuffer;
//import java.util.Arrays;
//import javax.annotation.Generated;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
//@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-09-07")
//public class TUser implements org.apache.thrift.TBase<TUser, TUser._Fields>, java.io.Serializable, Cloneable, Comparable<TUser> {
//  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TUser");
//
//  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
//  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I32, (short)2);
//  private static final org.apache.thrift.protocol.TField USER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("userName", org.apache.thrift.protocol.TType.STRING, (short)3);
//  private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)4);
//  private static final org.apache.thrift.protocol.TField AGE_FIELD_DESC = new org.apache.thrift.protocol.TField("age", org.apache.thrift.protocol.TType.I32, (short)5);
//
//  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
//  static {
//    schemes.put(StandardScheme.class, new TUserStandardSchemeFactory());
//    schemes.put(TupleScheme.class, new TUserTupleSchemeFactory());
//  }
//
//  public int id; // required
//  public int userId; // required
//  public String userName; // required
//  public String password; // required
//  public int age; // required
//
//  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
//  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
//    ID((short)1, "id"),
//    USER_ID((short)2, "userId"),
//    USER_NAME((short)3, "userName"),
//    PASSWORD((short)4, "password"),
//    AGE((short)5, "age");
//
//    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();
//
//    static {
//      for (_Fields field : EnumSet.allOf(_Fields.class)) {
//        byName.put(field.getFieldName(), field);
//      }
//    }
//
//    /**
//     * Find the _Fields constant that matches fieldId, or null if its not found.
//     */
//    public static _Fields findByThriftId(int fieldId) {
//      switch(fieldId) {
//        case 1: // ID
//          return ID;
//        case 2: // USER_ID
//          return USER_ID;
//        case 3: // USER_NAME
//          return USER_NAME;
//        case 4: // PASSWORD
//          return PASSWORD;
//        case 5: // AGE
//          return AGE;
//        default:
//          return null;
//      }
//    }
//
//    /**
//     * Find the _Fields constant that matches fieldId, throwing an exception
//     * if it is not found.
//     */
//    public static _Fields findByThriftIdOrThrow(int fieldId) {
//      _Fields fields = findByThriftId(fieldId);
//      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
//      return fields;
//    }
//
//    /**
//     * Find the _Fields constant that matches name, or null if its not found.
//     */
//    public static _Fields findByName(String name) {
//      return byName.get(name);
//    }
//
//    private final short _thriftId;
//    private final String _fieldName;
//
//    _Fields(short thriftId, String fieldName) {
//      _thriftId = thriftId;
//      _fieldName = fieldName;
//    }
//
//    public short getThriftFieldId() {
//      return _thriftId;
//    }
//
//    public String getFieldName() {
//      return _fieldName;
//    }
//  }
//
//  // isset id assignments
//  private static final int __ID_ISSET_ID = 0;
//  private static final int __USERID_ISSET_ID = 1;
//  private static final int __AGE_ISSET_ID = 2;
//  private byte __isset_bitfield = 0;
//  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
//  static {
//    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
//    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT,
//        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
//    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.DEFAULT,
//        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
//    tmpMap.put(_Fields.USER_NAME, new org.apache.thrift.meta_data.FieldMetaData("userName", org.apache.thrift.TFieldRequirementType.DEFAULT,
//        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
//    tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.DEFAULT,
//        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
//    tmpMap.put(_Fields.AGE, new org.apache.thrift.meta_data.FieldMetaData("age", org.apache.thrift.TFieldRequirementType.DEFAULT,
//        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
//    metaDataMap = Collections.unmodifiableMap(tmpMap);
//    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TUser.class, metaDataMap);
//  }
//
//  public TUser() {
//  }
//
//  public TUser(
//    int id,
//    int userId,
//    String userName,
//    String password,
//    int age)
//  {
//    this();
//    this.id = id;
//    setIdIsSet(true);
//    this.userId = userId;
//    setUserIdIsSet(true);
//    this.userName = userName;
//    this.password = password;
//    this.age = age;
//    setAgeIsSet(true);
//  }
//
//  /**
//   * Performs a deep copy on <i>other</i>.
//   */
//  public TUser(TUser other) {
//    __isset_bitfield = other.__isset_bitfield;
//    this.id = other.id;
//    this.userId = other.userId;
//    if (other.isSetUserName()) {
//      this.userName = other.userName;
//    }
//    if (other.isSetPassword()) {
//      this.password = other.password;
//    }
//    this.age = other.age;
//  }
//
//  public TUser deepCopy() {
//    return new TUser(this);
//  }
//
//  @Override
//  public void clear() {
//    setIdIsSet(false);
//    this.id = 0;
//    setUserIdIsSet(false);
//    this.userId = 0;
//    this.userName = null;
//    this.password = null;
//    setAgeIsSet(false);
//    this.age = 0;
//  }
//
//  public int getId() {
//    return this.id;
//  }
//
//  public TUser setId(int id) {
//    this.id = id;
//    setIdIsSet(true);
//    return this;
//  }
//
//  public void unsetId() {
//    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
//  }
//
//  /** Returns true if field id is set (has been assigned a value) and false otherwise */
//  public boolean isSetId() {
//    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
//  }
//
//  public void setIdIsSet(boolean value) {
//    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
//  }
//
//  public int getUserId() {
//    return this.userId;
//  }
//
//  public TUser setUserId(int userId) {
//    this.userId = userId;
//    setUserIdIsSet(true);
//    return this;
//  }
//
//  public void unsetUserId() {
//    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USERID_ISSET_ID);
//  }
//
//  /** Returns true if field userId is set (has been assigned a value) and false otherwise */
//  public boolean isSetUserId() {
//    return EncodingUtils.testBit(__isset_bitfield, __USERID_ISSET_ID);
//  }
//
//  public void setUserIdIsSet(boolean value) {
//    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USERID_ISSET_ID, value);
//  }
//
//  public String getUserName() {
//    return this.userName;
//  }
//
//  public TUser setUserName(String userName) {
//    this.userName = userName;
//    return this;
//  }
//
//  public void unsetUserName() {
//    this.userName = null;
//  }
//
//  /** Returns true if field userName is set (has been assigned a value) and false otherwise */
//  public boolean isSetUserName() {
//    return this.userName != null;
//  }
//
//  public void setUserNameIsSet(boolean value) {
//    if (!value) {
//      this.userName = null;
//    }
//  }
//
//  public String getPassword() {
//    return this.password;
//  }
//
//  public TUser setPassword(String password) {
//    this.password = password;
//    return this;
//  }
//
//  public void unsetPassword() {
//    this.password = null;
//  }
//
//  /** Returns true if field password is set (has been assigned a value) and false otherwise */
//  public boolean isSetPassword() {
//    return this.password != null;
//  }
//
//  public void setPasswordIsSet(boolean value) {
//    if (!value) {
//      this.password = null;
//    }
//  }
//
//  public int getAge() {
//    return this.age;
//  }
//
//  public TUser setAge(int age) {
//    this.age = age;
//    setAgeIsSet(true);
//    return this;
//  }
//
//  public void unsetAge() {
//    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __AGE_ISSET_ID);
//  }
//
//  /** Returns true if field age is set (has been assigned a value) and false otherwise */
//  public boolean isSetAge() {
//    return EncodingUtils.testBit(__isset_bitfield, __AGE_ISSET_ID);
//  }
//
//  public void setAgeIsSet(boolean value) {
//    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __AGE_ISSET_ID, value);
//  }
//
//  public void setFieldValue(_Fields field, Object value) {
//    switch (field) {
//    case ID:
//      if (value == null) {
//        unsetId();
//      } else {
//        setId((Integer)value);
//      }
//      break;
//
//    case USER_ID:
//      if (value == null) {
//        unsetUserId();
//      } else {
//        setUserId((Integer)value);
//      }
//      break;
//
//    case USER_NAME:
//      if (value == null) {
//        unsetUserName();
//      } else {
//        setUserName((String)value);
//      }
//      break;
//
//    case PASSWORD:
//      if (value == null) {
//        unsetPassword();
//      } else {
//        setPassword((String)value);
//      }
//      break;
//
//    case AGE:
//      if (value == null) {
//        unsetAge();
//      } else {
//        setAge((Integer)value);
//      }
//      break;
//
//    }
//  }
//
//  public Object getFieldValue(_Fields field) {
//    switch (field) {
//    case ID:
//      return getId();
//
//    case USER_ID:
//      return getUserId();
//
//    case USER_NAME:
//      return getUserName();
//
//    case PASSWORD:
//      return getPassword();
//
//    case AGE:
//      return getAge();
//
//    }
//    throw new IllegalStateException();
//  }
//
//  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
//  public boolean isSet(_Fields field) {
//    if (field == null) {
//      throw new IllegalArgumentException();
//    }
//
//    switch (field) {
//    case ID:
//      return isSetId();
//    case USER_ID:
//      return isSetUserId();
//    case USER_NAME:
//      return isSetUserName();
//    case PASSWORD:
//      return isSetPassword();
//    case AGE:
//      return isSetAge();
//    }
//    throw new IllegalStateException();
//  }
//
//  @Override
//  public boolean equals(Object that) {
//    if (that == null)
//      return false;
//    if (that instanceof TUser)
//      return this.equals((TUser)that);
//    return false;
//  }
//
//  public boolean equals(TUser that) {
//    if (that == null)
//      return false;
//
//    boolean this_present_id = true;
//    boolean that_present_id = true;
//    if (this_present_id || that_present_id) {
//      if (!(this_present_id && that_present_id))
//        return false;
//      if (this.id != that.id)
//        return false;
//    }
//
//    boolean this_present_userId = true;
//    boolean that_present_userId = true;
//    if (this_present_userId || that_present_userId) {
//      if (!(this_present_userId && that_present_userId))
//        return false;
//      if (this.userId != that.userId)
//        return false;
//    }
//
//    boolean this_present_userName = true && this.isSetUserName();
//    boolean that_present_userName = true && that.isSetUserName();
//    if (this_present_userName || that_present_userName) {
//      if (!(this_present_userName && that_present_userName))
//        return false;
//      if (!this.userName.equals(that.userName))
//        return false;
//    }
//
//    boolean this_present_password = true && this.isSetPassword();
//    boolean that_present_password = true && that.isSetPassword();
//    if (this_present_password || that_present_password) {
//      if (!(this_present_password && that_present_password))
//        return false;
//      if (!this.password.equals(that.password))
//        return false;
//    }
//
//    boolean this_present_age = true;
//    boolean that_present_age = true;
//    if (this_present_age || that_present_age) {
//      if (!(this_present_age && that_present_age))
//        return false;
//      if (this.age != that.age)
//        return false;
//    }
//
//    return true;
//  }
//
//  @Override
//  public int hashCode() {
//    List<Object> list = new ArrayList<Object>();
//
//    boolean present_id = true;
//    list.add(present_id);
//    if (present_id)
//      list.add(id);
//
//    boolean present_userId = true;
//    list.add(present_userId);
//    if (present_userId)
//      list.add(userId);
//
//    boolean present_userName = true && (isSetUserName());
//    list.add(present_userName);
//    if (present_userName)
//      list.add(userName);
//
//    boolean present_password = true && (isSetPassword());
//    list.add(present_password);
//    if (present_password)
//      list.add(password);
//
//    boolean present_age = true;
//    list.add(present_age);
//    if (present_age)
//      list.add(age);
//
//    return list.hashCode();
//  }
//
//  @Override
//  public int compareTo(TUser other) {
//    if (!getClass().equals(other.getClass())) {
//      return getClass().getName().compareTo(other.getClass().getName());
//    }
//
//    int lastComparison = 0;
//
//    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
//    if (lastComparison != 0) {
//      return lastComparison;
//    }
//    if (isSetId()) {
//      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
//      if (lastComparison != 0) {
//        return lastComparison;
//      }
//    }
//    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(other.isSetUserId());
//    if (lastComparison != 0) {
//      return lastComparison;
//    }
//    if (isSetUserId()) {
//      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userId, other.userId);
//      if (lastComparison != 0) {
//        return lastComparison;
//      }
//    }
//    lastComparison = Boolean.valueOf(isSetUserName()).compareTo(other.isSetUserName());
//    if (lastComparison != 0) {
//      return lastComparison;
//    }
//    if (isSetUserName()) {
//      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userName, other.userName);
//      if (lastComparison != 0) {
//        return lastComparison;
//      }
//    }
//    lastComparison = Boolean.valueOf(isSetPassword()).compareTo(other.isSetPassword());
//    if (lastComparison != 0) {
//      return lastComparison;
//    }
//    if (isSetPassword()) {
//      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, other.password);
//      if (lastComparison != 0) {
//        return lastComparison;
//      }
//    }
//    lastComparison = Boolean.valueOf(isSetAge()).compareTo(other.isSetAge());
//    if (lastComparison != 0) {
//      return lastComparison;
//    }
//    if (isSetAge()) {
//      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.age, other.age);
//      if (lastComparison != 0) {
//        return lastComparison;
//      }
//    }
//    return 0;
//  }
//
//  public _Fields fieldForId(int fieldId) {
//    return _Fields.findByThriftId(fieldId);
//  }
//
//  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
//    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
//  }
//
//  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
//    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
//  }
//
//  @Override
//  public String toString() {
//    StringBuilder sb = new StringBuilder("TUser(");
//    boolean first = true;
//
//    sb.append("id:");
//    sb.append(this.id);
//    first = false;
//    if (!first) sb.append(", ");
//    sb.append("userId:");
//    sb.append(this.userId);
//    first = false;
//    if (!first) sb.append(", ");
//    sb.append("userName:");
//    if (this.userName == null) {
//      sb.append("null");
//    } else {
//      sb.append(this.userName);
//    }
//    first = false;
//    if (!first) sb.append(", ");
//    sb.append("password:");
//    if (this.password == null) {
//      sb.append("null");
//    } else {
//      sb.append(this.password);
//    }
//    first = false;
//    if (!first) sb.append(", ");
//    sb.append("age:");
//    sb.append(this.age);
//    first = false;
//    sb.append(")");
//    return sb.toString();
//  }
//
//  public void validate() throws TException {
//    // check for required fields
//    // check for sub-struct validity
//  }
//
//  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
//    try {
//      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
//    } catch (TException te) {
//      throw new java.io.IOException(te);
//    }
//  }
//
//  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
//    try {
//      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
//      __isset_bitfield = 0;
//      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
//    } catch (TException te) {
//      throw new java.io.IOException(te);
//    }
//  }
//
//  private static class TUserStandardSchemeFactory implements SchemeFactory {
//    public TUserStandardScheme getScheme() {
//      return new TUserStandardScheme();
//    }
//  }
//
//  private static class TUserStandardScheme extends StandardScheme<TUser> {
//
//    public void read(org.apache.thrift.protocol.TProtocol iprot, TUser struct) throws TException {
//      org.apache.thrift.protocol.TField schemeField;
//      iprot.readStructBegin();
//      while (true)
//      {
//        schemeField = iprot.readFieldBegin();
//        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
//          break;
//        }
//        switch (schemeField.id) {
//          case 1: // ID
//            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
//              struct.id = iprot.readI32();
//              struct.setIdIsSet(true);
//            } else {
//              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
//            }
//            break;
//          case 2: // USER_ID
//            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
//              struct.userId = iprot.readI32();
//              struct.setUserIdIsSet(true);
//            } else {
//              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
//            }
//            break;
//          case 3: // USER_NAME
//            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
//              struct.userName = iprot.readString();
//              struct.setUserNameIsSet(true);
//            } else {
//              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
//            }
//            break;
//          case 4: // PASSWORD
//            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
//              struct.password = iprot.readString();
//              struct.setPasswordIsSet(true);
//            } else {
//              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
//            }
//            break;
//          case 5: // AGE
//            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
//              struct.age = iprot.readI32();
//              struct.setAgeIsSet(true);
//            } else {
//              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
//            }
//            break;
//          default:
//            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
//        }
//        iprot.readFieldEnd();
//      }
//      iprot.readStructEnd();
//
//      // check for required fields of primitive type, which can't be checked in the validate method
//      struct.validate();
//    }
//
//    public void write(org.apache.thrift.protocol.TProtocol oprot, TUser struct) throws TException {
//      struct.validate();
//
//      oprot.writeStructBegin(STRUCT_DESC);
//      oprot.writeFieldBegin(ID_FIELD_DESC);
//      oprot.writeI32(struct.id);
//      oprot.writeFieldEnd();
//      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
//      oprot.writeI32(struct.userId);
//      oprot.writeFieldEnd();
//      if (struct.userName != null) {
//        oprot.writeFieldBegin(USER_NAME_FIELD_DESC);
//        oprot.writeString(struct.userName);
//        oprot.writeFieldEnd();
//      }
//      if (struct.password != null) {
//        oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
//        oprot.writeString(struct.password);
//        oprot.writeFieldEnd();
//      }
//      oprot.writeFieldBegin(AGE_FIELD_DESC);
//      oprot.writeI32(struct.age);
//      oprot.writeFieldEnd();
//      oprot.writeFieldStop();
//      oprot.writeStructEnd();
//    }
//
//  }
//
//  private static class TUserTupleSchemeFactory implements SchemeFactory {
//    public TUserTupleScheme getScheme() {
//      return new TUserTupleScheme();
//    }
//  }
//
//  private static class TUserTupleScheme extends TupleScheme<TUser> {
//
//    @Override
//    public void write(org.apache.thrift.protocol.TProtocol prot, TUser struct) throws TException {
//      TTupleProtocol oprot = (TTupleProtocol) prot;
//      BitSet optionals = new BitSet();
//      if (struct.isSetId()) {
//        optionals.set(0);
//      }
//      if (struct.isSetUserId()) {
//        optionals.set(1);
//      }
//      if (struct.isSetUserName()) {
//        optionals.set(2);
//      }
//      if (struct.isSetPassword()) {
//        optionals.set(3);
//      }
//      if (struct.isSetAge()) {
//        optionals.set(4);
//      }
//      oprot.writeBitSet(optionals, 5);
//      if (struct.isSetId()) {
//        oprot.writeI32(struct.id);
//      }
//      if (struct.isSetUserId()) {
//        oprot.writeI32(struct.userId);
//      }
//      if (struct.isSetUserName()) {
//        oprot.writeString(struct.userName);
//      }
//      if (struct.isSetPassword()) {
//        oprot.writeString(struct.password);
//      }
//      if (struct.isSetAge()) {
//        oprot.writeI32(struct.age);
//      }
//    }
//
//    @Override
//    public void read(org.apache.thrift.protocol.TProtocol prot, TUser struct) throws TException {
//      TTupleProtocol iprot = (TTupleProtocol) prot;
//      BitSet incoming = iprot.readBitSet(5);
//      if (incoming.get(0)) {
//        struct.id = iprot.readI32();
//        struct.setIdIsSet(true);
//      }
//      if (incoming.get(1)) {
//        struct.userId = iprot.readI32();
//        struct.setUserIdIsSet(true);
//      }
//      if (incoming.get(2)) {
//        struct.userName = iprot.readString();
//        struct.setUserNameIsSet(true);
//      }
//      if (incoming.get(3)) {
//        struct.password = iprot.readString();
//        struct.setPasswordIsSet(true);
//      }
//      if (incoming.get(4)) {
//        struct.age = iprot.readI32();
//        struct.setAgeIsSet(true);
//      }
//    }
//  }
//
//}
//
