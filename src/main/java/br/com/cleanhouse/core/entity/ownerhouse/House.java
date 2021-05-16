package br.com.cleanhouse.core.entity.ownerhouse;

import br.com.cleanhouse.core.entity.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class House extends Address {
    private String houseOwnerCpf;
    private Integer numberRooms;
    private Integer numberFloorsHome;
    private Integer numberBathroom;
    private boolean hasPet;
    private boolean hasGarage;
}