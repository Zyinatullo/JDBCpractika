package com.PeakSoft.jdbc;

public class cities {
    private int id;
    private String first_name;
    private String last_name;
    private String peoples;
    private String president;

    public cities(int id, String first_name, String last_name, String peoples, String president) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.peoples = peoples;
        this.president = president;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPeoples() {
        return peoples;
    }

    public void setPeoples(String peoples) {
        this.peoples = peoples;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;

    }

    @Override
    public String toString() {
        return "cities{" +
                "id=" + id +
                "first_name='" + first_name + '\'' +
                "last_name='" + last_name + '\'' +
                "peoples='" + peoples + '\'' +
                "president='" + president + '\'' +
                '}'+"\n";
    }
}

