package org.example.Entity;

import lombok.Data;

import java.util.List;
@Data
public class ListKarts {
    private List data;

    @Override
    public String toString() {
        return "Картотека{" +
                "Данные " + data +
                '}';
    }
}
