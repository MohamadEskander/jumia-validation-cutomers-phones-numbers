package com.example.jumiatask.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Country {
    private String name;
    private String code;
    private String regex;

    public Map<String , Country> getCountries(){
        return new HashMap<String , Country>(){{
            put("(237)", new Country("Cameroon","(237)", "\\(237\\)\\ ?[2368]\\d{7,8}$"));
            put("(251)",new Country( "Ethiopia","(251)", "\\(251\\)\\ ?[1-59]\\d{8}$"));
            put("(212)",new Country("Morocco","(212)", "\\(212\\)\\ ?[5-9]\\d{8}$"));
            put("(258)",new Country("Mozambique","(258)", "\\(258\\)\\ ?[28]\\d{7,8}$"));
            put("(256)",new Country("Uganda","(256)", "\\(256\\)\\ ?\\d{9}$"));
        }};
    }
}
