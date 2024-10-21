package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 求助信息
 *
 * @author 
 * @email
 */
@TableName("qiuzhu")
public class QiuzhuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QiuzhuEntity() {

	}

	public QiuzhuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 求助标题
     */
    @ColumnInfo(comment="求助标题",type="varchar(200)")
    @TableField(value = "qiuzhu_name")

    private String qiuzhuName;


    /**
     * 求助封面
     */
    @ColumnInfo(comment="求助封面",type="varchar(200)")
    @TableField(value = "qiuzhu_photo")

    private String qiuzhuPhoto;


    /**
     * 类别
     */
    @ColumnInfo(comment="类别",type="int(11)")
    @TableField(value = "qiuzhu_types")

    private Integer qiuzhuTypes;


    /**
     * 物品名称
     */
    @ColumnInfo(comment="物品名称",type="varchar(200)")
    @TableField(value = "qiuzhu_wupin")

    private String qiuzhuWupin;


    /**
     * 所需数量
     */
    @ColumnInfo(comment="所需数量",type="int(11)")
    @TableField(value = "qiuzhu_num")

    private Integer qiuzhuNum;


    /**
     * 地址
     */
    @ColumnInfo(comment="地址",type="varchar(200)")
    @TableField(value = "qiuzhu_address")

    private String qiuzhuAddress;


    /**
     * 提货方式
     */
    @ColumnInfo(comment="提货方式",type="varchar(200)")
    @TableField(value = "qiuzhu_tihuo")

    private String qiuzhuTihuo;


    /**
     * 求助热度
     */
    @ColumnInfo(comment="求助热度",type="int(11)")
    @TableField(value = "qiuzhu_clicknum")

    private Integer qiuzhuClicknum;


    /**
     * 求助介绍
     */
    @ColumnInfo(comment="求助介绍",type="longtext")
    @TableField(value = "qiuzhu_content")

    private String qiuzhuContent;


    /**
     * 求助审核
     */
    @ColumnInfo(comment="求助审核",type="int(11)")
    @TableField(value = "qiuzhu_yesno_types")

    private Integer qiuzhuYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "qiuzhu_yesno_text")

    private String qiuzhuYesnoText;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "qiuzhu_delete")

    private Integer qiuzhuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Qiuzhu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", qiuzhuName=" + qiuzhuName +
            ", qiuzhuPhoto=" + qiuzhuPhoto +
            ", qiuzhuTypes=" + qiuzhuTypes +
            ", qiuzhuWupin=" + qiuzhuWupin +
            ", qiuzhuNum=" + qiuzhuNum +
            ", qiuzhuAddress=" + qiuzhuAddress +
            ", qiuzhuTihuo=" + qiuzhuTihuo +
            ", qiuzhuClicknum=" + qiuzhuClicknum +
            ", qiuzhuContent=" + qiuzhuContent +
            ", qiuzhuYesnoTypes=" + qiuzhuYesnoTypes +
            ", qiuzhuYesnoText=" + qiuzhuYesnoText +
            ", qiuzhuDelete=" + qiuzhuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
