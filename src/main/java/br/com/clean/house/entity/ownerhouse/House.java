package br.com.clean.house.entity.ownerhouse;

import br.com.clean.house.entity.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class House {
    private Address address;
    private String houseOwnerCpf;
    private Integer numberRooms;
    private Integer numberFloorsHome;
    private Integer numberBathroom;
    private boolean hasPet;
    private boolean hasGarage;
}
