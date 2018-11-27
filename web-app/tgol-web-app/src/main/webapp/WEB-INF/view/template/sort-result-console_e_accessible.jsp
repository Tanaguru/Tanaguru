<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tagutils" prefix="tg" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="result-option-console-eaccessible" class="row option-console option-console-eaccessible">
    <div class="span16">
        <h2 id="result-option-console-title" class="option-console-title">
            <fmt:message key="resultPage.eaccessibletitle"/>
        </h2>
    </div>
    <div class="span16">
        <form:form  method="post" acceptCharset="UTF-8" enctype="application/x-www-form-urlencoded" class="form-stacked">
            <fieldset>
                <legend><fmt:message key="resultPage.eaccessibleviewby"/></legend>
                <div class="clearfix ">
                    <label class="radiobutton" for="lvl1">
                        <input class="inputs-list" type="radio" id="lvl1" name="eaccess_lvl"  />
                        <fmt:message key="resultPage.eaccessiblelevel1" />
                    </label>

                    <label class="radiobutton" for="lvl2">
                        <input class="inputs-list" type="radio" id="lvl2" name="eaccess_lvl" />
                        <fmt:message key="resultPage.eaccessiblelevel2" />
                    </label>

                    <label class="radiobutton" for="lvl3">
                        <input class="inputs-list" type="radio" id="lvl3" name="eaccess_lvl" />
                        <fmt:message key="resultPage.eaccessiblelevel3" />
                    </label>
                    <label class="radiobutton" for="lvl5">
                        <input class="inputs-list" type="radio" id="lvl5" name="eaccess_lvl" />
                        <fmt:message key="resultPage.eaccessiblelevel5" />
                    </label>
                </div>
                <div  class="actions option-console-update reset">
                    <input type="submit" class="update-action" value="<fmt:message key="resultPage.eaccessiblereset"/>"/>
                </div> 
            </fieldset>
            <div class="clearfix eaccessible-desc ">
                <p> <fmt:message key="resultPage.eaccessibleDesc1"/>
                </p>
                <p><fmt:message key="resultPage.eaccessibleDesc2"/>
                </p>
            </div>
        </form:form>
    </div>
</div>



