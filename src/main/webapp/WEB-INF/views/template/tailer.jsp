<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     </div> <!-- /container -->
     <!-- footer -->
     <div class="footer">
        <p>
            <c:foreach items="${friendLinkList}" var="friendLink">
                 <a href="${friendLink.websiteurl}" target="_blank">${friendLink.websitename}</a>
            </c:foreach>
        </p>
       <p>云顶畅游&nbsp;版权所有</p>
       <p>Beijing Yunding Changyou Technology CO.,Ltd Copyright©2013 ALL Rights reserved</p>
       <p>京ICP备13033577号 京公网安备11010802011887号</p> 
     </div>
  </body>
</html>