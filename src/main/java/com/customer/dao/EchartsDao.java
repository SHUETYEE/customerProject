package com.customer.dao;

import com.customer.entity.Echarts;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.Year;
import java.util.List;

/**
 * (Echarts)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-03 10:21:30
 */
public interface EchartsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Echarts queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Echarts> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param echarts 实例对象
     * @return 对象列表
     */
    List<Echarts> queryAll(Echarts echarts);

    /**
     * 新增数据
     *
     * @param echarts 实例对象
     * @return 影响行数
     */
    int insert(Echarts echarts);

    /**
     * 修改数据
     *
     * @param echarts 实例对象
     * @return 影响行数
     */
    int update(Echarts echarts);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    @Select("select name ,count(1) as value from echarts group by name")
    List<Echarts> findAll();

    @Select("select name,sum(value) as value from echarts where DATE_FORMAT(createtime,'%Y')='2019' group by name")
    List<Echarts> bar();

    @Select("SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','01') UNION ALL\n" +
            "SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','02') UNION ALL\n" +
            "SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','03') UNION ALL\n" +
            "SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','04') UNION ALL\n" +
            "SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','05') UNION ALL\n" +
            "SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','06') UNION ALL\n" +
            "SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','07') UNION ALL\n" +
            "SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','08') UNION ALL\n" +
            "SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','09') UNION ALL\n" +
            "SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','10') UNION ALL\n" +
            "SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','11') UNION ALL\n" +
            "SELECT sum(value)  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','12') ")
    List<Integer> line();

    @Select("SELECT sum(value) as value ,sum(price) as price from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','01') UNION ALL\n" +
            "SELECT sum(value) as value ,sum(price) as price  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','02') UNION ALL\n" +
            "SELECT sum(value) as value ,sum(price) as price   from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','03') UNION ALL\n" +
            "SELECT sum(value) as value ,sum(price) as price   from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','04') UNION ALL\n" +
            "SELECT sum(value) as value ,sum(price) as price   from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','05') UNION ALL\n" +
            "SELECT sum(value) as value ,sum(price) as price  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','06') UNION ALL\n" +
            "SELECT sum(value) as value ,sum(price) as price  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','07') UNION ALL\n" +
            "SELECT sum(value) as value ,sum(price) as price  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','08') UNION ALL\n" +
            "SELECT sum(value) as value ,sum(price) as price  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','09') UNION ALL\n" +
            "SELECT sum(value) as value ,sum(price) as price   from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','10') UNION ALL\n" +
            "SELECT sum(value) as value ,sum(price) as price  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','11') UNION ALL\n" +
            "SELECT sum(value) as value ,sum(price) as price  from echarts WHERE DATE_FORMAT(createtime,'%Y%m')=concat('2019','12') ")
    List<Echarts> lineStack();
}