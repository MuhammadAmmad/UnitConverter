package learners.com.unitconverter;

/**
 * Created by baldor on 27/7/17.
 */

public class Formula {
    String to;
    String from;
    Double value;

    public Formula() {
    }

    public Formula(String to, String from, Double value) {
        this.to = to;
        this.from = from;
        this.value = value;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
