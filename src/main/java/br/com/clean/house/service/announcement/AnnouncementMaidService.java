package br.com.clean.house.service.announcement;

import br.com.clean.house.entity.UserProfile;
import br.com.clean.house.entity.maid.AnnouncementMaid;
import br.com.clean.house.repository.AnnouncementMaidRepository;
import br.com.clean.house.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnnouncementMaidService {

    private final AnnouncementMaidRepository announcementMaidRepository;

    public List<AnnouncementMaid> findAll(){
        return this.announcementMaidRepository.findAll();
    }

    public Optional<AnnouncementMaid> findById(String id){
        return this.announcementMaidRepository.findById(id);
    }

    public AnnouncementMaid save(AnnouncementMaid announcementMaid){
        return this.announcementMaidRepository.save(announcementMaid);
    }
}
