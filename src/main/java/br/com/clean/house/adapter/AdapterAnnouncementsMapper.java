package br.com.clean.house.adapter;


import br.com.clean.house.dto.announcement.houseowner.AnnouncementHouseOwnerDto;
import br.com.clean.house.dto.announcement.maid.AnnouncementMaidDto;
import br.com.clean.house.entity.maid.AnnouncementMaid;
import br.com.clean.house.entity.ownerhouse.AnnouncementHouseOwner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdapterAnnouncementsMapper {
    AnnouncementMaid convertAnnouncementMaidDtoToEntity(AnnouncementMaidDto announcementMaidDto);
    AnnouncementHouseOwner convertAnnouncementHouseOwnerDtoToEntity(AnnouncementHouseOwnerDto announcementHouseOwnerDto);
}
