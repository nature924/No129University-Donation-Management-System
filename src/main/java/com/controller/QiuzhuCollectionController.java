
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 求助收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qiuzhuCollection")
public class QiuzhuCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(QiuzhuCollectionController.class);

    private static final String TABLE_NAME = "qiuzhuCollection";

    @Autowired
    private QiuzhuCollectionService qiuzhuCollectionService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JuanzhengService juanzhengService;//捐赠信息
    @Autowired
    private NewsService newsService;//公告资讯
    @Autowired
    private QiuzhuService qiuzhuService;//求助信息
    @Autowired
    private QiuzhuLiuyanService qiuzhuLiuyanService;//求助留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = qiuzhuCollectionService.queryPage(params);

        //字典表数据转换
        List<QiuzhuCollectionView> list =(List<QiuzhuCollectionView>)page.getList();
        for(QiuzhuCollectionView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QiuzhuCollectionEntity qiuzhuCollection = qiuzhuCollectionService.selectById(id);
        if(qiuzhuCollection !=null){
            //entity转view
            QiuzhuCollectionView view = new QiuzhuCollectionView();
            BeanUtils.copyProperties( qiuzhuCollection , view );//把实体数据重构到view中
            //级联表 求助信息
            //级联表
            QiuzhuEntity qiuzhu = qiuzhuService.selectById(qiuzhuCollection.getQiuzhuId());
            if(qiuzhu != null){
            BeanUtils.copyProperties( qiuzhu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setQiuzhuId(qiuzhu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(qiuzhuCollection.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody QiuzhuCollectionEntity qiuzhuCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qiuzhuCollection:{}",this.getClass().getName(),qiuzhuCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            qiuzhuCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<QiuzhuCollectionEntity> queryWrapper = new EntityWrapper<QiuzhuCollectionEntity>()
            .eq("qiuzhu_id", qiuzhuCollection.getQiuzhuId())
            .eq("yonghu_id", qiuzhuCollection.getYonghuId())
            .eq("qiuzhu_collection_types", qiuzhuCollection.getQiuzhuCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiuzhuCollectionEntity qiuzhuCollectionEntity = qiuzhuCollectionService.selectOne(queryWrapper);
        if(qiuzhuCollectionEntity==null){
            qiuzhuCollection.setInsertTime(new Date());
            qiuzhuCollection.setCreateTime(new Date());
            qiuzhuCollectionService.insert(qiuzhuCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QiuzhuCollectionEntity qiuzhuCollection, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,qiuzhuCollection:{}",this.getClass().getName(),qiuzhuCollection.toString());
        QiuzhuCollectionEntity oldQiuzhuCollectionEntity = qiuzhuCollectionService.selectById(qiuzhuCollection.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            qiuzhuCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            qiuzhuCollectionService.updateById(qiuzhuCollection);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<QiuzhuCollectionEntity> oldQiuzhuCollectionList =qiuzhuCollectionService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        qiuzhuCollectionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<QiuzhuCollectionEntity> qiuzhuCollectionList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            QiuzhuCollectionEntity qiuzhuCollectionEntity = new QiuzhuCollectionEntity();
//                            qiuzhuCollectionEntity.setQiuzhuId(Integer.valueOf(data.get(0)));   //求助 要改的
//                            qiuzhuCollectionEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            qiuzhuCollectionEntity.setQiuzhuCollectionTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            qiuzhuCollectionEntity.setInsertTime(date);//时间
//                            qiuzhuCollectionEntity.setCreateTime(date);//时间
                            qiuzhuCollectionList.add(qiuzhuCollectionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        qiuzhuCollectionService.insertBatch(qiuzhuCollectionList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = qiuzhuCollectionService.queryPage(params);

        //字典表数据转换
        List<QiuzhuCollectionView> list =(List<QiuzhuCollectionView>)page.getList();
        for(QiuzhuCollectionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QiuzhuCollectionEntity qiuzhuCollection = qiuzhuCollectionService.selectById(id);
            if(qiuzhuCollection !=null){


                //entity转view
                QiuzhuCollectionView view = new QiuzhuCollectionView();
                BeanUtils.copyProperties( qiuzhuCollection , view );//把实体数据重构到view中

                //级联表
                    QiuzhuEntity qiuzhu = qiuzhuService.selectById(qiuzhuCollection.getQiuzhuId());
                if(qiuzhu != null){
                    BeanUtils.copyProperties( qiuzhu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setQiuzhuId(qiuzhu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(qiuzhuCollection.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody QiuzhuCollectionEntity qiuzhuCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,qiuzhuCollection:{}",this.getClass().getName(),qiuzhuCollection.toString());
        Wrapper<QiuzhuCollectionEntity> queryWrapper = new EntityWrapper<QiuzhuCollectionEntity>()
            .eq("qiuzhu_id", qiuzhuCollection.getQiuzhuId())
            .eq("yonghu_id", qiuzhuCollection.getYonghuId())
            .eq("qiuzhu_collection_types", qiuzhuCollection.getQiuzhuCollectionTypes())
//            .notIn("qiuzhu_collection_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiuzhuCollectionEntity qiuzhuCollectionEntity = qiuzhuCollectionService.selectOne(queryWrapper);
        if(qiuzhuCollectionEntity==null){
            qiuzhuCollection.setInsertTime(new Date());
            qiuzhuCollection.setCreateTime(new Date());
        qiuzhuCollectionService.insert(qiuzhuCollection);

            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }

}

