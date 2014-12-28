/**
 * @author sql
 *@version:2.0
 * @time Jul 22, 2010
 * @description:
 */
package hjj.chnews.comments;

/**
 * @author sql
 *@version:2.0
 * @time Jul 22, 2010
 * @description:
 */
import org.junit.Test;
import static org.junit.Assert.*;
public class CommentsDAOTest {
	 
     CommentsDAO commentsdao = new CommentsDAO();
     @Test
     public void read(){
    	 Comments comments = new Comments();
    	 comments.setId(1);
    	 try{
    		 comments=(Comments)commentsdao.read(comments);
    	 }
    	 catch(Exception e){
    		 e.printStackTrace();
    	 }
    	 assertEquals("test",comments.getContent());
     }
     @Test
     public void update(){
    	 Comments comments = new Comments();
    	 comments.setId(2);
    	 try{
    		 comments=(Comments)commentsdao.read(comments);
    		 comments.setContent("content");
    		 commentsdao.update(comments);
    	 }
    	 catch(Exception e){
    		 e.printStackTrace();
    	 }
    	 assertEquals("content",comments.getContent());
     }
     @Test
     public void bentchDetele(){
    	 String ids[] = new String[]{"3","4","5"};
    	 try{
    		 commentsdao.bentchDelete(ids);
    	 }
    	 catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
     @Test
     public void delete(){
    	 Comments comments = new Comments();
    	 comments.setId(9);
    	 try{
    		 comments=(Comments)commentsdao.read(comments);
    		 commentsdao.delete(comments);
    	 }
    	 catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
     @Test
     public void create(){
    	 Comments comments = new Comments();
    	 comments.setNewsId(1);
    	 comments.setAuthor("author");
    	 comments.setContent("content");
    	 try{
    		 commentsdao.create(comments);
    	 }
    	 catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
}
