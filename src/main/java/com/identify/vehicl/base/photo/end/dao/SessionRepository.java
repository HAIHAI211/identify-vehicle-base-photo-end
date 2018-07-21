package com.identify.vehicl.base.photo.end.dao;

import com.identify.vehicl.base.photo.end.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

/*
* author: Harrison
* Time: 2018/4/16 19:52
* */
public interface SessionRepository extends JpaRepository<Session,Integer>{
    Optional<Session> findFirstBySessionIdAndLastDateAfter(String sessionId, Date date);
    Optional<Session> findFirstBySessionIdAndLastDateBefore(String sessionId, Date date);
    Optional<Session> findFirstBySessionId(String sessionId);
}
