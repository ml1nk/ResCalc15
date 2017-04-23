package v1.hapra.rescalc15;

/**
 * Created by mlink on 4/23/17.
 */

public class calculation {

    private String first;
    private String second;
    private String third;
    private String fourth;
    private String fifth;
    private String sixth;

    public calculation(String first, String second, String third, String fourth, String fifth, String sixth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
    }

    public String getResistance() {
        try {
            Double resistance = getResistanceAsNumber();
            return String.format("%.0f", resistance) + " Ω";
        } catch (Exception e) {
            return "";
        }
    }

    public String getTolerance() {
        try {
            Double tolerance = colorToTolerance();
            return "± " + tolerance.toString() + " %";
        } catch (Exception e) {
            return "";
        }
    }

    public String getTemperatureCoefficient() {
        try {
            return colorToTemperatureCoefficient().toString();
        } catch (Exception e) {
            return "";
        }
    }

    private Double getResistanceAsNumber() throws Exception {
        Integer first = colorToNumber(this.first);
        Integer second = colorToNumber(this.second);
        Integer third = colorToNumber(this.third);
        Double fourth = colorToMultiplier();
        return (first * 100 + second * 10 * third)*fourth;
    }


    private Integer colorToNumber(String color) throws Exception {
        Integer number;
        switch (color) {
            case "black":case "schwarz":
                number = 0;
                break;
            case "brown":case "braun":
                number = 1;
                break;
            case "red":case "rot":
                number = 2;
                break;
            case "orange":
                number = 3;
                break;
            case "yellow":case "gelb":
                number = 4;
                break;
            case "green":case "grün":
                number = 5;
                break;
            case "blue":case "blau":
                number = 6;
                break;
            case "violet":case "violett":
                number = 7;
                break;
            case "gray":case "grau":
                number = 8;
                break;
            case "white":case "weiß":
                number = 9;
                break;
            default:
                throw new Exception();
        }
        return number;
    }

    private Double colorToMultiplier() throws Exception {
        Double number;
        switch (fourth) {
            case "silver":case "silber":
                number = 0.01;
                break;
            case "gold":
                number = 0.1;
                break;
            case "black":case "schwarz":
                number = 1.0;
                break;
            case "brown":case "braun":
                number = 10.0;
                break;
            case "red":case "rot":
                number = 100.0;
                break;
            case "orange":
                number = 1000.0;
                break;
            case "yellow":case "gelb":
                number = 10000.0;
                break;
            case "green":case "grün":
                number = 100000.0;
                break;
            case "blue":case "blau":
                number = 1000000.0;
                break;
            case "violet":case "violett":
                number = 10000000.0;
                break;
            case "gray":case "grau":
                number = 100000000.0;
                break;
            case "white":case "weiß":
                number = 1000000000.0;
                break;
            default:
                throw new Exception();
        }
        return number;
    }

    private Double colorToTolerance() throws Exception {
        Double number;
        switch (fifth) {
            case "silver":case "silber":
                number = 10.0;
                break;
            case "gold":
                number = 5.0;
                break;
            case "brown":case "braun":
                number = 1.0;
                break;
            case "red":case "rot":
                number = 2.0;
                break;
            case "green":case "grün":
                number = 0.5;
                break;
            case "blue":case "blau":
                number = 0.25;
                break;
            case "violet":case "violett":
                number = 0.1;
                break;
            case "gray":case "grau":
                number = 0.05;
                break;
            default:
                throw new Exception();
        }
        return number;
    }

    private Integer colorToTemperatureCoefficient() throws Exception {
        Integer number;
        switch (sixth) {
            case "brown":case "braun":
                number = 100;
                break;
            case "red":case "rot":
                number = 50;
                break;
            case "orange":
                number = 15;
                break;
            case "yellow":case "gelb":
                number = 25;
                break;
            case "blue":case "blau":
                number = 10;
                break;
            case "violet":case "violett":
                number = 5;
                break;
            case "white":case "weiß":
                number = 1;
                break;
            default:
                throw new Exception();
        }
        return number;
    }
}
