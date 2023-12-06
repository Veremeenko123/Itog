package org.example.Entity;

import lombok.Data;

@Data
public class KartEntity {
    private String num;
    private ChelEntity chel;
    private DelEntity del;
//`
    @Override
    public String toString() {
        return "Картотека{" +
                "номер '" + num + '\'' +
                ", Преступник " + chel +
                ", дело " + del +
                '}';
    }
}
