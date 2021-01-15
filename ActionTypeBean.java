package cn.xaele.vue.bean;

public class ActionTypeBean {

	// 主键id
	private int id = 0;
	// 上级id
	private int pid = 0;
	// 活动名称
	private String name = "";
	// 是否默认
	private boolean checked = false;
	
	public ActionTypeBean() {
		
	}

	public ActionTypeBean(int id, int pid, String name, boolean checked) {
		this.setId(id);
		this.setPid(pid);
		this.setName(name);
		this.setChecked(checked);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
