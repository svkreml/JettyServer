import com.sun.net.httpserver.HttpServer;

/**
 * Created by s.kremlev on 30.05.2017.
 */
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import servlets.Page;


public class MainServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(80);
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setMaxFormContentSize(10000);// ограничить размер запроса
        handler.addServlet(Page.class, "");

        server.setHandler(handler);
        server.start();
    }


}
