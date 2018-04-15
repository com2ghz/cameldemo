import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {

    public static void main(String[] args) {
        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new CopyFilesRoute());

            context.start();

            Thread.sleep(5000);

            context.stop();
        } catch (Exception e) {
            System.out.println("Exception is: " + e);
            e.printStackTrace();
        }
    }
}
