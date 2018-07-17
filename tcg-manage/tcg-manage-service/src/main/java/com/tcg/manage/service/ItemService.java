package com.tcg.manage.service;


import com.github.pagehelper.PageInfo;
import com.tcg.manage.pojo.Item;
import com.tcg.manage.pojo.ItemDesc;

public interface ItemService {

	void saveItem(Item item, String desc);

	Item selectItem(Item item);

	PageInfo<Item> queryPageListAndSort(Integer page, Integer rows);

	ItemDesc queryItemDescById(Long itemId);

	void updateItem(Item item, String desc);
}
