package br.com.clean.house.dto.announcement.maid;

import br.com.clean.house.dto.announcement.enums.AcceptedPaymentsEnumDto;
import br.com.clean.house.dto.announcement.enums.DaysOfWeekAvailableEnumDto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Getter
public class AnnouncementMaidDto {

    @NotBlank
    private String loginUserProfile;

    @NotNull
    private BigDecimal averagePrice;

    @NotNull
    private List<DaysOfWeekAvailableEnumDto> availableSchedule;

    @NotNull
    private List<AcceptedPaymentsEnumDto> acceptedPayments;

    @NotNull
    private boolean locomotionPaidOfClient;

    private String comments;
}
