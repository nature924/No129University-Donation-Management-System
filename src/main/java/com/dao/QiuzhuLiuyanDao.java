package com.dao;

import com.entity.QiuzhuLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QiuzhuLiuyanView;

/**
 * 求助留言 Dao 接口
 *
 * @author 
 */
public interface QiuzhuLiuyanDao extends BaseMapper<QiuzhuLiuyanEntity> {

   List<QiuzhuLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
