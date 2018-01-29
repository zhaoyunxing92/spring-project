package com.sunny.blog.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author sunny
 * @className BaseTestController
 * @date 2018-01-29 18:27
 * @description:
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootContextConfig.class, WebMvcConfig.class})
public abstract class BaseTestController {
//    private Gson gson;
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Before()
//    public void setup() {
//        //使用GsonBuilder针对日期类型指定解析后的格式,当Date只有年月日时,会使用当前时间来凑够解析长度
//        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); // 初始化MockMvc对象
//       // init();
//    }
    /**
     * 模板方法,由子类重写以决定是否在运行之前登录
     */
   // protected abstract void init();
}
