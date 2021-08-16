package br.com.cleanhouse.dto.announcement;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Getter
public class AnnouncementMaidDto {

    @NotBlank
    private String login;

    @NotNull
    private BigDecimal averagePrice;

    @NotBlank
    private List<DaysOfWeekAvailableEnumDto> availableSchedule;

    @NotBlank
    private List<AcceptedPaymentsEnumDto> acceptedPayments;

    @NotNull
    private boolean locomotionPaidOfClient;

    private String comments;
}
