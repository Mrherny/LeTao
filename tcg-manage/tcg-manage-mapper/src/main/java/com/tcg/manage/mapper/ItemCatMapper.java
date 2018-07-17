package com.tcg.manage.mapper;

import java.util.List;

import com.tcg.manage.pojo.ItemCat;

public interface ItemCatMapper {

	List<ItemCat> queryItemCats(Long id);

	ItemCat queryItemCatName(Long id);

	List<ItemCat> queryItemCatAll();
	
}
