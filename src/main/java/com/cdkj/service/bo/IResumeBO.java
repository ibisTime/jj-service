package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Resume;

public interface IResumeBO extends IPaginableBO<Resume> {

    public boolean isResumeExist(String code);

    public String saveResume(Resume data);

    public int removeResume(String code);

    public int refreshResume(Resume data);

    public int refreshResumeUseTime(String code);

    public int refreshResumeStatus(String code, String dealer, String dealNote);

    public List<Resume> queryResumeList(Resume condition);

    public Resume getResume(String code);

}
