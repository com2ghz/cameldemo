import org.apache.camel.builder.RouteBuilder;

public class CopyFilesRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .from("direct:sampleInput")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .to("file:target/data/output/");
    }
}
