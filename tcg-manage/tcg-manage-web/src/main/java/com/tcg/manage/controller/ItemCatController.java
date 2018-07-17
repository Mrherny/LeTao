package com.tcg.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcg.manage.pojo.ItemCat;
import com.tcg.manage.service.ItemCatService;

@RequestMapping("item/cat")
@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ItemCat> queryItemCatAll(@RequestParam(value = "id", defaultValue = "0") Long id) {
			List<ItemCat> list = itemCatService.queryItemCats(id);
			return list;
	}
	
	@RequestMapping(value="{id}")
	@ResponseBody
	public ItemCat queryItemCatName(@PathVariable("id")Long id){
		ItemCat itemCat = this.itemCatService.queryItemCatName(id);
		return itemCat;
	}
}
