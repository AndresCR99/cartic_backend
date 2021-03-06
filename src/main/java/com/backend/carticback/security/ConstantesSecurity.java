package com.backend.carticback.security;

import com.backend.carticback.utils.AppPropiedades;
import com.backend.carticback.utils.AppContexto;

public class ConstantesSecurity {

    public static String SIGN_UP_URl= "/usuarios";
    public static long EXPIRATION_DATE= 864000000;
    public static String HEADER_STRING= "Authorization"; 
    public static String TOKEN_PREFIX= "Bearer "; 

    public static String getTokenSecret(){
        AppPropiedades appProperties = (AppPropiedades) AppContexto.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }
    
}
