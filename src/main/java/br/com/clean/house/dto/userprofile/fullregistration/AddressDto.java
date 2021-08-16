package br.com.clean.house.dto.userprofile.fullregistration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
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
