package edu.eci.arsw.wellness;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: appointment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AppointmentServiceGrpc {

  private AppointmentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "AppointmentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.wellness.AppointmentRequest,
      edu.eci.arsw.wellness.AppointmentResponse> getRequestAppointmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestAppointment",
      requestType = edu.eci.arsw.wellness.AppointmentRequest.class,
      responseType = edu.eci.arsw.wellness.AppointmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.wellness.AppointmentRequest,
      edu.eci.arsw.wellness.AppointmentResponse> getRequestAppointmentMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.wellness.AppointmentRequest, edu.eci.arsw.wellness.AppointmentResponse> getRequestAppointmentMethod;
    if ((getRequestAppointmentMethod = AppointmentServiceGrpc.getRequestAppointmentMethod) == null) {
      synchronized (AppointmentServiceGrpc.class) {
        if ((getRequestAppointmentMethod = AppointmentServiceGrpc.getRequestAppointmentMethod) == null) {
          AppointmentServiceGrpc.getRequestAppointmentMethod = getRequestAppointmentMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.wellness.AppointmentRequest, edu.eci.arsw.wellness.AppointmentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestAppointment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.wellness.AppointmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.wellness.AppointmentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppointmentServiceMethodDescriptorSupplier("RequestAppointment"))
              .build();
        }
      }
    }
    return getRequestAppointmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.wellness.CancelRequest,
      edu.eci.arsw.wellness.CancelResponse> getCancelAppointmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelAppointment",
      requestType = edu.eci.arsw.wellness.CancelRequest.class,
      responseType = edu.eci.arsw.wellness.CancelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.wellness.CancelRequest,
      edu.eci.arsw.wellness.CancelResponse> getCancelAppointmentMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.wellness.CancelRequest, edu.eci.arsw.wellness.CancelResponse> getCancelAppointmentMethod;
    if ((getCancelAppointmentMethod = AppointmentServiceGrpc.getCancelAppointmentMethod) == null) {
      synchronized (AppointmentServiceGrpc.class) {
        if ((getCancelAppointmentMethod = AppointmentServiceGrpc.getCancelAppointmentMethod) == null) {
          AppointmentServiceGrpc.getCancelAppointmentMethod = getCancelAppointmentMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.wellness.CancelRequest, edu.eci.arsw.wellness.CancelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelAppointment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.wellness.CancelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.wellness.CancelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppointmentServiceMethodDescriptorSupplier("CancelAppointment"))
              .build();
        }
      }
    }
    return getCancelAppointmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.wellness.StudentRequest,
      edu.eci.arsw.wellness.AppointmentList> getGetAppointmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAppointments",
      requestType = edu.eci.arsw.wellness.StudentRequest.class,
      responseType = edu.eci.arsw.wellness.AppointmentList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.wellness.StudentRequest,
      edu.eci.arsw.wellness.AppointmentList> getGetAppointmentsMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.wellness.StudentRequest, edu.eci.arsw.wellness.AppointmentList> getGetAppointmentsMethod;
    if ((getGetAppointmentsMethod = AppointmentServiceGrpc.getGetAppointmentsMethod) == null) {
      synchronized (AppointmentServiceGrpc.class) {
        if ((getGetAppointmentsMethod = AppointmentServiceGrpc.getGetAppointmentsMethod) == null) {
          AppointmentServiceGrpc.getGetAppointmentsMethod = getGetAppointmentsMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.wellness.StudentRequest, edu.eci.arsw.wellness.AppointmentList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAppointments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.wellness.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.wellness.AppointmentList.getDefaultInstance()))
              .setSchemaDescriptor(new AppointmentServiceMethodDescriptorSupplier("GetAppointments"))
              .build();
        }
      }
    }
    return getGetAppointmentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AppointmentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceStub>() {
        @java.lang.Override
        public AppointmentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppointmentServiceStub(channel, callOptions);
        }
      };
    return AppointmentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AppointmentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceBlockingStub>() {
        @java.lang.Override
        public AppointmentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppointmentServiceBlockingStub(channel, callOptions);
        }
      };
    return AppointmentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AppointmentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceFutureStub>() {
        @java.lang.Override
        public AppointmentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppointmentServiceFutureStub(channel, callOptions);
        }
      };
    return AppointmentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void requestAppointment(edu.eci.arsw.wellness.AppointmentRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.wellness.AppointmentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestAppointmentMethod(), responseObserver);
    }

    /**
     */
    default void cancelAppointment(edu.eci.arsw.wellness.CancelRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.wellness.CancelResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelAppointmentMethod(), responseObserver);
    }

    /**
     */
    default void getAppointments(edu.eci.arsw.wellness.StudentRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.wellness.AppointmentList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAppointmentsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AppointmentService.
   */
  public static abstract class AppointmentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AppointmentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AppointmentService.
   */
  public static final class AppointmentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AppointmentServiceStub> {
    private AppointmentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppointmentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppointmentServiceStub(channel, callOptions);
    }

    /**
     */
    public void requestAppointment(edu.eci.arsw.wellness.AppointmentRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.wellness.AppointmentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestAppointmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelAppointment(edu.eci.arsw.wellness.CancelRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.wellness.CancelResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelAppointmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAppointments(edu.eci.arsw.wellness.StudentRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.wellness.AppointmentList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAppointmentsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AppointmentService.
   */
  public static final class AppointmentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AppointmentServiceBlockingStub> {
    private AppointmentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppointmentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppointmentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.eci.arsw.wellness.AppointmentResponse requestAppointment(edu.eci.arsw.wellness.AppointmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestAppointmentMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.eci.arsw.wellness.CancelResponse cancelAppointment(edu.eci.arsw.wellness.CancelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelAppointmentMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.eci.arsw.wellness.AppointmentList getAppointments(edu.eci.arsw.wellness.StudentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAppointmentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AppointmentService.
   */
  public static final class AppointmentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AppointmentServiceFutureStub> {
    private AppointmentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppointmentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppointmentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.wellness.AppointmentResponse> requestAppointment(
        edu.eci.arsw.wellness.AppointmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestAppointmentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.wellness.CancelResponse> cancelAppointment(
        edu.eci.arsw.wellness.CancelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelAppointmentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.wellness.AppointmentList> getAppointments(
        edu.eci.arsw.wellness.StudentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAppointmentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_APPOINTMENT = 0;
  private static final int METHODID_CANCEL_APPOINTMENT = 1;
  private static final int METHODID_GET_APPOINTMENTS = 2;

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
        case METHODID_REQUEST_APPOINTMENT:
          serviceImpl.requestAppointment((edu.eci.arsw.wellness.AppointmentRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.wellness.AppointmentResponse>) responseObserver);
          break;
        case METHODID_CANCEL_APPOINTMENT:
          serviceImpl.cancelAppointment((edu.eci.arsw.wellness.CancelRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.wellness.CancelResponse>) responseObserver);
          break;
        case METHODID_GET_APPOINTMENTS:
          serviceImpl.getAppointments((edu.eci.arsw.wellness.StudentRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.wellness.AppointmentList>) responseObserver);
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
          getRequestAppointmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.wellness.AppointmentRequest,
              edu.eci.arsw.wellness.AppointmentResponse>(
                service, METHODID_REQUEST_APPOINTMENT)))
        .addMethod(
          getCancelAppointmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.wellness.CancelRequest,
              edu.eci.arsw.wellness.CancelResponse>(
                service, METHODID_CANCEL_APPOINTMENT)))
        .addMethod(
          getGetAppointmentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.wellness.StudentRequest,
              edu.eci.arsw.wellness.AppointmentList>(
                service, METHODID_GET_APPOINTMENTS)))
        .build();
  }

  private static abstract class AppointmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AppointmentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.eci.arsw.wellness.AppointmentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AppointmentService");
    }
  }

  private static final class AppointmentServiceFileDescriptorSupplier
      extends AppointmentServiceBaseDescriptorSupplier {
    AppointmentServiceFileDescriptorSupplier() {}
  }

  private static final class AppointmentServiceMethodDescriptorSupplier
      extends AppointmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AppointmentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AppointmentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AppointmentServiceFileDescriptorSupplier())
              .addMethod(getRequestAppointmentMethod())
              .addMethod(getCancelAppointmentMethod())
              .addMethod(getGetAppointmentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
