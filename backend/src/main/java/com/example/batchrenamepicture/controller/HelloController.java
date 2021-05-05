package com.example.batchrenamepicture.controller;

import com.example.batchrenamepicture.result.Result;
import com.example.batchrenamepicture.result.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/hello")
@CrossOrigin(origins = "http://localhost:9080", maxAge = 3600) //跨域配置参考：https://juejin.cn/post/6844903991558537223
public class HelloController {

    // 9080 的发送请求端口在 electron-vue 项目的 src/main/index.js 中配置着
    @RequestMapping("/world")
    @ResponseBody
    public Result hello(@RequestBody Map map){
        String path = (String) map.get("pathStr");
        boolean result = rename(path);
        if (result){
            return new Result().setCode(ResultCode.SUCCESS).setMessage("成功");
        }else{
            return new Result().setCode(ResultCode.FAIL).setMessage("失败");
        }

    }

    public boolean rename(String path) {
        //输入的目录路径  E:\photos\网图
        String _path = path;
        //将要实现的转换格式
        String targetSuffix = ".png";
        //目标文件夹路径
        File file = new File(_path);
        //如果目录存在
        if (file.exists() && file.isDirectory()) {
            //获取目标目录下所有的文件数组
            File[] files = file.listFiles();
            //标记该数组的长度
            int len = files.length;
            System.out.println(file + "目录下总共有：" + len + "个文件");
            for (int i = 0; i < len; i++) {
                String name = files[i].getName();
                int index = name.lastIndexOf(".");
                //获取后缀名
                String suffixName = name.substring(index);
                //通过后缀名判断图片
                if (".jpg".equals(suffixName) || ".png".equals(suffixName) || ".webp".equals(suffixName)){
                    String newName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + (i + 1) + targetSuffix;
                    //重命名
                    File dest = new File(_path + "/" + newName);
                    files[i].renameTo(dest);
                    System.out.println(_path + "\\" + name + " 重命名为：" + dest.getName() + "成功");
                }else System.out.println(_path + "\\" + name + " 文件不是一个图片文件");

            }

            return true;
        }else return false;
    }
}
