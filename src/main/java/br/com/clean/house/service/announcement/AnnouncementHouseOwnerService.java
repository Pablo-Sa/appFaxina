package br.com.clean.house.service.announcement;

import br.com.clean.house.entity.ownerhouse.AnnouncementHouseOwner;
import br.com.clean.house.repository.AnnouncementHouseOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnnouncementHouseOwnerService {

    private final AnnouncementHouseOwnerRepository announcementHouseOwnerRepository;

    public List<AnnouncementHouseOwner> findAll(){
        return this.announcementHouseOwnerRepository.findAll();
    }

    public Optional<AnnouncementHouseOwner> findById(String id){
        return this.announcementHouseOwnerRepository.findById(id);
    }

    public AnnouncementHouseOwner save(AnnouncementHouseOwner announcementMaid){
        return this.announcementHouseOwnerRepository.save(announcementMaid);
    }
}
