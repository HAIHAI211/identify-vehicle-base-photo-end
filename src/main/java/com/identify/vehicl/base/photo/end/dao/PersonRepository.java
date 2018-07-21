package com.identify.vehicl.base.photo.end.dao;

import com.identify.vehicl.base.photo.end.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* author: Harrison
* Time: 2018/4/10 14:54
* */
public interface PersonRepository extends JpaRepository<Person,Integer>{
//    //原生SQL实现更新方法接口
//    @Query(value = "update person set name=?1 where id=?2 ", nativeQuery = true)
//    @Modifying
//    public void update(String name,int id);
}
