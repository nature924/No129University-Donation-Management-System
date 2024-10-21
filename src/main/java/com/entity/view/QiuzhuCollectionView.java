package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.QiuzhuCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 求助收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("qiuzhu_collection")
public class QiuzhuCollectionView extends QiuzhuCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String qiuzhuCollectionValue;

	//级联表 求助信息
					 
		/**
		* 求助信息 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer qiuzhuYonghuId;
		/**
		* 求助标题
		*/

		@ColumnInfo(comment="求助标题",type="varchar(200)")
		private String qiuzhuName;
		/**
		* 求助封面
		*/

		@ColumnInfo(comment="求助封面",type="varchar(200)")
		private String qiuzhuPhoto;
		/**
		* 类别
		*/
		@ColumnInfo(comment="类别",type="int(11)")
		private Integer qiuzhuTypes;
			/**
			* 类别的值
			*/
			@ColumnInfo(comment="类别的字典表值",type="varchar(200)")
			private String qiuzhuValue;
		/**
		* 物品名称
		*/

		@ColumnInfo(comment="物品名称",type="varchar(200)")
		private String qiuzhuWupin;
		/**
		* 所需数量
		*/

		@ColumnInfo(comment="所需数量",type="int(11)")
		private Integer qiuzhuNum;
		/**
		* 地址
		*/

		@ColumnInfo(comment="地址",type="varchar(200)")
		private String qiuzhuAddress;
		/**
		* 提货方式
		*/

		@ColumnInfo(comment="提货方式",type="varchar(200)")
		private String qiuzhuTihuo;
		/**
		* 求助热度
		*/

		@ColumnInfo(comment="求助热度",type="int(11)")
		private Integer qiuzhuClicknum;
		/**
		* 求助介绍
		*/

		@ColumnInfo(comment="求助介绍",type="longtext")
		private String qiuzhuContent;
		/**
		* 求助审核
		*/
		@ColumnInfo(comment="求助审核",type="int(11)")
		private Integer qiuzhuYesnoTypes;
			/**
			* 求助审核的值
			*/
			@ColumnInfo(comment="求助审核的字典表值",type="varchar(200)")
			private String qiuzhuYesnoValue;
		/**
		* 审核回复
		*/

		@ColumnInfo(comment="审核回复",type="longtext")
		private String qiuzhuYesnoText;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer qiuzhuDelete;
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



	public QiuzhuCollectionView() {

	}

	public QiuzhuCollectionView(QiuzhuCollectionEntity qiuzhuCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, qiuzhuCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getQiuzhuCollectionValue() {
		return qiuzhuCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setQiuzhuCollectionValue(String qiuzhuCollectionValue) {
		this.qiuzhuCollectionValue = qiuzhuCollectionValue;
	}


	//级联表的get和set 求助信息
		/**
		* 获取：求助信息 的 用户
		*/
		public Integer getQiuzhuYonghuId() {
			return qiuzhuYonghuId;
		}
		/**
		* 设置：求助信息 的 用户
		*/
		public void setQiuzhuYonghuId(Integer qiuzhuYonghuId) {
			this.qiuzhuYonghuId = qiuzhuYonghuId;
		}

		/**
		* 获取： 求助标题
		*/
		public String getQiuzhuName() {
			return qiuzhuName;
		}
		/**
		* 设置： 求助标题
		*/
		public void setQiuzhuName(String qiuzhuName) {
			this.qiuzhuName = qiuzhuName;
		}

		/**
		* 获取： 求助封面
		*/
		public String getQiuzhuPhoto() {
			return qiuzhuPhoto;
		}
		/**
		* 设置： 求助封面
		*/
		public void setQiuzhuPhoto(String qiuzhuPhoto) {
			this.qiuzhuPhoto = qiuzhuPhoto;
		}
		/**
		* 获取： 类别
		*/
		public Integer getQiuzhuTypes() {
			return qiuzhuTypes;
		}
		/**
		* 设置： 类别
		*/
		public void setQiuzhuTypes(Integer qiuzhuTypes) {
			this.qiuzhuTypes = qiuzhuTypes;
		}


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

		/**
		* 获取： 物品名称
		*/
		public String getQiuzhuWupin() {
			return qiuzhuWupin;
		}
		/**
		* 设置： 物品名称
		*/
		public void setQiuzhuWupin(String qiuzhuWupin) {
			this.qiuzhuWupin = qiuzhuWupin;
		}

		/**
		* 获取： 所需数量
		*/
		public Integer getQiuzhuNum() {
			return qiuzhuNum;
		}
		/**
		* 设置： 所需数量
		*/
		public void setQiuzhuNum(Integer qiuzhuNum) {
			this.qiuzhuNum = qiuzhuNum;
		}

		/**
		* 获取： 地址
		*/
		public String getQiuzhuAddress() {
			return qiuzhuAddress;
		}
		/**
		* 设置： 地址
		*/
		public void setQiuzhuAddress(String qiuzhuAddress) {
			this.qiuzhuAddress = qiuzhuAddress;
		}

		/**
		* 获取： 提货方式
		*/
		public String getQiuzhuTihuo() {
			return qiuzhuTihuo;
		}
		/**
		* 设置： 提货方式
		*/
		public void setQiuzhuTihuo(String qiuzhuTihuo) {
			this.qiuzhuTihuo = qiuzhuTihuo;
		}

		/**
		* 获取： 求助热度
		*/
		public Integer getQiuzhuClicknum() {
			return qiuzhuClicknum;
		}
		/**
		* 设置： 求助热度
		*/
		public void setQiuzhuClicknum(Integer qiuzhuClicknum) {
			this.qiuzhuClicknum = qiuzhuClicknum;
		}

		/**
		* 获取： 求助介绍
		*/
		public String getQiuzhuContent() {
			return qiuzhuContent;
		}
		/**
		* 设置： 求助介绍
		*/
		public void setQiuzhuContent(String qiuzhuContent) {
			this.qiuzhuContent = qiuzhuContent;
		}
		/**
		* 获取： 求助审核
		*/
		public Integer getQiuzhuYesnoTypes() {
			return qiuzhuYesnoTypes;
		}
		/**
		* 设置： 求助审核
		*/
		public void setQiuzhuYesnoTypes(Integer qiuzhuYesnoTypes) {
			this.qiuzhuYesnoTypes = qiuzhuYesnoTypes;
		}


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

		/**
		* 获取： 审核回复
		*/
		public String getQiuzhuYesnoText() {
			return qiuzhuYesnoText;
		}
		/**
		* 设置： 审核回复
		*/
		public void setQiuzhuYesnoText(String qiuzhuYesnoText) {
			this.qiuzhuYesnoText = qiuzhuYesnoText;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getQiuzhuDelete() {
			return qiuzhuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setQiuzhuDelete(Integer qiuzhuDelete) {
			this.qiuzhuDelete = qiuzhuDelete;
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
		return "QiuzhuCollectionView{" +
			", qiuzhuCollectionValue=" + qiuzhuCollectionValue +
			", qiuzhuName=" + qiuzhuName +
			", qiuzhuPhoto=" + qiuzhuPhoto +
			", qiuzhuWupin=" + qiuzhuWupin +
			", qiuzhuNum=" + qiuzhuNum +
			", qiuzhuAddress=" + qiuzhuAddress +
			", qiuzhuTihuo=" + qiuzhuTihuo +
			", qiuzhuClicknum=" + qiuzhuClicknum +
			", qiuzhuContent=" + qiuzhuContent +
			", qiuzhuYesnoText=" + qiuzhuYesnoText +
			", qiuzhuDelete=" + qiuzhuDelete +
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
