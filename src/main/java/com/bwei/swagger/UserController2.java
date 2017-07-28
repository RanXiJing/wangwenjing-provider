package com.bwei.swagger;

import com.bwei.bean.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 染熙 on 2017/7/19.
 * @Controller：修饰class，用来创建处理http请求的对象
 * @RestController：Spring4之后加入的注解，原来在@Controller中返回json需要@ResponseBody来配合，
 * 如果直接用@RestController替代@Controller就不需要再配置@ResponseBody，默认返回json格式。
 * @RequestMapping：配置url映射
 */
@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController2 {
    @Autowired
    private UserService userService;
    /*
    为添加的API相关注解。
    @ApiOperation(value = "接口说明" , httpMethod = "接口请求方式", response = "接口返回参数类型",notes = "接口发布说明")
     */
    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={"/findUser"}, method= RequestMethod.PUT)
    public List<User> findUser() {
        List<User> user = userService.findUser();
        return user;
    }
    /*
    @ApiImplicitParam 用于规定接收参数类型、名称、是否必须等信息
         name  对应方法中接收参数名称
         ovalue  备注说明
         orequired  是否必须 boolean
         dataType  参数类型
     */
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        userService.save(user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/findUserById{id}", method= RequestMethod.GET)
    public User findUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/update{id}", method= RequestMethod.PUT)
    public String updateUser(@PathVariable Integer id, @RequestBody User user) {
        User u = userService.findUserById(id);
        u.setUsername(user.getUsername());
        u.setAge(user.getAge());
        userService.save(user);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/delete{id}", method= RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return "success";
    }

}

