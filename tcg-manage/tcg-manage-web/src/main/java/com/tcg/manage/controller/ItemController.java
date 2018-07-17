package com.tcg.manage.controller;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tcg.common.bean.EasyUiResult;
import com.tcg.manage.pojo.Item;
import com.tcg.manage.pojo.ItemDesc;
import com.tcg.manage.service.ItemService;

@RequestMapping("item")
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> saveItem(Item item,String desc ){
		HashMap<String, String> map = new HashMap<String, String>();
		if (StringUtils.isEmpty(item.getTitle())) {
			map.put("code", "400");
		}
		item.setStatus(1);
		item.setId(null);
		itemService.saveItem(item, desc);
		map.put("code", "201");
		return map;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public EasyUiResult queryItem(@RequestParam(value="page",defaultValue="0")Integer page, 
			                      @RequestParam(value="rows",defaultValue="30")Integer rows){
		PageInfo<Item> pageInfo = this.itemService.queryPageListAndSort(page,rows);
		EasyUiResult easyUiResult = new EasyUiResult(pageInfo.getTotal(), pageInfo.getList());
		return easyUiResult;
	}
	
	@RequestMapping("desc/{itemId}")
	@ResponseBody
	public ItemDesc queryItemDescById(@PathVariable("itemId")Long itemId){
		ItemDesc itemDesc = this.itemService.queryItemDescById(itemId);
		return itemDesc;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseBody
	public HashMap<String,String> updateItem(Item item,String desc ){
		HashMap<String, String> map = new HashMap<String, String>();
		if (StringUtils.isEmpty(item.getTitle())) {
			map.put("code", "400");
		}
		try {
			item.setStatus(1);
			itemService.updateItem(item, desc);
			map.put("code", "204");
		} catch (Exception e) {
			map.put("code", "500");
		}
		return map;
	}
}
