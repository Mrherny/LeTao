package com.tcg.manage.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcg.common.bean.ItemCatResult;
import com.tcg.manage.service.ItemCatService;

@Controller
@RequestMapping("api/item/cat")
public class ApiItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("all")
	public ItemCatResult queryItemCatToTree(){
		ItemCatResult itemCatResult = this.itemCatService.queryItemCatToTree();
		return itemCatResult;
	}
}
