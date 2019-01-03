package com.zsx.crawler.service.impl;

import com.zsx.crawler.mapper.CompanyInfoMapper;
import com.zsx.crawler.pojo.CompanyInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyInfoServiceImpl {

    @Resource
    private CompanyInfoMapper cim;

    void addCompanyInfo(List<CompanyInfo> list){
        cim.addCompanyInfo(list);
    }
}
