package ir.milux;

import org.apache.log4j.PropertyConfigurator;

/**
 * Created by milux on 1/1/17.
 */
public class MainClass {
    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure("conf/log4j.properties");
        LightServer lightServer = new LightServer(8090);
        lightServer.start();
    }
}
