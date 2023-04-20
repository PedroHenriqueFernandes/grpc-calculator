import com.google.protobuf.gradle.id

plugins {
    java
    id("com.google.protobuf") version "0.9.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:3.22.2")
    implementation("io.grpc:grpc-netty:1.54.0");
    implementation("io.grpc:grpc-protobuf:1.54.0");
    implementation("io.grpc:grpc-stub:1.54.0");
    implementation("javax.annotation:javax.annotation-api:1.3.1")
}

protobuf {
    protoc { artifact = "com.google.protobuf:protoc:3.22.2" }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.54.0"
        }
    }
    generateProtoTasks {
        all()
            .forEach {
                it.plugins {
                    id("grpc") {}
                }
            }
    }
}