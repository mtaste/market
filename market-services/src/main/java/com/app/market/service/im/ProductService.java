package com.app.market.service.im;

import java.util.Map;

import com.app.market.dto.common.PageBean;
import com.app.market.dto.common.PageDTO;
import com.app.market.dto.im.ImProductInfoDTO;

public interface ProductService {

	PageBean<Map<String, String>> getList(ImProductInfoDTO p, PageDTO page);

	String saveData(ImProductInfoDTO p);

}
