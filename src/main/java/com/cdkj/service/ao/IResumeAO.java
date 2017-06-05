package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Resume;
import com.cdkj.service.dto.req.XN612180Req;
import com.cdkj.service.dto.req.XN612182Req;
import com.cdkj.service.dto.res.XN612186Res;

public interface IResumeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addResume(XN612180Req req);

    public void dropResume(String code);

    public void editResume(XN612182Req req);

    public void editResumeStatus(String code, String dealer, String dealNote);

    public Paginable<Resume> queryResumePage(int start, int limit,
            Resume condition);

    public List<Resume> queryResumeList(String publisher, String status);

    public XN612186Res getResume(String code);

}
