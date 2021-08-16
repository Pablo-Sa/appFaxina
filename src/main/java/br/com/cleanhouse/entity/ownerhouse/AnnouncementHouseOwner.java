package br.com.cleanhouse.entity.ownerhouse;

import br.com.cleanhouse.entity.enums.DaysOfWeekAvailableEnum;
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
