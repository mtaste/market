package org.market.services.admin;

import com.app.market.dto.sys.SysAuthDTO;
import com.app.market.support.util.ReflectUtil;

public class TestClass {

	public static void main(String[] args) {
		SysAuthDTO p = new SysAuthDTO();
		p.setId("Test11");
		String id = ReflectUtil.getValue(p, "getId").toString();
		System.out.println(id);
		ReflectUtil.setValue(p, "setId", "Testkkkk");
		System.out.println(p.getId());

	}

}
