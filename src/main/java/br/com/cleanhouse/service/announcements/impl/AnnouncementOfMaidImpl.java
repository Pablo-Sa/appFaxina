package br.com.cleanhouse.service.announcements.impl;

import br.com.cleanhouse.adapter.AdapterAnnouncementsMapper;
import br.com.cleanhouse.service.announcements.Announcement;
import br.com.cleanhouse.core.usecase.announcements.AnnouncementOfMaidUseCase;
import br.com.cleanhouse.infra.database.dynamodb.repository.AnnouncementRepositoryDynamoDb;
import br.com.cleanhouse.dto.announcement.AnnouncementMaidDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnnouncementOfMaidImpl implements Announcement<AnnouncementMaidDto> {

    private final AdapterAnnouncementsMapper adapterAnnouncementsMapper;
    private AnnouncementOfMaidUseCase announcementOfMaidUseCase = new AnnouncementOfMaidUseCase(new AnnouncementRepositoryDynamoDb());

    public void createAnnouncement(AnnouncementMaidDto announcementMaidDto) {
        this.announcementOfMaidUseCase.create(this.adapterAnnouncementsMapper.convertDtoToEntityMaid(announcementMaidDto));
    }
}
