<%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tagutils" prefix="tg" %>
<!DOCTYPE html>

<!-- external js -->
<c:set var="jqueryUrl">
    <c:url value="/External-Js/jquery-1.9.1.min.js"/>
</c:set>
<c:set var="d3JsUrl" scope="request">
    <c:url value="/External-Js/d3.v3.min.js"/>
</c:set> 
<c:set var="r2d3JsUrl" scope="request">
    <c:url value="/External-Js/r2d3.v2.min.js"/>
</c:set> 

<!-- internal js -->
<c:set var="homeScoreJsUrl" scope="request">
    <c:url value="/Js/score/score-home-min.js"/>
</c:set> 
<c:set var="homeScoreIEJsUrl" scope="request">
    <c:url value="/Js/ie/score/score-home-ie-min.js"/>
</c:set>
<c:set var="scoreJsUrl" scope="request">
    <c:url value="/Js/score/score-min.js"/>
</c:set> 
<c:set var="scoreIEJsUrl" scope="request">
    <c:url value="/Js/ie/score/score-ie-min.js"/>
</c:set> 

<!-- external images -->
<c:set var="gearImgUrl">
    <c:url value="/Images/gear.png"/>  
</c:set>
<c:set var="increaseLogoUrl">
    <c:url value="/Images/increase-narrow.png"/>  
</c:set>
<c:set var="decreaseLogoUrl">
    <c:url value="/Images/decrease-narrow.png"/>
</c:set>
<c:set var="stableLogoUrl">
    <c:url value="/Images/stable-narrow.png"/>
</c:set>

<html lang="${tg:lang(pageContext)}">
    <c:set var="pageTitle" scope="page">
        <fmt:message key="home.pageTitle"/>
    </c:set>
    <%@include file="template/head.jsp" %>
    <body id="tgm-home">
        <%@include file="template/header-utils.jsp" %>
        <div class="container">
            <div class="row">
                <div class="span16">
                    <h1><fmt:message key="home.h1"/></h1>
                </div>
            </div>
            <c:import url="template/sort-contract-console.jsp" />
            <div class="row">
                <div class="span16">
                <c:forEach var="contract" items="${contractList}" varStatus="pContractSet">
                    <c:set var="explanation">
                        <c:catch var="explanationException">
                            <spring:message code="${contract.presetContractKey}-explanation" arguments="${tg:host(contract.url)}"/>
                        </c:catch>
                    </c:set>
                    <table class="project-table">
                        <c:choose>
                        <c:when test="${fn:length(contractList) == pContractSet.index + 1 && empty explanation}">
                            <tr id="project-${pContractSet.index}" class="one-project last-project">
                        </c:when>
                        <c:otherwise>
                            <tr id="project-${pContractSet.index}" class="one-project">
                        </c:otherwise>
                        </c:choose>
                        <c:set var="url" scope="page" value="${contract.url}"/>
                        <c:set var="contract" scope="page" value="${contract}"/>
                        <c:set var="size" scope="page" value="T"/>
                        <c:choose>
                            <c:when test="${contract.lastActInfo.status == 'COMPLETED'}">
                                <c:set var="snapshot" scope="page" value="${contract.lastActInfo.snapshot}"/>
                            </c:when>
                            <c:otherwise>
                                <c:set var="snapshot" scope="page" value="${null}"/>
                            </c:otherwise>
                        </c:choose>
                        <td class="project-thumbnail">
                        <%@include file="template/thumbnail.jsp" %>
                        </td>
                        <c:choose>
                            <c:when test="${contract.isContractExpired != 'true'}">
                        <td class="project-info">
                            <h2 class="project-name">
                                <a href="home/contract.html?cr=${contract.id}">
                                    ${contract.label}
                                </a>
                                <c:if test="${contract.isActRunning == 'true'}">
                                <img src="${gearImgUrl}" title="<fmt:message key="home.actRunning"/>" alt="<fmt:message key="home.actRunning"/>" class="running-audit"/>
                                </c:if>
                            </h2>
                            <c:if test="${not empty contract.url}">
                            <div class="project-url"><a href="${contract.url}">${contract.url}</a></div>
                            </c:if>
                            <c:choose>
                                <c:when test='${contract.lastActInfo != null}'>
                                    <c:set var="resultUrl" scope="page" value="/home/contract/audit-result.html?audit="/>
                                    <c:set var="auditDate" scope="page">
                                        <fmt:formatDate type="date" value="${contract.lastActInfo.date}" dateStyle="long"/> <fmt:message key="home.at"/> <fmt:formatDate type="time" value="${contract.lastActInfo.date}"/>
                                    </c:set>
                                    <div class="project-status">
                                        <a href="<c:url value="${resultUrl}${contract.lastActInfo.auditId}"/>">
                                            <span class="last-audit-label" title="<fmt:message key="pageList.pageDetailedResult"></fmt:message> <fmt:message key="pageList.for"></fmt:message> ${contract.lastActInfo.url} (${auditDate})">
                                                <fmt:message key="home.lastAudit"/>
                                            </span>
                                        </a>
                                        : ${auditDate}
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="project-status"><span class="last-audit-label"><fmt:message key="home.noAudit"/></span></div>
                                </c:otherwise>
                            </c:choose>
                                    
                                       <div class="project-status">
                                           <span class="contract-expireon"> <fmt:message key="contract.expireOn"/> : </span><fmt:formatDate type="date" value="${contract.expirationDate}" dateStyle="long"/>
                                       </div>     
                                  
                        </td>
                        <td class="project-actions">
                            <c:forEach var="contractAction" items="${contract.actionList}" varStatus="pContractAction">
                                <c:set var="actionNameI18N">
                                    <fmt:message key="${contractAction.actionI81NCode}"/>
                                </c:set>
                                <c:set var="actionName">
                                    ${fn:replace(actionNameI18N, '<br/>', '')}
                                </c:set>

                                <c:choose>
                                    <c:when test="${contractAction.actionEnabled}">
                                        <c:set var="contractActionImgUrl">
                                            <c:url value="${contractAction.enabledActionImageUrl}"/>
                                        </c:set>
                                        <c:set var="disabledComplement" value=""/>
                                    </c:when>
                                    <c:otherwise>
                                        <c:set var="contractActionImgUrl">
                                            <c:url value="${contractAction.disabledActionImageUrl}"/>
                                        </c:set>
                                        <c:set var="disabledComplement">
                                            <fmt:message key="contract.disabled"/>
                                        </c:set>
                                    </c:otherwise>
                                </c:choose>
                                
                            <span class="action-button">
                                <c:choose>
                                    <c:when test="${contractAction.actionEnabled}">
                                <a href="<c:url value="${contractAction.actionUrl}?cr=${contract.id}"/>" title="${actionName} ${disabledComplement}">
                                    <img src="${contractActionImgUrl}" alt="${actionName} ${disabledComplement}" class="action-s"/>
                                </a>
                                    </c:when>
                                    <c:otherwise>
                                        <img src="${contractActionImgUrl}" alt="${actionName} ${disabledComplement}" class="action-s" title="${actionName} ${disabledComplement}"/>
                                    </c:otherwise>
                                </c:choose>
                            </span>
                            </c:forEach>
                        </td>
                        <td class="project-result">
                        <c:if test='${contract.lastActInfo != null}'>
                            <c:choose>
                                <c:when test="${contract.lastActInfo.status == 'COMPLETED'}">
                            <c:set var="mark" scope="page" value="${contract.lastActInfo.rawMark}"/>
                            <c:set var="scoreClass" scope="page" value="one-project-score"/>
                            <c:set var="scoreId" scope="page" value=""/>
                            <c:set var="hasScoreFormulaLink" scope="page" value="false"/>
                            <c:set var="spanClass" scope="page" value=""/>
                            <%@include file="template/score.jsp" %>
                                </c:when>
                                <c:otherwise>
                                <span class="project-fail"><fmt:message key="${contract.lastActInfo.status}"/></span>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                        </td>
                        <td class="project-trend">
                        <c:set var="progressValue" scope="page" value="${contract.siteAuditProgression}"/>
                        <c:choose>
                        <c:when test="${progressValue eq 'PROGRESS'}">
                            <img src="${increaseLogoUrl}" alt="<fmt:message key="score-increase"/>" title="<fmt:message key="score-increase"/>" class="score-progression"/>
                        </c:when>
                        <c:when test="${progressValue eq 'REGRESS'}">
                            <img src="${decreaseLogoUrl}" alt="<fmt:message key="score-decrease"/>" title="<fmt:message key="score-decrease"/>" class="score-progression"/>
                        </c:when>
                        <c:when test="${progressValue eq 'STABLE'}">
                            <img src="${stableLogoUrl}" alt="<fmt:message key="score-stable"/>" title="<fmt:message key="score-stable"/>" class="score-progression"/>
                        </c:when>
                        </c:choose>
                        </td>
                            </c:when>
                            <c:otherwise>
                        <td class="project-expired">
                            <h2 class="project-name">${contract.label}</h2>
                            <div class="project-expiration"><fmt:message key="home.projectHasExpired"/></div>
                            <div class="project-url"><a href="${contract.url}">${contract.url}</a></div>
                        </td>
                            </c:otherwise>
                        </c:choose>
                        </tr>
                        <c:if test="${not empty explanation}">
                        <c:choose>
                        <c:when test="${fn:length(contractList) == pContractSet.index + 1}">
                            <tr class="contract-explanation last-project">
                        </c:when>
                        <c:otherwise>
                            <tr class="contract-explanation">
                        </c:otherwise>
                        </c:choose>    
                            <td></td>
                            <td colspan="2">
                                <div class="help-message">${explanation}</div>
                            </td>
                            <td></td>
                            <td></td>
                        </tr>
                        </c:if>
                    </table>
                </c:forEach>
                </div><!-- class="span16" -->
            </div><!-- class="row" -->
        </div><!-- class="container" -->
        <%@include file="template/footer.jsp" %>
        <script type="text/javascript" src="${jqueryUrl}"></script>
        <!--[if lte IE 8]>
        <script type="text/javascript" src="${r2d3JsUrl}"></script>
        <script type="text/javascript" src="${scoreIEJsUrl}"></script>
        <script type="text/javascript" src="${homeScoreIEJsUrl}"></script>
        <![endif]-->
        <!--[if gt IE 8]>
        <script type="text/javascript" src="${d3JsUrl}"></script>
        <script type="text/javascript" src="${scoreJsUrl}"></script>
        <script type="text/javascript" src="${homeScoreJsUrl}"></script>
        <![endif]-->
        <!--[if !IE]><!-->
        <script type="text/javascript" src="${d3JsUrl}"></script>
        <script type="text/javascript" src="${scoreJsUrl}"></script>
        <script type="text/javascript" src="${homeScoreJsUrl}"></script>
        <!--<![endif]-->
    </body>
</html>
</compress:html>