package com.zzx.filterlistenerintercept.listenerfilterintercept;


import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;


public class TokenCheck {

    /**
     * 解码，返回Token主体部分
     * printXXX 的函数就是encode，parseXXX 的函数就是decode
     * @return
     */
    public static Boolean checkToken(String token,String tokenKey){
        Jws jws;
        try {
            jws = Jwts.parser()  //解码，这部分自带签名验证功能，验证通过才能解码得到jws。
                    .setSigningKey(tokenKey) //插入密钥（数据转换.字符串还原成字节码（字符串））
                    .parseClaimsJws(token); //解码token
        }catch (Exception e){
            return false;
        }

        return true;
    }

    /**
     * 加密，生成Token字符串
     *
     */
    public static String createToken(String tokenKey,String userId,long TTLMillis){
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;  //B部分编码方式，可选选项见表
        long nowMillis = System.currentTimeMillis();     //当前时间
        Date now = new Date(nowMillis);

        JwtBuilder jwtBuilder = Jwts.builder().setHeaderParam("typ","JWT").setHeaderParam("alg",algorithm)   //设置A部分，setHeaderParam可设置4个键值对typ、alg等
                .setAudience(userId)
                .setIssuedAt(now)                     //设置时间戳，放在claim之后，对claim的时间戳进行刷新
                .signWith(algorithm,tokenKey);             //最后是签名（B编码方式，C加密密钥）
        //signWith接受三种C部分密钥：byte[] secretKey，String base64EncodedSecretKey，Key key。前两种最终被JWTBuilder转换成Key。
        //添加过期时间
        if (TTLMillis >= 0) {                            //如果设置了过期间隔时间，单位：自1970年1月1日0时起的毫秒数
            long expMillis = nowMillis + TTLMillis;      //过期时间，单位：毫秒
            Date exp = new Date(expMillis);              //转换过期时间为未来某一时刻
            jwtBuilder.setExpiration(exp).setNotBefore(now);//设置B部分，过期时间.
        }

        return jwtBuilder.compact();   //开始提交加密并返回字符串
    }

    /**
     * 刷新Token
     * @return
     */
    public static String refreshToken(){

        return null;
    }
}
