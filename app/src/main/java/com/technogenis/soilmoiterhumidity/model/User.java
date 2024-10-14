package com.technogenis.soilmoiterhumidity.model;

public class User {

    String Id;
    String AirHumidity;
    String AirTemps;
    String DatedTime;
    String Moistures;
    String SoilTemps;
    String SoilNitrogen;
    String SoilPhosphorous;
    String SoilPotassium;
    String img;

    public User(String id, String airHumidity, String airTemps, String datedTime, String moistures, String soilTemps, String soilNitrogen, String soilPhosphorous, String soilPotassium, String img) {
        Id = id;
        AirHumidity = airHumidity;
        AirTemps = airTemps;
        DatedTime = datedTime;
        Moistures = moistures;
        SoilTemps = soilTemps;
        SoilNitrogen = soilNitrogen;
        SoilPhosphorous = soilPhosphorous;
        SoilPotassium = soilPotassium;
        this.img = img;
    }

    public User() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAirHumidity() {
        return AirHumidity;
    }

    public void setAirHumidity(String airHumidity) {
        AirHumidity = airHumidity;
    }

    public String getAirTemps() {
        return AirTemps;
    }

    public void setAirTemps(String airTemps) {
        AirTemps = airTemps;
    }

    public String getDatedTime() {
        return DatedTime;
    }

    public void setDatedTime(String datedTime) {
        DatedTime = datedTime;
    }

    public String getMoistures() {
        return Moistures;
    }

    public void setMoistures(String moistures) {
        Moistures = moistures;
    }

    public String getSoilTemps() {
        return SoilTemps;
    }

    public void setSoilTemps(String soilTemps) {
        SoilTemps = soilTemps;
    }

    public String getSoilNitrogen() {
        return SoilNitrogen;
    }

    public void setSoilNitrogen(String soilNitrogen) {
        SoilNitrogen = soilNitrogen;
    }

    public String getSoilPhosphorous() {
        return SoilPhosphorous;
    }

    public void setSoilPhosphorous(String soilPhosphorous) {
        SoilPhosphorous = soilPhosphorous;
    }

    public String getSoilPotassium() {
        return SoilPotassium;
    }

    public void setSoilPotassium(String soilPotassium) {
        SoilPotassium = soilPotassium;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
