AWS Functions using Micronaut
-----

How to run:
- setup sls credentials for aws account
- run `./gradlew clean build` to package jar
- run `sls deploy` to deploy the function
- to execute function run `sls invoke -f "micronaut-aws" --data '{"message":"Hello World", "someValue":8}'`


##Zipkin Setup
Distributed tracing using Zipkin is enabled by default, start zipkin on a docker before running the app

```
$> docker run -d -p 9411:9411 openzipkin/zipkin
```

##Swagger/Redoc/RapiDoc
Open api specs are available at `http://localhost:8080/swagger/employees-0.1`

Swagger UI: `http://localhost:8080/swagger-ui`

Rapidoc: `http://localhost:8080/rapidoc`

Redoc: `http://localhost:8080/redoc`