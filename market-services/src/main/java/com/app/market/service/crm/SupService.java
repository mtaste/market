package com.app.market.service.crm;

import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.crm.CrmSupInfoDTO;

public interface SupService {

	PageBean<Map<String, String>> getSupList(CrmSupInfoDTO p, PageDTO page);

	String saveSupData(CrmSupInfoDTO p);

}
