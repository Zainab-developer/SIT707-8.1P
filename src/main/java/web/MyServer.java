package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import web.handler.LoginServlet;
import web.handler.RegistrationServlet;
import web.handler.WelcomeServlet;


/**
 * HTTP server. Starts server and registers Java Servlets to URL routes.
 */
public class MyServer {
	
	private static int PORT = 8082;
	
	public void start() throws Exception {
	    // HTTP server listening on port 8082.
	    Server server = new Server(PORT);

	    // URL routing/mapping handler
	    ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
	    handler.setContextPath("/");

	    // Set initialization parameter
	    handler.getServletContext().setAttribute("login", "text/html");

	    // Attach the handler to the server
	    server.setHandler(handler);

	    // Register servlets to URL routes
	    handler.addServlet(WelcomeServlet.class, "/");
	    handler.addServlet(LoginServlet.class, "/login");
	    handler.addServlet(RegistrationServlet.class, "/reg");

	    System.out.println("Server started!");
	    server.start();
	}



	public static void main(String[] args) throws Exception {
		new MyServer().start();
	}
}