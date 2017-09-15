package ir.milux;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class LightServer {
    private Server server;

    public LightServer(int port) {

        ResourceConfig config = new ResourceConfig();
        config.packages("ir.milux");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));

        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(server,"/*");
        context.addServlet(servlet,"/*");
    }

    public void start() throws Exception {
        server.start();
        server.join();
    }

    public void stop() {
        server.destroy();
    }
}
