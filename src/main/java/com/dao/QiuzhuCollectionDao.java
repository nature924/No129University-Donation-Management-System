package com.dao;

import com.entity.QiuzhuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QiuzhuCollectionView;

/**
 * 求助收藏 Dao 接口
 *
 * @author 
 */
public interface QiuzhuCollectionDao extends BaseMapper<QiuzhuCollectionEntity> {

   List<QiuzhuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
