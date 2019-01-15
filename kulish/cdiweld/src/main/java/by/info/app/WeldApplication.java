package by.info.app;

import by.info.bean.City;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.inject.Inject;
import java.io.IOException;

public class WeldApplication {

    @Inject
    private City calc;


    public static void main(String[] args) throws IOException {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        WeldApplication app = container.instance().select(WeldApplication.class).get();
        app.run();
        weld.shutdown();
    }

    public void run() {
        calc.setPopulation(3);
        System.out.println("getPop="+calc.getPopulation());
    }
}
