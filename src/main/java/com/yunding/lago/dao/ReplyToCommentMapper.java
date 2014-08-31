package com.yunding.lago.dao;

import java.util.List;

import com.yunding.lago.bean.ReplyToComment;

public interface ReplyToCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReplyToComment record);

    int insertSelective(ReplyToComment record);

    ReplyToComment selectByPrimaryKey(Integer id);
    
    List<ReplyToComment> selectByCommentId(Integer commentId);
    
    List<ReplyToComment> selectByArticleId(Integer articleId);

    int updateByPrimaryKeySelective(ReplyToComment record);

    int updateByPrimaryKeyWithBLOBs(ReplyToComment record);

    int updateByPrimaryKey(ReplyToComment record);
}