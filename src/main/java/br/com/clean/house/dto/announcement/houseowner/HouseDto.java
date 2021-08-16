package br.com.clean.house.dto.announcement.houseowner;

import lombok.Getter;

@Getter
public class HouseDto {
    private AddressDto address;
    private String houseOwnerCpf;
    private Integer numberRooms;
    private Integer numberFloorsHome;
    private Integer numberBathroom;
    private boolean hasPet;
    private boolean hasGarage;
}
