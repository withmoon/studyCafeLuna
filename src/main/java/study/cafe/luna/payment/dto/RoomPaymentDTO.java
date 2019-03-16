package study.cafe.luna.payment.dto;

public class RoomPaymentDTO {
	int seq; //로그번호
	String imp_uid; //고유번호
	String merchant_uid; //주문번호
	String branchName; //지점명
	int roomNum; //룸번호
	String id; //user id
	String reserveTime; //예약한 시간
	String reserveEndTime; //예약한 시간
	int payAmount; //결제금액
	int varAmount; //부가세
	int status; //결제상태
	long paid_ats; //결제 시간
	String paid_at;
	String receipt_url; //결제 영수증
	String pg_provider; //결제승인된 pg사
	String pg_tid; //pg사 거래고유번호
	String reservdate; //예약 날짜
	String reservenddate;
	
	String paid_at_start; //시작 날짜 --검색용
	String paid_at_end; //끝날짜 --검색용
	
	String baseline;

	public String getBaseline() {
		return baseline;
	}

	public void setBaseline(String baseline) {
		this.baseline = baseline;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getImp_uid() {
		return imp_uid;
	}

	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}

	public String getMerchant_uid() {
		return merchant_uid;
	}

	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public String getReserveEndTime() {
		return reserveEndTime;
	}

	public void setReserveEndTime(String reserveEndTime) {
		this.reserveEndTime = reserveEndTime;
	}

	public int getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}

	public int getVarAmount() {
		return varAmount;
	}

	public void setVarAmount(int varAmount) {
		this.varAmount = varAmount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getPaid_ats() {
		return paid_ats;
	}

	public void setPaid_ats(long paid_ats) {
		this.paid_ats = paid_ats;
	}

	public String getPaid_at() {
		return paid_at;
	}

	public void setPaid_at(String paid_at) {
		this.paid_at = paid_at;
	}

	public String getReceipt_url() {
		return receipt_url;
	}

	public void setReceipt_url(String receipt_url) {
		this.receipt_url = receipt_url;
	}

	public String getPg_provider() {
		return pg_provider;
	}

	public void setPg_provider(String pg_provider) {
		this.pg_provider = pg_provider;
	}

	public String getPg_tid() {
		return pg_tid;
	}

	public void setPg_tid(String pg_tid) {
		this.pg_tid = pg_tid;
	}

	public String getReservdate() {
		return reservdate;
	}

	public void setReservdate(String reservdate) {
		this.reservdate = reservdate;
	}

	public String getReservenddate() {
		return reservenddate;
	}

	public void setReservenddate(String reservenddate) {
		this.reservenddate = reservenddate;
	}

	public String getPaid_at_start() {
		return paid_at_start;
	}

	public void setPaid_at_start(String paid_at_start) {
		this.paid_at_start = paid_at_start;
	}

	public String getPaid_at_end() {
		return paid_at_end;
	}

	public void setPaid_at_end(String paid_at_end) {
		this.paid_at_end = paid_at_end;
	}
	
}
