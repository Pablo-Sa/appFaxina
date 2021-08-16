package br.com.cleanhouse.controller;

import br.com.cleanhouse.adapter.AdapterAnnouncementsMapper;
import br.com.cleanhouse.adapter.AdapterSpringRest;
import br.com.cleanhouse.service.announcements.impl.AnnouncementOfMaidImpl;
import br.com.cleanhouse.dto.announcement.AnnouncementMaidDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create_announcement")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class CreateAnnouncementController {

    private final AdapterSpringRest adapterSpringRest;
    private final AdapterAnnouncementsMapper adapterAnnouncementsMapper;

    @PostMapping("/maid")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOfMaid(final AnnouncementMaidDto announcementMaidDto){
        this.adapterSpringRest.createAnnouncement(announcementMaidDto, new AnnouncementOfMaidImpl(adapterAnnouncementsMapper));
    }

    @PostMapping("/house_owner")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOfHouseOwner(final AnnouncementMaidDto announcementMaidDto){
        this.adapterSpringRest.createAnnouncement(announcementMaidDto, new AnnouncementOfMaidImpl(adapterAnnouncementsMapper));
    }
}
