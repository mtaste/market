package com.app.market.dao.mapper.im.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.im.ImProductChangeDTO;
import com.app.market.dto.im.ImProductInfoDTO;

public interface ImProductMapper {

	List<Map<String, String>> getList(@Param("param") ImProductInfoDTO p);

	List<Map<String, String>> getChangeList(@Param("param") ImProductChangeDTO p);

	List<Map<String, String>> getChangeProductList(@Param("param") ImProductChangeDTO p);

	List<Map<String, String>> getChangeDetail(@Param("param") ImProductChangeDTO p);

	/**
	 * 删除明细
	 * 
	 * @param id
	 * @param selectIds
	 * @return
	 */
	Integer removeChangeDetail(@Param("param") ImProductChangeDTO p);

	/**
	 * 保存明细
	 * 
	 * @param id
	 * @param selectIds
	 * @return
	 */
	Integer saveChangeDetail(@Param("param") ImProductChangeDTO p);

	/**
	 * 更新库存明细
	 * 
	 * @param id
	 * @param selectIds
	 * @return
	 */
	Integer saveChangeQty(@Param("param") ImProductChangeDTO p);

}
