package common.page;

public class PageUtil {
//这个类是根据当前页总记录数以及每页记录数创建page对象
public static Page createPage(int size,int currentpage,int totalcounts){
int totalpages=totalPages(size,totalcounts);
int prepage=prePage(currentpage);
int nextpage=nextPage(currentpage,totalpages);
int beginindex=beginIndex(size,currentpage);
int lastindex=lastIndex(beginindex,size);
return new Page(currentpage,size,totalcounts,totalpages,prepage,nextpage,beginindex,lastindex);
}

//返回总页数
public static int totalPages(int size,int totalcounts){
	if(totalcounts==0) return 0;
	else {
		if(totalcounts%size==0) return totalcounts/size;
		return totalcounts/size+1;
	}
}
//返回上一页
public static int prePage(int currentpage){
	return currentpage==1?1:(currentpage-1);
}
//返回下一页
public static int nextPage(int currentpage,int totalpages){
	return currentpage==totalpages?totalpages:(currentpage+1);
}
//返回开始查询的地方
public static int beginIndex(int size,int currentpage){
	return (currentpage-1)*size;
}
public static int lastIndex(int beginIndex,int size){
	return beginIndex+size;
}
}
