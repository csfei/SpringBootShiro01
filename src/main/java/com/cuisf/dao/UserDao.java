package com.cuisf.dao;

import com.cuisf.entity.Perms;
import com.cuisf.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* @Repository需要在Spring中配置扫描地址，然后生成Dao层的Bean才能被注入到Service层中
            *   @SpringBootApplication   //添加启动类注解
                @MapperScan("com.anson.dao")  //配置mapper扫描地址
                public class application
                {
                    public static   void main(String[] args)
                    {
                        SpringApplication.run(application.class,args);
                    }
                }
*
* @Mapper不需要配置扫描地址，通过xml里面的namespace里面的接口地址，生成了Bean后注入到Service层中
* */


@Repository
//@Mapper
public interface UserDao {

    void save(User user);

    User findByUserName(String username);


    //根据用户名查询所有角色
    User findRolesByUsername(String username);

    //根据角色id 获取权限
    List<Perms> findPermsByRoleId(String id);
}

