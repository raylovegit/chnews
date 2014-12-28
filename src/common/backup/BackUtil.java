/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.backup;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rslee
 * @data 2010-6-8
 * 说明：这个BackUtil有如下的功能：
 * 1.按照当前的时间备份到指定的目录下面去
 * 2.获取备份目录的所有备份然后返回List<String>，供选择恢复
 * 3.根据指定的备份文件名还原数据库
 */
public class BackUtil {

    private BackupProperties bp;

    public BackUtil() throws IOException {
        bp = new BackupProperties();
    }

    //备份
    public void backup() throws Exception {
        //先判断备份的路径是否存在，如果没有存在的话则新建
        File f = new File(bp.getBackPath());
        if (!f.exists()) {
            f.mkdir();
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-kk-mm-ss");
        String saveName = sf.format(new Date()) + ".sql";
        //这样写需要将mysql的bin配置到path里面去才可以
        String exet = bp.getMySqlPath() + "mysqldump -u" + bp.getUser() + " -p"
                + bp.getPassword() + " " + bp.getDatabase();
        System.out.println("exet:"+exet);
        Runtime rt = Runtime.getRuntime();
        Process child = rt.exec(exet);
        InputStream in = child.getInputStream();// 控制台的输出信息作为输入流

        InputStreamReader xx = new InputStreamReader(in, "utf8");// 设置输出流编码为utf8。这里必须是utf8，否则从流中读入的是乱码

        String inStr;
        StringBuffer sb = new StringBuffer("");
        String outStr;
        // 组合控制台输出信息字符串
        BufferedReader br = new BufferedReader(xx);
        while ((inStr = br.readLine()) != null) {
            sb.append(inStr + "\r\n");
        }
        outStr = sb.toString();

        // 要用来做导入用的sql目标文件：
        FileOutputStream fout = new FileOutputStream(bp.getBackPath() + saveName);
        OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");
        writer.write(outStr);
        // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免
        writer.flush();

        // 别忘记关闭输入输出流
        in.close();
        xx.close();
        br.close();
        writer.close();
        fout.close();
    }
    /**
     * 导入
     *
     */
    public  void load(String fPath) throws IOException {
        if(!new File(bp.getBackPath()+fPath).exists()) throw new IOException("备份的文件不存在！！");
        //这样写需要将mysql的bin配置到path里面去才可以
        String exet = bp.getMySqlPath() + "mysql.exe -u" + bp.getUser() + " -p"
                + bp.getPassword() + " " + bp.getDatabase();
        Runtime rt = Runtime.getRuntime();
        Process child = rt.exec(exet);
        OutputStream out = child.getOutputStream();//控制台的输入信息作为输出流
        String inStr;
        StringBuffer sb = new StringBuffer("");
        String outStr;
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(bp.getBackPath()+fPath), "utf8"));
        while ((inStr = br.readLine()) != null) {
            sb.append(inStr + "\r\n");
        }
        outStr = sb.toString();

        OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
        writer.write(outStr);
        // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免
        writer.flush();
        // 别忘记关闭输入输出流
        out.close();
        br.close();
        writer.close();
    }

//    public static void main(String[] args) throws Exception {
//        BackUtil bu = new BackUtil();
//        //bu.backup();
//        bu.load("2010-07-17-19-02-00.sql");
//    }
}
