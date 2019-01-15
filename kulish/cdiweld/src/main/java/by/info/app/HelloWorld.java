package by.info.app;

import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class HelloWorld
{
    public void printHello(@Observes ContainerInitialized event, @Parameters List<String> parameters) {

        System.out.println("Hello " + parameters.get(0));

    }

}