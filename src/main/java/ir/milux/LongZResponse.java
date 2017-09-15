package ir.milux;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LongZResponse {
    Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public LongZResponse() {
    }
    public LongZResponse(long value) {
        setValue(value);
    }
}