<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
                                                   
<%@page import="org.springframework.web.context.request.RequestContextHolder" %>
<%@page import="org.springframework.web.context.request.ServletRequestAttributes" %>
<%@page import="java.util.Collection" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>

            <c:set var="tgLogoUrl">
                <c:url value="/Images/Logo-Tanaguru.com-75dpi-210x95-transp.png"/>  
            </c:set>

            <c:set var="properQueryString" scope="page" value="${fn:replace(pageContext.request.queryString, '&', '&amp;')}"/>
            <c:choose>
                <c:when test="${not empty pageContext.request.queryString}">
                    <c:choose>
                        <c:when test="${fn:contains(pageContext.request.queryString, 'lang=en')}">
                            <c:set var="enUrl" scope="request" value="?${properQueryString}"/>
                            <c:set var="frUrl" scope="request" value="?${fn:replace(properQueryString, 
                                'lang=en', 'lang=fr')}" />
                        </c:when>
                        <c:when test="${fn:contains(pageContext.request.queryString, 'lang=fr')}">
                            <c:set var="frUrl" scope="request" value="?${properQueryString}"/>
                            <c:set var="enUrl" scope="request" value="?${fn:replace(properQueryString, 
                                'lang=fr', 'lang=en')}" />
                        </c:when>
                        <c:otherwise>
                            <c:set var="frUrl" scope="request" value="?${properQueryString}&amp;lang=fr"/>
                            <c:set var="enUrl" scope="request" value="?${properQueryString}&amp;lang=en"/>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <c:set var="frUrl" scope="request" value="?lang=fr"/>
                    <c:set var="enUrl" scope="request" value="?lang=en"/>
                </c:otherwise>
            </c:choose>
            <div id="lang-switcher">
                <a href="${enUrl}" title="Switch to english" lang="en">
                    <abbr title="English">EN</abbr>
                </a>
                <a href="${frUrl}" title="Passer en français" lang="fr">
                    <abbr title="Français">FR</abbr>
                </a>
            </div>
