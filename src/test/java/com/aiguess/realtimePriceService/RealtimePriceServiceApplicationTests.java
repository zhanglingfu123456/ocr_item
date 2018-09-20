package com.aiguess.realtimePriceService;

import com.aiguess.Utils.SortedMapUtils;
import com.sun.jdi.connect.spi.TransportService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RealtimePriceServiceApplicationTests {

	@Test
	public void contextLoads() {
		String str = "|930,940,940,935,940,285430000,267778797900|931,940,942,939,940,338862100,318517121900|932,941,947,941,946,213080000,200912100000|9";

		System.err.println(str.split("|"));

	}


	@Test
	public void timeUtils(){
		System.err.println("时间测试");

		String password = DigestUtils.md5Hex("baidu.com");

		System.err.println(password);


	}

	//排序的测试
	@Test
	public  void sortByValue() {
		Map<String,BigDecimal> map = new TreeMap<String,BigDecimal>();
		map.put("a", new BigDecimal(1.243));
		map.put("d", new BigDecimal(1.213));
		map.put("b", new BigDecimal(1.253));
		map.put("c", new BigDecimal(1.263));

		// 构造结果
		LinkedHashMap<String, BigDecimal> resultMap= SortedMapUtils.sortByValueBigToSmall(map);

		//验证：
		// 跌幅最小
		SortedMapUtils.logForHashMap(resultMap);


		System.err.println("最大"+SortedMapUtils.getFirstElement(resultMap).getValue());

		System.err.println("最小"+SortedMapUtils.getLastElement(resultMap).getValue());

	}

}
