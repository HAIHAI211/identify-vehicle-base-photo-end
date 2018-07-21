package com.identify.vehicl.base.photo.end.dao;

import com.identify.vehicl.base.photo.end.entity.Appoint;
import com.identify.vehicl.base.photo.end.pojo.AppointInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
* author: Harrison
* Time: 2018/4/23 17:16
* */
public interface AppointRepository extends JpaRepository<Appoint,Integer>{
    @Query(value="SELECT new com.highschool.football.pojo.AppointInfo(a,u) FROM "
            + " Appoint a, com.highschool.football.entity.User u WHERE a.creatorId = u.id ")
    List<AppointInfo> findAppointInfo();


    @Query(value="SELECT new com.highschool.football.pojo.AppointInfo(a,u)"
            + " FROM Appoint a, com.highschool.football.entity.User u"
            + " WHERE a.creatorId = u.id "
            + " AND a.status = 0")
    List<AppointInfo> findAppointInfo1();


    @Query(value="SELECT a FROM "
            + " Appoint a, com.highschool.football.entity.AppointJoinUser aju "
            + " WHERE a.id = aju.appointId AND aju.userId = ?1")
    List<Appoint> findMyJoinAppoints(Integer userId);

    List<Appoint> findAppointsByCreatorId(Integer userId);

//    @Query(value = "SELECT new CreatedAppointInfo(a, u) FROM " +
//            "Appoint a , AppointJoinUser aju, User u WHERE " +
//            "a.creatorId = ?1 AND a.id = aju.appointId AND u.id = aju.userId")
//    List<CreatedAppointInfo> findCreatedAppointInfo(Integer creatorId);
}
