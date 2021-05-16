package br.com.cleanhouse.core.entity.ownerhouse;

import br.com.cleanhouse.core.entity.AbstractPersonEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HouseOwner extends AbstractPersonEntity {
    private String suggestedPrice;
}
