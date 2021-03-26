package String;

import java.util.List;

public class AB {

	private String toUser;
	private String templateId;
	private String url;
	private String topColor;
	private List datas;
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getTemplateId() {
		return templateId;
	}
	@Override
	public String toString() {
		return "AB [toUser=" + toUser + ", templateId=" + templateId + ", url=" + url + ", topColor=" + topColor
				+ ", datas=" + datas + "]";
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTopColor() {
		return topColor;
	}
	public void setTopColor(String topColor) {
		this.topColor = topColor;
	}
	public List getDatas() {
		return datas;
	}
	public void setDatas(List datas) {
		this.datas = datas;
	}

}
