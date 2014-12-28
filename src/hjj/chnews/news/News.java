package hjj.chnews.news;

/**
 * @author sql
 *@version:2.0
 * @time Jul 20, 2010
 * @description:新闻
 */

import java.util.Date;

public class News {
private long id;
private String title ;
private String subTitle;
private String sub2Title;
private String caption;
private int kindid;
private int newsType;
private String time;
private String author;
private int visitnum;
private String newsFrom;
private String kindName;
private String typeName;
private String url;
private String orderNum;
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
 * @return the title
 */
public String getTitle() {
	return title;
}
/**
 * @param title the title to set
 */
public void setTitle(String title) {
	this.title = title;
}
/**
 * @return the subTitle
 */
public String getSubTitle() {
	return subTitle;
}
/**
 * @param subTitle the subTitle to set
 */
public void setSubTitle(String subTitle) {
	this.subTitle = subTitle;
}
/**
 * @return the sub2Title
 */
public String getSub2Title() {
	return sub2Title;
}
/**
 * @param sub2Title the sub2Title to set
 */
public void setSub2Title(String sub2Title) {
	this.sub2Title = sub2Title;
}
/**
 * @return the caption
 */
public String getCaption() {
	return caption;
}
/**
 * @param caption the caption to set
 */
public void setCaption(String caption) {
	this.caption = caption;
}
/**
 * @return the kindid
 */
public int getKindid() {
	return kindid;
}
/**
 * @param kindid the kindid to set
 */
public void setKindid(int kindid) {
	this.kindid = kindid;
}
/**
 * @return the newsType
 */
public int getNewsType() {
	return newsType;
}
/**
 * @param newsType the newsType to set
 */
public void setNewsType(int newsType) {
	this.newsType = newsType;
}

public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
/*
 * @return the authar
 */
public String getAuthor() {
	return author;
}
/**
 * @param authar the author to set
 */
public void setAuthor(String author) {
	this.author = author;
}
/**
 * @return the visitnum
 */
public int getVisitnum() {
	return visitnum;
}
/**
 * @param visitnum the visitnum to set
 */
public void setVisitnum(int visitnum) {
	this.visitnum = visitnum;
}
/**
 * @return the newsFrom
 */
public String getNewsFrom() {
	return newsFrom;
}
/**
 * @param newsFrom the newsFrom to set
 */
public void setNewsFrom(String newsFrom) {
	this.newsFrom = newsFrom;
}
public String getKindName() {
	return kindName;
}
public void setKindName(String kindName) {
	this.kindName = kindName;
}
public String getTypeName() {
	return typeName;
}
public void setTypeName(String typeName) {
	this.typeName = typeName;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getOrderNum() {
	return orderNum;
}
public void setOrderNum(String orderNum) {
	this.orderNum = orderNum;
}


}
