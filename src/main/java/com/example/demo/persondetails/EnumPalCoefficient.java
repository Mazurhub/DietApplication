package com.example.demo.persondetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum EnumPalCoefficient {
    PAL_1(1.2),
    PAL_2(1.4),
    PAL_3(1.6),
    PAL_4(1.8),
    PAL_5(2.0);

    private final double coefficient;
}
