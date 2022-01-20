package com.PeakSoft.jdbc;

public class olko {
    private int id;
    private String name;
    private String area;
    private String currency;
    private String language;

    public olko(int id, String name, String area, String currency, String language) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.currency = currency;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "olko{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", currency='" + currency + '\'' +
                ", language='" + language + '\'' +
                '}'+"\n";
    }
}
