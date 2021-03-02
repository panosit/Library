package com.dit.hua.dao;
import com.dit.hua.entity.*;
import org.springframework.stereotype.*;
import java.util.*;

@Repository
public interface AuthoritiesDAO{
    void insertAuthorities(Authorities authority);
    void deleteAuthorities(Authorities authority);
    Authorities getAuthorByUsername(String username);
    List<Authorities> getAuthorities();
    List<Authorities> getTeachers();
}