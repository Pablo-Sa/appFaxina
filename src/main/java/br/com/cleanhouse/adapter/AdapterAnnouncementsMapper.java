package br.com.cleanhouse.adapter;

import br.com.cleanhouse.entity.maid.AnnouncementMaid;
import br.com.cleanhouse.dto.announcement.AnnouncementMaidDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdapterAnnouncementsMapper {
    AnnouncementMaid convertDtoToEntityMaid(AnnouncementMaidDto announcementMaidDto);
}
