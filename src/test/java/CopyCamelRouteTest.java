import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CopyCamelRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CopyFilesRoute();
    }

    @Test
    public void checkFileExistInOutputDirectory() throws InterruptedException {
        Thread.sleep(5000);
        File output = new File("target/data/output");

        assertTrue(output.isDirectory());
        assertEquals(2, output.list().length);

    }
}