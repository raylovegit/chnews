/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.backup;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rslee
 * @data 2010-6-8
 * 说明：这个BackupServlet有如下的功能：
 */
public class BackupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String status = req.getParameter("status");
        this.operoa(status, req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    //处理函数

    private void operoa(String status, HttpServletRequest req, HttpServletResponse resp) {
        String url;
        try {
            if ("list".equals(status)) {
                this.list(req);
            }
            if ("backup".equals(status)) {
                this.backup();
                this.list(req);
            }
            if ("load".equals(status)) {
                this.load(req);
                this.list(req);
            }
            if ("delete".equals(status)) {
                this.delete(req);
                this.list(req);
            }
        } catch (Exception ex) {
            Logger.getLogger(BackupServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         url = "WEB-INF/jsp/backup/list.jsp";
        this.send(req, resp, url);
    }

    private void list(HttpServletRequest req) throws IOException {
        List<FileInfo> list = FileInfoUtil.getFileInfos();
        Collections.reverse(list);
        req.setAttribute("list", list);
    }

    private void delete(HttpServletRequest req) throws IOException {
        String[] fileName = req.getParameterValues("fileName");
        FileInfoUtil.delete(fileName);
    }

    private void backup() throws Exception {
        new BackUtil().backup();
    }

    private void load(HttpServletRequest req) throws Exception {
        String[] fileName = req.getParameterValues("fileName");
        if (fileName != null && fileName.length > 0) {
            new BackUtil().load(fileName[0]);
        }
    }

    private void send(HttpServletRequest req, HttpServletResponse resp, String url) {
        try {
            req.getRequestDispatcher(url).forward(req, resp);
        } catch (ServletException ex) {
            Logger.getLogger(BackupServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BackupServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
