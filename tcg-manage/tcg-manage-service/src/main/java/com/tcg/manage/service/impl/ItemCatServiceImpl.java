package com.tcg.manage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcg.common.bean.ItemCatData;
import com.tcg.common.bean.ItemCatResult;
import com.tcg.manage.mapper.ItemCatMapper;
import com.tcg.manage.pojo.ItemCat;
import com.tcg.manage.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private PropertiesService propertiesService;

	@Autowired
	private ItemCatMapper itemCatMapper;

	public List<ItemCat> queryItemCats(Long id) {
		return itemCatMapper.queryItemCats(id);
	}

	@Override
	public ItemCat queryItemCatName(Long id) {
		return this.itemCatMapper.queryItemCatName(id);
	}

	@Override
	public List<ItemCat> queryItemCatAll() {
		return this.itemCatMapper.queryItemCatAll();
	}

	@Override
	public ItemCatResult queryItemCatToTree() {
		List<ItemCat> itemCats = this.queryItemCatAll();
		// 分离开所有的父级类目 isParent属性为true,将父级类目的所有子类目进行关联
		// Map<"父级类目id","子类目的集合">
		Map<Long, List<ItemCat>> parentMap = new HashMap<Long, List<ItemCat>>();
		// 最顶级类目
		// parentMap.put(0L, new ArrayList<ItemCat>());
		for (ItemCat itemCat : itemCats) {

			if (!parentMap.containsKey(itemCat.getParentId())) {
				parentMap.put(itemCat.getParentId(), new ArrayList<ItemCat>());
			}
			parentMap.get(itemCat.getParentId()).add(itemCat);
			// 如果当前对象的父级类目id在parentMap的key中，归入子类目集合中

		}
		// 封装一级类目
		List<ItemCat> parent1 = parentMap.get(0L);
		ItemCatResult result = new ItemCatResult();
		for (ItemCat itemCat1 : parent1) {
			// 一级类目 itemCatData
			ItemCatData itemCatData = new ItemCatData();
			// 将一级类目放入Result中
			result.getItemCatDatas().add(itemCatData);
			itemCatData.setUrl("/products/" + itemCat1.getId() + ".html");
			itemCatData.setName("<a href='/products/" + itemCat1.getId() + ".html'>" + itemCat1.getName() + "</a>");
			// items是当前一级类目的二级类目的集合
			List<ItemCatData> itemCatDatas2 = new ArrayList<ItemCatData>();
			itemCatData.setItems(itemCatDatas2);
			// 从Map中取出当前一级类目的所有子类目
			List<ItemCat> parent2 = parentMap.get(itemCat1.getId());
			for (ItemCat itemCat2 : parent2) {
				// 二级类目对象itemCatData2
				ItemCatData itemCatData2 = new ItemCatData();
				itemCatData2.setUrl("/products/" + itemCat2.getId() + ".html");
				itemCatData2
						.setName("<a href='/products/" + itemCat2.getId() + ".html'>" + itemCat2.getName() + "</a>");
				// 放入一级类目中
				itemCatDatas2.add(itemCatData2);
				// 当前二级类目的三级类目
				List<String> itemCatDatas3 = new ArrayList<String>();
				itemCatData2.setItems(itemCatDatas3);
				List<ItemCat> parent3 = parentMap.get(itemCat2.getId());
				for (ItemCat itemCat3 : parent3) {
					itemCatDatas3.add("/products/" + itemCat3.getId() + ".html|" + itemCat3.getName());
				}
			}
		}
		return result;
	}

}
