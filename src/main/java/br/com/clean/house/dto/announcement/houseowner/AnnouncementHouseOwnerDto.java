package br.com.clean.house.dto.announcement.houseowner;

import br.com.clean.house.dto.announcement.enums.DaysOfWeekAvailableEnumDto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class AnnouncementHouseOwnerDto {

    @NotBlank
    private String loginUserProfile;

    @NotNull
    private List<DaysOfWeekAvailableEnumDto> availableSchedule;

    @NotNull
    private HouseDto house;

    private String comments;
}
