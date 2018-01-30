import com.sunny.blog.config.RootContextConfig;
import com.sunny.blog.config.WebMvcConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author sunny
 * @className BlogWebAppContextInitializer
 * @date 2018-01-29 11:44
 * @description:
 */
public class BlogWebAppContextInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 配置root上下文,如Jpa数据源等等的配置
     *  返回带有@Configuration 注解的类将会用来配置 ContextLoaderListener 创建的应用上下文中的bean
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class<?>[]{RootContextConfig.class};
    }

    /**
     * 配置dispatcher servlet，如果在root config指定了该转发规则就可以忽略
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    /**
     * 指定开始被servlet处理的url,配置从/开始
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置servlet过滤器
     *
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
      //  DelegatingFilterProxy securityFilterChain = new DelegatingFilterProxy("springSecurityFilterChain");
        return new Filter[]{characterEncodingFilter};
    }
}
