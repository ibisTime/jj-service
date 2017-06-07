package com.cdkj.service.dto.res;

import com.cdkj.service.domain.CbIntention;
import com.cdkj.service.domain.Operate;
import com.cdkj.service.domain.Photo;
import com.cdkj.service.domain.Position;
import com.cdkj.service.domain.Resume;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.domain.Train;

/**
 * 详情查询CB意向
 * @author: asus 
 * @since: 2017年6月7日 下午6:42:19 
 * @history:
 */
public class XN612176Res {
    // cb意向
    private CbIntention cbIntention;

    // 职位
    private Position position;

    // 服务
    private Serve serve;

    // 运营
    private Operate operate;

    // 培训
    private Train train;

    // 摄影
    private Photo photo;

    // 简历
    private Resume resume;

    public CbIntention getCbIntention() {
        return cbIntention;
    }

    public void setCbIntention(CbIntention cbIntention) {
        this.cbIntention = cbIntention;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Serve getServe() {
        return serve;
    }

    public void setServe(Serve serve) {
        this.serve = serve;
    }

    public Operate getOperate() {
        return operate;
    }

    public void setOperate(Operate operate) {
        this.operate = operate;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }
}
