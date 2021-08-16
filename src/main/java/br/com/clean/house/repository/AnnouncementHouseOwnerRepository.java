package br.com.clean.house.repository;

import br.com.clean.house.entity.ownerhouse.AnnouncementHouseOwner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnnouncementHouseOwnerRepository extends MongoRepository<AnnouncementHouseOwner, String> {
}
