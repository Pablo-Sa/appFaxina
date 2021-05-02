package br.com.cleanhouse.entity.maid;

import br.com.cleanhouse.entity.AbstractPersonEntity;
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
