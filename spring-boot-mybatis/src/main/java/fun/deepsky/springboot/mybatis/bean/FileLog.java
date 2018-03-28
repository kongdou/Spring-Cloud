package fun.deepsky.springboot.mybatis.bean;

import java.util.Date;

public class FileLog {

	private String node;
	private Date date;
	private int ExecuteThreadId;
	private String content;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getExecuteThreadId() {
		return ExecuteThreadId;
	}
	public void setExecuteThreadId(int executeThreadId) {
		ExecuteThreadId = executeThreadId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	
}
