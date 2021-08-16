package br.com.clean.house.dto.announcement.houseowner;

import lombok.Getter;
import lombok.Setter;

@Getter
public class AddressDto {
    private String address;
    private String numberHome;
    private String district;
    private String cep;
    private String city;
    private String state;
    private String country;
    private String complement;
}
