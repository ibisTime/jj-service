package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Resume;

public interface IResumeBO extends IPaginableBO<Resume> {

    public boolean isResumeExist(String code);

    public void saveResume(Resume data);

    public void removeResume(String code);

    public void refreshResume(Resume data);

    public void refreshResumeUseTime(String code);

    public void refreshResumeStatus(String code, String dealer, String dealNote);

    public List<Resume> queryResumeList(String publisher, String status);

    public Resume getResume(String code);

}
