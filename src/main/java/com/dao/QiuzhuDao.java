package com.dao;

import com.entity.QiuzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QiuzhuView;

/**
 * 求助信息 Dao 接口
 *
 * @author 
 */
public interface QiuzhuDao extends BaseMapper<QiuzhuEntity> {

   List<QiuzhuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
