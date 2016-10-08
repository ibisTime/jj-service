package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Resume;

public interface IResumeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addResume(Resume data);

    public int dropResume(String code);

    public int editResume(Resume data);

    public int editResumeStatus(String code, String dealer, String dealNote);

    public Paginable<Resume> queryResumePage(int start, int limit,
            Resume condition);

    public List<Resume> queryResumeList(Resume condition);

    public Resume getResume(String code);

}
