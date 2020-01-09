package cn.leadeon.comm;

import cn.leadeon.util.RSAUtil;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 *  解析 配置文件加密串
 */
public class PropertyPlaceholder extends PropertyPlaceholderConfigurer {

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if(propertyName.startsWith("encrypt")){
            return  RSAUtil.decrypt(propertyValue);
        }else{
            return propertyValue;
        }
    }
}
