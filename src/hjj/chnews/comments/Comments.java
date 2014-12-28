package hjj.chnews.comments;

public class Comments {
private long id;
private long newsId;
private String author;
private String content;
private String time;//评论的时间
private String flag;//控制评论是否显示
/**
 * @return the id
 */
public long getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(long id) {
	this.id = id;
}
/**
 * @return the newsId
 */
public long getNewsId() {
	return newsId;
}
/**
 * @param newsId the newsId to set
 */
public void setNewsId(long newsId) {
	this.newsId = newsId;
}
/**
 * @return the author
 */
public String getAuthor() {
	return author;
}
/**
 * @param author the author to set
 */
public void setAuthor(String author) {
	this.author = author;
}
/**
 * @return the content
 */
public String getContent() {
	return content;
}
/**
 * @param content the content to set
 */
public void setContent(String content) {
	this.content = content;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getFlag() {
	return flag;
}
public void setFlag(String flag) {
	this.flag = flag;
}


}
