package cn.emay.test.http;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpTest {

	public void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getOutputStream().write("test1".getBytes());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	public void test2(HttpServletRequest request, HttpServletResponse response, List<String> params) throws IOException {
		String hh = "/";
		for (String param : params) {
			hh += param + "/";
		}
		response.getOutputStream().write(hh.getBytes());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	

}
