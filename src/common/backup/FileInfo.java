/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.backup;

import java.io.File;

/**
 *
 * @author rslee
 * @data 2010-6-8
 * 说明：这个FileInfo有如下的功能：
 * 保存某一个路径下面所有文件的相关信息，包括：
 * 1.文件名
 * 2.文件创建时间
 * 3.文件更改时间
 * 4.文件最后一次访问时间
 * 5.文件是否只读
 */
public class FileInfo {

    private String fileName;
    private String createTime;
    private String modifyTime;
    private String lastReadTime;
    private String isReadOnly;
    private String fileLength;

    @Override
    public String toString(){
        return "fileName:"+fileName+",lastReadTime:"+lastReadTime+",isReadOnly:"+
                isReadOnly+",fileLength:"+fileLength;
    }
    public FileInfo(){
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the modifyTime
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime the modifyTime to set
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * @return the lastReadTime
     */
    public String getLastReadTime() {
        return lastReadTime;
    }

    /**
     * @param lastReadTime the lastReadTime to set
     */
    public void setLastReadTime(String lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    /**
     * @return the isReadOnly
     */
    public String getIsReadOnly() {
        return isReadOnly;
    }

    /**
     * @param isReadOnly the isReadOnly to set
     */
    public void setIsReadOnly(String isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    /**
     * @return the fileLength
     */
    public String getFileLength() {
        return fileLength;
    }

    /**
     * @param fileLength the fileLength to set
     */
    public void setFileLength(String fileLength) {
        this.fileLength = fileLength;
    }

}
