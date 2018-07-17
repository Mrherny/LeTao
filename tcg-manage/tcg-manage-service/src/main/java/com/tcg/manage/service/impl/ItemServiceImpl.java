package com.tcg.manage.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tcg.manage.mapper.ItemMapper;
import com.tcg.manage.pojo.Item;
import com.tcg.manage.pojo.ItemDesc;
import com.tcg.manage.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public void saveItem(Item item,String desc) {
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());
		itemMapper.saveItem(item);
		
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(this.selectItem(item).getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(itemDesc.getCreated());
		itemMapper.saveItemDesc(itemDesc);
	}

	@Override
	public Item selectItem(Item item) {
		return itemMapper.selectItem(item);
	}

	@Override
	public PageInfo<Item> queryPageListAndSort( Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Item> itemlist = itemMapper.selectItemAll();
		return new PageInfo<>(itemlist);
	}

	@Override
	public ItemDesc queryItemDescById(Long itemId) {
		return this.itemMapper.queryItemDescById(itemId);
	}

	@Override
	public void updateItem(Item item, String desc) {
		 this.itemMapper.updateItem(item);
		
		 ItemDesc itemDesc = new ItemDesc();
		 itemDesc.setItemDesc(desc);
		 itemDesc.setItemId(item.getId());
		 this.itemMapper.updateItemDesc(itemDesc);
		
	}
	


}
