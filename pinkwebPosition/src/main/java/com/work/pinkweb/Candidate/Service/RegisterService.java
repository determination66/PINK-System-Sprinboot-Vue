package com.work.pinkweb.Candidate.Service;

import java.util.Date;

public interface RegisterService {
    //注册账号1，传入账号密码
    Integer candidateRegister(String phone,String password);
    //注册2,传入后面信息
    Integer perfectCandidateInfo(String phone, String name, Integer sex, Date birthday);
}
