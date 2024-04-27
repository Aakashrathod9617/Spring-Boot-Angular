package com.rays.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceImpl;
import com.rays.util.DataUtility;

@Controller
@RequestMapping(value = "/ctl/User")
public class UserCtl {

	@Autowired
	public UserServiceImpl service;

	@ModelAttribute("form")
	public void preload(Model model) {
		List list = service.search(null, 0, 0);
		model.addAttribute("userList", list);
	}

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form, @RequestParam(required = false) Long id, Model model) {

		if (id != null && id > 0) {
			UserDTO dto = service.findByPk(id);
			form.setId(dto.getId());
			form.setFirstName(dto.getFirstName());
			form.setLastName(dto.getLastName());
			form.setLogin(dto.getLogin());
			form.setPassword(dto.getPassword());
			form.setDob(DataUtility.dateToString(dto.getDob()));
			form.setAddress(dto.getAddress());
		}

		return "UserView";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") @Valid UserForm form, BindingResult bindingResult ,Model model) {

		if (bindingResult.hasErrors()) {
			return "UserView";
		}

		UserDTO dto = new UserDTO();
		dto.setId(form.getId());
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setDob(DataUtility.stringToDate(form.getDob()));
		dto.setAddress(form.getAddress());

		if (form.getId() > 0) {
			service.update(dto);
			model.addAttribute("success", "DATA UPDATE");
			
		} else {
			service.add(dto);
			model.addAttribute("success", "DATA ADDED");
		}
		return "UserView";
	}

	@GetMapping("search")
	public String display(@ModelAttribute("form") UserForm form, Model model) {

		int pageNo = 1;
		int pageSize = 5;

		List list = service.search(null, pageNo, pageSize);

		form.setPageNo(pageNo);

		model.addAttribute("list", list);

		return "UserListView";

	}

	 @PostMapping("search")
	    public String search(@ModelAttribute("form") UserForm form, @RequestParam(required = false) String operation,
	                         Model model) {

	        UserDTO dto = null;

	        int pageNo = 1;
	        int pageSize = 5;


	        if (operation.equals("next")) {

	            pageNo = form.getPageNo();

	            pageNo++;

	        }

	        if (operation.equals("previous")) {

	            pageNo = form.getPageNo();
	            System.out.println("pageno" + pageNo);

	            pageNo--;

	            System.out.println("chliiii" + pageNo);

	           /* if (pageNo > 1) {
	                System.out.println("pageNo > 1");
	                pageNo--;
	            } else {
	                System.out.println("pageNo = 1");
	                pageNo = 1;

	            }*/


	            //pageNo--;

	        }

	        if (operation.equals("search")) {

	            dto = new UserDTO();

	            dto.setId(form.getId());

	            dto.setFirstName(form.getFirstName());

	        }
	        if (operation.equals("delete")) {
	            if (form.getIds() != null && form.getIds().length > 0) {
	                for (long id : form.getIds()) {
	                    service.delete(id);
	                	model.addAttribute("success", "Data Deleted");

	                }
	            }
	            else {
					model.addAttribute("error", "Select Checkbox");
				}
 
	        }

	        form.setPageNo(pageNo);
	       // form.setPageSize(pageSize);

	        List list = service.search(dto, pageNo, pageSize);
	        List nextlist = service.search(dto, pageNo + 1, pageSize);


	        model.addAttribute("list", list);
	        model.addAttribute("nextlist", nextlist);

	        return "UserListView";

	    }


}