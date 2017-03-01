package com.app.market.dao.mapper.im.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.im.ImProductChangeDTO;
import com.app.market.dto.im.ImProductInfoDTO;

public interface ImProductMapper {
	List<Map<String, String>> getList(@Param("param") ImProductInfoDTO p);

	List<Map<String, String>> getChangeList(@Param("param") ImProductChangeDTO p);

	/**
	 * 保存明细
	 * 
	 * @param id
	 * @param productIds
	 * @return
	 */
	Integer saveChangeDetail(@Param("billId") String id, @Param("productIds") String productIds);
}
