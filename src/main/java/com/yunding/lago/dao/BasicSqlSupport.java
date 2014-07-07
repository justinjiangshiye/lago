/**
 * 
 */
package com.yunding.lago.dao;

import org.apache.ibatis.session.SqlSession;

/**
 * @author justin
 *
 */

public class BasicSqlSupport{ 
    protected SqlSession session;

    protected SqlSession getSession() { 
        return session; 
    } 
    public void setSession(SqlSession session) { 
        this.session = session; 
    } 
}