/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.backup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.util.PropertiesParser;

/**
 *
 * @author rslee
 * @data 2010-6-8
 * 说明：这个FileInfoUtil有如下的功能：
 * 实现对于某一个目录下面的文件的操作
 */
public class FileInfoUtil {
    //默认的情况，使用
    public static List<FileInfo> getFileInfos() throws IOException{
        String path=new PropertiesParser("backup.properties").getValue("backup.path");
        return getFileInfos(path);
    }
    public static void delete(String []fileName)throws IOException{
        String path=new PropertiesParser("backup.properties").getValue("backup.path");
        delete(path,fileName);
    }
    public static List<FileInfo> getFileInfos(String path){
        List<FileInfo> flist = new ArrayList<FileInfo>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日kk时mm分ss秒");
        File p = new File(path);
        if(p.isDirectory()){
            File [] files = p.listFiles();
            for(File f:files){
                if(!f.isDirectory()){
                    FileInfo fi = new FileInfo();
                    fi.setFileName(f.getName());
                    //创建时间是个大问题。。。
                    fi.setLastReadTime(sf.format(new Date(f.lastModified())));
                    if(f.canRead()){
                        fi.setIsReadOnly("否");
                    }else{
                        fi.setIsReadOnly("是");
                    }
                    Long l = f.length();
                    fi.setFileLength((l/1000.0f)+"K");
                    flist.add(fi);
                }
            }
        }
        return flist;
    }
    //删除
    public static void delete(String filePath,String [] fileName){
        for(String f:fileName){
            File file = new File(filePath+f);
            if(file.exists()){
                file.delete();
            }
        }
    }

//    public static void main(String[] args) {
//        List<FileInfo> flist = getFileInfos("d://");
//        for(FileInfo fi:flist){
//            System.out.println(fi);
//        }
//        delete("d://",new String[]{"1.txt","2.txt"});
//    }
     
}
