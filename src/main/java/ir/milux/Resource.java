package ir.milux;


import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Path("/rest")
public class Resource{
Logger logger = Logger.getLogger(Resource.class);
    @POST
    @Path("/long")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LongZResponse getIt(LongZRequest request) {

        try {
            Connection con = PgConnection.getConnection();
            PreparedStatement stat = con.prepareStatement("select getvalue_uint(?,?,?)");
            stat.setString(1,request.getKey());
            stat.setString(2,request.getHost());
            stat.setLong(3,request.getTimestamp());
            ResultSet result = stat.executeQuery();
            while (result.next()){
                LongZResponse response = new LongZResponse(
                        result.getLong("getvalue_uint")
                );
                return response;
            }

        }catch (Exception e){
            logger.error(e);
        }
        return null;
    }

}
