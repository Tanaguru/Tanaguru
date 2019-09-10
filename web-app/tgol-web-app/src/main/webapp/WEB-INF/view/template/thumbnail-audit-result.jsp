<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="height" value="170"/>
<c:set var="width" value="270"/>
<c:set var="tgLogoUrl">
    <c:url value="/Images/Logo-Tanaguru-G-w${width}-h${height}-75dpi-bgTransp.png"/>
</c:set>
<div class="${proportion} ${offset}">
    <div class="thumbnail" >
        <c:choose>
            <c:when test="${scope != 'FILE' &&
                            not empty snapshot}">
                <img src="data:image/png;base64, ${snapshot}"
                     alt="audit snapshot" height="${height}" width="${width}"/>
            </c:when>
            <c:otherwise>
                <c:set var="tgLogoUrl">
                    <c:url value="/Images/Logo-Tanaguru-G-w${width}-h${height}-75dpi-bgTransp.png"/>
                </c:set>
                <img src="${tgLogoUrl}"
                     alt=""
                     class="tg-logo"/><br/>
            </c:otherwise>
        </c:choose>
    </div>
</div>