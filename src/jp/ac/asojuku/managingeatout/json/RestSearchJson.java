package jp.ac.asojuku.gurunabiapi.json;

import com.fasterxml.jackson.annotation.JsonProperty;;

/**
 * @author nishino
 * http://api.gnavi.co.jp/api/manual/restsearch/を参考にレスポンスのクラスを作成
 * 「複数回」となっているところは配列にする
 */
public class RestSearchJson extends GurunaviAPIBaseJson{


	@JsonProperty("total_hit_count")
	private Object total_hit_count;

	@JsonProperty("hit_per_page")
	private Object hit_per_page;

	@JsonProperty("page_offset")
	private Object page_offset;

	@JsonProperty("rest")
	private Rest[] rest;



	public Object getTotal_hit_count() {
		return total_hit_count;
	}

	public void setTotal_hit_count(Object total_hit_count) {
		this.total_hit_count = total_hit_count;
	}

	public Object getHit_per_page() {
		return hit_per_page;
	}

	public void setHit_per_page(Object hit_per_page) {
		this.hit_per_page = hit_per_page;
	}

	public Object getPage_offset() {
		return page_offset;
	}

	public void setPage_offset(Object page_offset) {
		this.page_offset = page_offset;
	}

	public Rest[] getRest() {
		return rest;
	}

	public void setRest(Rest[] rest) {
		this.rest = rest;
	}


	//Order
	public static class Order {
		@JsonProperty("order")
		Object order;

		public Object getOrder() {
			return order;
		}

		public void setOrder(Object order) {
			this.order = order;
		}

	}
	//RESTクラス
	public static class Rest{
		@JsonProperty("@attributes")
		private Order order;

		@JsonProperty("id")
		private Object id;
		@JsonProperty("update_date")
		private Object update_date;
		@JsonProperty("name")
		private Object name;
		@JsonProperty("name_kana")
		private Object name_kana;
		@JsonProperty("latitude")
		private Object latitude;
		@JsonProperty("longitude")
		private Object longitude;
		@JsonProperty("category")
		private Object category;
		@JsonProperty("url")
		private Object url;
		@JsonProperty("url_mobile")
		private Object url_mobile;
		@JsonProperty("coupon_url")
		private CouponUrl coupon_url;
		@JsonProperty("image_url")
		private ImageUrl image_url;
		@JsonProperty("address")
		private Object address;
		@JsonProperty("tel")
		private Object tel;
		@JsonProperty("tel_sub")
		private Object tel_sub;
		@JsonProperty("fax")
		private Object fax;
		@JsonProperty("opentime")
		private Object opentime;
		@JsonProperty("holiday")
		private Object holiday;
		@JsonProperty("access")
		private Access access;
		@JsonProperty("parking_lots")
		private Object parking_lots;
		@JsonProperty("pr")
		private Pr pr;
		@JsonProperty("code")
		private Code code;
		@JsonProperty("budget")
		private Object budget;
		@JsonProperty("party")
		private Object party;
		@JsonProperty("lunch")
		private Object lunch;
		@JsonProperty("credit_card")
		private Object credit_card;
		@JsonProperty("e_money")
		private Object e_money;
		@JsonProperty("flags")
		private Flags flags;
		public Object getId() {
			return id;
		}
		public void setId(Object id) {
			this.id = id;
		}
		public Object getUpdate_date() {
			return update_date;
		}
		public void setUpdate_date(Object update_date) {
			this.update_date = update_date;
		}
		public Object getName() {
			return name;
		}
		public void setName(Object name) {
			this.name = name;
		}
		public Object getName_kana() {
			return name_kana;
		}
		public void setName_kana(Object name_kana) {
			this.name_kana = name_kana;
		}
		public Object getLatitude() {
			return latitude;
		}
		public void setLatitude(Object latitude) {
			this.latitude = latitude;
		}
		public Object getLongitude() {
			return longitude;
		}
		public void setLongitude(Object longitude) {
			this.longitude = longitude;
		}
		public Object getCategory() {
			return category;
		}
		public void setCategory(Object category) {
			this.category = category;
		}
		public Object getUrl() {
			return url;
		}
		public void setUrl(Object url) {
			this.url = url;
		}
		public Object getUrl_mobile() {
			return url_mobile;
		}
		public void setUrl_mobile(Object url_mobile) {
			this.url_mobile = url_mobile;
		}
		public CouponUrl getCoupon_url() {
			return coupon_url;
		}
		public void setCoupon_url(CouponUrl coupon_url) {
			this.coupon_url = coupon_url;
		}
		public ImageUrl getImage_url() {
			return image_url;
		}
		public void setImage_url(ImageUrl image_url) {
			this.image_url = image_url;
		}
		public Object getAddress() {
			return address;
		}
		public void setAddress(Object address) {
			this.address = address;
		}
		public Object getTel() {
			return tel;
		}
		public void setTel(Object tel) {
			this.tel = tel;
		}
		public Object getTel_sub() {
			return tel_sub;
		}
		public void setTel_sub(Object tel_sub) {
			this.tel_sub = tel_sub;
		}
		public Object getFax() {
			return fax;
		}
		public void setFax(Object fax) {
			this.fax = fax;
		}
		public Object getOpentime() {
			return opentime;
		}
		public void setOpentime(Object opentime) {
			this.opentime = opentime;
		}
		public Object getHoliday() {
			return holiday;
		}
		public void setHoliday(Object holiday) {
			this.holiday = holiday;
		}
		public Access getAccess() {
			return access;
		}
		public void setAccess(Access access) {
			this.access = access;
		}
		public Object getParking_lots() {
			return parking_lots;
		}
		public void setParking_lots(Object parking_lots) {
			this.parking_lots = parking_lots;
		}
		public Pr getPr() {
			return pr;
		}
		public void setPr(Pr pr) {
			this.pr = pr;
		}
		public Code getCode() {
			return code;
		}
		public void setCode(Code code) {
			this.code = code;
		}
		public Object getBudget() {
			return budget;
		}
		public void setBudget(Object budget) {
			this.budget = budget;
		}
		public Object getParty() {
			return party;
		}
		public void setParty(Object party) {
			this.party = party;
		}
		public Object getLunch() {
			return lunch;
		}
		public void setLunch(Object lunch) {
			this.lunch = lunch;
		}
		public Object getCredit_card() {
			return credit_card;
		}
		public void setCredit_card(Object credit_card) {
			this.credit_card = credit_card;
		}
		public Object getE_money() {
			return e_money;
		}
		public void setE_money(Object e_money) {
			this.e_money = e_money;
		}
		public Flags getFlags() {
			return flags;
		}
		public void setFlags(Flags flags) {
			this.flags = flags;
		}

	}

	public static class CouponUrl{
		@JsonProperty("pc")
		private Object pc;
		@JsonProperty("mobile")
		private Object mobile;
		public Object getPc() {
			return pc;
		}
		public void setPc(Object pc) {
			this.pc = pc;
		}
		public Object getMobile() {
			return mobile;
		}
		public void setMobile(Object mobile) {
			this.mobile = mobile;
		}

	}

	public static class ImageUrl{
		@JsonProperty("shop_image1")
		private Object shop_image1;
		@JsonProperty("shop_image2")
		private Object shop_image2;
		@JsonProperty("qrcode")
		private Object qrcode;

		public Object getShop_image1() {
			return shop_image1;
		}
		public void setShop_image1(Object shop_image1) {
			this.shop_image1 = shop_image1;
		}
		public Object getShop_image2() {
			return shop_image2;
		}
		public void setShop_image2(Object shop_image2) {
			this.shop_image2 = shop_image2;
		}
		public Object getQrcode() {
			return qrcode;
		}
		public void setQrcode(Object qrcode) {
			this.qrcode = qrcode;
		}


	}
	public static class Access{
		@JsonProperty("line")
		private Object line;
		@JsonProperty("station")
		private Object station;
		@JsonProperty("station_exit")
		private Object station_exit;
		@JsonProperty("walk")
		private Object walk;
		@JsonProperty("note")
		private Object note;
		public Object getLine() {
			return line;
		}
		public void setLine(Object line) {
			this.line = line;
		}
		public Object getStation() {
			return station;
		}
		public void setStation(Object station) {
			this.station = station;
		}
		public Object getStation_exit() {
			return station_exit;
		}
		public void setStation_exit(Object station_exit) {
			this.station_exit = station_exit;
		}
		public Object getWalk() {
			return walk;
		}
		public void setWalk(Object walk) {
			this.walk = walk;
		}
		public Object getNote() {
			return note;
		}
		public void setNote(Object note) {
			this.note = note;
		}


	}
	public static class Pr{
		@JsonProperty("pr_short")
		private Object pr_short;
		@JsonProperty("pr_long")
		private Object pr_long;
		public Object getPr_short() {
			return pr_short;
		}
		public void setPr_short(Object pr_short) {
			this.pr_short = pr_short;
		}
		public Object getPr_long() {
			return pr_long;
		}
		public void setPr_long(Object pr_long) {
			this.pr_long = pr_long;
		}


	}
	public static class Code{
		@JsonProperty("areacode")
		private Object areacode;
		@JsonProperty("areaname")
		private Object areaname;
		@JsonProperty("prefcode")
		private Object prefcode;
		@JsonProperty("prefname")
		private Object prefname;
		@JsonProperty("areacode_s")
		private Object areacode_s;
		@JsonProperty("areaname_s")
		private Object areaname_s;
		@JsonProperty("category_code_l")
		private Object[] category_code_l;
		@JsonProperty("category_name_l")
		private Object[] category_name_l;
		@JsonProperty("category_code_s")
		private Object[] category_code_s;
		@JsonProperty("category_name_s")
		private Object[] category_name_s;
		public Object getAreacode() {
			return areacode;
		}
		public void setAreacode(Object areacode) {
			this.areacode = areacode;
		}
		public Object getAreaname() {
			return areaname;
		}
		public void setAreaname(Object areaname) {
			this.areaname = areaname;
		}
		public Object getPrefcode() {
			return prefcode;
		}
		public void setPrefcode(Object prefcode) {
			this.prefcode = prefcode;
		}
		public Object getPrefname() {
			return prefname;
		}
		public void setPrefname(Object prefname) {
			this.prefname = prefname;
		}
		public Object getAreacode_s() {
			return areacode_s;
		}
		public void setAreacode_s(Object areacode_s) {
			this.areacode_s = areacode_s;
		}
		public Object getAreaname_s() {
			return areaname_s;
		}
		public void setAreaname_s(Object areaname_s) {
			this.areaname_s = areaname_s;
		}
		public Object[] getCategory_code_l() {
			return category_code_l;
		}
		public void setCategory_code_l(Object[] category_code_l) {
			this.category_code_l = category_code_l;
		}
		public Object[] getCategory_name_l() {
			return category_name_l;
		}
		public void setCategory_name_l(Object[] category_name_l) {
			this.category_name_l = category_name_l;
		}
		public Object[] getCategory_code_s() {
			return category_code_s;
		}
		public void setCategory_code_s(Object[] category_code_s) {
			this.category_code_s = category_code_s;
		}
		public Object[] getCategory_name_s() {
			return category_name_s;
		}
		public void setCategory_name_s(Object[] category_name_s) {
			this.category_name_s = category_name_s;
		}

	}
	public static class Flags{
		@JsonProperty("mobile_site")
		private Object mobile_site;
		@JsonProperty("mobile_coupon")
		private Object mobile_coupon;
		@JsonProperty("pc_coupon")
		private Object pc_coupon;
		public Object getMobile_site() {
			return mobile_site;
		}
		public void setMobile_site(Object mobile_site) {
			this.mobile_site = mobile_site;
		}
		public Object getMobile_coupon() {
			return mobile_coupon;
		}
		public void setMobile_coupon(Object mobile_coupon) {
			this.mobile_coupon = mobile_coupon;
		}
		public Object getPc_coupon() {
			return pc_coupon;
		}
		public void setPc_coupon(Object pc_coupon) {
			this.pc_coupon = pc_coupon;
		}

	}
}
