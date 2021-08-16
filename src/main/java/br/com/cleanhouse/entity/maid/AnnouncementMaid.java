package br.com.cleanhouse.entity.maid;

import br.com.cleanhouse.entity.enums.AcceptedPaymentsEnum;
import br.com.cleanhouse.entity.enums.DaysOfWeekAvailableEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnnouncementMaid {
    private String login;
    private List<DaysOfWeekAvailableEnum> availableSchedule;
    private List<AcceptedPaymentsEnum> acceptedPayments;
    private boolean locomotionPaidOfClient;
    private String comments;
}
