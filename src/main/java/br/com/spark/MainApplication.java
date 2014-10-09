package br.com.spark;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;

import spark.servlet.SparkFilter;


public class MainApplication {
	
	private static final Integer DEFAULT_PORT = 9125;
	
	public static void main(String[] args) {
		try {
			final WebAppContext webapp = new WebAppContext();
			webapp.setContextPath( "/" );
			webapp.setWar( "/" );
            
            final FilterHolder holder = webapp.addFilter(SparkFilter.class, "/*", EnumSet.of( DispatcherType.REQUEST ));
            holder.setInitParameter("applicationClass", "br.com.spark.config.SparkApplication");
            
            final Server jetty = new Server(DEFAULT_PORT);
            jetty.setHandler( webapp );
            jetty.start();

            addShutdownHook(webapp);

            jetty.join();
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(1);
        }
	}
	
	private static void addShutdownHook(final ServletContextHandler context) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    context.getServer().stop();
                } catch (Exception e) {
                	e.printStackTrace(System.err);
                } 
        }, "shutdown-hook"));
    }
}
