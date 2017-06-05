package com.cdkj.service.dto.res;

import com.cdkj.service.domain.Resume;
import com.cdkj.service.domain.User;

/**
 * 简历
 * @author: asus 
 * @since: 2017年6月5日 下午3:45:55 
 * @history:
 */
public class XN612186Res {
    private Resume resume;

    private User user;

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
