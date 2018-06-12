package ruisiyuan;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;  
  
//获取spring中带注解的类的工具类  
public class SpringUtil implements ApplicationContextAware{  
    public static ApplicationContext ct;  
    //spring中获得bean  
    public static Object getObject(String beanId){  
        return ct.getBean(beanId);  
    }  
    @Override  
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {  
        SpringUtil.ct = arg0;  
    }  
    
}  
