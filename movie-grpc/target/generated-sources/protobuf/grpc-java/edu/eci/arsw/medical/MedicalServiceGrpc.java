package edu.eci.arsw.medical;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: medical.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MedicalServiceGrpc {

  private MedicalServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "MedicalService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.medical.MedicalEmptyRequest,
      edu.eci.arsw.medical.SpecialtyList> getGetSpecialtiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSpecialties",
      requestType = edu.eci.arsw.medical.MedicalEmptyRequest.class,
      responseType = edu.eci.arsw.medical.SpecialtyList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.medical.MedicalEmptyRequest,
      edu.eci.arsw.medical.SpecialtyList> getGetSpecialtiesMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.medical.MedicalEmptyRequest, edu.eci.arsw.medical.SpecialtyList> getGetSpecialtiesMethod;
    if ((getGetSpecialtiesMethod = MedicalServiceGrpc.getGetSpecialtiesMethod) == null) {
      synchronized (MedicalServiceGrpc.class) {
        if ((getGetSpecialtiesMethod = MedicalServiceGrpc.getGetSpecialtiesMethod) == null) {
          MedicalServiceGrpc.getGetSpecialtiesMethod = getGetSpecialtiesMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.medical.MedicalEmptyRequest, edu.eci.arsw.medical.SpecialtyList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSpecialties"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.medical.MedicalEmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.medical.SpecialtyList.getDefaultInstance()))
              .setSchemaDescriptor(new MedicalServiceMethodDescriptorSupplier("GetSpecialties"))
              .build();
        }
      }
    }
    return getGetSpecialtiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.medical.SpecialtyRequest,
      edu.eci.arsw.medical.AvailabilityResponse> getGetAvailabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAvailability",
      requestType = edu.eci.arsw.medical.SpecialtyRequest.class,
      responseType = edu.eci.arsw.medical.AvailabilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.medical.SpecialtyRequest,
      edu.eci.arsw.medical.AvailabilityResponse> getGetAvailabilityMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.medical.SpecialtyRequest, edu.eci.arsw.medical.AvailabilityResponse> getGetAvailabilityMethod;
    if ((getGetAvailabilityMethod = MedicalServiceGrpc.getGetAvailabilityMethod) == null) {
      synchronized (MedicalServiceGrpc.class) {
        if ((getGetAvailabilityMethod = MedicalServiceGrpc.getGetAvailabilityMethod) == null) {
          MedicalServiceGrpc.getGetAvailabilityMethod = getGetAvailabilityMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.medical.SpecialtyRequest, edu.eci.arsw.medical.AvailabilityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAvailability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.medical.SpecialtyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.medical.AvailabilityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MedicalServiceMethodDescriptorSupplier("GetAvailability"))
              .build();
        }
      }
    }
    return getGetAvailabilityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MedicalServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MedicalServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MedicalServiceStub>() {
        @java.lang.Override
        public MedicalServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MedicalServiceStub(channel, callOptions);
        }
      };
    return MedicalServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MedicalServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MedicalServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MedicalServiceBlockingStub>() {
        @java.lang.Override
        public MedicalServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MedicalServiceBlockingStub(channel, callOptions);
        }
      };
    return MedicalServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MedicalServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MedicalServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MedicalServiceFutureStub>() {
        @java.lang.Override
        public MedicalServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MedicalServiceFutureStub(channel, callOptions);
        }
      };
    return MedicalServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getSpecialties(edu.eci.arsw.medical.MedicalEmptyRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.medical.SpecialtyList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSpecialtiesMethod(), responseObserver);
    }

    /**
     */
    default void getAvailability(edu.eci.arsw.medical.SpecialtyRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.medical.AvailabilityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAvailabilityMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MedicalService.
   */
  public static abstract class MedicalServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MedicalServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MedicalService.
   */
  public static final class MedicalServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MedicalServiceStub> {
    private MedicalServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MedicalServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MedicalServiceStub(channel, callOptions);
    }

    /**
     */
    public void getSpecialties(edu.eci.arsw.medical.MedicalEmptyRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.medical.SpecialtyList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSpecialtiesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAvailability(edu.eci.arsw.medical.SpecialtyRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.medical.AvailabilityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAvailabilityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MedicalService.
   */
  public static final class MedicalServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MedicalServiceBlockingStub> {
    private MedicalServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MedicalServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MedicalServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.eci.arsw.medical.SpecialtyList getSpecialties(edu.eci.arsw.medical.MedicalEmptyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSpecialtiesMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.eci.arsw.medical.AvailabilityResponse getAvailability(edu.eci.arsw.medical.SpecialtyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAvailabilityMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MedicalService.
   */
  public static final class MedicalServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MedicalServiceFutureStub> {
    private MedicalServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MedicalServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MedicalServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.medical.SpecialtyList> getSpecialties(
        edu.eci.arsw.medical.MedicalEmptyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSpecialtiesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.medical.AvailabilityResponse> getAvailability(
        edu.eci.arsw.medical.SpecialtyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAvailabilityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SPECIALTIES = 0;
  private static final int METHODID_GET_AVAILABILITY = 1;

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
        case METHODID_GET_SPECIALTIES:
          serviceImpl.getSpecialties((edu.eci.arsw.medical.MedicalEmptyRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.medical.SpecialtyList>) responseObserver);
          break;
        case METHODID_GET_AVAILABILITY:
          serviceImpl.getAvailability((edu.eci.arsw.medical.SpecialtyRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.medical.AvailabilityResponse>) responseObserver);
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
          getGetSpecialtiesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.medical.MedicalEmptyRequest,
              edu.eci.arsw.medical.SpecialtyList>(
                service, METHODID_GET_SPECIALTIES)))
        .addMethod(
          getGetAvailabilityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.medical.SpecialtyRequest,
              edu.eci.arsw.medical.AvailabilityResponse>(
                service, METHODID_GET_AVAILABILITY)))
        .build();
  }

  private static abstract class MedicalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MedicalServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.eci.arsw.medical.MedicalProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MedicalService");
    }
  }

  private static final class MedicalServiceFileDescriptorSupplier
      extends MedicalServiceBaseDescriptorSupplier {
    MedicalServiceFileDescriptorSupplier() {}
  }

  private static final class MedicalServiceMethodDescriptorSupplier
      extends MedicalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MedicalServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MedicalServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MedicalServiceFileDescriptorSupplier())
              .addMethod(getGetSpecialtiesMethod())
              .addMethod(getGetAvailabilityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
