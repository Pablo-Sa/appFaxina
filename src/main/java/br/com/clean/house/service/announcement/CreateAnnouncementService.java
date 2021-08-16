package br.com.clean.house.service.announcement;

import br.com.clean.house.adapter.AdapterAnnouncementsMapper;
import br.com.clean.house.dto.announcement.houseowner.AnnouncementHouseOwnerDto;
import br.com.clean.house.dto.announcement.maid.AnnouncementMaidDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAnnouncementService {

    private final AnnouncementMaidService announcementMaidService;
    private final AnnouncementHouseOwnerService announcementHouseOwnerService;
    private final AdapterAnnouncementsMapper adapterAnnouncementsMapper;

    public void createAnnouncementMaid(AnnouncementMaidDto dto){
        this.announcementMaidService.save(adapterAnnouncementsMapper.convertAnnouncementMaidDtoToEntity(dto));
    }

    public void createAnnouncementHouseOwner(AnnouncementHouseOwnerDto announcementHouseOwnerDto){
        this.announcementHouseOwnerService.save(this.adapterAnnouncementsMapper.convertAnnouncementHouseOwnerDtoToEntity(announcementHouseOwnerDto));
    }
}
