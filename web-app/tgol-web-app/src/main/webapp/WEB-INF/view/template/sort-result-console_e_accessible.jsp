<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tagutils" prefix="tg" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="result-option-console" class="row option-console option-console-eaccessible">
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
                <p> You can filter the results depending on the levels of the <a href="http://references.modernisation.gouv.fr/e-accessible](http://references.modernisation.gouv.fr/e-accessible" target="blank" >e-accessible certification</a>.
                </p>
                <p>Reminder: In relations to the RGAA, Level 1 of the e-accessible certification is a <a href="http://references.modernisation.gouv.fr/e-accessible-50-criteres-du-niveau-1](http://references.modernisation.gouv.fr/e-accessible-50-criteres-du-niveau-1" target="blank" > selection of 50 criteria of the A level</a>. Level 2 is the equivalent of the level A. Level 3 corresponds to the validation of at least 50% of the applicable criteria of the AA level. Level 4 corresponds to the AA Level. To reach Level 5, it is necessary to have validated the Level 4 and at least one of the AAA Level criteria.
                </p>
            </div>




        </form:form>
    </div>
</div>



