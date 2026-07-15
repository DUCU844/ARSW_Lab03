package edu.eci.arsw.movie;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: movie.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MovieServiceGrpc {

  private MovieServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "MovieService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.movie.MovieRequest,
      edu.eci.arsw.movie.MovieResponse> getGetMovieMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMovie",
      requestType = edu.eci.arsw.movie.MovieRequest.class,
      responseType = edu.eci.arsw.movie.MovieResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.movie.MovieRequest,
      edu.eci.arsw.movie.MovieResponse> getGetMovieMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.movie.MovieRequest, edu.eci.arsw.movie.MovieResponse> getGetMovieMethod;
    if ((getGetMovieMethod = MovieServiceGrpc.getGetMovieMethod) == null) {
      synchronized (MovieServiceGrpc.class) {
        if ((getGetMovieMethod = MovieServiceGrpc.getGetMovieMethod) == null) {
          MovieServiceGrpc.getGetMovieMethod = getGetMovieMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.movie.MovieRequest, edu.eci.arsw.movie.MovieResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMovie"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.movie.MovieRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.movie.MovieResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MovieServiceMethodDescriptorSupplier("GetMovie"))
              .build();
        }
      }
    }
    return getGetMovieMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MovieServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieServiceStub>() {
        @java.lang.Override
        public MovieServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieServiceStub(channel, callOptions);
        }
      };
    return MovieServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MovieServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieServiceBlockingStub>() {
        @java.lang.Override
        public MovieServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieServiceBlockingStub(channel, callOptions);
        }
      };
    return MovieServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MovieServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieServiceFutureStub>() {
        @java.lang.Override
        public MovieServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieServiceFutureStub(channel, callOptions);
        }
      };
    return MovieServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getMovie(edu.eci.arsw.movie.MovieRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.movie.MovieResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMovieMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MovieService.
   */
  public static abstract class MovieServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MovieServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MovieService.
   */
  public static final class MovieServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MovieServiceStub> {
    private MovieServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieServiceStub(channel, callOptions);
    }

    /**
     */
    public void getMovie(edu.eci.arsw.movie.MovieRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.movie.MovieResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMovieMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MovieService.
   */
  public static final class MovieServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MovieServiceBlockingStub> {
    private MovieServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.eci.arsw.movie.MovieResponse getMovie(edu.eci.arsw.movie.MovieRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMovieMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MovieService.
   */
  public static final class MovieServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MovieServiceFutureStub> {
    private MovieServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.movie.MovieResponse> getMovie(
        edu.eci.arsw.movie.MovieRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMovieMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MOVIE = 0;

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
        case METHODID_GET_MOVIE:
          serviceImpl.getMovie((edu.eci.arsw.movie.MovieRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.movie.MovieResponse>) responseObserver);
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
          getGetMovieMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.movie.MovieRequest,
              edu.eci.arsw.movie.MovieResponse>(
                service, METHODID_GET_MOVIE)))
        .build();
  }

  private static abstract class MovieServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MovieServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.eci.arsw.movie.MovieProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MovieService");
    }
  }

  private static final class MovieServiceFileDescriptorSupplier
      extends MovieServiceBaseDescriptorSupplier {
    MovieServiceFileDescriptorSupplier() {}
  }

  private static final class MovieServiceMethodDescriptorSupplier
      extends MovieServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MovieServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MovieServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MovieServiceFileDescriptorSupplier())
              .addMethod(getGetMovieMethod())
              .build();
        }
      }
    }
    return result;
  }
}
