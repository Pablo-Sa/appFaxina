package br.com.clean.house.entity.maid;

import br.com.clean.house.entity.enums.AcceptedPaymentsEnum;
import br.com.clean.house.entity.enums.DaysOfWeekAvailableEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "announcement_maid")
public class AnnouncementMaid {

    @Id
    private String id;
    private String loginUserProfile;
    private List<DaysOfWeekAvailableEnum> availableSchedule;
    private List<AcceptedPaymentsEnum> acceptedPayments;
    private boolean locomotionPaidOfClient;
    private String comments;
}
