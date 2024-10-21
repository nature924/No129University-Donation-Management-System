package com.dao;

import com.entity.JuanzhengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JuanzhengView;

/**
 * 捐赠信息 Dao 接口
 *
 * @author 
 */
public interface JuanzhengDao extends BaseMapper<JuanzhengEntity> {

   List<JuanzhengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
