package com.community.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.community.app.domain.orm.Announcement;
import com.community.app.service.AnnouncementService;

@Component
public class AnnouncmentsBusiness {

	@Autowired
	AnnouncementService announcementService;
	
	public Page<Announcement> findCommunityAnnouncmentsList(Pageable pageable,int communityId) {
		
		Page<Announcement> announcementslist = announcementService.findCommunityAnnouncmentsList(pageable, communityId);
		 
		return announcementslist;
	}

}
