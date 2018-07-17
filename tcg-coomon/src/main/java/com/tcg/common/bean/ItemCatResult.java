package com.tcg.common.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemCatResult {

	@JsonProperty("data")
	private List<ItemCatData> itemCatDatas = new ArrayList<ItemCatData>();

	public List<ItemCatData> getItemCatDatas() {
		return itemCatDatas;
	}

	public void setItemCatDatas(List<ItemCatData> itemCatDatas) {
		this.itemCatDatas = itemCatDatas;
	}

	
	//将ItemCatResult转成json后，格式如下
//	data[{
//		u,
//		n,
//		i[{
//			u,
//			n,
//			i[{
//				"";
//				"";
//			}]
//		}],
//	}]
}
