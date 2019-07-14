package pl.biuropodrozy.entity.trip;

import lombok.Getter;

@Getter
public enum Catering {
    BB("BB"),
    HB("HB"),
    FB("FB"),
    AI("AI");

    private String symbol;

    Catering(String symbol) {
        this.symbol = symbol;
    }
}
