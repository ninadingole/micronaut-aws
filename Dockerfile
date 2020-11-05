FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/micronaut-aws
WORKDIR /home/app/micronaut-aws

RUN native-image --no-server -cp dist/micronaut-aws.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-aws/demo /app/micronaut-aws
ENTRYPOINT ["/app/micronaut-aws"]