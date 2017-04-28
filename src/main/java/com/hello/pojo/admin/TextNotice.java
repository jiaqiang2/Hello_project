package com.hello.pojo.admin;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文本消息
 * @author ttc
 *
 */
//@XmlRootElement
@XStreamAlias("xml")
public class TextNotice {
	@XStreamAlias("ToUserName")
	private String ToUserName;     //开发者微信号 
	
	@XStreamAlias("FromUserName")
	private String FromUserName;   //发送方帐号（一个OpenID）
	
	@XStreamAlias("CreateTime")
	private Integer CreateTime;    //消息创建时间 （整型） 
	
	@XStreamAlias("MsgType")
	private String MsgType;        //text 
	
	@XStreamAlias("Content")
	private String Content;        //文本消息内容
	
	@XStreamAlias("MsgId")
	private Integer MsgId;         //消息id，64位整型
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public Integer getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Integer createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Integer getMsgId() {
		return MsgId;
	}
	public void setMsgId(Integer msgId) {
		MsgId = msgId;
	}
	
	public TextNotice() {
		super();
	}
	public TextNotice(String toUserName, String fromUserName, Integer createTime, String msgType, String content,
			Integer msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		Content = content;
		MsgId = msgId;
	}
	
	@Override
	public String toString() {
		return "TextNotice [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime
				+ ", MsgType=" + MsgType + ", Content=" + Content + ", MsgId=" + MsgId + "]";
	}
	
	
	
}
