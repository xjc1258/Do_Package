package basic.ZhiFuBao;

public class PayVo {
	
		private String out_trade_no; // 商户订单号 必填
	    private String subject; // 订单名称 必填
	    private String total_amount;  // 付款金额 必填
	    private String body; // 商品描述 可空


	    @Override
		public String toString() {
			return "PayVo [out_trade_no=" + out_trade_no + ", subject=" + subject + ", total_amount=" + total_amount
					+ ", body=" + body + ", getOut_trade_no()=" + getOut_trade_no() + ", getSubject()=" + getSubject()
					+ ", getTotal_amount()=" + getTotal_amount() + ", getBody()=" + getBody() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
			public String getOut_trade_no() {
			return out_trade_no;
		}
		public void setOut_trade_no(String out_trade_no) {
			this.out_trade_no = out_trade_no;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getTotal_amount() {
			return total_amount;
		}
		public void setTotal_amount(String total_amount) {
			this.total_amount = total_amount;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
}
