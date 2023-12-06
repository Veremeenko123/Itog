package org.example.Entity;

import lombok.Data;

@Data
public class DelEntity {
    private String rost;
    private String chvet;
    private String primet;
    private String grachd;
    private String datar;
    private String prof;
    private String delo;

    @Override
    public String toString() {
        return "Дело{" +
                "Рост '" + rost + '\'' +
                ", Цвет волос и глаз '" + chvet + '\'' +
                ", Приметы '" + primet + '\'' +
                ", Гражданство '" + grachd + '\'' +
                ", Место и дата рождения" + datar + '\'' +
                ", Профессия " + prof + '\'' +
                ", Последнее дело '" + delo + '\'' +
                '}';
    }
}