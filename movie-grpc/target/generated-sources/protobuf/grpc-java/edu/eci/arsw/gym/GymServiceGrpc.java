package edu.eci.arsw.gym;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: gym.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GymServiceGrpc {

  private GymServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "GymService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.gym.GymEmptyRequest,
      edu.eci.arsw.gym.SessionList> getGetSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSessions",
      requestType = edu.eci.arsw.gym.GymEmptyRequest.class,
      responseType = edu.eci.arsw.gym.SessionList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.gym.GymEmptyRequest,
      edu.eci.arsw.gym.SessionList> getGetSessionsMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.gym.GymEmptyRequest, edu.eci.arsw.gym.SessionList> getGetSessionsMethod;
    if ((getGetSessionsMethod = GymServiceGrpc.getGetSessionsMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getGetSessionsMethod = GymServiceGrpc.getGetSessionsMethod) == null) {
          GymServiceGrpc.getGetSessionsMethod = getGetSessionsMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.gym.GymEmptyRequest, edu.eci.arsw.gym.SessionList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSessions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.gym.GymEmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.gym.SessionList.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("GetSessions"))
              .build();
        }
      }
    }
    return getGetSessionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.gym.SessionRequest,
      edu.eci.arsw.gym.SessionResponse> getReserveSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReserveSession",
      requestType = edu.eci.arsw.gym.SessionRequest.class,
      responseType = edu.eci.arsw.gym.SessionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.gym.SessionRequest,
      edu.eci.arsw.gym.SessionResponse> getReserveSessionMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.gym.SessionRequest, edu.eci.arsw.gym.SessionResponse> getReserveSessionMethod;
    if ((getReserveSessionMethod = GymServiceGrpc.getReserveSessionMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getReserveSessionMethod = GymServiceGrpc.getReserveSessionMethod) == null) {
          GymServiceGrpc.getReserveSessionMethod = getReserveSessionMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.gym.SessionRequest, edu.eci.arsw.gym.SessionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReserveSession"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.gym.SessionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.gym.SessionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("ReserveSession"))
              .build();
        }
      }
    }
    return getReserveSessionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GymServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GymServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GymServiceStub>() {
        @java.lang.Override
        public GymServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GymServiceStub(channel, callOptions);
        }
      };
    return GymServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GymServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GymServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GymServiceBlockingStub>() {
        @java.lang.Override
        public GymServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GymServiceBlockingStub(channel, callOptions);
        }
      };
    return GymServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GymServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GymServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GymServiceFutureStub>() {
        @java.lang.Override
        public GymServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GymServiceFutureStub(channel, callOptions);
        }
      };
    return GymServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getSessions(edu.eci.arsw.gym.GymEmptyRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.gym.SessionList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSessionsMethod(), responseObserver);
    }

    /**
     */
    default void reserveSession(edu.eci.arsw.gym.SessionRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.gym.SessionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReserveSessionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GymService.
   */
  public static abstract class GymServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GymServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GymService.
   */
  public static final class GymServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GymServiceStub> {
    private GymServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GymServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GymServiceStub(channel, callOptions);
    }

    /**
     */
    public void getSessions(edu.eci.arsw.gym.GymEmptyRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.gym.SessionList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSessionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reserveSession(edu.eci.arsw.gym.SessionRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.gym.SessionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReserveSessionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GymService.
   */
  public static final class GymServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GymServiceBlockingStub> {
    private GymServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GymServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GymServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.eci.arsw.gym.SessionList getSessions(edu.eci.arsw.gym.GymEmptyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSessionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.eci.arsw.gym.SessionResponse reserveSession(edu.eci.arsw.gym.SessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReserveSessionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GymService.
   */
  public static final class GymServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GymServiceFutureStub> {
    private GymServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GymServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GymServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.gym.SessionList> getSessions(
        edu.eci.arsw.gym.GymEmptyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSessionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.gym.SessionResponse> reserveSession(
        edu.eci.arsw.gym.SessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReserveSessionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SESSIONS = 0;
  private static final int METHODID_RESERVE_SESSION = 1;

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
        case METHODID_GET_SESSIONS:
          serviceImpl.getSessions((edu.eci.arsw.gym.GymEmptyRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.gym.SessionList>) responseObserver);
          break;
        case METHODID_RESERVE_SESSION:
          serviceImpl.reserveSession((edu.eci.arsw.gym.SessionRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.gym.SessionResponse>) responseObserver);
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
          getGetSessionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.gym.GymEmptyRequest,
              edu.eci.arsw.gym.SessionList>(
                service, METHODID_GET_SESSIONS)))
        .addMethod(
          getReserveSessionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.gym.SessionRequest,
              edu.eci.arsw.gym.SessionResponse>(
                service, METHODID_RESERVE_SESSION)))
        .build();
  }

  private static abstract class GymServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GymServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.eci.arsw.gym.GymProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GymService");
    }
  }

  private static final class GymServiceFileDescriptorSupplier
      extends GymServiceBaseDescriptorSupplier {
    GymServiceFileDescriptorSupplier() {}
  }

  private static final class GymServiceMethodDescriptorSupplier
      extends GymServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GymServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GymServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GymServiceFileDescriptorSupplier())
              .addMethod(getGetSessionsMethod())
              .addMethod(getReserveSessionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
