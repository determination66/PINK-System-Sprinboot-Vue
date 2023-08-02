package com.work.pinkweb.Candidate.Service;

import com.github.pagehelper.PageInfo;
import com.work.pinkweb.Entity.Company;
import com.work.pinkweb.Entity.CompanyHr;

import java.util.List;

public interface CaCompanyService {
    Company getCompanyDetailbById(Integer e_id);
    Company getCompanyHr(Integer e_id);
    List<CompanyHr> getHrRecruitment(Integer e_id);

    //条件查询公司信息  第几页  每页数量  限定条件
    PageInfo<Company> getCompanyByCondition(Integer pageIndex, Integer pageSize,String key,String flag);

    //获取热门公司
    List<Company> getHotCompany();


}
