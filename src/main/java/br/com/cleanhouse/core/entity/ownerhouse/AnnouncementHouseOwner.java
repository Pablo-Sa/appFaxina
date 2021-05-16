package br.com.cleanhouse.core.entity.ownerhouse;

import br.com.cleanhouse.core.entity.enums.DaysOfWeekAvailableEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AnnouncementHouseOwner {
    private List<DaysOfWeekAvailableEnum> availabeSchedule;
    private House house;
    private String comments;
}
