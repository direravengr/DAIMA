package com.springboot.project.enums;

import lombok.Getter;

/**
 * <p>
 * 状态码封装
 * </p>
 * @description: 状态码封装
 */
@Getter
public enum Status {
	/**
	 * 操作成功
	 */
	OK(200, "成功"),

	/**
	 * 客户端异常
	 */
	BAD_REQUEST(400,"客户端异常"),

	/**
	 * 没有权限
	 */
	UNAUTHORIZED(401, "暂未登录或token已经过期"),

	/**
	 * 请求异常
	 */
	REQUEST_ERROR(404, "请求资源不存在"),

	/**
	 * 未知异常
	 */
	UNKNOWN_ERROR(20001, "未知异常"),

	/**
	 * 服务器异常
	 */
	SERVER_ERROR(500, "服务器异常");

	/**
	 * 状态码
	 */
	private Integer code;
	/**
	 * 内容
	 */
	private String message;

	Status(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
