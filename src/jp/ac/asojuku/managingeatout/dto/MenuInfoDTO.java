package jp.ac.asojuku.managingeatout.DTO;

import java.sql.Date;

public class MenuInfoDTO {
	private String mn_id;
	private String mn_restid;
	private String mn_name;
	private String mn_cat;
	private Integer mn_price;
	private Date mn_startdate;
	private Date mn_enddate;
	private Date mn_update;
	private String mn_maneger;
	public String getMn_id() {
		return mn_id;
	}
	public void setMn_id(String mn_id) {
		this.mn_id = mn_id;
	}
	public String getMn_restid() {
		return mn_restid;
	}
	public void setMn_restid(String mn_restid) {
		this.mn_restid = mn_restid;
	}
	public String getMn_name() {
		return mn_name;
	}
	public void setMn_name(String mn_name) {
		this.mn_name = mn_name;
	}
	public String getMn_cat() {
		return mn_cat;
	}
	public void setMn_cat(String mn_cat) {
		this.mn_cat = mn_cat;
	}
	public Integer getMn_price() {
		return mn_price;
	}
	public void setMn_price(Integer mn_price) {
		this.mn_price = mn_price;
	}
	public Date getMn_startdate() {
		return mn_startdate;
	}
	public void setMn_startdate(Date mn_startdate) {
		this.mn_startdate = mn_startdate;
	}
	public Date getMn_enddate() {
		return mn_enddate;
	}
	public void setMn_enddate(Date mn_enddate) {
		this.mn_enddate = mn_enddate;
	}
	public Date getMn_update() {
		return mn_update;
	}
	public void setMn_update(Date mn_update) {
		this.mn_update = mn_update;
	}
	public String getMn_maneger() {
		return mn_maneger;
	}
	public void setMn_maneger(String mn_maneger) {
		this.mn_maneger = mn_maneger;
	}

}