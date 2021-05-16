package br.com.cleanhouse.core.entity.maid;

import br.com.cleanhouse.core.entity.AbstractPersonEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Maid extends AbstractPersonEntity {
    private BigDecimal averagePrice;
}
