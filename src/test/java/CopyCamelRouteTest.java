import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CopyCamelRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new CopyFilesRoute();
    }

    @Test
    public void checkFileExistInOutputDirectory() throws InterruptedException {
        Thread.sleep(5000);
        File output = new File("target/data/output");

        assertTrue(output.isDirectory());
        assertEquals(2, output.list().length);
    }

    @Test
    public void testDirectInput() throws InterruptedException {
        template.sendBody("direct:sampleInput", "this is a directInput");
        Thread.sleep(2000);

        Exchange exchange = consumer.receive("file:target/direct/output/");
        assertEquals("this is a directInput", exchange.getIn().getBody(String.class));
    }
}