// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RequestProto.proto

package cn.v2ss.cn.server.api.protocol;

public final class RequestProto {
  private RequestProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface BaseRequestProtoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:BaseRequestProto)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string reqMsg = 1;</code>
     * @return The reqMsg.
     */
    String getReqMsg();
    /**
     * <code>string reqMsg = 1;</code>
     * @return The bytes for reqMsg.
     */
    com.google.protobuf.ByteString
        getReqMsgBytes();

    /**
     * <code>int64 requestId = 2;</code>
     * @return The requestId.
     */
    long getRequestId();

    /**
     * <code>int32 type = 3;</code>
     * @return The type.
     */
    int getType();

    /**
     * <code>int64 fromId = 4;</code>
     * @return The fromId.
     */
    long getFromId();

    /**
     * <code>int64 receiveId = 5;</code>
     * @return The receiveId.
     */
    long getReceiveId();

    /**
     * <code>int32 msgCode = 6;</code>
     * @return The msgCode.
     */
    int getMsgCode();

    /**
     * <code>int32 chatType = 7;</code>
     * @return The chatType.
     */
    int getChatType();
  }
  /**
   * Protobuf type {@code BaseRequestProto}
   */
  public static final class BaseRequestProto extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:BaseRequestProto)
      BaseRequestProtoOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use BaseRequestProto.newBuilder() to construct.
    private BaseRequestProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private BaseRequestProto() {
      reqMsg_ = "";
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new BaseRequestProto();
    }

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return RequestProto.internal_static_BaseRequestProto_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return RequestProto.internal_static_BaseRequestProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              BaseRequestProto.class, Builder.class);
    }

    public static final int REQMSG_FIELD_NUMBER = 1;
    @SuppressWarnings("serial")
    private volatile Object reqMsg_ = "";
    /**
     * <code>string reqMsg = 1;</code>
     * @return The reqMsg.
     */
    @Override
    public String getReqMsg() {
      Object ref = reqMsg_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        reqMsg_ = s;
        return s;
      }
    }
    /**
     * <code>string reqMsg = 1;</code>
     * @return The bytes for reqMsg.
     */
    @Override
    public com.google.protobuf.ByteString
        getReqMsgBytes() {
      Object ref = reqMsg_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        reqMsg_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int REQUESTID_FIELD_NUMBER = 2;
    private long requestId_ = 0L;
    /**
     * <code>int64 requestId = 2;</code>
     * @return The requestId.
     */
    @Override
    public long getRequestId() {
      return requestId_;
    }

    public static final int TYPE_FIELD_NUMBER = 3;
    private int type_ = 0;
    /**
     * <code>int32 type = 3;</code>
     * @return The type.
     */
    @Override
    public int getType() {
      return type_;
    }

    public static final int FROMID_FIELD_NUMBER = 4;
    private long fromId_ = 0L;
    /**
     * <code>int64 fromId = 4;</code>
     * @return The fromId.
     */
    @Override
    public long getFromId() {
      return fromId_;
    }

    public static final int RECEIVEID_FIELD_NUMBER = 5;
    private long receiveId_ = 0L;
    /**
     * <code>int64 receiveId = 5;</code>
     * @return The receiveId.
     */
    @Override
    public long getReceiveId() {
      return receiveId_;
    }

    public static final int MSGCODE_FIELD_NUMBER = 6;
    private int msgCode_ = 0;
    /**
     * <code>int32 msgCode = 6;</code>
     * @return The msgCode.
     */
    @Override
    public int getMsgCode() {
      return msgCode_;
    }

    public static final int CHATTYPE_FIELD_NUMBER = 7;
    private int chatType_ = 0;
    /**
     * <code>int32 chatType = 7;</code>
     * @return The chatType.
     */
    @Override
    public int getChatType() {
      return chatType_;
    }

    private byte memoizedIsInitialized = -1;
    @Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(reqMsg_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, reqMsg_);
      }
      if (requestId_ != 0L) {
        output.writeInt64(2, requestId_);
      }
      if (type_ != 0) {
        output.writeInt32(3, type_);
      }
      if (fromId_ != 0L) {
        output.writeInt64(4, fromId_);
      }
      if (receiveId_ != 0L) {
        output.writeInt64(5, receiveId_);
      }
      if (msgCode_ != 0) {
        output.writeInt32(6, msgCode_);
      }
      if (chatType_ != 0) {
        output.writeInt32(7, chatType_);
      }
      getUnknownFields().writeTo(output);
    }

    @Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(reqMsg_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, reqMsg_);
      }
      if (requestId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, requestId_);
      }
      if (type_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, type_);
      }
      if (fromId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(4, fromId_);
      }
      if (receiveId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(5, receiveId_);
      }
      if (msgCode_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(6, msgCode_);
      }
      if (chatType_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(7, chatType_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof BaseRequestProto)) {
        return super.equals(obj);
      }
      BaseRequestProto other = (BaseRequestProto) obj;

      if (!getReqMsg()
          .equals(other.getReqMsg())) return false;
      if (getRequestId()
          != other.getRequestId()) return false;
      if (getType()
          != other.getType()) return false;
      if (getFromId()
          != other.getFromId()) return false;
      if (getReceiveId()
          != other.getReceiveId()) return false;
      if (getMsgCode()
          != other.getMsgCode()) return false;
      if (getChatType()
          != other.getChatType()) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + REQMSG_FIELD_NUMBER;
      hash = (53 * hash) + getReqMsg().hashCode();
      hash = (37 * hash) + REQUESTID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRequestId());
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType();
      hash = (37 * hash) + FROMID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getFromId());
      hash = (37 * hash) + RECEIVEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getReceiveId());
      hash = (37 * hash) + MSGCODE_FIELD_NUMBER;
      hash = (53 * hash) + getMsgCode();
      hash = (37 * hash) + CHATTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getChatType();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static BaseRequestProto parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static BaseRequestProto parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static BaseRequestProto parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static BaseRequestProto parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static BaseRequestProto parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static BaseRequestProto parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static BaseRequestProto parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static BaseRequestProto parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static BaseRequestProto parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }

    public static BaseRequestProto parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static BaseRequestProto parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static BaseRequestProto parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(BaseRequestProto prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code BaseRequestProto}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:BaseRequestProto)
        BaseRequestProtoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return RequestProto.internal_static_BaseRequestProto_descriptor;
      }

      @Override
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return RequestProto.internal_static_BaseRequestProto_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                BaseRequestProto.class, Builder.class);
      }

      // Construct using cn.v2ss.cn.server.api.protocol.RequestProto.BaseRequestProto.newBuilder()
      private Builder() {

      }

      private Builder(
          BuilderParent parent) {
        super(parent);

      }
      @Override
      public Builder clear() {
        super.clear();
        bitField0_ = 0;
        reqMsg_ = "";
        requestId_ = 0L;
        type_ = 0;
        fromId_ = 0L;
        receiveId_ = 0L;
        msgCode_ = 0;
        chatType_ = 0;
        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return RequestProto.internal_static_BaseRequestProto_descriptor;
      }

      @Override
      public BaseRequestProto getDefaultInstanceForType() {
        return BaseRequestProto.getDefaultInstance();
      }

      @Override
      public BaseRequestProto build() {
        BaseRequestProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public BaseRequestProto buildPartial() {
        BaseRequestProto result = new BaseRequestProto(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(BaseRequestProto result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.reqMsg_ = reqMsg_;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.requestId_ = requestId_;
        }
        if (((from_bitField0_ & 0x00000004) != 0)) {
          result.type_ = type_;
        }
        if (((from_bitField0_ & 0x00000008) != 0)) {
          result.fromId_ = fromId_;
        }
        if (((from_bitField0_ & 0x00000010) != 0)) {
          result.receiveId_ = receiveId_;
        }
        if (((from_bitField0_ & 0x00000020) != 0)) {
          result.msgCode_ = msgCode_;
        }
        if (((from_bitField0_ & 0x00000040) != 0)) {
          result.chatType_ = chatType_;
        }
      }

      @Override
      public Builder clone() {
        return super.clone();
      }
      @Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.setField(field, value);
      }
      @Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.addRepeatedField(field, value);
      }
      @Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof BaseRequestProto) {
          return mergeFrom((BaseRequestProto)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(BaseRequestProto other) {
        if (other == BaseRequestProto.getDefaultInstance()) return this;
        if (!other.getReqMsg().isEmpty()) {
          reqMsg_ = other.reqMsg_;
          bitField0_ |= 0x00000001;
          onChanged();
        }
        if (other.getRequestId() != 0L) {
          setRequestId(other.getRequestId());
        }
        if (other.getType() != 0) {
          setType(other.getType());
        }
        if (other.getFromId() != 0L) {
          setFromId(other.getFromId());
        }
        if (other.getReceiveId() != 0L) {
          setReceiveId(other.getReceiveId());
        }
        if (other.getMsgCode() != 0) {
          setMsgCode(other.getMsgCode());
        }
        if (other.getChatType() != 0) {
          setChatType(other.getChatType());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @Override
      public final boolean isInitialized() {
        return true;
      }

      @Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 10: {
                reqMsg_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
              case 16: {
                requestId_ = input.readInt64();
                bitField0_ |= 0x00000002;
                break;
              } // case 16
              case 24: {
                type_ = input.readInt32();
                bitField0_ |= 0x00000004;
                break;
              } // case 24
              case 32: {
                fromId_ = input.readInt64();
                bitField0_ |= 0x00000008;
                break;
              } // case 32
              case 40: {
                receiveId_ = input.readInt64();
                bitField0_ |= 0x00000010;
                break;
              } // case 40
              case 48: {
                msgCode_ = input.readInt32();
                bitField0_ |= 0x00000020;
                break;
              } // case 48
              case 56: {
                chatType_ = input.readInt32();
                bitField0_ |= 0x00000040;
                break;
              } // case 56
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private Object reqMsg_ = "";
      /**
       * <code>string reqMsg = 1;</code>
       * @return The reqMsg.
       */
      public String getReqMsg() {
        Object ref = reqMsg_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          reqMsg_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string reqMsg = 1;</code>
       * @return The bytes for reqMsg.
       */
      public com.google.protobuf.ByteString
          getReqMsgBytes() {
        Object ref = reqMsg_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          reqMsg_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string reqMsg = 1;</code>
       * @param value The reqMsg to set.
       * @return This builder for chaining.
       */
      public Builder setReqMsg(
          String value) {
        if (value == null) { throw new NullPointerException(); }
        reqMsg_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <code>string reqMsg = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearReqMsg() {
        reqMsg_ = getDefaultInstance().getReqMsg();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>string reqMsg = 1;</code>
       * @param value The bytes for reqMsg to set.
       * @return This builder for chaining.
       */
      public Builder setReqMsgBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        reqMsg_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }

      private long requestId_ ;
      /**
       * <code>int64 requestId = 2;</code>
       * @return The requestId.
       */
      @Override
      public long getRequestId() {
        return requestId_;
      }
      /**
       * <code>int64 requestId = 2;</code>
       * @param value The requestId to set.
       * @return This builder for chaining.
       */
      public Builder setRequestId(long value) {

        requestId_ = value;
        bitField0_ |= 0x00000002;
        onChanged();
        return this;
      }
      /**
       * <code>int64 requestId = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearRequestId() {
        bitField0_ = (bitField0_ & ~0x00000002);
        requestId_ = 0L;
        onChanged();
        return this;
      }

      private int type_ ;
      /**
       * <code>int32 type = 3;</code>
       * @return The type.
       */
      @Override
      public int getType() {
        return type_;
      }
      /**
       * <code>int32 type = 3;</code>
       * @param value The type to set.
       * @return This builder for chaining.
       */
      public Builder setType(int value) {

        type_ = value;
        bitField0_ |= 0x00000004;
        onChanged();
        return this;
      }
      /**
       * <code>int32 type = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearType() {
        bitField0_ = (bitField0_ & ~0x00000004);
        type_ = 0;
        onChanged();
        return this;
      }

      private long fromId_ ;
      /**
       * <code>int64 fromId = 4;</code>
       * @return The fromId.
       */
      @Override
      public long getFromId() {
        return fromId_;
      }
      /**
       * <code>int64 fromId = 4;</code>
       * @param value The fromId to set.
       * @return This builder for chaining.
       */
      public Builder setFromId(long value) {

        fromId_ = value;
        bitField0_ |= 0x00000008;
        onChanged();
        return this;
      }
      /**
       * <code>int64 fromId = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearFromId() {
        bitField0_ = (bitField0_ & ~0x00000008);
        fromId_ = 0L;
        onChanged();
        return this;
      }

      private long receiveId_ ;
      /**
       * <code>int64 receiveId = 5;</code>
       * @return The receiveId.
       */
      @Override
      public long getReceiveId() {
        return receiveId_;
      }
      /**
       * <code>int64 receiveId = 5;</code>
       * @param value The receiveId to set.
       * @return This builder for chaining.
       */
      public Builder setReceiveId(long value) {

        receiveId_ = value;
        bitField0_ |= 0x00000010;
        onChanged();
        return this;
      }
      /**
       * <code>int64 receiveId = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearReceiveId() {
        bitField0_ = (bitField0_ & ~0x00000010);
        receiveId_ = 0L;
        onChanged();
        return this;
      }

      private int msgCode_ ;
      /**
       * <code>int32 msgCode = 6;</code>
       * @return The msgCode.
       */
      @Override
      public int getMsgCode() {
        return msgCode_;
      }
      /**
       * <code>int32 msgCode = 6;</code>
       * @param value The msgCode to set.
       * @return This builder for chaining.
       */
      public Builder setMsgCode(int value) {

        msgCode_ = value;
        bitField0_ |= 0x00000020;
        onChanged();
        return this;
      }
      /**
       * <code>int32 msgCode = 6;</code>
       * @return This builder for chaining.
       */
      public Builder clearMsgCode() {
        bitField0_ = (bitField0_ & ~0x00000020);
        msgCode_ = 0;
        onChanged();
        return this;
      }

      private int chatType_ ;
      /**
       * <code>int32 chatType = 7;</code>
       * @return The chatType.
       */
      @Override
      public int getChatType() {
        return chatType_;
      }
      /**
       * <code>int32 chatType = 7;</code>
       * @param value The chatType to set.
       * @return This builder for chaining.
       */
      public Builder setChatType(int value) {

        chatType_ = value;
        bitField0_ |= 0x00000040;
        onChanged();
        return this;
      }
      /**
       * <code>int32 chatType = 7;</code>
       * @return This builder for chaining.
       */
      public Builder clearChatType() {
        bitField0_ = (bitField0_ & ~0x00000040);
        chatType_ = 0;
        onChanged();
        return this;
      }
      @Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:BaseRequestProto)
    }

    // @@protoc_insertion_point(class_scope:BaseRequestProto)
    private static final BaseRequestProto DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new BaseRequestProto();
    }

    public static BaseRequestProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<BaseRequestProto>
        PARSER = new com.google.protobuf.AbstractParser<BaseRequestProto>() {
      @Override
      public BaseRequestProto parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<BaseRequestProto> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<BaseRequestProto> getParserForType() {
      return PARSER;
    }

    @Override
    public BaseRequestProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BaseRequestProto_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BaseRequestProto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\022RequestProto.proto\"\211\001\n\020BaseRequestProt" +
      "o\022\016\n\006reqMsg\030\001 \001(\t\022\021\n\trequestId\030\002 \001(\003\022\014\n\004" +
      "type\030\003 \001(\005\022\016\n\006fromId\030\004 \001(\003\022\021\n\treceiveId\030" +
      "\005 \001(\003\022\017\n\007msgCode\030\006 \001(\005\022\020\n\010chatType\030\007 \001(\005" +
      "B.\n\036cn.v2ss.cn.server.api.protocolB\014Requ" +
      "estProtob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_BaseRequestProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_BaseRequestProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BaseRequestProto_descriptor,
        new String[] { "ReqMsg", "RequestId", "Type", "FromId", "ReceiveId", "MsgCode", "ChatType", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
