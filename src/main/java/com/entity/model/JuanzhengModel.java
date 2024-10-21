package com.entity.model;

import com.entity.JuanzhengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 捐赠信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JuanzhengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 求助
     */
    private Integer qiuzhuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 捐赠数量
     */
    private Integer juanzhengNum;


    /**
     * 备注
     */
    private String juanzhengText;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：求助
	 */
    public Integer getQiuzhuId() {
        return qiuzhuId;
    }


    /**
	 * 设置：求助
	 */
    public void setQiuzhuId(Integer qiuzhuId) {
        this.qiuzhuId = qiuzhuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：捐赠数量
	 */
    public Integer getJuanzhengNum() {
        return juanzhengNum;
    }


    /**
	 * 设置：捐赠数量
	 */
    public void setJuanzhengNum(Integer juanzhengNum) {
        this.juanzhengNum = juanzhengNum;
    }
    /**
	 * 获取：备注
	 */
    public String getJuanzhengText() {
        return juanzhengText;
    }


    /**
	 * 设置：备注
	 */
    public void setJuanzhengText(String juanzhengText) {
        this.juanzhengText = juanzhengText;
    }
    /**
	 * 获取：发布日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布日期
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
