package ir.milux;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LongZRequest {
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    Long timestamp;
    String host;
    String key;
}
