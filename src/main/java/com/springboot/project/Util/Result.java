package com.springboot.project.Util;

import com.springboot.project.enums.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 通用的 API 接口封装
 * </p>
 * @description: 通用的 API 接口封装
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "通用API接口返回", description = "Common Api Response")
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 7701490074486923134L;

	@ApiModelProperty(value = "状态码")
	private Integer code;

	@ApiModelProperty(value = "返回信息")
	private String message;

	@ApiModelProperty(value = "返回数据")
	private T data;

	/**
	 * 默认返回结果
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> Success(){
		return new Result(Status.OK.getCode(),Status.OK.getMessage(),null);
	}

	/**
	 * 返回结果包含数据
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> Success(T data){
		return new Result(Status.OK.getCode(),Status.OK.getMessage(),data);
	}

	/**
	 * 自定义消息返回
	 * @param msg
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> Success(String msg,T data){
		return new Result(Status.OK.getCode(),msg,data);
	}

	/**
	 * 失败
	 * @param code
	 * @param msg
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> Error(int code,String msg){
		return new Result(code,msg,null);
	}

	/**
	 * 包含数据
	 * @param code
	 * @param msg
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> Error(int code,String msg,T data){
		return new Result(code,msg,data);
	}
}
