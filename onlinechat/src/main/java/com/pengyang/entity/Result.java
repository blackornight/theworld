package com.pengyang.entity;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class Result {
	private String status;//请求状态，当请求状态为200时，表示成功，400时表示失败。
	private Map data;//传回页面的数据,单条数据
	private List<Map> listData;//传回页面的数据，多条数据
	
	
	public Result(){
		
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map getData() {
		return data;
	}
	public void setData(Map data) {
		this.data = data;
	}
	public List<Map> getListData() {
		return listData;
	}
	public void setListData(List<Map> listData) {
		this.listData = listData;
	}
	
	@Override
	public String toString() {
		return "Result [status=" + status + ", data=" + data + ", listData="
				+ listData + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((listData == null) ? 0 : listData.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (listData == null) {
			if (other.listData != null)
				return false;
		} else if (!listData.equals(other.listData))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	

}
