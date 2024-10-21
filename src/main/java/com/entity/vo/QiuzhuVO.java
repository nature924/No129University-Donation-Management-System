package com.entity.vo;

import com.entity.QiuzhuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 求助信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiuzhu")
public class QiuzhuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 求助标题
     */

    @TableField(value = "qiuzhu_name")
    private String qiuzhuName;


    /**
     * 求助封面
     */

    @TableField(value = "qiuzhu_photo")
    private String qiuzhuPhoto;


    /**
     * 类别
     */

    @TableField(value = "qiuzhu_types")
    private Integer qiuzhuTypes;


    /**
     * 物品名称
     */

    @TableField(value = "qiuzhu_wupin")
    private String qiuzhuWupin;


    /**
     * 所需数量
     */

    @TableField(value = "qiuzhu_num")
    private Integer qiuzhuNum;


    /**
     * 地址
     */

    @TableField(value = "qiuzhu_address")
    private String qiuzhuAddress;


    /**
     * 提货方式
     */

    @TableField(value = "qiuzhu_tihuo")
    private String qiuzhuTihuo;


    /**
     * 求助热度
     */

    @TableField(value = "qiuzhu_clicknum")
    private Integer qiuzhuClicknum;


    /**
     * 求助介绍
     */

    @TableField(value = "qiuzhu_content")
    private String qiuzhuContent;


    /**
     * 求助审核
     */

    @TableField(value = "qiuzhu_yesno_types")
    private Integer qiuzhuYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "qiuzhu_yesno_text")
    private String qiuzhuYesnoText;


    /**
     * 逻辑删除
     */

    @TableField(value = "qiuzhu_delete")
    private Integer qiuzhuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：求助标题
	 */
    public String getQiuzhuName() {
        return qiuzhuName;
    }


    /**
	 * 获取：求助标题
	 */

    public void setQiuzhuName(String qiuzhuName) {
        this.qiuzhuName = qiuzhuName;
    }
    /**
	 * 设置：求助封面
	 */
    public String getQiuzhuPhoto() {
        return qiuzhuPhoto;
    }


    /**
	 * 获取：求助封面
	 */

    public void setQiuzhuPhoto(String qiuzhuPhoto) {
        this.qiuzhuPhoto = qiuzhuPhoto;
    }
    /**
	 * 设置：类别
	 */
    public Integer getQiuzhuTypes() {
        return qiuzhuTypes;
    }


    /**
	 * 获取：类别
	 */

    public void setQiuzhuTypes(Integer qiuzhuTypes) {
        this.qiuzhuTypes = qiuzhuTypes;
    }
    /**
	 * 设置：物品名称
	 */
    public String getQiuzhuWupin() {
        return qiuzhuWupin;
    }


    /**
	 * 获取：物品名称
	 */

    public void setQiuzhuWupin(String qiuzhuWupin) {
        this.qiuzhuWupin = qiuzhuWupin;
    }
    /**
	 * 设置：所需数量
	 */
    public Integer getQiuzhuNum() {
        return qiuzhuNum;
    }


    /**
	 * 获取：所需数量
	 */

    public void setQiuzhuNum(Integer qiuzhuNum) {
        this.qiuzhuNum = qiuzhuNum;
    }
    /**
	 * 设置：地址
	 */
    public String getQiuzhuAddress() {
        return qiuzhuAddress;
    }


    /**
	 * 获取：地址
	 */

    public void setQiuzhuAddress(String qiuzhuAddress) {
        this.qiuzhuAddress = qiuzhuAddress;
    }
    /**
	 * 设置：提货方式
	 */
    public String getQiuzhuTihuo() {
        return qiuzhuTihuo;
    }


    /**
	 * 获取：提货方式
	 */

    public void setQiuzhuTihuo(String qiuzhuTihuo) {
        this.qiuzhuTihuo = qiuzhuTihuo;
    }
    /**
	 * 设置：求助热度
	 */
    public Integer getQiuzhuClicknum() {
        return qiuzhuClicknum;
    }


    /**
	 * 获取：求助热度
	 */

    public void setQiuzhuClicknum(Integer qiuzhuClicknum) {
        this.qiuzhuClicknum = qiuzhuClicknum;
    }
    /**
	 * 设置：求助介绍
	 */
    public String getQiuzhuContent() {
        return qiuzhuContent;
    }


    /**
	 * 获取：求助介绍
	 */

    public void setQiuzhuContent(String qiuzhuContent) {
        this.qiuzhuContent = qiuzhuContent;
    }
    /**
	 * 设置：求助审核
	 */
    public Integer getQiuzhuYesnoTypes() {
        return qiuzhuYesnoTypes;
    }


    /**
	 * 获取：求助审核
	 */

    public void setQiuzhuYesnoTypes(Integer qiuzhuYesnoTypes) {
        this.qiuzhuYesnoTypes = qiuzhuYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getQiuzhuYesnoText() {
        return qiuzhuYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setQiuzhuYesnoText(String qiuzhuYesnoText) {
        this.qiuzhuYesnoText = qiuzhuYesnoText;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getQiuzhuDelete() {
        return qiuzhuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setQiuzhuDelete(Integer qiuzhuDelete) {
        this.qiuzhuDelete = qiuzhuDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
