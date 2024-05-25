/*
 * CCStates.java
 *
 * Created on October 28, 2003, 5:57 PM
 */

package com.trinity.ea.design.payments.preview.data;
import java.io.*;
import java.util.*;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class CCCountries 
{
    /* Removed the following countries from the purchase list due to U.S. export restrictions
     * Afghanistan, Cuba, Iran, Iraq, Libya, North Korea, Serbia/Montenegro (Yugoslavia), 
     * Sudan, Syria and parties listed on the Denied and Restricted Parties List.
     */
    Map countryMap = new HashMap();   
    /** Creates a new instance of CCStates */
    public CCCountries() 
    {

        try
        {
            countryMap.put("Albania","AL");
            countryMap.put("Algeria","DZ");
            countryMap.put("American Samoa","AS");
            countryMap.put("Andorra","AD");
            countryMap.put("Angola","AO");
            countryMap.put("Anguilla","AI");
            countryMap.put("Antarctica","AQ");
            countryMap.put("Antigua and Barbuda","AG");
            countryMap.put("Argentina","AR");
            countryMap.put("Armenia","AM");
            countryMap.put("Aruba","AW");
            countryMap.put("Australia","AU");
            countryMap.put("Austria","AT");
            countryMap.put("Azerbaidjan","AZ");
            countryMap.put("Bahamas","BS");
            countryMap.put("Bahrain","BH");
            countryMap.put("Banglades","BD");
            countryMap.put("Barbados","BB");
            countryMap.put("Belarus","BY");
            countryMap.put("Belgium","BE");
            countryMap.put("Belize","BZ");
            countryMap.put("Benin","BJ");
            countryMap.put("Bermuda","BM");
            countryMap.put("Bolivia","BO");
            countryMap.put("Bosnia-Herzegovina","BA");
            countryMap.put("Botswana","BW");
            countryMap.put("Bouvet Island","BV");
            countryMap.put("Brazil","BR");
            countryMap.put("British Indian O. Terr.","IO");
            countryMap.put("Brunei Darussalam","BN");
            countryMap.put("Bulgaria","BG");
            countryMap.put("Burkina Faso","BF");
            countryMap.put("Burundi","BI");
            countryMap.put("Buthan","BT");
            countryMap.put("Cambodia","KH");
            countryMap.put("Cameroon","CM");
            countryMap.put("Canada","CA");
            countryMap.put("Cape Verde","CV");
            countryMap.put("Cayman Islands","KY");
            countryMap.put("Central African Rep.","CF");
            countryMap.put("Chad","TD");
            countryMap.put("Chile","CL");
            countryMap.put("China","CN");
            countryMap.put("Christmas Island","CX");
            countryMap.put("Cocos (Keeling) Isl.","CC");
            countryMap.put("Columbia","CO");
            countryMap.put("Comoros","KM");
            countryMap.put("Congo","CG");
            countryMap.put("Cook Islands","CK");
            countryMap.put("Costa Rica","CR");
            countryMap.put("Croatia","HR");
            countryMap.put("Cyprus","CY");
            countryMap.put("Czech Republic","CZ");
            countryMap.put("Czechoslovakia","CS");
            countryMap.put("Denmark","DK");
            countryMap.put("Djibouti","DJ");
            countryMap.put("Dominica","DM");
            countryMap.put("Dominican Republic","DO");
            countryMap.put("East Timor","TP");
            countryMap.put("Ecuador","EC");
            countryMap.put("Egypt","EG");
            countryMap.put("El Salvador","SV");
            countryMap.put("Equatorial Guinea","GQ");
            countryMap.put("Estonia","EE");
            countryMap.put("Ethiopia","ET");
            countryMap.put("Falkland Isl.(Malvinas)","FK");
            countryMap.put("Faroe Islands","FO");
            countryMap.put("Fiji","FJ");
            countryMap.put("Finland","FI");
            countryMap.put("France","FR");
            countryMap.put("France (European Ter.)","FX");
            countryMap.put("French Southern Terr.","TF");
            countryMap.put("Gabon","GA");
            countryMap.put("Gambia","GM");
            countryMap.put("Georgia","GE");
            countryMap.put("Germany","DE");
            countryMap.put("Ghana","GH");
            countryMap.put("Gibraltar","GI");
            countryMap.put("Great Britain (UK)","GB");
            countryMap.put("Greece","GR");
            countryMap.put("Greenland","GL");
            countryMap.put("Grenada","GD");
            countryMap.put("Guadeloupe (Fr.)","GP");
            countryMap.put("Guam (US)","GU");
            countryMap.put("Guatemala","GT");
            countryMap.put("Guinea","GN");
            countryMap.put("Guinea Bissau","GW");
            countryMap.put("Guyana","GY");
            countryMap.put("Guyana (Fr.)","GF");
            countryMap.put("Haiti","HT");
            countryMap.put("Heard & McDonald Isl.","HM");
            countryMap.put("Honduras","HN");
            countryMap.put("Hong Kong","HK");
            countryMap.put("Hungary","HU");
            countryMap.put("Iceland","IS");
            countryMap.put("India","IN");
            countryMap.put("Indonesia","ID");
//            countryMap.put("Iraq","IQ");
            countryMap.put("Ireland","IE");
            countryMap.put("Israel","IL");
            countryMap.put("Italy","IT");
            countryMap.put("Ivory Coast","CI");
            countryMap.put("Jamaica","JM");
            countryMap.put("Japan","JP");
            countryMap.put("Jordan","JO");
            countryMap.put("Kazachstan","KZ");
            countryMap.put("Kenya","KE");
            countryMap.put("Kirgistan","KG");
            countryMap.put("Kiribati","KI");
            countryMap.put("Korea (North)","KP");
            countryMap.put("Korea (South)","KR");
            countryMap.put("Kuwait","KW");
            countryMap.put("Laos","LA");
            countryMap.put("Latvia","LV");
            countryMap.put("Lebanon","LB");
            countryMap.put("Lesotho","LS");
            countryMap.put("Liberia","LR");
//            countryMap.put("Libya","LY");
            countryMap.put("Liechtenstein","LI");
            countryMap.put("Lithuania","LT");
            countryMap.put("Luxembourg","LU");
            countryMap.put("Macau","MO");
            countryMap.put("Madagascar","MG");
            countryMap.put("Malawi","MW");
            countryMap.put("Malaysia","MY");
            countryMap.put("Maldives","MV");
            countryMap.put("Mali","ML");
            countryMap.put("Malta","MT");
            countryMap.put("Marshall Islands","MH");
            countryMap.put("Martinique (Fr.)","MQ");
            countryMap.put("Mauritania","MR");
            countryMap.put("Mauritius","MU");
            countryMap.put("Mexico","MX");
            countryMap.put("Micronesia","FM");
            countryMap.put("Moldavia","MD");
            countryMap.put("Monaco","MC");
            countryMap.put("Mongolia","MN");
            countryMap.put("Montserrat","MS");
            countryMap.put("Morocco","MA");
            countryMap.put("Mozambique","MZ");
            countryMap.put("Myanmar","MM");
            countryMap.put("Namibia","NA");
            countryMap.put("Nauru","NR");
            countryMap.put("Nepal","NP");
            countryMap.put("Netherland Antilles","AN");
            countryMap.put("Netherlands","NL");
            countryMap.put("Neutral Zone","NT");
            countryMap.put("New Caledonia (Fr.)","NC");
            countryMap.put("New Zealand","NZ");
            countryMap.put("Nicaragua","NI");
            countryMap.put("Niger","NE");
            countryMap.put("Nigeria","NG");
            countryMap.put("Niue","NU");
            countryMap.put("Norfolk Island","NF");
            countryMap.put("Northern Mariana Isl.","MP");
            countryMap.put("Norway","NO");
            countryMap.put("Oman","OM");
            countryMap.put("Pakistan","PK");
            countryMap.put("Palau","PW");
            countryMap.put("Panama","PA");
            countryMap.put("Papua New","PG");
            countryMap.put("Paraguay","PY");
            countryMap.put("Peru","PE");
            countryMap.put("Philippines","PH");
            countryMap.put("Pitcairn","PN");
            countryMap.put("Poland","PL");
            countryMap.put("Polynesia (Fr.)","PF");
            countryMap.put("Portugal","PT");
            countryMap.put("Puerto Rico (US)","PR");
            countryMap.put("Qatar","QA");
            countryMap.put("Reunion (Fr.)","RE");
            countryMap.put("Romania","RO");
            countryMap.put("Russian Federation","RU");
            countryMap.put("Rwanda","RW");
            countryMap.put("Saint Lucia","LC");
            countryMap.put("Samoa","WS");
            countryMap.put("San Marino","SM");
            countryMap.put("Saudi Arabia","SA");
            countryMap.put("Senegal","SN");
            countryMap.put("Seychelles","SC");
            countryMap.put("Sierra Leone","SL");
            countryMap.put("Singapore","SG");
            countryMap.put("Slovak Republic","SK");
            countryMap.put("Slovenia","SI");
            countryMap.put("Solomon Islands","SB");
            countryMap.put("Somalia","SO");
            countryMap.put("South Africa","ZA");
            countryMap.put("Soviet Union","SU");
            countryMap.put("Spain","ES");
            countryMap.put("Sri Lanka","LK");
            countryMap.put("St. Helena","SH");
            countryMap.put("St. Pierre & Miquelon","PM");
            countryMap.put("St. Tome and Principe","ST");
            countryMap.put("St.Kitts Nevis Anguilla","KN");
            countryMap.put("St.Vincent & Grenadines","VC");
//            countryMap.put("Sudan","SD");
            countryMap.put("Suriname","SR");
            countryMap.put("Svalbard & Jan Mayen Is","SJ");
            countryMap.put("Swaziland","SZ");
            countryMap.put("Sweden","SE");
            countryMap.put("Switzerland","CH");
//            countryMap.put("Syria","SY");
            countryMap.put("Tadjikistan","TJ");
            countryMap.put("Taiwan","TW");
            countryMap.put("Tanzania","TZ");
            countryMap.put("Thailand","TH");
            countryMap.put("Togo","TG");
            countryMap.put("Tokelau","TK");
            countryMap.put("Tonga","TO");
            countryMap.put("Trinidad & Tobago","TT");
            countryMap.put("Tunisia","TN");
            countryMap.put("Turkey","TR");
            countryMap.put("Turkmenistan","TM");
            countryMap.put("Turks & Caicos Islands","TC");
            countryMap.put("Tuvalu","TV");
            countryMap.put("Uganda","UG");
            countryMap.put("Ukraine","UA");
            countryMap.put("United Arab Emirates","AE");
            countryMap.put("United Kingdom","UK");
            countryMap.put("United States","US");
            countryMap.put("Unknown Country","ZZ");
            countryMap.put("Uruguay","UY");
            countryMap.put("US Minor outlying Isl.","UM");
            countryMap.put("Uzbekistan","UZ");
            countryMap.put("Vanuatu","VU");
            countryMap.put("Vatican City State","VA");
            countryMap.put("Venezuela","VE");
            countryMap.put("Vietnam","VN");
            countryMap.put("Virgin Islands (British)","VG");
            countryMap.put("Virgin Islands (US)","VI");
            countryMap.put("Wallis & Futuna Islands","WF");
            countryMap.put("Western Sahara","EH");
            countryMap.put("Yemen","YE");
//            countryMap.put("Yugoslavia","YU");
            countryMap.put("Zaire","ZR");
            countryMap.put("Zambia","ZM");
            countryMap.put("Zimbabwe","ZW");
        }
        catch(Exception e)
        {
            
        }
        
    }
    /** Return the Country Abbreviation for Credit Card Processing.
     * @return
     * @param Country
     */
    public String getCountryID(String Country)
    {
        try
        {
            return (String)countryMap.get(Country);
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
