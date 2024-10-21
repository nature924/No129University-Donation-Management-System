package com.entity.vo;

import com.entity.JuanzhengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 捐赠信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("juanzheng")
public class JuanzhengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 求助
     */

    @TableField(value = "qiuzhu_id")
    private Integer qiuzhuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 捐赠数量
     */

    @TableField(value = "juanzheng_num")
    private Integer juanzhengNum;


    /**
     * 备注
     */

    @TableField(value = "juanzheng_text")
    private String juanzhengText;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：求助
	 */
    public Integer getQiuzhuId() {
        return qiuzhuId;
    }


    /**
	 * 获取：求助
	 */

    public void setQiuzhuId(Integer qiuzhuId) {
        this.qiuzhuId = qiuzhuId;
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
	 * 设置：捐赠数量
	 */
    public Integer getJuanzhengNum() {
        return juanzhengNum;
    }


    /**
	 * 获取：捐赠数量
	 */

    public void setJuanzhengNum(Integer juanzhengNum) {
        this.juanzhengNum = juanzhengNum;
    }
    /**
	 * 设置：备注
	 */
    public String getJuanzhengText() {
        return juanzhengText;
    }


    /**
	 * 获取：备注
	 */

    public void setJuanzhengText(String juanzhengText) {
        this.juanzhengText = juanzhengText;
    }
    /**
	 * 设置：发布日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
