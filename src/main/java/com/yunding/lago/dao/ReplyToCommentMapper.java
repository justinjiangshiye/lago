package com.yunding.lago.dao;

import com.yunding.lago.bean.ReplyToComment;

public interface ReplyToCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReplyToComment record);

    int insertSelective(ReplyToComment record);

    ReplyToComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReplyToComment record);

    int updateByPrimaryKeyWithBLOBs(ReplyToComment record);

    int updateByPrimaryKey(ReplyToComment record);
}