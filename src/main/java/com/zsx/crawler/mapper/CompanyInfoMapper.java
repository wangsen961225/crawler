package com.zsx.crawler.mapper;

import com.zsx.crawler.pojo.CompanyInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CompanyInfoMapper {

    void addCompanyInfo(List<CompanyInfo> list);
}
