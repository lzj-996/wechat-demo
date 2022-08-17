* 安装jdk环境
[百度的挺详细的，应该没问题](https://blog.csdn.net/weixin_43583223/article/details/123296163)

* [登陆微信的测试公众平台](http://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index)
    1. 拿到appID和appsecret
    2. 关注测试公众号，拿到用户微信账户（微信用户openId）
    3. 新增测试模板 
       1. 模板标题：懒猪猪的每天提醒（可以随便输）
       2. 模板内容：
          {{title.DATA}}
          {{time.DATA}}
          今天是我们认识的第{{day.DATA}}天
          我希望今天的你心情是 {{state.DATA}}
          你的城市：{{city.DATA}}
          今天天气：{{dayWeather.DATA}}
          今天温度：{{daytemp.DATA}}
          你的幸运颜色：{{color.DATA}}
          {{constellationName.DATA}}的你今天的爱情指数是 {{love.DATA}}
          速配星座：{{friend.DATA}}
          今天的你:{{summary.DATA}}
          送你一句油油的话语：{{chp.DATA}}
          鸡汤鸡汤：{{du.DATA}}
       3. 添加就能获取到模板ID
  

* 打开了这个文件：src/main/resources/application.yaml
    1. 把appId、appSecret、templateId、用户openId替换掉（多个用户可以继续添加用户openId）
    2. title、meetDate、city、cityCode、constellation填写该用户的信息
    3. 注意:前要有个空格，不然格式错误
    4. lbs:
        key:为高德地图接口天气api的私钥（去这里申请填进去https://lbs.amap.com/api/webservice/guide/api/weatherinfo）
    5. constellation
        key:为聚合星座接口api的私钥（不过这个免费只能请求30次/天，还要实名认真，有点坑。https://www.juhe.cn/docs/api/id/58）
* 所有东西完成后，打开项目的cmd路径（直接在文件夹路径上敲cmd回车）,敲命令:java -jar wechat-demo-0.0.1-SNAPSHOT.jar
等待启动完成后，网页上调用http://localhost:8081/wechat/demo/wechat/sendMessage,就能收到推送消息了，每天8点会定时发送，但服务要一直开着，
不差钱的，可以买个云服务器放在服务器上。新人优惠第一年一般都很便宜，可以嫖一嫖，后续我可开发一个exe程序，win系统定时任务发送，java环境都不用安装了
