package br.com.cleanhouse.entity.ownerhouse;

import br.com.cleanhouse.entity.AbstractPersonEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HouseOwner extends AbstractPersonEntity {
    private String suggestedPrice;
}
