package org.example.Entity;

import lombok.Data;

@Data
public class ChelEntity {
    private String name;
    private String surname;
    private String klichka;
//`
    @Override
    public String toString() {
        return "Преступник{" +
                "Имя='" + name + '\'' +
                ", Фамилия='" + surname + '\'' +
                ", Погоняло='" + klichka + '\'' +
                '}';
    }
}
