package com.cloud.demo.res;

import com.cloud.demo.annotationi.IgnoreResponseAdvice;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author: wangjing
 * @date 2022/12/29
 **/
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return filter(returnType);
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
								  Class<? extends HttpMessageConverter<?>> selectedConverterType,
								  ServerHttpRequest request, ServerHttpResponse response) {
		if (body == null) {
			return GlobalResResult.success();
		}

		return GlobalResResult.success(body);
	}

	private Boolean filter(MethodParameter returnType) {
		final String returnTypeName = returnType.getParameterType().getName();
		boolean filter = !"com.cloud.demo.res.GlobalResResult".equals(returnTypeName) && !"org.springframework.http.ResponseEntity".equals(returnTypeName);
		// 检查注解是否存在
		if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
			filter = false;
		}
		return filter;

	}
}
