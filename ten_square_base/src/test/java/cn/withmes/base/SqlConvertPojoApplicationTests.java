package cn.withmes.base;

import cn.withmes.base.entity.TbLabel;
import cn.withmes.base.mapper.TbLabelMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlConvertPojoApplicationTests {


    @Autowired
    private  TbLabelMapper labelMapper;


    @Test
    public void contextLoads() {
        Page<TbLabel> page = new Page<>(1, 5);
        IPage<TbLabel> userIPage = labelMapper.selectPage(page, new QueryWrapper<TbLabel>());
        Assert.assertSame(userIPage, page);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        print(userIPage.getRecords());
    }

    private <T> void print(List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(System.out::println);
        }
    }

}
