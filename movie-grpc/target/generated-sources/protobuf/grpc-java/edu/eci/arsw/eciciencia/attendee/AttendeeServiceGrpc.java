package edu.eci.arsw.eciciencia.attendee;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: eciciencia_attendee.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AttendeeServiceGrpc {

  private AttendeeServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "AttendeeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.attendee.AttendeeRequest,
      edu.eci.arsw.eciciencia.attendee.AttendeeResponse> getRegisterAttendeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterAttendee",
      requestType = edu.eci.arsw.eciciencia.attendee.AttendeeRequest.class,
      responseType = edu.eci.arsw.eciciencia.attendee.AttendeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.attendee.AttendeeRequest,
      edu.eci.arsw.eciciencia.attendee.AttendeeResponse> getRegisterAttendeeMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.attendee.AttendeeRequest, edu.eci.arsw.eciciencia.attendee.AttendeeResponse> getRegisterAttendeeMethod;
    if ((getRegisterAttendeeMethod = AttendeeServiceGrpc.getRegisterAttendeeMethod) == null) {
      synchronized (AttendeeServiceGrpc.class) {
        if ((getRegisterAttendeeMethod = AttendeeServiceGrpc.getRegisterAttendeeMethod) == null) {
          AttendeeServiceGrpc.getRegisterAttendeeMethod = getRegisterAttendeeMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.eciciencia.attendee.AttendeeRequest, edu.eci.arsw.eciciencia.attendee.AttendeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterAttendee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.attendee.AttendeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.attendee.AttendeeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AttendeeServiceMethodDescriptorSupplier("RegisterAttendee"))
              .build();
        }
      }
    }
    return getRegisterAttendeeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest,
      edu.eci.arsw.eciciencia.attendee.AttendeeResponse> getGetAttendeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAttendee",
      requestType = edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest.class,
      responseType = edu.eci.arsw.eciciencia.attendee.AttendeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest,
      edu.eci.arsw.eciciencia.attendee.AttendeeResponse> getGetAttendeeMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest, edu.eci.arsw.eciciencia.attendee.AttendeeResponse> getGetAttendeeMethod;
    if ((getGetAttendeeMethod = AttendeeServiceGrpc.getGetAttendeeMethod) == null) {
      synchronized (AttendeeServiceGrpc.class) {
        if ((getGetAttendeeMethod = AttendeeServiceGrpc.getGetAttendeeMethod) == null) {
          AttendeeServiceGrpc.getGetAttendeeMethod = getGetAttendeeMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest, edu.eci.arsw.eciciencia.attendee.AttendeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAttendee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.attendee.AttendeeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AttendeeServiceMethodDescriptorSupplier("GetAttendee"))
              .build();
        }
      }
    }
    return getGetAttendeeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AttendeeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttendeeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AttendeeServiceStub>() {
        @java.lang.Override
        public AttendeeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AttendeeServiceStub(channel, callOptions);
        }
      };
    return AttendeeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AttendeeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttendeeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AttendeeServiceBlockingStub>() {
        @java.lang.Override
        public AttendeeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AttendeeServiceBlockingStub(channel, callOptions);
        }
      };
    return AttendeeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AttendeeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttendeeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AttendeeServiceFutureStub>() {
        @java.lang.Override
        public AttendeeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AttendeeServiceFutureStub(channel, callOptions);
        }
      };
    return AttendeeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void registerAttendee(edu.eci.arsw.eciciencia.attendee.AttendeeRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.attendee.AttendeeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterAttendeeMethod(), responseObserver);
    }

    /**
     */
    default void getAttendee(edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.attendee.AttendeeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAttendeeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AttendeeService.
   */
  public static abstract class AttendeeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AttendeeServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AttendeeService.
   */
  public static final class AttendeeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AttendeeServiceStub> {
    private AttendeeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttendeeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttendeeServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerAttendee(edu.eci.arsw.eciciencia.attendee.AttendeeRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.attendee.AttendeeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterAttendeeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAttendee(edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.attendee.AttendeeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAttendeeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AttendeeService.
   */
  public static final class AttendeeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AttendeeServiceBlockingStub> {
    private AttendeeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttendeeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttendeeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.eci.arsw.eciciencia.attendee.AttendeeResponse registerAttendee(edu.eci.arsw.eciciencia.attendee.AttendeeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterAttendeeMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.eci.arsw.eciciencia.attendee.AttendeeResponse getAttendee(edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAttendeeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AttendeeService.
   */
  public static final class AttendeeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AttendeeServiceFutureStub> {
    private AttendeeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttendeeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttendeeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.eciciencia.attendee.AttendeeResponse> registerAttendee(
        edu.eci.arsw.eciciencia.attendee.AttendeeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterAttendeeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.eciciencia.attendee.AttendeeResponse> getAttendee(
        edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAttendeeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_ATTENDEE = 0;
  private static final int METHODID_GET_ATTENDEE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_ATTENDEE:
          serviceImpl.registerAttendee((edu.eci.arsw.eciciencia.attendee.AttendeeRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.attendee.AttendeeResponse>) responseObserver);
          break;
        case METHODID_GET_ATTENDEE:
          serviceImpl.getAttendee((edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.attendee.AttendeeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getRegisterAttendeeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.eciciencia.attendee.AttendeeRequest,
              edu.eci.arsw.eciciencia.attendee.AttendeeResponse>(
                service, METHODID_REGISTER_ATTENDEE)))
        .addMethod(
          getGetAttendeeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.eciciencia.attendee.AttendeeIdRequest,
              edu.eci.arsw.eciciencia.attendee.AttendeeResponse>(
                service, METHODID_GET_ATTENDEE)))
        .build();
  }

  private static abstract class AttendeeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AttendeeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.eci.arsw.eciciencia.attendee.AttendeeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AttendeeService");
    }
  }

  private static final class AttendeeServiceFileDescriptorSupplier
      extends AttendeeServiceBaseDescriptorSupplier {
    AttendeeServiceFileDescriptorSupplier() {}
  }

  private static final class AttendeeServiceMethodDescriptorSupplier
      extends AttendeeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AttendeeServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AttendeeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AttendeeServiceFileDescriptorSupplier())
              .addMethod(getRegisterAttendeeMethod())
              .addMethod(getGetAttendeeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
