package com.mlwc.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

/**
 * @Author: by simple on 2018/4/18.
 */
public class TokenUtil {
    public TokenUtil() {
    }
    private static Key generalKey(String key) {
        byte[] encodedKey = Base64Codec.BASE64.encode(key.getBytes()).getBytes();
        return new SecretKeySpec(encodedKey, "AES");
    }

    public static String createToken(String userId, String key, Date expireDate) {
        String token = Jwts.builder().setSubject(userId).signWith(SignatureAlgorithm.HS256, generalKey(key)).setIssuedAt(new Date()).setExpiration(expireDate).compact();
        return token;
    }

    public static Claims parseToken(String token, String key) throws Exception {
        if(token == null) {
            throw new NullPointerException("token不能为null");
        } else {
            return Jwts.parser().setSigningKey(generalKey(key)).parseClaimsJws(token).getBody();
        }
    }
}
