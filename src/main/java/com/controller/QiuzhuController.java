
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
 * 求助信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qiuzhu")
public class QiuzhuController {
    private static final Logger logger = LoggerFactory.getLogger(QiuzhuController.class);

    private static final String TABLE_NAME = "qiuzhu";

    @Autowired
    private QiuzhuService qiuzhuService;


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
    private QiuzhuCollectionService qiuzhuCollectionService;//求助收藏
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
        params.put("qiuzhuDeleteStart",1);params.put("qiuzhuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = qiuzhuService.queryPage(params);

        //字典表数据转换
        List<QiuzhuView> list =(List<QiuzhuView>)page.getList();
        for(QiuzhuView c:list){
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
        QiuzhuEntity qiuzhu = qiuzhuService.selectById(id);
        if(qiuzhu !=null){
            //entity转view
            QiuzhuView view = new QiuzhuView();
            BeanUtils.copyProperties( qiuzhu , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(qiuzhu.getYonghuId());
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
    public R save(@RequestBody QiuzhuEntity qiuzhu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qiuzhu:{}",this.getClass().getName(),qiuzhu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            qiuzhu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<QiuzhuEntity> queryWrapper = new EntityWrapper<QiuzhuEntity>()
            .eq("yonghu_id", qiuzhu.getYonghuId())
            .eq("qiuzhu_name", qiuzhu.getQiuzhuName())
            .eq("qiuzhu_types", qiuzhu.getQiuzhuTypes())
            .eq("qiuzhu_wupin", qiuzhu.getQiuzhuWupin())
            .eq("qiuzhu_num", qiuzhu.getQiuzhuNum())
            .eq("qiuzhu_address", qiuzhu.getQiuzhuAddress())
            .eq("qiuzhu_tihuo", qiuzhu.getQiuzhuTihuo())
            .in("qiuzhu_yesno_types", new Integer[]{1,2})
            .eq("qiuzhu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiuzhuEntity qiuzhuEntity = qiuzhuService.selectOne(queryWrapper);
        if(qiuzhuEntity==null){
            qiuzhu.setQiuzhuClicknum(1);
            qiuzhu.setQiuzhuYesnoTypes(1);
            qiuzhu.setQiuzhuDelete(1);
            qiuzhu.setInsertTime(new Date());
            qiuzhu.setCreateTime(new Date());
            qiuzhuService.insert(qiuzhu);
            return R.ok();
        }else {
            if(qiuzhuEntity.getQiuzhuYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(qiuzhuEntity.getQiuzhuYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QiuzhuEntity qiuzhu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,qiuzhu:{}",this.getClass().getName(),qiuzhu.toString());
        QiuzhuEntity oldQiuzhuEntity = qiuzhuService.selectById(qiuzhu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            qiuzhu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(qiuzhu.getQiuzhuPhoto()) || "null".equals(qiuzhu.getQiuzhuPhoto())){
                qiuzhu.setQiuzhuPhoto(null);
        }

            qiuzhuService.updateById(qiuzhu);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody QiuzhuEntity qiuzhuEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,qiuzhuEntity:{}",this.getClass().getName(),qiuzhuEntity.toString());

        QiuzhuEntity oldQiuzhu = qiuzhuService.selectById(qiuzhuEntity.getId());//查询原先数据

//        if(qiuzhuEntity.getQiuzhuYesnoTypes() == 2){//通过
//            qiuzhuEntity.setQiuzhuTypes();
//        }else if(qiuzhuEntity.getQiuzhuYesnoTypes() == 3){//拒绝
//            qiuzhuEntity.setQiuzhuTypes();
//        }
        qiuzhuService.updateById(qiuzhuEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<QiuzhuEntity> oldQiuzhuList =qiuzhuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<QiuzhuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            QiuzhuEntity qiuzhuEntity = new QiuzhuEntity();
            qiuzhuEntity.setId(id);
            qiuzhuEntity.setQiuzhuDelete(2);
            list.add(qiuzhuEntity);
        }
        if(list != null && list.size() >0){
            qiuzhuService.updateBatchById(list);
        }

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
            List<QiuzhuEntity> qiuzhuList = new ArrayList<>();//上传的东西
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
                            QiuzhuEntity qiuzhuEntity = new QiuzhuEntity();
//                            qiuzhuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            qiuzhuEntity.setQiuzhuName(data.get(0));                    //求助标题 要改的
//                            qiuzhuEntity.setQiuzhuPhoto("");//详情和图片
//                            qiuzhuEntity.setQiuzhuTypes(Integer.valueOf(data.get(0)));   //类别 要改的
//                            qiuzhuEntity.setQiuzhuWupin(data.get(0));                    //物品名称 要改的
//                            qiuzhuEntity.setQiuzhuNum(Integer.valueOf(data.get(0)));   //所需数量 要改的
//                            qiuzhuEntity.setQiuzhuAddress(data.get(0));                    //地址 要改的
//                            qiuzhuEntity.setQiuzhuTihuo(data.get(0));                    //提货方式 要改的
//                            qiuzhuEntity.setQiuzhuClicknum(Integer.valueOf(data.get(0)));   //求助热度 要改的
//                            qiuzhuEntity.setQiuzhuContent("");//详情和图片
//                            qiuzhuEntity.setQiuzhuYesnoTypes(Integer.valueOf(data.get(0)));   //求助审核 要改的
//                            qiuzhuEntity.setQiuzhuYesnoText(data.get(0));                    //审核回复 要改的
//                            qiuzhuEntity.setQiuzhuDelete(1);//逻辑删除字段
//                            qiuzhuEntity.setInsertTime(date);//时间
//                            qiuzhuEntity.setCreateTime(date);//时间
                            qiuzhuList.add(qiuzhuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        qiuzhuService.insertBatch(qiuzhuList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<QiuzhuView> returnQiuzhuViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("qiuzhuYesnoTypes",2);
        params1.put("sort","yonghu_jif");
        CommonUtil.checkMap(params1);
        PageUtils pageUtils = qiuzhuCollectionService.queryPage(params1);
        List<QiuzhuCollectionView> collectionViewsList =(List<QiuzhuCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(QiuzhuCollectionView collectionView:collectionViewsList){
            Integer qiuzhuTypes = collectionView.getQiuzhuTypes();
            if(typeMap.containsKey(qiuzhuTypes)){
                typeMap.put(qiuzhuTypes,typeMap.get(qiuzhuTypes)+1);
            }else{
                typeMap.put(qiuzhuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("qiuzhuTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("qiuzhuYesnoTypes",2);
            params2.put("sort","yonghu_jif");
            CommonUtil.checkMap(params2);
            PageUtils pageUtils1 = qiuzhuService.queryPage(params2);
            List<QiuzhuView> qiuzhuViewList =(List<QiuzhuView>)pageUtils1.getList();
            returnQiuzhuViewList.addAll(qiuzhuViewList);
            if(returnQiuzhuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("qiuzhuYesnoTypes",2);
        params.put("sort","yonghu_jif");
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = qiuzhuService.queryPage(params);
        if(returnQiuzhuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnQiuzhuViewList.size();//要添加的数量
            List<QiuzhuView> qiuzhuViewList =(List<QiuzhuView>)page.getList();
            for(QiuzhuView qiuzhuView:qiuzhuViewList){
                Boolean addFlag = true;
                for(QiuzhuView returnQiuzhuView:returnQiuzhuViewList){
                    if(returnQiuzhuView.getId().intValue() ==qiuzhuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnQiuzhuViewList.add(qiuzhuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnQiuzhuViewList = returnQiuzhuViewList.subList(0, limit);
        }

        for(QiuzhuView c:returnQiuzhuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnQiuzhuViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = qiuzhuService.queryPage(params);

        //字典表数据转换
        List<QiuzhuView> list =(List<QiuzhuView>)page.getList();
        for(QiuzhuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QiuzhuEntity qiuzhu = qiuzhuService.selectById(id);
            if(qiuzhu !=null){

                //点击数量加1
                qiuzhu.setQiuzhuClicknum(qiuzhu.getQiuzhuClicknum()+1);
                qiuzhuService.updateById(qiuzhu);

                //entity转view
                QiuzhuView view = new QiuzhuView();
                BeanUtils.copyProperties( qiuzhu , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(qiuzhu.getYonghuId());
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
    public R add(@RequestBody QiuzhuEntity qiuzhu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,qiuzhu:{}",this.getClass().getName(),qiuzhu.toString());
        Wrapper<QiuzhuEntity> queryWrapper = new EntityWrapper<QiuzhuEntity>()
            .eq("yonghu_id", qiuzhu.getYonghuId())
            .eq("qiuzhu_name", qiuzhu.getQiuzhuName())
            .eq("qiuzhu_types", qiuzhu.getQiuzhuTypes())
            .eq("qiuzhu_wupin", qiuzhu.getQiuzhuWupin())
            .eq("qiuzhu_num", qiuzhu.getQiuzhuNum())
            .eq("qiuzhu_address", qiuzhu.getQiuzhuAddress())
            .eq("qiuzhu_tihuo", qiuzhu.getQiuzhuTihuo())
            .eq("qiuzhu_clicknum", qiuzhu.getQiuzhuClicknum())
            .in("qiuzhu_yesno_types", new Integer[]{1,2})
            .eq("qiuzhu_yesno_text", qiuzhu.getQiuzhuYesnoText())
            .eq("qiuzhu_delete", qiuzhu.getQiuzhuDelete())
//            .notIn("qiuzhu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiuzhuEntity qiuzhuEntity = qiuzhuService.selectOne(queryWrapper);
        if(qiuzhuEntity==null){
            qiuzhu.setQiuzhuClicknum(1);
            qiuzhu.setQiuzhuYesnoTypes(1);
            qiuzhu.setQiuzhuDelete(1);
            qiuzhu.setInsertTime(new Date());
            qiuzhu.setCreateTime(new Date());
        qiuzhuService.insert(qiuzhu);

            return R.ok();
        }else {
            if(qiuzhuEntity.getQiuzhuYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(qiuzhuEntity.getQiuzhuYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

