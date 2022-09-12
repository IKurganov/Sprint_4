package model;

public class RentInformation {
    private String date;
    private String time;
    private String color;

    public RentInformation(String date, String time, String color) {
        this.date = date;
        this.time = time;
        this.color = color;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
