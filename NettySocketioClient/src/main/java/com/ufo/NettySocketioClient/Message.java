package com.ufo.NettySocketioClient;

import java.util.HashSet;

public class Message {
	// 主键
	private String SID;
	// 发送人ID
	private String SenderID;
	// 接收人ID
	private HashSet<String> ReceiverIDs;
	// 标题
	private String Alert;
	// 时间
	private long Time;
	// 消息类型(文字、图片、文件、链接、音频、视频、表情等)
	private String MessageType;
	// 提醒
	private Boolean IsAlert;
	// 自定义
	private Object Others;

	public String getSID() {
		return SID;
	}

	public void setSID(String sID) {
		SID = sID;
	}

	public String getSenderID() {
		return SenderID;
	}

	public void setSenderID(String senderID) {
		SenderID = senderID;
	}

	public HashSet<String> getReceiverIDs() {
		return ReceiverIDs;
	}

	public void setReceiverIDs(HashSet<String> receiverIDs) {
		ReceiverIDs = receiverIDs;
	}

	public String getAlert() {
		return Alert;
	}

	public void setAlert(String alert) {
		Alert = alert;
	}

	public long getTime() {
		return Time;
	}

	public void setTime(long time) {
		Time = time;
	}


	public String getMessageType() {
		return MessageType;
	}

	public void setMessageType(String messageType) {
		MessageType = messageType;
	}

	public Boolean getIsAlert() {
		return IsAlert;
	}

	public void setIsAlert(Boolean isAlert) {
		IsAlert = isAlert;
	}

	public Object getOthers() {
		return Others;
	}

	public void setOthers(Object others) {
		Others = others;
	}
}
