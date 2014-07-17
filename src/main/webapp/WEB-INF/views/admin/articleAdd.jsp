<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp" %>

<h3 class="sub-header">新增文章</h3>
<form class="form-horizontal" role="form">
  <div class="form-group">
    <label for="selectCategory" class="col-sm-2 control-label">栏目</label>
    <div class="col-sm-10">
      <select id="selectCategory" name="Category">
         <option value="父母学堂">父母学堂</option>
         <option value="守护成长">守护成长</option>
         <option value="我爱我家">我爱我家</option>
         <option value="亲子阅读">亲子阅读</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputTitle" class="col-sm-2 control-label">标题</label>
    <div class="col-sm-10">
      <input id="inputTitle" name="Title" type="text" class="form-control">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">保存</button>
    </div>
  </div>
</form>

<%@ include file="../template/admin-tailer.jsp" %>