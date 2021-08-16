package br.com.cleanhouse.core.usecase.announcements;

import br.com.cleanhouse.entity.maid.AnnouncementMaid;
import br.com.cleanhouse.core.repository.AnnouncementRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnnouncementOfMaidUseCase {

    private final AnnouncementRepository announcementRepository;

    public void create(AnnouncementMaid announcementMaid){
        this.announcementRepository.createAnnouncementsMaid(announcementMaid);
    }
}
