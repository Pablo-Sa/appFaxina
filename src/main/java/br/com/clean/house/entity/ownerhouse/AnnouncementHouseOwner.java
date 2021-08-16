package br.com.clean.house.entity.ownerhouse;

import br.com.clean.house.entity.enums.DaysOfWeekAvailableEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "announcement_house_owner")
public class AnnouncementHouseOwner {

    @Id
    private String id;
    private String loginUserProfile;
    private List<DaysOfWeekAvailableEnum> availableSchedule;
    private House house;
    private String comments;
}
