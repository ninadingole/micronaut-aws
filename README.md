AWS Functions using Micronaut
-----

How to run:
- setup sls credentials for aws account
- run `./gradlew clean build` to package jar
- run `sls deploy` to deploy the function
- to execute function run `sls invoke -f "micronaut-aws" --data '{"message":"Hello World", "someValue":8}'`