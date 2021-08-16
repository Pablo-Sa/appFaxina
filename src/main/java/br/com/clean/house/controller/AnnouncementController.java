package br.com.clean.house.controller;

import br.com.clean.house.dto.announcement.houseowner.AnnouncementHouseOwnerDto;
import br.com.clean.house.dto.announcement.maid.AnnouncementMaidDto;
import br.com.clean.house.service.announcement.CreateAnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/create_announcement")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AnnouncementController {

    private final CreateAnnouncementService createAnnouncementService;

    @PostMapping("/maid")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOfMaid(@RequestBody @Valid final AnnouncementMaidDto announcementMaidDto){
        this.createAnnouncementService.createAnnouncementMaid(announcementMaidDto);
    }

    @PostMapping("/house_owner")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOfHouseOwner(@RequestBody @Valid final AnnouncementHouseOwnerDto announcementHouseOwnerDto){
        this.createAnnouncementService.createAnnouncementHouseOwner(announcementHouseOwnerDto);
    }
}
