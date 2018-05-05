简单好用的图片生成工具，基于Java实现，可以动态生成二维码海报和汉字名字头像，有任何问题欢迎提交issue或者给我发送邮件： me@gongdexing.com

## 如何运行
> mvn clean package <br>
java -jar target\ImageTool-1.0.0.jar


## 如何使用

#### 生成动态二维码海报
请求
> POST  127.0.0.1:8080/poster/create

参数

    nickname: 昵称
    headImageUrl: 头像地址
    qrcodeText: 生成二维码的内容

生成的海报图片保存在项目目录: **poster.jpg**，效果如下
![海报](poster.jpg)

### 生成汉字名字头像
请求
> POST  127.0.0.1:8080/head/create

参数

    name: 姓名
    rgb: 字体颜色，格式类似"#FFFFFF"
    bgRGB: 背景颜色，格式类似"#CC99FF"

生成的头像图片保存在项目目录: **head.jpg**，效果如下

![头像](head.jpg)