package edu.eci.arsw.eciciencia.reservation;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: eciciencia_reservation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReservationServiceGrpc {

  private ReservationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ReservationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.ReservationRequest,
      edu.eci.arsw.eciciencia.reservation.ReservationResponse> getReserveSpotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReserveSpot",
      requestType = edu.eci.arsw.eciciencia.reservation.ReservationRequest.class,
      responseType = edu.eci.arsw.eciciencia.reservation.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.ReservationRequest,
      edu.eci.arsw.eciciencia.reservation.ReservationResponse> getReserveSpotMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.ReservationRequest, edu.eci.arsw.eciciencia.reservation.ReservationResponse> getReserveSpotMethod;
    if ((getReserveSpotMethod = ReservationServiceGrpc.getReserveSpotMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getReserveSpotMethod = ReservationServiceGrpc.getReserveSpotMethod) == null) {
          ReservationServiceGrpc.getReserveSpotMethod = getReserveSpotMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.eciciencia.reservation.ReservationRequest, edu.eci.arsw.eciciencia.reservation.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReserveSpot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.reservation.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.reservation.ReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("ReserveSpot"))
              .build();
        }
      }
    }
    return getReserveSpotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.CancelReservationRequest,
      edu.eci.arsw.eciciencia.reservation.CancelReservationResponse> getCancelReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelReservation",
      requestType = edu.eci.arsw.eciciencia.reservation.CancelReservationRequest.class,
      responseType = edu.eci.arsw.eciciencia.reservation.CancelReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.CancelReservationRequest,
      edu.eci.arsw.eciciencia.reservation.CancelReservationResponse> getCancelReservationMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.CancelReservationRequest, edu.eci.arsw.eciciencia.reservation.CancelReservationResponse> getCancelReservationMethod;
    if ((getCancelReservationMethod = ReservationServiceGrpc.getCancelReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCancelReservationMethod = ReservationServiceGrpc.getCancelReservationMethod) == null) {
          ReservationServiceGrpc.getCancelReservationMethod = getCancelReservationMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.eciciencia.reservation.CancelReservationRequest, edu.eci.arsw.eciciencia.reservation.CancelReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.reservation.CancelReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.reservation.CancelReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("CancelReservation"))
              .build();
        }
      }
    }
    return getCancelReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.CapacityRequest,
      edu.eci.arsw.eciciencia.reservation.CapacityResponse> getGetCapacityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCapacity",
      requestType = edu.eci.arsw.eciciencia.reservation.CapacityRequest.class,
      responseType = edu.eci.arsw.eciciencia.reservation.CapacityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.CapacityRequest,
      edu.eci.arsw.eciciencia.reservation.CapacityResponse> getGetCapacityMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.CapacityRequest, edu.eci.arsw.eciciencia.reservation.CapacityResponse> getGetCapacityMethod;
    if ((getGetCapacityMethod = ReservationServiceGrpc.getGetCapacityMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetCapacityMethod = ReservationServiceGrpc.getGetCapacityMethod) == null) {
          ReservationServiceGrpc.getGetCapacityMethod = getGetCapacityMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.eciciencia.reservation.CapacityRequest, edu.eci.arsw.eciciencia.reservation.CapacityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCapacity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.reservation.CapacityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.reservation.CapacityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetCapacity"))
              .build();
        }
      }
    }
    return getGetCapacityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest,
      edu.eci.arsw.eciciencia.reservation.ReservationList> getGetMyReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMyReservations",
      requestType = edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest.class,
      responseType = edu.eci.arsw.eciciencia.reservation.ReservationList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest,
      edu.eci.arsw.eciciencia.reservation.ReservationList> getGetMyReservationsMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest, edu.eci.arsw.eciciencia.reservation.ReservationList> getGetMyReservationsMethod;
    if ((getGetMyReservationsMethod = ReservationServiceGrpc.getGetMyReservationsMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetMyReservationsMethod = ReservationServiceGrpc.getGetMyReservationsMethod) == null) {
          ReservationServiceGrpc.getGetMyReservationsMethod = getGetMyReservationsMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest, edu.eci.arsw.eciciencia.reservation.ReservationList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMyReservations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.eciciencia.reservation.ReservationList.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetMyReservations"))
              .build();
        }
      }
    }
    return getGetMyReservationsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReservationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReservationServiceStub>() {
        @java.lang.Override
        public ReservationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReservationServiceStub(channel, callOptions);
        }
      };
    return ReservationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReservationServiceBlockingStub>() {
        @java.lang.Override
        public ReservationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReservationServiceBlockingStub(channel, callOptions);
        }
      };
    return ReservationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReservationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReservationServiceFutureStub>() {
        @java.lang.Override
        public ReservationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReservationServiceFutureStub(channel, callOptions);
        }
      };
    return ReservationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void reserveSpot(edu.eci.arsw.eciciencia.reservation.ReservationRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.ReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReserveSpotMethod(), responseObserver);
    }

    /**
     */
    default void cancelReservation(edu.eci.arsw.eciciencia.reservation.CancelReservationRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.CancelReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelReservationMethod(), responseObserver);
    }

    /**
     */
    default void getCapacity(edu.eci.arsw.eciciencia.reservation.CapacityRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.CapacityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCapacityMethod(), responseObserver);
    }

    /**
     */
    default void getMyReservations(edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.ReservationList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMyReservationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReservationService.
   */
  public static abstract class ReservationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ReservationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ReservationService.
   */
  public static final class ReservationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReservationServiceStub> {
    private ReservationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationServiceStub(channel, callOptions);
    }

    /**
     */
    public void reserveSpot(edu.eci.arsw.eciciencia.reservation.ReservationRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.ReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReserveSpotMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelReservation(edu.eci.arsw.eciciencia.reservation.CancelReservationRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.CancelReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCapacity(edu.eci.arsw.eciciencia.reservation.CapacityRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.CapacityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCapacityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMyReservations(edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.ReservationList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMyReservationsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ReservationService.
   */
  public static final class ReservationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReservationServiceBlockingStub> {
    private ReservationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.eci.arsw.eciciencia.reservation.ReservationResponse reserveSpot(edu.eci.arsw.eciciencia.reservation.ReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReserveSpotMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.eci.arsw.eciciencia.reservation.CancelReservationResponse cancelReservation(edu.eci.arsw.eciciencia.reservation.CancelReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.eci.arsw.eciciencia.reservation.CapacityResponse getCapacity(edu.eci.arsw.eciciencia.reservation.CapacityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCapacityMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.eci.arsw.eciciencia.reservation.ReservationList getMyReservations(edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMyReservationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ReservationService.
   */
  public static final class ReservationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReservationServiceFutureStub> {
    private ReservationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.eciciencia.reservation.ReservationResponse> reserveSpot(
        edu.eci.arsw.eciciencia.reservation.ReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReserveSpotMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.eciciencia.reservation.CancelReservationResponse> cancelReservation(
        edu.eci.arsw.eciciencia.reservation.CancelReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.eciciencia.reservation.CapacityResponse> getCapacity(
        edu.eci.arsw.eciciencia.reservation.CapacityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCapacityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.eciciencia.reservation.ReservationList> getMyReservations(
        edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMyReservationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RESERVE_SPOT = 0;
  private static final int METHODID_CANCEL_RESERVATION = 1;
  private static final int METHODID_GET_CAPACITY = 2;
  private static final int METHODID_GET_MY_RESERVATIONS = 3;

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
        case METHODID_RESERVE_SPOT:
          serviceImpl.reserveSpot((edu.eci.arsw.eciciencia.reservation.ReservationRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.ReservationResponse>) responseObserver);
          break;
        case METHODID_CANCEL_RESERVATION:
          serviceImpl.cancelReservation((edu.eci.arsw.eciciencia.reservation.CancelReservationRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.CancelReservationResponse>) responseObserver);
          break;
        case METHODID_GET_CAPACITY:
          serviceImpl.getCapacity((edu.eci.arsw.eciciencia.reservation.CapacityRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.CapacityResponse>) responseObserver);
          break;
        case METHODID_GET_MY_RESERVATIONS:
          serviceImpl.getMyReservations((edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.eciciencia.reservation.ReservationList>) responseObserver);
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
          getReserveSpotMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.eciciencia.reservation.ReservationRequest,
              edu.eci.arsw.eciciencia.reservation.ReservationResponse>(
                service, METHODID_RESERVE_SPOT)))
        .addMethod(
          getCancelReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.eciciencia.reservation.CancelReservationRequest,
              edu.eci.arsw.eciciencia.reservation.CancelReservationResponse>(
                service, METHODID_CANCEL_RESERVATION)))
        .addMethod(
          getGetCapacityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.eciciencia.reservation.CapacityRequest,
              edu.eci.arsw.eciciencia.reservation.CapacityResponse>(
                service, METHODID_GET_CAPACITY)))
        .addMethod(
          getGetMyReservationsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.eciciencia.reservation.AttendeeReservationRequest,
              edu.eci.arsw.eciciencia.reservation.ReservationList>(
                service, METHODID_GET_MY_RESERVATIONS)))
        .build();
  }

  private static abstract class ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.eci.arsw.eciciencia.reservation.ReservationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationService");
    }
  }

  private static final class ReservationServiceFileDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier {
    ReservationServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationServiceMethodDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ReservationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ReservationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReservationServiceFileDescriptorSupplier())
              .addMethod(getReserveSpotMethod())
              .addMethod(getCancelReservationMethod())
              .addMethod(getGetCapacityMethod())
              .addMethod(getGetMyReservationsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
