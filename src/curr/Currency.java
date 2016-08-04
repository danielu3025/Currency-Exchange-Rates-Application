package curr;
public class Currency {
    String name;
    int unit;
    String code;
    String country;
    double rate;
    double change;

    public Currency() {
        this.name = "";
        this.unit = 0;
        this.code = "";
        this.country = "";
        this.rate = 0;
        this.change = 0;
    }
    public Currency(String name, int unit, String code, String country, double rate, double change) {
        this.name = name;
        this.unit = unit;
        this.code = code;
        this.country = country;
        this.rate = rate;
        this.change = change;
    }

    public Currency(String name, String unit, String code, String country, String rate, String change) {
        this.name = name;
        this.unit = Integer.parseInt(unit);
        this.code = code;
        this.country = country;
        this.rate = Double.parseDouble(rate);
        this.change = Double.parseDouble(change);
    }

    public String getName() {
        return name;
    }

    public int getUnit() {
        return unit;
    }

    public String getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }

    public double getRate() {
        return rate;
    }

    public double getChange() {
        return change;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", unit=" + unit +
                ", code='" + code + '\'' +
                ", country='" + country + '\'' +
                ", rate=" + rate +
                ", change=" + change +
                '}';
    }
}
