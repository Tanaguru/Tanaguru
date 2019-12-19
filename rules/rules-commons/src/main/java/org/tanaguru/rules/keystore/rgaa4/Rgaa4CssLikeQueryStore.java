package org.tanaguru.rules.keystore.rgaa4;

import static org.tanaguru.rules.keystore.CssLikeQueryStore.IMAGE_LINK_CHILDREN_CSS_LIKE_QUERY;

public class Rgaa4CssLikeQueryStore {

    public static final String IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY =
            "img[aria-labelledby], " +
            "img[aria-label], " +
            "img[alt], " +
            "img[title]";

    public static final String ROLE_IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY =
            "[role=img][aria-labelledby], " +
            "[role=img][aria-label]";

    public static final String AREA_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY =
            "area[aria-label], " +
            "area[alt]";

    public static final String INPUT_IMAGE_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY =
            "input[type=image][aria-labelledby], " +
            "input[type=image][aria-label], " +
            "input[type=image][alt], " +
            "input[type=image][title]";

    public static final String OBJECT_IMAGE_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY =
            "object[type=image][aria-labelledby], " +
            "object[type=image][aria-label], " +
            "object[type=image][title]";

    public static final String SVG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY =
            "svg[aria-labelledby], " +
            "svg[aria-label]";

    public static final String CANVAS_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY =
            "canvas[aria-labelledby], " +
            "canvas[aria-label]";

    public static final String EMBED_IMAGE_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY =
            "embed[type=image][aria-labelledby]," +
            "embed[type=image][aria-label]," +
            "embed[type=image][title]";

    public static final String GRAPHIC_ELEMENT_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY =
            IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY + ", " +
            ROLE_IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY + ", " +
            AREA_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY + ", " +
            INPUT_IMAGE_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY + ", " +
            OBJECT_IMAGE_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY + ", " +
            SVG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY + ", " +
            CANVAS_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY + ", " +
            EMBED_IMAGE_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY;

    public static final String IMAGE_LINK_CHILDREN_RGAA4_CSS_LIKE_QUERY =
            IMAGE_LINK_CHILDREN_CSS_LIKE_QUERY + ", [role=img]";

    public static final String TEXT_LINK_RGAA4_CSS_LIKE_QUERY
            = "a[href]:not(:has(img, [role=img], object, canvas, svg))";
    public static final String LINK_RGAA4_CSS_LIKE_QUERY
            = TEXT_LINK_RGAA4_CSS_LIKE_QUERY +
            ", [role=link], svg > a[xlink:href]";

    public static final String LINK_WITH_CHILDREN_RGAA4_CSS_LIKE_QUERY
            = "a[href]:has(*), [role=link]:has(*)";

    public static final String FORM_ELEMENT_RGAA4_CSS_LIKE_QUERY
            = "input[type=text], "
            + "input[type=password], "
            + "input[type=checkbox], "
            + "input[type=radio], "
            + "input[type=file], "
            + "input[type=search], "
            + "input[type=tel], "
            + "input[type=email], "
            + "input[type=number], "
            + "input[type=url], "
            + "input[type=date], "
            + "input[type=datetime-local], "
            + "input[type=range], "
            + "input[type=color], "
            + "input[type=time], "
            + "input[type=month], "
            + "input[type=week], "
            + "textarea, "
            + "select, "
            + "[role=progressbar], "
            + "[role=slider], "
            + "[role=spinbutton], "
            + "[role=textbox], "
            + "[role=listbox], "
            + "[role=searchbox], "
            + "[role=combobox], "
            + "[role=checkbox], "
            + "[role=radio], "
            + "[role=switch]";

    public static final String LABEL_WITHIN_FORM_RGAA4_CSS_LIKE_QUERY
            = "form:has(" + FORM_ELEMENT_RGAA4_CSS_LIKE_QUERY + ") label";

    public static final String INPUT_ELEMENT_WITH_TITLE_RGAA4_CSS_LIKE_QUERY
            = "input[type=text][title], "
            + "input[type=password][title], "
            + "input[type=checkbox][title], "
            + "input[type=radio][title], "
            + "input[type=file][title], "
            + "input[type=search][title], "
            + "input[type=tel][title], "
            + "input[type=email][title], "
            + "input[type=number][title], "
            + "input[type=url][title], "
            + "input[type=date][title], "
            + "input[type=datetime-local][title], "
            + "input[type=range][title], "
            + "input[type=color][title], "
            + "input[type=time][title], "
            + "input[type=month][title], "
            + "input[type=week][title], "
            + "textarea[title], "
            + "select[title], "
            + "[role=progressbar][title], "
            + "[role=slider][title], "
            + "[role=spinbutton][title], "
            + "[role=textbox][title], "
            + "[role=listbox][title], "
            + "[role=searchbox][title], "
            + "[role=combobox][title], "
            + "[role=checkbox][title], "
            + "[role=radio][title], "
            + "[role=switch][title]";

    public static final String INPUT_ELEMENT_WITH_ARIA_LABEL_RGAA4_CSS_LIKE_QUERY
            = "input[type=text][aria-label], "
            + "input[type=password][aria-label], "
            + "input[type=checkbox][aria-label], "
            + "input[type=radio][aria-label], "
            + "input[type=file][aria-label], "
            + "input[type=search][aria-label], "
            + "input[type=tel][aria-label], "
            + "input[type=email][aria-label], "
            + "input[type=number][aria-label], "
            + "input[type=url][aria-label], "
            + "input[type=date][aria-label], "
            + "input[type=datetime-local][aria-label], "
            + "input[type=range][aria-label], "
            + "input[type=color][aria-label], "
            + "input[type=time][aria-label], "
            + "input[type=month][aria-label], "
            + "input[type=week][aria-label], "
            + "textarea[aria-label], "
            + "select[aria-label], "
            + "[role=progressbar][aria-label], "
            + "[role=slider][aria-label], "
            + "[role=spinbutton][aria-label], "
            + "[role=textbox][aria-label], "
            + "[role=listbox][aria-label], "
            + "[role=searchbox][aria-label], "
            + "[role=combobox][aria-label], "
            + "[role=checkbox][aria-label], "
            + "[role=radio][aria-label], "
            + "[role=switch][aria-label]";

    public static final String INPUT_ELEMENT_WITH_ARIA_LABELLEDBY_RGAA4_CSS_LIKE_QUERY
            = "input[type=text][aria-labelledby], "
            + "input[type=password][aria-labelledby], "
            + "input[type=checkbox][aria-labelledby], "
            + "input[type=radio][aria-labelledby], "
            + "input[type=file][aria-labelledby], "
            + "input[type=search][aria-labelledby], "
            + "input[type=tel][aria-labelledby], "
            + "input[type=email][aria-labelledby], "
            + "input[type=number][aria-labelledby], "
            + "input[type=url][aria-labelledby], "
            + "input[type=date][aria-labelledby], "
            + "input[type=datetime-local][aria-labelledby], "
            + "input[type=range][aria-labelledby], "
            + "input[type=color][aria-labelledby], "
            + "input[type=time][aria-labelledby], "
            + "input[type=month][aria-labelledby], "
            + "input[type=week][aria-labelledby], "
            + "textarea[aria-labelledby], "
            + "select[aria-labelledby], "
            + "[role=progressbar][aria-labelledby], "
            + "[role=slider][aria-labelledby], "
            + "[role=spinbutton][aria-labelledby], "
            + "[role=textbox][aria-labelledby], "
            + "[role=listbox][aria-labelledby], "
            + "[role=searchbox][aria-labelledby], "
            + "[role=combobox][aria-labelledby], "
            + "[role=checkbox][aria-labelledby], "
            + "[role=radio][aria-labelledby], "
            + "[role=switch][aria-labelledby]";

    public static final String INPUT_ELEMENT_WITH_ID_RGAA4_CSS_LIKE_QUERY
            = "input[type=text][id], "
            + "input[type=password][id], "
            + "input[type=checkbox][id], "
            + "input[type=radio][id], "
            + "input[type=file][id], "
            + "input[type=search][id], "
            + "input[type=tel][id], "
            + "input[type=email][id], "
            + "input[type=number][id], "
            + "input[type=url][id], "
            + "input[type=date][id], "
            + "input[type=datetime-local][id], "
            + "input[type=range][id], "
            + "input[type=color][id], "
            + "input[type=time][id], "
            + "input[type=month][id], "
            + "input[type=week][id], "
            + "textarea[id], "
            + "select[id], "
            + "[role=progressbar][id], "
            + "[role=slider][id], "
            + "[role=spinbutton][id], "
            + "[role=textbox][id], "
            + "[role=listbox][id], "
            + "[role=searchbox][id], "
            + "[role=combobox][id], "
            + "[role=checkbox][id], "
            + "[role=radio][id], "
            + "[role=switch][id]";


}
