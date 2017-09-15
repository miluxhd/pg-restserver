package ir.milux;


import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by miluz on 9/15/17.
 */
public class PgConnection {
    private static Logger logger = Logger.getLogger(PgConnection.class);
    private static Connection INSTANCE;
    public static synchronized Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        if (INSTANCE == null){
            logger.info("initializing database connection...");
            Properties properties = new Properties();
            FileInputStream inputStream = new FileInputStream("conf/config.conf");
            properties.load(inputStream);
            Class.forName(properties.getProperty("driverclass"));
            StringBuilder url = new StringBuilder();
            url.append("jdbc:")
                    .append(properties.getProperty("databasetype")+"://")
                    .append(properties.getProperty("host")+":")
                    .append(properties.getProperty("port")+"/")
                    .append(properties.getProperty("dbname"));
            INSTANCE = DriverManager.getConnection(url.toString(),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
        }
return INSTANCE;
    }
}
