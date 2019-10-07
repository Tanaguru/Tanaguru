/*
 *  Tanaguru - Automated webpage assessment
 *  Copyright (C) 2008-2015  Tanaguru.org
 * 
 *  This file is part of Tanaguru.
 * 
 *  Tanaguru is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * 
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.rules.keystore;

/**
 * Utility class that stores css-like queries as static String
 */
public final class CssLikeQueryStore {

    // Image theme css-like queries
	public static final String ROLE_IMG_LIKE_QUERY = "[role=img]";
    public static final String IMG_WITHOUT_ALT_CSS_LIKE_QUERY = "img:not([alt])";
    public static final String IMG_WITH_ALT_CSS_LIKE_QUERY = "img[alt]";
    public static final String IMG_WITH_ALT_NOT_IN_LINK_CSS_LIKE_QUERY
            = "img[alt]:not(a img)";
    public static final String IMG_WITH_ALT_NOT_IN_LINK_WITHOUT_LONGDESC_CSS_LIKE_QUERY
            = "img[alt]:not(a img):not([longdesc])";
    public static final String IMG_NOT_IN_LINK_CSS_LIKE_QUERY = "img:not(a img)";
    public static final String IMG_ROLE_CSS_LIKE_QUERY = "[role=img]";
    public static final String IMG_WITH_ISMAP_ATTR_CSS_LIKE_QUERY
            = "img[ismap] , "
            + "input[type=image][ismap]";
    public static final String IMG_WITH_ALT_WITHOUT_LONGDESC_CSS_LIKE_QUERY
            = "img[alt]:not([longdesc])";
    public static final String APPLET_WITH_ALT_CSS_LIKE_QUERY
            = "applet[alt]";
    public static final String APPLET_WITH_ALT_NOT_IN_LINK_CSS_LIKE_QUERY
            = "applet[alt]:not(a applet)";
    public static final String APPLET_NOT_IN_LINK_CSS_LIKE_QUERY
            = "applet:not(a applet)";
    public static final String OBJECT_TYPE_IMG_CSS_LIKE_QUERY
            = "object[type^=image]";
    public static final String OBJECT_TYPE_IMG_WITH_TITLE_CSS_LIKE_QUERY
		    = "object[type^=image][title][aria-label] ,"
		    		+ "object[type^=image][title][aria-labelledby]"; 
    public static final String OBJECT_TYPE_IMG_NOT_IN_LINK_CSS_LIKE_QUERY
            = "object[type^=image]:not(a object)";
    public static final String EMBED_TYPE_IMG_CSS_LIKE_QUERY
            = "embed[type^=image]";
    public static final String EMBED_TYPE_IMG_WITH_TITLE_CSS_LIKE_QUERY 
		    = "embed[type^=image][title][aria-label] ,"+
		    		"embed[type^=image][title][aria-labelledby]";
    public static final String EMBED_TYPE_IMG_NOT_IN_LINK_CSS_LIKE_QUERY
            = "embed[type^=image]:not(a embed)";
    public static final String CANVAS_TYPE_IMG_WITH_TITLE_CSS_LIKE_QUERY 
		    = "canvas[title][aria-label] ,"+
		    		"canvas[title][aria-labelledby]";
    public static final String AREA_WITH_ALT_CSS_LIKE_QUERY
            = "area[alt]";
    public static final String AREA_WITH_ALT_NOT_IN_LINK_CSS_LIKE_QUERY
            = "area[alt]:not(a area)";
    public static final String AREA_NOT_IN_LINK_CSS_LIKE_QUERY
            = "area:not(a area)";
    public static final String AREA_WITH_ALT_WITHOUT_HREF_ATTR_CSS_LIKE_QUERY
            = "area[alt]:not([href])";
    public static final String FORM_BUTTON_CSS_LIKE_QUERY = "input[type=image]";
    public static final String FORM_BUTTON_WITH_ALT_CSS_LIKE_QUERY
            = "input[type=image][alt]";
    public static final String MAP_WITH_AREA_CHILD_AND_NAME_ATTR_CSS_LIKE_QUERY
            = "map:has(area)[name]:not([name~=^\\s*$])";
    public static final String NOT_EMPTY_ALT_ATTR_NOT_IN_LINK_CSS_LIKE_QUERY
            = "[alt]:not([alt~=^\\s*$]):not(a [alt])";
    public static final String ALL_IMG_TAGS_CSS_LIKE_QUERY
            = "img ,"
            + "canvas ,"
            + "area ,"
            + "svg ,"
            + OBJECT_TYPE_IMG_CSS_LIKE_QUERY + "," + EMBED_TYPE_IMG_CSS_LIKE_QUERY;

    //aria
    public static final String ARIA_ATTRIBUTES_CSS_LIKE_QUERY = "[^aria]";
    public static final String ARIA_DESCRIBEDBY_CSS_LIKE_QUERY = "[aria-describedby]";
    public static final String ARIA_LABEL_CSS_LIKE_QUERY = "[aria-label]";
    public static final String ARIA_LABELLEDBY_CSS_LIKE_QUERY = "[aria-labelledby]";

    //svg children
    public static final String NOT_EMPTY_ARIA_TITLE_CSS_LIKE_QUERY
            = "title:not(:matchesOwn(^\\s*$))";
    public static final String NOT_EMPTY_ARIA_DESC_CSS_LIKE_QUERY
            = "desc:not(:matchesOwn(^\\s*$))";
    public static final String SVG_NOT_IN_LINK_CSS_LIKE_QUERY
            = "svg:not(a svg)";
    public static final String SVG_NOT_IN_LINK_WITH_DESC_CHILD_CSS_LIKE_QUERY
            = "svg:not(a svg):has(desc:not(:matchesOwn(^\\s*$))";
    public static final String SVG_NOT_IN_LINK_WITH_ARIA_LABEL_CSS_LIKE_QUERY
            = "svg[aria-label]:not([aria-label~=^\\s*$]:not(a svg)";
    public static final String SVG_NOT_IN_LINK_WITH_DESC_CHILD_AND_ROLE_IMG_CSS_LIKE_QUERY
            = "svg[role=img]:not(a svg):has(desc:not(:matchesOwn(^\\s*$))";
    public static final String SVG_NOT_IN_LINK_WITH_ARIA_LABEL_AND_ROLE_IMG_CSS_LIKE_QUERY
            = "svg[role=img][aria-label]:not([aria-label~=^\\s*$]:not(a svg)";
    public static final String CANVAS_CSS_LIKE_QUERY
    		= "canvas:not(:matchesOwn(^\\\\s*$))";
    public static final String CANVAS_NOT_IN_LINK_CSS_LIKE_QUERY
            = "canvas:not(a canvas)";
    public static final String CANVAS_NOT_IN_LINK_WITH_NOT_EMPTY_CONTENT_CSS_LIKE_QUERY
            = "canvas:not(a canvas):not(:matchesOwn(^\\s*$))";

    // Table theme css-like queries
    public static final String TABLE_WITH_SUMMARY_CSS_LIKE_QUERY = "table[summary]";
    public static final String TABLE_WITH_CAPTION_CSS_LIKE_QUERY = "table:has(caption)";
    public static final String TABLE_WITH_TH_CSS_LIKE_QUERY = "table:has(th)";
    public static final String TABLE_WITH_TH_OR_TD_CSS_LIKE_QUERY
            = "table:has(th), table:has(td)";
    public static final String DATA_TABLE_MARKUP_CSS_LIKE_QUERY
            = "caption , "
            + "th , "
            + "thead , "
            + "tfoot , "
            + "colgroup , "
            + "td[scope] , "
            + "td[headers] , "
            + "td[axis]";
    public static final String DATA_TABLE_MARKUP_CSS_LIKE_QUERY2
		    = "caption , "
		    + "th , "
		    + "thead , "
		    + "tfoot , "
		    + "colgroup , "
		    + "[role=rowheader] , "
		    + "[role=columnheader] , "
		    + "td[scope] , "
		    + "td[headers] , "
		    + "td[axis]";
    public static final String DATA_TABLE_CSS_LIKE_QUERY
    		= "table , "
    		+ "[role=table]";
    public static final String DATA_TABLE_WITH_TITLE_CSS_LIKE_QUERY
			= "table:has(caption) , "
			+"table[aria-labelledby] , "
			+"table[aria-label] , "
			+"table[title] , "
			+"[role=table][aria-labelledby] , "
			+"[role=table][aria-label] ,"
			+"[role=table][title]";

    // Frame theme css-like queries
    public static final String FRAME_WITH_TITLE_CSS_LIKE_QUERY = "frame[title]";
    public static final String IFRAME_WITH_TITLE_CSS_LIKE_QUERY = "iframe[title]";
    public static final String IFRAME_WITH_NOT_EMPTY_TITLE_CSS_LIKE_QUERY
            = "iframe[title]:not([title~=^\\s*$])";
    public static final String FRAME_WITH_NOT_EMPTY_TITLE_CSS_LIKE_QUERY
            = "frame[title]:not([title~=^\\s*$])";

    // multimedia
    public static final String AUDIO_FILE_EXTENSION
            = "WAV|CDA|MID|MP2|MP3|mp3PRO|MOD|RM|RAM|WMA|Ogg|oga|AIF|AIFF|AA|AAC|M4A|VQF|AU|M3U|RIFF|BWF|CAF|PCM|RAW|FLAC|ALAC|AC3|ACC";
    public static final String VIDEO_FILE_EXTENSION
            = "MP4|avi|wmv|mov|Xvid|mkv|mka|mks|FLV|rmvb|MPA|WMA|MP2|M2P|DIF|DV|VOB|VRO|rmvb|vivo|bik|ASF|ifo|mts|mxf|nds|rv|web|wlmp|wmp|ogv";
    public static final String MEDIA_AUDIO_CSS_LIKE_QUERY
            = "audio ,"
            + "video[src~=(?i)\\.(" + AUDIO_FILE_EXTENSION + ")] ,"
            + "video:has(source[src~=(?i)\\.(" + AUDIO_FILE_EXTENSION + ")]) ,"
            + "embed[src~=(?i)\\.(" + AUDIO_FILE_EXTENSION + ")] ,"
            + "object[data~=(?i)\\.(" + AUDIO_FILE_EXTENSION + ")]";
    public static final String MEDIA_VIDEO_TRANS_CSS_LIKE_QUERY = "video";
    // video:has(track), 
    public static final String MEDIA_ONLY_VIDEO_TRANS_CSS_LIKE_QUERY = "video:has(track)";
    //public static final String MEDIA_ONLY_VIDEO_TRANS_CSS_LIKE_QUERY="track[kind=captions]";
    public static final String MEDIA_VIDEO_CSS_LIKE_QUERY
            //            = "video:not([src~=(?i)\\.(" + AUDIO_FILE_EXTENSION + ")]) ,"
            //            + "video:has(source[src]:not([src~=(?i)\\.(" + AUDIO_FILE_EXTENSION + ")])) ,"
            = "video[src~=(?i)\\.(" + VIDEO_FILE_EXTENSION + ")] ,"
            + "video:has(source[src~=(?i)\\.(" + VIDEO_FILE_EXTENSION + ")]) ,"
            + "svg ,"
            + "svg ,"
            + "canvas ,"
            + "object[data~=(?i)\\.(" + VIDEO_FILE_EXTENSION + ")] ,"
            + "embed[src~=(?i)\\.(" + VIDEO_FILE_EXTENSION + ")] ";

    //Text
    public static final String TEXTUAL_NODE_CSS_LIKE_QUERY = "p[dir],H1[dir],H2[dir],H3[dir],H4[dir],H5[dir],H6[dir],a[dir]";
    // Document Structure

    public static String DOC_STR_CSS_LIKE_QUERY = "main ,nav[role=navigation]";

    public static final String MEDIA_TMP_CSS_LIKE_QUERY
            = MEDIA_AUDIO_CSS_LIKE_QUERY + "," + MEDIA_VIDEO_CSS_LIKE_QUERY;

    // Form theme css-like queries
    public static final String FORM_WITHOUT_FIELDSET_CSS_LIKE_QUERY
            = "form:not(:has(fieldset))";
    public static final String FORM_TITLE_CSS_LIKE_QUERY
    		= "textarea[title], "
    	    + "select[title], "
            + "datalist[title], "
            + "keygen[title], "
            + "input[type=password][title] , "
            + "input[type=checkbox][title] , "
            + "input[type=file][title] , "
            + "input[type=text][title] , "
            + "input[type=search][title] , "
            + "input[type=tel][title] , "
            + "input[type=email][title] , "
            + "input[type=number][title] , "
            + "input[type=url][title] , "
            + "input[type=date][title] , "
            + "input[type=range][title] , "
            + "input[type=color][title] , "
            + "input[type=time][title] , "
            + "input[type=radio][title]";
    public static final String FORM_ARIA_CSS_LIKE_QUERY
    		= "textarea[aria-label], "
            + "textarea[aria-labelledby], "
            + "select[aria-label], "
            + "select[aria-labelledby], "
            + "datalist[aria-label], "
            + "datalist[aria-labelledby], "
            + "keygen[aria-label], "
            + "keygen[aria-labelledby], "
            + "input[aria-label]:not([type=submit]):not([type=reset]):not([type=image]):not([type=button]),:not([type=hidden]),"
            + "input[aria-labelledby]:not([type=submit]):not([type=reset]):not([type=image]):not([type=button]),:not([type=hidden])";
    public static final String FORM_ARIA_LABEL_CSS_LIKE_QUERY
			= "textarea[aria-label], "
		    + "select[aria-label], "
		    + "datalist[aria-label], "
		    + "keygen[aria-label], "
            + "input[type=password][aria-label] , "
            + "input[type=checkbox][aria-label] , "
            + "input[type=file][aria-label] , "
            + "input[type=text][aria-label] , "
            + "input[type=search][aria-label] , "
            + "input[type=tel][aria-label] , "
            + "input[type=email][aria-label] , "
            + "input[type=number][aria-label] , "
            + "input[type=url][aria-label] , "
            + "input[type=date][aria-label], "
            + "input[type=range][aria-label] , "
            + "input[type=color][aria-label] , "
            + "input[type=time][aria-label] , "
            + "input[type=radio][aria-label]";
    public static final String FORM_ARIA_LABELLEDBY_CSS_LIKE_QUERY
			= "textarea[aria-labelledby], "
		    + "select[aria-labelledby], "
		    + "datalist[aria-labelledby], "
		    + "keygen[aria-labelledby], "
            + "input[type=password][aria-labelledby] , "
            + "input[type=checkbox][aria-labelledby] , "
            + "input[type=file][aria-labelledby] , "
            + "input[type=text][aria-labelledby] , "
            + "input[type=search][aria-labelledby] , "
            + "input[type=tel][aria-labelledby] , "
            + "input[type=email][aria-labelledby] , "
            + "input[type=number][aria-labelledby] , "
            + "input[type=url][aria-labelledby] , "
            + "input[type=date][aria-labelledby] , "
            + "input[type=range][aria-labelledby] , "
            + "input[type=color][aria-labelledby] , "
            + "input[type=time][aria-labelledby] , "
            + "input[type=radio][aria-labelledby]";
    public static final String FORM_ELEMENT_CSS_LIKE_QUERY
            = "textarea , "
            + "select , "
            + "datalist , "
            + "keygen , "
            + "input[type=password] , "
            + "input[type=checkbox] , "
            + "input[type=file] , "
            + "input[type=text] , "
            + "input[type=search] , "
            + "input[type=tel] , "
            + "input[type=email] , "
            + "input[type=number] , "
            + "input[type=url] , "
            + "input[type=date] , "
            + "input[type=range] , "
            + "input[type=color] , "
            + "input[type=time] , "
            + "input[type=radio]";
    public static final String LABEL_ELEMENT_CSS_LIKE_QUERY 
    		= "input:not([type=image]):not([type=button]):not([type=hidden]):not([type=submit]):not([type=reset]):not([role]), "
    		+ "select:not([role]), "
    		+ "textarea:not([role]), "
            + "input[type=password] , "
            + "input[type=checkbox] , "
            + "input[type=file] , "
            + "input[type=text] , "
            + "input[type=search] , "
            + "input[type=tel] , "
            + "input[type=email] , "
            + "input[type=number] , "
            + "input[type=url] , "
            + "input[type=checkbox] , "
            + "input[type=radio], "
            + "input[type=date] , "
            + "input[type=range] , "
            + "input[type=color] , "
            + "input[type=time] ";
    
    
    public static final String INPUT_ELEMENT_CSS_LIKE_QUERY
    		= "input[type=checkbox] , "
    		+ "input[type=radio] , "
    		+ "input[type=date] , "
    		+ "input[type=range] , "
    		+ "input[type=color] , "
    		+ "input[type=time] , "
    		+ "input[type=file] , "
    		+ "input[type=password] , "
            + "input[type=text] , "
            + "input[type=search] , "
            + "input[type=tel] , "
            + "input[type=email] , "
            + "input[type=number] , "
            + "input[type=url] , "
    		+ "textarea , "
    		+ "select , "
    		+ "datalist , "
    		+ "optgroup , "
    		+ "option , "
    		+ "keygen , "
    		+ "output , "
    		+ "progress , "
    		+ "meter";
    public static final String INPUT_ELEMENT_INSIDE_FORM_CSS_LIKE_QUERY
            = "form textarea:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form select:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form datalist:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form keygen:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=password]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=checkbox]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=file]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=text]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=search]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=tel]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=email]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=number]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=url]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=date]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=range]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=color]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=time]:not([title]):not([aria-label]):not([aria-labelledby]) , "
            + "form input[type=radio]:not([title]):not([aria-label]):not([aria-labelledby])";
    public static final String INPUT_ELEMENT_WITH_ARIA_INSIDE_FORM_CSS_LIKE_QUERY
            = "form textarea[aria-labelledby] , "
            + "form select[aria-labelledby] , "
            + "form datalist[aria-labelledby] , "
            + "form keygen[aria-labelledby] , "
            + "form input[type=password][aria-labelledby] , "
            + "form input[type=checkbox][aria-labelledby] , "
            + "form input[type=file][aria-labelledby] , "
            + "form input[type=text][aria-labelledby] , "
            + "form input[type=search][aria-labelledby] , "
            + "form input[type=tel][aria-labelledby] , "
            + "form input[type=email][aria-labelledby] , "
            + "form input[type=number][aria-labelledby] , "
            + "form input[type=url][aria-labelledby] , "
            + "form input[type=date][aria-labelledby] , "
            + "form input[type=range][aria-labelledby] , "
            + "form input[type=color][aria-labelledby] , "
            + "form input[type=time][aria-labelledby] , "
            + "form input[type=radio][aria-labelledby]";
   public static final String INPUT_ELEMENT_REQUIRED_INSIDE_FORM_CSS_LIKE_QUERY
            = "form textarea[aria-label] , "
            + "form select[aria-label] , "
            + "form datalist[aria-label] , "
            + "form keygen[aria-label] , "
            + "form input[type=password][aria-label] , "
            + "form input[type=checkbox][aria-label] , "
            + "form input[type=file][aria-label] , "
            + "form input[type=text][aria-label] , "
            + "form input[type=search][aria-label] , "
            + "form input[type=tel][aria-label] , "
            + "form input[type=email][aria-label] , "
            + "form input[type=number][aria-label] , "
            + "form input[type=url][aria-label] , "
            + "form input[type=date][aria-label] , "
            + "form input[type=range][aria-label] , "
            + "form input[type=color][aria-label] , "
            + "form input[type=time][aria-label] , "
            + "form input[type=radio][aria-label] ,"
	    + "form textarea[aria-required] , "
            + "form select[aria-required] , "
            + "form datalist[aria-required] , "
            + "form keygen[aria-required] , "
            + "form input[type=password][aria-required] , "
            + "form input[type=checkbox][aria-required] , "
            + "form input[type=file][aria-required] , "
            + "form input[type=text][aria-required] , "
            + "form input[type=search][aria-required] , "
            + "form input[type=tel][aria-required] , "
            + "form input[type=email][aria-required] , "
            + "form input[type=number][aria-required] , "
            + "form input[type=url][aria-required] , "
            + "form input[type=date][aria-required] , "
            + "form input[type=range][aria-required] , "
            + "form input[type=color][aria-required] , "
            + "form input[type=time][aria-required] , "
            + "form input[type=radio][aria-required] ,"
	    + "form textarea[required] , "
            + "form select[required] , "
            + "form datalist[required] , "
            + "form keygen[required] , "
            + "form input[type=password][required] , "
            + "form input[type=checkbox][required] , "
            + "form input[type=file][required] , "
            + "form input[type=text][required] , "
            + "form input[type=search][required] , "
            + "form input[type=tel][required] , "
            + "form input[type=email][required] , "
            + "form input[type=number][required] , "
            + "form input[type=url][required] , "
            + "form input[type=date][required] , "
            + "form input[type=range][required] , "
            + "form input[type=color][required] , "
            + "form input[type=time][required] , "
            + "form input[type=radio][required]";
    public static final String INPUT_ELEMENT_WITH_ARIA_LABEL_INSIDE_FORM_CSS_LIKE_QUERY
            = "form textarea[aria-label] , "
            + "form select[aria-label] , "
            + "form datalist[aria-label] , "
            + "form keygen[aria-label] , "
            + "form input[type=password][aria-label] , "
            + "form input[type=checkbox][aria-label] , "
            + "form input[type=file][aria-label] , "
            + "form input[type=text][aria-label] , "
            + "form input[type=search][aria-label] , "
            + "form input[type=tel][aria-label] , "
            + "form input[type=email][aria-label] , "
            + "form input[type=number][aria-label] , "
            + "form input[type=url][aria-label] , "
            + "form input[type=date][aria-label] , "
            + "form input[type=range][aria-label] , "
            + "form input[type=color][aria-label] , "
            + "form input[type=time][aria-label] , "
            + "form input[type=radio][aria-label]";
    public static final String FORM_ELEMENT_WITH_ID_CSS_LIKE_QUERY
            = "textarea[id] , "
            + "select[id] , "
            + "datalist[id] , "
            + "keygen[id] , "
            + "input[type=password][id] , "
            + "input[type=checkbox][id] , "
            + "input[type=file][id] , "
            + "input[type=text][id] , "
            + "input[type=search][id] , "
            + "input[type=tel][id] , "
            + "input[type=email][id] , "
            + "input[type=number][id] , "
            + "input[type=url][id] , "
            + "input[type=date][id] , "
            + "input[type=range][id] , "
            + "input[type=color][id] , "
            + "input[type=time][id] , "
            + "input[type=radio][id]";
    public static final String FORM_ELEMENT_WITH_TITLE_CSS_LIKE_QUERY
            = "textarea[title] , "
            + "select[title] , "
            + "datalist[title] , "
            + "keygen[title] , "
            + "input[type=password][title] , "
            + "input[type=checkbox][title] , "
            + "input[type=file][title] , "
            + "input[type=text][title] , "
            + "input[type=search][title] , "
            + "input[type=tel][title] , "
            + "input[type=email][title] , "
            + "input[type=number][title] , "
            + "input[type=url][title] , "
            + "input[type=date][title] , "
            + "input[type=range][title] , "
            + "input[type=color][title] , "
            + "input[type=time][title] , "
            + "input[type=radio][title]";
    public static final String FORM_TEXT_INPUT_CSS_LIKE_QUERY
            = "form:has(textarea) , "
            + "form:has(input[type=password]) , "
            + "form:has(input[type=text])";
    public static final String FORM_WITH_TITLE_ATTR_CSS_LIKE_QUERY
            = "select[title], "
            + "datalist[title], "
            + "keygen[title], "
            + "optgroup[title], "
            + "option[title], "
            + "input[title]:not([type=submit]):not([type=reset]):not([type=image]):not([type=button])";
    public static final String INPUT_NOT_INSIDE_FORM_CSS_LIKE_QUERY
            = "input:not(form input) ";
    public static final String LABEL_WITHIN_FORM_CSS_LIKE_QUERY
            = "form:has(" + FORM_ELEMENT_CSS_LIKE_QUERY + ") label";
    public static final String FORM_LABEL_WITH_INNER_FORM_ELEMENT_CSS_LIKE_QUERY
            = "form label:has(input[type=text]) , "
            + "form label:has(input[type=password]) , "
            + "form label:has(input[type=checkbox]) , "
            + "form label:has(input[type=radio]) , "
            + "form label:has(input[type=file]) , "
            + "form label:has(input[type=search]) , "
            + "form label:has(input[type=tel]) , "
            + "form label:has(input[type=email]) , "
            + "form label:has(input[type=number]) , "
            + "form label:has(input[type=url]) , "
            + "form label:has(input[type=date]) , "
            + "form label:has(input[type=range]) , "
            + "form label:has(input[type=color]) , "
            + "form label:has(input[type=time]) , "
            + "form label:has(textarea) , "
            + "form label:has(select) , "
            + "form label:has(datalist) , "
            + "form label:has(keygen)";
    public static final String LEGEND_WITHIN_FIELDSET_CSS_LIKE_QUERY
            = "fieldset legend";
    public static final String SELECT_WITHOUT_OPTGROUP_CSS_LIKE_QUERY
            = "select:not(:has(optgroup))";
    public static final String SELECT_WITHIN_FORM_CSS_LIKE_QUERY
            = "form select";
    public static final String OPTGROUP_WITH_LABEL_ATTR_CSS_LIKE_QUERY
            = "optgroup[label]";
    public static final String OPTGROUP_WITHIN_SELECT_WITH_LABEL_ATTR_CSS_LIKE_QUERY
            = "select optgroup[label]";
    public static final String OPTGROUP_WITHIN_SELECT_CSS_LIKE_QUERY
            = "select optgroup";
    public static final String BUTTON_FORM_CSS_LIKE_QUERY
            = "form input[type=submit] , "
            + "form input[type=reset] , "
            + "form input[type=button] , "
            + "form input[type=image] , "
            + "form button ";

    // Lang css-like queries
    public static final String ELEMENT_WITH_LANG_ATTR_CSS_LIKE_QUERY
            = "html [lang], html [xml:lang]";
    public static final String ELEMENT_WITHOUT_LANG_ATTR_CSS_LIKE_QUERY
            = "html *:not(:matchesOwn(^\\s*$)):not([lang]):not([xml:lang]), "
            + "html *[alt]:not([alt~=^\\s*$]):not([lang]):not([xml:lang]), "
            + "html *[title]:not([title~=^\\s*$]):not([lang]):not([xml:lang]), "
            + "html *[summary]:not([summary~=^\\s*$]):not([lang]):not([xml:lang])"
            + "html *[content]:not([content~=^\\s*$]):not([lang]):not([xml:lang])"
            + "hmtl *[value]:not([value~=^\\s*$]):not([lang]):not([xml:lang])";

    // Mandatory elements css-like queries
    public static final String TITLE_WITHIN_HEAD_CSS_LIKE_QUERY 
            = "head title" ;
    public static final String NO_TITLE_IN_HTML_PAGE 
    		= "head:not(title)"  + "body :not title";
    public static final String TITLE_CSS_LIKE_QUERY
    		= "title";
    
    public static final String HTML_WITH_LANG_CSS_LIKE_QUERY
            = "html[lang], html[xml:lang]";

    // Links css-like queries
    public static final String NOT_ANCHOR_LINK_CSS_LIKE_QUERY
            = "a:not([name]):not([id])";
    public static final String NOT_ANCHOR_LINK_WITH_HREF_CSS_LIKE_QUERY
    		= "a[href]:not([name]):not([id])";
    public static final String TEXT_LINK_CSS_LIKE_QUERY
            = "a[href]:not(:has(*))";
    public static final String LINK_WITH_CHILDREN_CSS_LIKE_QUERY
            = "a[href]:has(*)";
    public static final String LINK_WITH_HREF_CSS_LIKE_QUERY
            = "a[href]";
    public static final String IMAGE_LINK_CHILDREN_CSS_LIKE_QUERY
            = "img[alt] , object[type^=image], object[data^=data:image],"
            + "object[data$=png], object[data$=jpeg], object[data$=jpg],"
            + "object[data$=bmp], object[data$=gif], canvas";
    public static final String CLICKABLE_AREA_CSS_LIKE_QUERY = "area[href][alt]";
    public static final String LINK_WITHOUT_TARGET_CSS_LIKE_QUERY
            = "a:not([href]):not([name]):not([id])";
    public static final String FIELDSET_NOT_WITHIN_FORM_CSS_LIKE_QUERY
            = "fieldset:not(form fieldset):not(*[role=search] fieldset):not(*[role=form] fieldset)";
    public static final String LINK_WITH_TARGET_ATTR_CSS_LIKE_QUERY
            = "a[href][target]:not([target=_self]):not([target~=^\\s*$])"
            + ":not([target=_top]):not([target=_parent])";

    // Scripts css-like queries
    public static final String CHANGE_CONTEXT_SCRIPT_CSS_LIKE_QUERY
            = "select[onchange], "
            + "form:has(select)"
            + ":not(:has(button))"
            + ":not(:has(input[type=submit]))"
            + ":not(:has(input[type=button]))"
            + ":not(:has(input[type=reset]))";

    // Consultation css-like queries
    public static final String META_WITH_REFRESH_CSS_LIKE_QUERY
            = "meta[http-equiv=refresh][content*=url]";
    public static final String FORM_CONTROL_CSS_LIKE_QUERY
            = "form, "
            + "select:not(form select), "
            + "textarea:not(form textarea), "
            + "input:not(form input):not([type=hidden]), "
            + "button:not(form button)";

    // Structuration of information css-like queries
    public static final String HEADINGS_CSS_LIKE_QUERY
            = "h1, h2, h3, h4, h5, h6";

    // Structuration of information css-like queries
    public static final String ARIA_HEADINGS_CSS_LIKE_QUERY
            = "[role=heading][aria-level]";

    // Structuration of information css-like queries
    public static final String ARIA_LEVEL1_HEADINGS_CSS_LIKE_QUERY
            = "[role=heading][aria-level=1]";

    // Elements with attributes (minus element exceptions)
    public static final String ELEMENT_WITH_WITDH_ATTR_NOT_IMG
            = ":not(img):not(svg)[width]:not(svg [width])";
    public static final String ELEMENT_WITH_HEIGHT_ATTR_NOT_IMG
            = ":not(img):not(svg)[height]:not(svg [height])";

    // Elements with attributes (minus element exceptions)
    public static final String ELEMENT_WITH_WITDH_ATTR_NOT_IMG_V2
            = "body :not(img):not(svg):not(object):not(embed):not(canvas)[width]:not(svg [width])";
    public static final String ELEMENT_WITH_HEIGHT_ATTR_NOT_IMG_V2
            = "body :not(img):not(svg):not(object):not(embed):not(canvas)[height]:not(svg [height])";

    public static final String IMG_CSS_LIKE_QUERY
            = IMAGE_LINK_CHILDREN_CSS_LIKE_QUERY
            + "embed[type^=image]"
            + "input[type^=image]";

    // scripts	
    public static final String ONCLICK_CSS_LIKE_QUERY
            = "*[onclick]"
            + ":not(a[onlick])"
            + ":not(area[onclick])"
            + ":not(button[onlick])"
            + ":not(input[type=button][onclick])"
            + ":not(input[type=submit][onclick])"
            + ":not(input[type=reset][onclick])"
            + ":not(input[type=image][onclick])"
            + ":not(input[type=password][onclick])"
            + ":not(input[type=radio][onclick])"
            + ":not(input[type=checkbox][onclick])"
            + ":not(input[type=button][onclick])";

    public static final String ELEMENT_WITH_ROLE_ATTR_CSS_LIKE_QUERY
            = "*[role=checkbox], *[role=radio], *[role=textbox], *[role=combobox]";

    // Seo 
    public static final String META_DESC_CSS_LIKE_QUERY
            = "head meta[name=description][content]";
    public static final String FLASH_CONTENT_CSS_LIKE_QUERY
            = "[type=application/x-shockwave-flash], "
            + "object[data$=swf], "
            + "embed[src$=swf]";
    public static final String REL_CANONICAL_CSS_LIKE_QUERY
            = "head link[rel=canonical][href]";

    //Navigation
    public static final String ROLE_NAVIGATION_CSS_LIKE_QUERY
    		= "*[role=navigation], *[role=navigation] ul li a[href] ";
    /**
     * Private constructor. This class handles keys and must not be instanciated
     */
    private CssLikeQueryStore() {
    }

}
