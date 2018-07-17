package com.tcg.manage.service;

import java.util.List;

import com.tcg.common.bean.ItemCatResult;
import com.tcg.manage.pojo.ItemCat;

public interface ItemCatService {

	List<ItemCat> queryItemCats(Long id);

	ItemCat queryItemCatName(Long id);

	ItemCatResult queryItemCatToTree();
	
	List<ItemCat> queryItemCatAll();

}
