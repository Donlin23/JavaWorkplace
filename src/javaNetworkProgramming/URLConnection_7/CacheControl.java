package javaNetworkProgramming.URLConnection_7;

import java.util.Date;
import java.util.Locale;

/**
 * @Author:Donlin
 * @Description: 7.6 如何检查Cache-control首部
 * @Date: Created in 19:03 2018/3/25
 * @Version: 1.0
 */
public class CacheControl {

    private Date maxAge = null;
    private Date sMaxAge = null;
    private boolean mustRevalidate = false;
    private boolean noCache = false;
    private boolean noStore = false;
    private boolean proxyRevalidate = false;
    private boolean publicCache = false;
    private boolean privateCache = false;

    public CacheControl(String s) {
        if (s == null || !s.contains(":")){
            return;//默认策略
        }

        String value = s.split(":")[1].trim();
        String[] components = value.split(",");

        Date now = new Date();
        for (String component: components) {
            try{
                component = component.trim().toLowerCase(Locale.US);
                if (component.startsWith("max-age=")){
                    int secondInTheFuture = Integer.parseInt(component.substring(8));
                    maxAge = new Date(now.getTime() + 1000 * secondInTheFuture);
                }else if (component.startsWith("s-maxage=")){
                    int secondInTheFuture = Integer.parseInt(component.substring(8));
                    sMaxAge = new Date(now.getTime() + 1000 * secondInTheFuture);
                }else if (component.equals("must-revalidate")){
                    mustRevalidate = true;
                }else if (component.equals("proxy-revalidate")){
                    proxyRevalidate = true;
                }else if (component.equals("no-cache")){
                    noCache = true;
                }else if (component.equals("public")){
                    publicCache = true;
                }else if (component.equals("private")){
                    privateCache = true;
                }
            }catch (RuntimeException ex){
                continue;
            }
        }
    }

    public Date getMaxAge() {
        return maxAge;
    }

    public Date getSharedMaxAge() {
        return sMaxAge;
    }

    public boolean isMustRevalidate() {
        return mustRevalidate;
    }

    public boolean isNoCache() {
        return noCache;
    }

    public boolean isNoStore() {
        return noStore;
    }

    public boolean isProxyRevalidate() {
        return proxyRevalidate;
    }

    public boolean isPublicCache() {
        return publicCache;
    }

    public boolean isPrivateCache() {
        return privateCache;
    }
}
