package com.ggm.example.speldemo.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component("city")
public class City {

    private String name;

    private double shipping;

    private Boolean isCapital;

}
