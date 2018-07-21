package com.identify.vehicl.base.photo.end.dao;

import com.identify.vehicl.base.photo.end.entity.AppointJoinUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/*
* author: Harrison
* Time: 2018/4/23 18:04
* */
public interface AppointJoinUserRepository extends JpaRepository<AppointJoinUser,Integer>{
    Optional<AppointJoinUser> findFirstByAppointIdAndUserId(Integer appointId, Integer userId);
    List<AppointJoinUser> findAllByUserId(Integer userId);
    List<AppointJoinUser> findAllByAppointId(Integer appointId);
}
