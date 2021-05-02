package br.com.cleanhouse.entity.maid;

import br.com.cleanhouse.entity.enums.DaysOfWeekAvailable;
import br.com.cleanhouse.entity.enums.AcceptedPayments;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AnnouncementMaid {
    private List<DaysOfWeekAvailable> availabeSchedule;
    private List<AcceptedPayments> acceptedPayments;
    private boolean locomotionPaidOfClient;
    private String comments;
}
