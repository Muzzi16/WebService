package com.community.app.service;

import java.util.ArrayList;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.domain.orm.Announcement;
import com.community.app.domain.orm.Community;
import com.community.app.jpa.repo.AnnouncementRepo;

@Service
@Transactional
public class AnnouncementService {

	@Autowired
	AnnouncementRepo announcementRepo;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	public Page<Announcement> findCommunityAnnouncmentsList(Pageable pageable, int communityId) {

		PageImpl pageResults = null;

		try {

			Community community = new Community();
			community.setCommunity_id(communityId);
			Page<Announcement> alist = announcementRepo.findAnnouncementByCommunity(community, pageable);

			ArrayList<Announcement> newList = new ArrayList<Announcement>();

			alist.forEach(announcement -> {
				Announcement outputAnn = dozerBeanMapper.map(announcement, Announcement.class);

				newList.add(outputAnn);

			});

			pageResults = new PageImpl(newList, pageable, alist.getTotalElements());

		} catch (Exception e) {
			e.printStackTrace();

		}

		return pageResults;
	}

}
