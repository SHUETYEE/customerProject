package com.customer.service;

import com.customer.entity.Echarts;
import java.util.List;

/**
 * (Echarts)表服务接口
 *
 * @author makejava
 * @since 2019-12-03 10:21:30
 */
public interface EchartsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Echarts queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Echarts> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param echarts 实例对象
     * @return 实例对象
     */
    Echarts insert(Echarts echarts);

    /**
     * 修改数据
     *
     * @param echarts 实例对象
     * @return 实例对象
     */
    Echarts update(Echarts echarts);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Echarts> findAll();

    List<Echarts> bar();

    List<Integer> line();

    List<Echarts> lineStack();
}