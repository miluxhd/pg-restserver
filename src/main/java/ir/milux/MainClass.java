package ir.milux;

/**
 * Created by milux on 1/1/17.
 */
public class MainClass {
    public static void main(String[] args) throws Exception {
        LightServer lightServer = new LightServer(8090);
        lightServer.start();
    }
}
