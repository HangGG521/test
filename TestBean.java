package cn.xaele.vue.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cn.xaele.utils.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestBean {

	private String name = "";
	private String region = "";
	private String date1 = "";
	private String date2 = "";
	private int[] type = null;
	private boolean delivery = false;
	private String resource = "";
	private String desc = "";
	
	private List<ActionTypeBean> typeList = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDate1() {
		return date1;
	}

	public String getDate1Str() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public int[] getType() {
		return type;
	}

	public void setType(int[] type) {
		this.type = type;
	}

	public boolean getDelivery() {
		return delivery;
	}

	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}

	public List<ActionTypeBean> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<ActionTypeBean> typeList) {
		this.typeList = typeList;
	}

	public void addTypeList(ActionTypeBean bean) {
		if (this.typeList == null) {
			this.typeList = new ArrayList<>();
		}
		this.typeList.add(bean);
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append("TestBean--->\n");
		str.append("name:[").append(this.getName()).append("]\n");
		str.append("region:[").append(this.getRegion()).append("]\n");
		str.append("date1:[").append(this.getDate1()).append("]\n");
		str.append("date2:[").append(this.getDate2()).append("]\n");
		str.append("delivery:[").append(this.getDelivery()).append("]\n");

		if (type != null && type.length > 0) {
			for (int i = 0; i < this.type.length; i++) {
				str.append("type[").append(i).append("]:[").append(this.getType()[i]).append("]\n");
			}
		}

		if (typeList != null && typeList.size() > 0) {
			for (int i = 0; i < this.typeList.size(); i++) {
				str.append("type[").append(i).append("]:[").append(this.getTypeList().get(i).getName()).append("]\n");
			}
		}
		str.append("resource:[").append(this.getResource()).append("]\n");
		str.append("desc:[").append(this.getDesc()).append("]\n");

		return str.toString();
	}

	public void initTypeList() {
		ActionTypeBean bean = new ActionTypeBean(1, 1, "地区", false);
		this.addTypeList(bean);

		bean = new ActionTypeBean(2, 2, "游戏类型", true);
		this.addTypeList(bean);

		bean = new ActionTypeBean(3, 4, "性别", true);
		this.addTypeList(bean);

		bean = new ActionTypeBean(4, 5, "设备类型", false);
		this.addTypeList(bean);

		bean = new ActionTypeBean(5, 6, "休闲时间", false);
		this.addTypeList(bean);

		bean = new ActionTypeBean(6, 7, "王者荣耀", false);
		this.addTypeList(bean);

		bean = new ActionTypeBean(7, 8, "音乐", false);
		this.addTypeList(bean);

		bean = new ActionTypeBean(8, 9, "品牌手表", false);
		this.addTypeList(bean);

		bean = new ActionTypeBean(9, 10, "相机", false);
		this.addTypeList(bean);

		bean = new ActionTypeBean(10, 12, "游戏人群", false);
		this.addTypeList(bean);
	}

	public static void main(String[] args) throws ParseException {

		TestBean app = new TestBean();

		// String datdString = "Wed Oct 12 2016 00:00:00 GMT+0800 (中国标准时间)";
		String gmtDateString = "Tue Mar 17 2020 11:00:10 GMT+0800 (中国标准时间)";
		Calendar cal1 = app.getGmtStrToCal(gmtDateString);
		System.out.println(DateUtils.FormatTime(cal1, "yyyy-MM-dd HH:mm:ss.SSS"));

		String htmlDateString = "2020-03-17T03:26:06.000Z";
		Calendar cal2 = app.getHtmlDateStrToCal(htmlDateString);
		System.out.println(DateUtils.FormatTime(cal2, "yyyy-MM-dd HH:mm:ss.SSS"));
	}

	public Calendar getGmtStrToCal(String gmtStr) {
		Calendar cal = null;
		try {
			gmtStr = gmtStr.replace("GMT", "").replaceAll("\\(.*\\)", "");
			// 将字符串转化为date类型，格式2016-10-12
			SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy hh:mm:ss z", Locale.ENGLISH);
			// Date dateTrans = format.parse(gmtStr);
			// System.out.println(new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss.SSS").format(dateTrans));

			format.parse(gmtStr);
			cal = format.getCalendar();
			// SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss.SSS");
			// System.out.println(formatDate.format(cal.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal;
	}

	public Calendar getHtmlDateStrToCal(String dateStr) {
		// "date1":"2020-03-11T16:00:00.000Z","date2":"2020-03-17T03:26:06.000Z"
		Calendar cal = null;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = df.parse(dateStr);
			SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
			format.parse(date.toString());
			cal = format.getCalendar();
			// date1 = df1.parse(date.toString());
			// df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal;
	}

}
