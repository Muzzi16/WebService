package com.community.app.jpa.repo;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.community.app.domain.orm.Announcement;
import com.community.app.domain.orm.Community;

public interface AnnouncementRepo extends CrudRepository<Announcement, BigDecimal> {

	  @Query("SELECT A FROM Announcement A WHERE A.community= ?1")
	  Page<Announcement> findAnnouncementByCommunity(Community community, Pageable pageable);
}
