<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/27
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%--paginate start--%>
<%--paginate--%>
<div class="col-sm-7">
    <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
        <ul class="pagination">
            <li <c:choose>
                <c:when test="${pageInfo.isFirstPage}">class="paginate_button previous disabled"</c:when>
                <c:otherwise>class="paginate_button previous"</c:otherwise>
            </c:choose>
                    id= "example2_previous">
                <a href="?pageNum=${pageInfo.pageNum-1}" aria-controls="example2" data-dt-idx="0" tabindex="0">
                    前一页
                </a>
            </li>

            <c:forEach begin="0" end="${pageInfo.pages-1}" varStatus="status" step="1">
                <li <c:choose>
                    <c:when test="${pageInfo.pageNum == status.count}">class="paginate_button active"</c:when>
                    <c:otherwise>class="paginate_button"</c:otherwise>
                </c:choose>>
                    <a href="?pageNum=${status.count}" aria-controls="example2" data-dt-idx="1" tabindex="0">
                            ${status.count}
                    </a>
                </li>
            </c:forEach>

            <li <c:choose>
                <c:when test="${pageInfo.isLastPage}">class="paginate_button next disabled"</c:when>
                <c:otherwise>class="paginate_button next"</c:otherwise>
            </c:choose> id="example2_next">
                <a href="?pageNum=${pageInfo.pageNum+1}" aria-controls="example2" data-dt-idx="7" tabindex="0">
                    下一页
                </a>
            </li>
        </ul>
    </div>
</div>
<%--paginate end--%>
