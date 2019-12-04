package com.customer.service.impl;

import com.customer.entity.Echarts;
import com.customer.dao.EchartsDao;
import com.customer.service.EchartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Echarts)表服务实现类
 *
 * @author makejava
 * @since 2019-12-03 10:21:30
 */
@Service("echartsService")
public class EchartsServiceImpl implements EchartsService {
    @Resource
    private EchartsDao echartsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Echarts queryById(Integer id) {
        return this.echartsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Echarts> queryAllByLimit(int offset, int limit) {
        return this.echartsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param echarts 实例对象
     * @return 实例对象
     */
    @Override
    public Echarts insert(Echarts echarts) {
        this.echartsDao.insert(echarts);
        return echarts;
    }

    /**
     * 修改数据
     *
     * @param echarts 实例对象
     * @return 实例对象
     */
    @Override
    public Echarts update(Echarts echarts) {
        this.echartsDao.update(echarts);
        return this.queryById(echarts.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.echartsDao.deleteById(id) > 0;
    }

    @Override
    public List<Echarts> findAll() {
        return echartsDao.findAll();
    }

    @Override
    public List<Echarts> bar() {
        return echartsDao.bar();
    }

    @Override
    public List<Integer> line() {
        return echartsDao.line();
    }

    @Override
    public List<Echarts> lineStack() {
        return echartsDao.lineStack();
    }
}