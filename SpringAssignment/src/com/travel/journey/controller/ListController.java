package com.travel.journey.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.travel.journey.dto.Travel;
import com.travel.journey.service.TravelService;

@Controller
public class ListController {
	@Autowired
	private TravelService travelService;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = "/photoWrite", method = RequestMethod.GET)
	public String photoWriteGet() {
		return "photoWrite";
	}

	@RequestMapping(value = "/photoWrite", method = RequestMethod.POST)
	public String photoWritePost(Travel travel) throws IllegalStateException, IOException {
		if (!travel.getTattach().isEmpty()) {
			travel.setToriginalfilename(travel.getTattach().getOriginalFilename());
			String originalFileName = travel.getToriginalfilename();

			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			String fileName = new Date().getTime() + "-" + travel.getToriginalfilename();

			File file = new File(realPath + fileName);
			travel.getTattach().transferTo(file);
			travel.setTsavedfilename(fileName);
			travel.setTfilecontent("/WEB-INF/upload/" + fileName);
		}
		travelService.travelWrite(travel);
		return "redirect:/photolist";
	}

	@RequestMapping("/photolist")
	public String photoList(@RequestParam(defaultValue = "1") int pageNo, Model model) {
		int rowsPerPage = 5;
		int pagesPerGroup = 3;
		int totalRows = travelService.travelTotalRows();
		int totalPageNo = totalRows / rowsPerPage + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		int totalGroupNo = totalPageNo / pagesPerGroup + ((totalPageNo % pagesPerGroup != 0) ? 1 : 0);
		int groupNo = (pageNo - 1) / pagesPerGroup + 1;
		int startPageNo = (groupNo - 1) * pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if (groupNo == totalGroupNo)
			endPageNo = totalPageNo;

		List<Travel> list = travelService.travelListPage(pageNo, rowsPerPage);

		model.addAttribute("list", list);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);

		return "photolist";
	}

	@RequestMapping("/photoDetail")
	public String photoDetail(int tnumber, Model model) {
		Travel travel = travelService.getTravel(tnumber);
		model.addAttribute("travel", travel);
		return "photoDetail";
	}

	@RequestMapping(value = "/photoUpdate", method = RequestMethod.GET)
	public String travelUpdateGet(int tnumber, Model model) {
		Travel travel = travelService.getTravel(tnumber);
		model.addAttribute("travel", travel);
		return "photoUpdate";
	}

	@RequestMapping(value = "/photoUpdate", method = RequestMethod.POST)
	public String travelUpdatePost(Travel travel) throws IllegalStateException, IOException {
		if (!travel.getTattach().isEmpty()) {
			travel.setToriginalfilename(travel.getTattach().getOriginalFilename());
			String originalFileName = travel.getToriginalfilename();

			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			String fileName = new Date().getTime() + "-" + travel.getToriginalfilename();

			File file = new File(realPath + fileName);
			
			travel.getTattach().transferTo(file);
			travel.setTsavedfilename(fileName);
			travel.setTfilecontent("/WEB-INF/upload/" + fileName);

		}
		travelService.travelUpdate(travel);
		return "redirect:/photoDetail?tnumber=" + travel.getTnumber();
	}

	@RequestMapping("/photoDelete")
	public String travelDelete(int tnumber) {
		travelService.travelDelete(tnumber);
		return "redirect:photolist";
	}
}
