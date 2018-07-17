package com.tcg.manage.mapper;

import java.util.List;

import com.tcg.manage.pojo.Item;
import com.tcg.manage.pojo.ItemDesc;

public interface ItemMapper {

	void saveItem(Item item);

	void saveItemDesc(ItemDesc itemDesc);

	Item selectItem(Item item);

	List<Item> selectItemAll();

	ItemDesc queryItemDescById(Long itemId);

	void updateItem(Item item);

	void updateItemDesc(ItemDesc itemDesc);
	
}
