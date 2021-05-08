package com.maina.redditBackend.Security;

public class SecurityConstants {

    public static final String SECRET = "6ff082e1bf4a4c988ca91a493b4cb63bashjda98239423shday99uu9u9i889hghgjh09897hghsdfhsiwecsdqer231erteerd";
    public static final long EXPIRATION_TIME = 1_800_000 * 2;// 30 * 2 * 24 minutes
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long PASSWORD_RESET_EXPIRATION_TIME = 900_000; // about 15 minutes
    public static final long OTP_EXPIRATION_DATE = 1_800_000 * 2; // 30 * 2 * 24 minutes

}
