package micronaut.aws

import io.micronaut.context.ApplicationContext
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.Specification
import javax.inject.Inject

@MicronautTest
class MicronautAwsFunctionSpec extends Specification {

    @Inject
    MicronautAwsClient client


    void "test micronaut-aws function"() {
        expect:
        client.micronautAws().blockingGet() == "micronaut-aws"
    }
}
