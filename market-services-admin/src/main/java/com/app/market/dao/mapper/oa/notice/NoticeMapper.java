package com.app.market.dao.mapper.oa.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.app.market.dto.oa.OaNoticeDTO;

public interface NoticeMapper {

	List<Map<String, String>> getNoticeList(@Param("param") OaNoticeDTO p);

	Integer deleteNoticeData(@Param("id") String id);

}
