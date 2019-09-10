<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter" %>                                 

<c:choose>
    <c:when test="${inline == 'true'}">
        <c:set var="formClass" value="inline" scope="page"/>
        <c:set var="inputSize" value="input-medium" scope="page"/>
    </c:when>
    <c:otherwise>
        <c:set var="formClass" value="form-stacked" scope="page"/>
        <c:set var="inputSize" value="input-xlarge" scope="page"/>
    </c:otherwise>
</c:choose>
<div id="login-form" class="row">
    <form method="post" 
          action="<c:url value="/perform_login"/>"
          class="${formClass}">
<c:choose>
    <c:when test="${not empty param.email}">
        <c:set var="usernameValue" value="${param.email}"/>  
    </c:when>
    <c:otherwise>
        <c:set var="usernameValue" value=""/>  
    </c:otherwise>
</c:choose>
<c:choose>
    <c:when test="${inline == 'true'}">
        <input type="text" 
               class="${inputSize}" 
               title="<fmt:message key="login.id"/>" 
               placeholder="<fmt:message key="login.id"/>" 
               name="username"
               id="j_username" 
               <c:if test="${not empty usernameValue}"> value="${usernameValue}"</c:if> />
        <div class="inline-password">
            <input type="password" 
                   name="password"
                   title="<fmt:message key="login.password"/>" 
                   placeholder="<fmt:message key="login.password"/>" 
                   id="j_password" 
                   class="${inputSize}"
                   autocomplete="off" />
            <span class="help">
                <a id="lost-password" 
                   href="<c:url value="/forgotten-password.html"/>"> 
                    <fmt:message key="login.passwordForgotten"/>
                </a>
            </span>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input class="btn" 
               type="submit" 
               name="Login" 
               value="<fmt:message key="login.submit"/>"/>
    </c:when>
    <c:otherwise>
        <label for="j_username">
            <fmt:message key="login.id"/>
        </label>
        <input type="text" 
               class="${inputSize}" 
               name="username"
               id="j_username" 
               <c:if test="${not empty usernameValue}"> value="${usernameValue}"</c:if> />
        <label for="j_password">
            <fmt:message key="login.password"/>
        </label>
        <input type="password" 
               name="password"
               id="j_password" 
               class="${inputSize}" 
               autocomplete="off" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <c:if test="${configProperties['enable-account-settings'] == 'true'}">
        <span class="help-block">
            <a href="<c:url value="/forgotten-password.html"/>">
                <fmt:message key="login.passwordForgotten"/>
            </a>
        </span>
        <input class="btn" 
               type="submit" 
               name="Login" 
               value="<fmt:message key="login.submit"/>"/>
        </c:if>
    </c:otherwise>
</c:choose>
    </form>
</div><!-- id="login-form" -->