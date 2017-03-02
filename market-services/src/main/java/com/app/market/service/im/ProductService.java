package com.app.market.service.im;

import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.im.ImProductChangeDTO;
import com.app.market.dto.im.ImProductChangeDetailDTO;
import com.app.market.dto.im.ImProductInfoDTO;

public interface ProductService {
	/**
	 * 产品列表
	 * 
	 * @param p
	 * @param page
	 * @return
	 */
	PageBean<Map<String, String>> getList(ImProductInfoDTO p, PageDTO page);

	/**
	 * 保存产品
	 * 
	 * @param p
	 * @return
	 */
	String saveData(ImProductInfoDTO p);

	/**
	 * 删除库存变更
	 * 
	 * @param p
	 * @return
	 */
	String removeChangeData(ImProductChangeDTO p);

	/**
	 * 否决
	 * 
	 * @param p
	 * @return
	 */
	String rejectChangeData(ImProductChangeDTO p);

	/**
	 * 获取变更列表
	 * 
	 * @param page
	 * @param p
	 * @return
	 */
	PageBean<Map<String, String>> getChangeList(PageDTO page, ImProductChangeDTO p);

	/**
	 * 保存
	 * 
	 * @param p
	 * @return
	 */
	String saveChangeData(ImProductChangeDTO p);

	/**
	 * 提交
	 * 
	 * @param p
	 * @return
	 */
	String appChangeData(ImProductChangeDTO p);

	/**
	 * 审核
	 * 
	 * @param p
	 * @return
	 */
	String authChangeData(ImProductChangeDTO p);

	/**
	 * 获取产品列表
	 * 
	 * @param page
	 * @param p
	 * @return
	 */
	PageBean<Map<String, String>> getChangeProductList(PageDTO page, ImProductChangeDTO p);

	/**
	 * 获取库存变更明细
	 * 
	 * @param page
	 * @param p
	 * @return
	 */
	PageBean<Map<String, String>> changeDetail(PageDTO page, ImProductChangeDTO p);

	/**
	 * 删除明细
	 * 
	 * @param p
	 * @return
	 */
	String removeChangeDetail(ImProductChangeDTO p);

	/**
	 * 增加明细
	 * 
	 * @param p
	 * @return
	 */
	String addChangeDetail(ImProductChangeDTO p);

	/**
	 * 改变明细数据
	 * 
	 * @param p
	 * @return
	 */
	String addChangeDetailQty(ImProductChangeDetailDTO p);

}
