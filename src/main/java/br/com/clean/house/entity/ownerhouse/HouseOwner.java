package br.com.clean.house.entity.ownerhouse;

import br.com.clean.house.entity.AbstractPerson;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HouseOwner extends AbstractPerson {
    private String suggestedPrice;
}
