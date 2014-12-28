package common.page;

public class Page {
private int currentpage;//当前页
private int size;//每一页显示的数量
private int totalcounts;//总记录数
private int totalpages;//总页数
private int prepage;//上一页
private int nextpage;//下一页
private int beginindex;//开始检索处
private int lastindex;//结束索引
public Page(){
	super();
}
public Page(int currentpage,int size,int totalcounts,int totalpages,int prepage,int nextpage,int beginindex,int lastindex)
{
this.beginindex=beginindex;
this.currentpage=currentpage;
this.nextpage=nextpage;
this.size=size;
this.totalcounts=totalcounts;
this.prepage=prepage;
this.totalpages=totalpages;
this.lastindex=lastindex;
}
public int getCurrentpage() {
	return currentpage;
}
public void setCurrentpage(int currentpage) {
	this.currentpage = currentpage;
}
public int getSize(){
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public int getTotalcounts() {
	return totalcounts;
}
public void setTotalcounts(int totalcounts) {
	this.totalcounts = totalcounts;
}
public int getTotalpages() {
	return totalpages;
}
public void setTotalpages(int totalpages) {
	this.totalpages = totalpages;
}
public int getPrepage() {
	return prepage;
}
public void setPrepage(int prepage) {
	this.prepage = prepage;
}
public int getNextpage() {
	return nextpage;
}
public void setNextpage(int nextpage) {
	this.nextpage = nextpage;
}
public int getBeginindex() {
	return beginindex;
}
public void setBeginindex(int beginindex) {
	this.beginindex = beginindex;
}
public int getLastindex() {
	return lastindex;
}
public void setLastindex(int lastindex) {
	this.lastindex = lastindex;
}

}
