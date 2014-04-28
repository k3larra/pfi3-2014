package se.mah.k3.k3lara.assignment5starter;

public class NewsItem {

	private String date;
	private String title;
	private String summary;
	private int icon;

	public NewsItem(String date, String title, String summary, int icon) {
		super();
		this.date = date;
		this.title = title;
		this.summary = summary;
		this.icon = icon;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

}
