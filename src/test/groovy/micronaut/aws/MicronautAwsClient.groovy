package micronaut.aws

import io.micronaut.function.client.FunctionClient
import io.reactivex.Single

import javax.inject.Named

@FunctionClient
interface MicronautAwsClient {

    @Named("micronaut-aws")
    Single<String> micronautAws()
}
