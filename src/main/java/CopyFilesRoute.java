import org.apache.camel.builder.RouteBuilder;

public class CopyFilesRoute extends RouteBuilder {

    public void configure() {
        from("file:data/input?noop=true")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .to("file:target/data/output/");

        from("direct:sampleInput")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .to("file:target/direct/output");
    }
}
