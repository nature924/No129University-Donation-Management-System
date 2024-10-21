package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.QiuzhuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 求助信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("qiuzhu")
public class QiuzhuView extends QiuzhuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类别的值
	*/
	@ColumnInfo(comment="类别的字典表值",type="varchar(200)")
	private String qiuzhuValue;
	/**
	* 求助审核的值
	*/
	@ColumnInfo(comment="求助审核的字典表值",type="varchar(200)")
	private String qiuzhuYesnoValue;

	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 积分数量
		*/

		@ColumnInfo(comment="积分数量",type="int(11)")
		private Integer yonghuJif;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public QiuzhuView() {

	}

	public QiuzhuView(QiuzhuEntity qiuzhuEntity) {
		try {
			BeanUtils.copyProperties(this, qiuzhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类别的值
	*/
	public String getQiuzhuValue() {
		return qiuzhuValue;
	}
	/**
	* 设置： 类别的值
	*/
	public void setQiuzhuValue(String qiuzhuValue) {
		this.qiuzhuValue = qiuzhuValue;
	}
	//当前表的
	/**
	* 获取： 求助审核的值
	*/
	public String getQiuzhuYesnoValue() {
		return qiuzhuYesnoValue;
	}
	/**
	* 设置： 求助审核的值
	*/
	public void setQiuzhuYesnoValue(String qiuzhuYesnoValue) {
		this.qiuzhuYesnoValue = qiuzhuYesnoValue;
	}


	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 积分数量
		*/
		public Integer getYonghuJif() {
			return yonghuJif;
		}
		/**
		* 设置： 积分数量
		*/
		public void setYonghuJif(Integer yonghuJif) {
			this.yonghuJif = yonghuJif;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "QiuzhuView{" +
			", qiuzhuValue=" + qiuzhuValue +
			", qiuzhuYesnoValue=" + qiuzhuYesnoValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuJif=" + yonghuJif +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
