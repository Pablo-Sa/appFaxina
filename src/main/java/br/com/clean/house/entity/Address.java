package br.com.clean.house.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Address {
    private String address;
    private String numberHome;
    private String district;
    private String cep;
    private String city;
    private String state;
    private String country;
    private String complement;
}
