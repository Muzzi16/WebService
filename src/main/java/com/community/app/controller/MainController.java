package com.community.app.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.community.app.business.AnnouncmentsBusiness;
import com.community.app.domain.orm.Announcement;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	AnnouncmentsBusiness announcmentsBusiness;
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@CrossOrigin
	@RequestMapping(value = "/announcments/community", method = RequestMethod.GET)
	@ResponseBody
	public Page<Announcement> getAnnaouncmentsByCommunity( @RequestParam(value="communityId",required=true) int communityId, Pageable pageable) {
		
		logger.info("Inside getAnnaouncmentsByCommunity");

		Page<Announcement> announcementsList = null;//new ArrayList<Announcement>();
		
		try {
			announcementsList = announcmentsBusiness.findCommunityAnnouncmentsList(pageable, communityId);

		} catch (Exception e) {
			//announcementsList = new ArrayList<Announcement>();
			e.printStackTrace();
		}
		
		
		return announcementsList;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@CrossOrigin
	@RequestMapping(value = "/announcments", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Announcement> getlatestAnnaouncments(@RequestParam(value="size",required=true) int size, @RequestParam(value="communityId",required=true) int communityId) {
		
		logger.info("Inside getlatestAnnaouncments");

		ArrayList<Announcement> announcementsList = new ArrayList<Announcement>();
		
		try {
			//announcementsList = announcmentsBusiness.findannouncmentsList(size, communityId);

		} catch (Exception e) {
			announcementsList = new ArrayList<Announcement>();
		}
		
		
		return announcementsList;
	}
	
	
	@CrossOrigin
	@MessageMapping("/mychat")
	@SendTo("/topic/messages")
	public Announcement send(Announcement message) throws Exception {
	 //   String time = new SimpleDateFormat("HH:mm").format(new Date());
		Announcement an = new Announcement();
		an.setAnnouncementDesc("websocket test");
		
		return an;
	}
	

}
