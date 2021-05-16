package br.com.cleanhouse.core.entity.maid;

import br.com.cleanhouse.core.entity.enums.DaysOfWeekAvailableEnum;
import br.com.cleanhouse.core.entity.enums.AcceptedPaymentsEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AnnouncementMaid {
    private List<DaysOfWeekAvailableEnum> availabeSchedule;
    private List<AcceptedPaymentsEnum> acceptedPayments;
    private boolean locomotionPaidOfClient;
    private String comments;
}
