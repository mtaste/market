package com.app.market.dao.mapper.mms.info;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.mms.MmsInfoDTO;
import com.app.market.dto.mms.MmsPointsChangeDTO;

public interface MmsMapper {
	List<Map<String, String>> getInfoList(@Param("param") MmsInfoDTO p);

	List<Map<String, String>> getPointChangeList(@Param("param") MmsPointsChangeDTO p);

	List<Map<String, String>> getPointsChangeDetail(@Param("param") MmsPointsChangeDTO p);

	List<Map<String, String>> getPointsChangeMemberList(@Param("param") MmsPointsChangeDTO p);

	Integer removePointsChangeDetail(@Param("param") MmsPointsChangeDTO p);

	Integer savePointsChangeDetail(@Param("param") MmsPointsChangeDTO p);

	Integer saveMemberPointsChange(@Param("param") MmsPointsChangeDTO p);
}
