package br.com.clean.house.repository;

import br.com.clean.house.entity.maid.AnnouncementMaid;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnnouncementMaidRepository extends MongoRepository<AnnouncementMaid, String> {
}
