# batch-rename-picture

> 一个批量重命名图片的小工具

#### Build Setup

**electron端项目构建**：

``` bash
# install dependencies
yarn

# serve with hot reload at localhost:9080
yarn run dev

# build electron application for production
yarn run build

# 直接双击 dist 目录下生成的 exe 可执行文件即可

```

**后端构建**：

> 进入backend路径，执行命令：`mvn clean && mvn package`
> 然后先启动后端项目（注意路径需要在target下）：`java -jar batchrenamepicture-0.0.1-SNAPSHOT.jar`
>

**demo**

![](https://img.imgdb.cn/item/6055ea01524f85ce29e10a4f.jpg)

![](https://img.imgdb.cn/item/6055ea29524f85ce29e11f6b.jpg)

---

This project was generated with [electron-vue](https://github.com/SimulatedGREG/electron-vue)@[45a3e22](https://github.com/SimulatedGREG/electron-vue/tree/45a3e224e7bb8fc71909021ccfdcfec0f461f634) using [vue-cli](https://github.com/vuejs/vue-cli). Documentation about the original structure can be found [here](https://simulatedgreg.gitbooks.io/electron-vue/content/index.html).
