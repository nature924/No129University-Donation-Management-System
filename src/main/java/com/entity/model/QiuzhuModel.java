package com.entity.model;

import com.entity.QiuzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 求助信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QiuzhuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 求助标题
     */
    private String qiuzhuName;


    /**
     * 求助封面
     */
    private String qiuzhuPhoto;


    /**
     * 类别
     */
    private Integer qiuzhuTypes;


    /**
     * 物品名称
     */
    private String qiuzhuWupin;


    /**
     * 所需数量
     */
    private Integer qiuzhuNum;


    /**
     * 地址
     */
    private String qiuzhuAddress;


    /**
     * 提货方式
     */
    private String qiuzhuTihuo;


    /**
     * 求助热度
     */
    private Integer qiuzhuClicknum;


    /**
     * 求助介绍
     */
    private String qiuzhuContent;


    /**
     * 求助审核
     */
    private Integer qiuzhuYesnoTypes;


    /**
     * 审核回复
     */
    private String qiuzhuYesnoText;


    /**
     * 逻辑删除
     */
    private Integer qiuzhuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 获取：求助标题
	 */
    public String getQiuzhuName() {
        return qiuzhuName;
    }


    /**
	 * 设置：求助标题
	 */
    public void setQiuzhuName(String qiuzhuName) {
        this.qiuzhuName = qiuzhuName;
    }
    /**
	 * 获取：求助封面
	 */
    public String getQiuzhuPhoto() {
        return qiuzhuPhoto;
    }


    /**
	 * 设置：求助封面
	 */
    public void setQiuzhuPhoto(String qiuzhuPhoto) {
        this.qiuzhuPhoto = qiuzhuPhoto;
    }
    /**
	 * 获取：类别
	 */
    public Integer getQiuzhuTypes() {
        return qiuzhuTypes;
    }


    /**
	 * 设置：类别
	 */
    public void setQiuzhuTypes(Integer qiuzhuTypes) {
        this.qiuzhuTypes = qiuzhuTypes;
    }
    /**
	 * 获取：物品名称
	 */
    public String getQiuzhuWupin() {
        return qiuzhuWupin;
    }


    /**
	 * 设置：物品名称
	 */
    public void setQiuzhuWupin(String qiuzhuWupin) {
        this.qiuzhuWupin = qiuzhuWupin;
    }
    /**
	 * 获取：所需数量
	 */
    public Integer getQiuzhuNum() {
        return qiuzhuNum;
    }


    /**
	 * 设置：所需数量
	 */
    public void setQiuzhuNum(Integer qiuzhuNum) {
        this.qiuzhuNum = qiuzhuNum;
    }
    /**
	 * 获取：地址
	 */
    public String getQiuzhuAddress() {
        return qiuzhuAddress;
    }


    /**
	 * 设置：地址
	 */
    public void setQiuzhuAddress(String qiuzhuAddress) {
        this.qiuzhuAddress = qiuzhuAddress;
    }
    /**
	 * 获取：提货方式
	 */
    public String getQiuzhuTihuo() {
        return qiuzhuTihuo;
    }


    /**
	 * 设置：提货方式
	 */
    public void setQiuzhuTihuo(String qiuzhuTihuo) {
        this.qiuzhuTihuo = qiuzhuTihuo;
    }
    /**
	 * 获取：求助热度
	 */
    public Integer getQiuzhuClicknum() {
        return qiuzhuClicknum;
    }


    /**
	 * 设置：求助热度
	 */
    public void setQiuzhuClicknum(Integer qiuzhuClicknum) {
        this.qiuzhuClicknum = qiuzhuClicknum;
    }
    /**
	 * 获取：求助介绍
	 */
    public String getQiuzhuContent() {
        return qiuzhuContent;
    }


    /**
	 * 设置：求助介绍
	 */
    public void setQiuzhuContent(String qiuzhuContent) {
        this.qiuzhuContent = qiuzhuContent;
    }
    /**
	 * 获取：求助审核
	 */
    public Integer getQiuzhuYesnoTypes() {
        return qiuzhuYesnoTypes;
    }


    /**
	 * 设置：求助审核
	 */
    public void setQiuzhuYesnoTypes(Integer qiuzhuYesnoTypes) {
        this.qiuzhuYesnoTypes = qiuzhuYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getQiuzhuYesnoText() {
        return qiuzhuYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setQiuzhuYesnoText(String qiuzhuYesnoText) {
        this.qiuzhuYesnoText = qiuzhuYesnoText;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getQiuzhuDelete() {
        return qiuzhuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setQiuzhuDelete(Integer qiuzhuDelete) {
        this.qiuzhuDelete = qiuzhuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
