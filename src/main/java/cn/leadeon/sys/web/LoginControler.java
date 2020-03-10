package cn.leadeon.sys.web;

import cn.leadeon.comm.JsonResult;
import cn.leadeon.sys.entity.UserEntity;
import cn.leadeon.sys.service.UserService;
import cn.leadeon.util.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login.do")
public class LoginControler {

    private  final Logger LOGGER = LoggerFactory.getLogger(LoginControler.class);
    @Resource
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @RequestMapping
    public String index(){
        return "sys/index";
    }

    @RequestMapping(params = "method=getUserList")
    @ResponseBody
    public JsonResult getUserList(){
        JsonResult jsonResult = new JsonResult();
        Map<String,Object> params = new HashMap<String,Object>();
        redisService.addString("text_1","111",10L);
        System.out.println(redisService.getString("text_1"));
        redisService.delete("text_1");
        params.put("","");
        params.put("","");
        try {
            LOGGER.info("查询用户");
            List<UserEntity> list = userService.getUser(params);
            System.out.println(list);
            jsonResult.setRows(list);
            jsonResult.setTatol(1);
        }catch (Exception e){
            LOGGER.error("查询用户列表信息出错",e);
        }
        return jsonResult;
    }
}
