# 咸鱼翻身网 - 二手交易平台
### 此为毕设作品

## github授权登陆模块（OAuth2.0）
1. 用户点击登陆按钮，请求github提供的authorize接口，需要提供的参数
   - client_id: github生成的
   - redirect_uri: 自己设置的回调接口地址 
   - state=1 
   - scope=user
2. github自动跳转到我们设置的callback接口中，并且携带参数code
3. 我们继续调用github提供的access_token接口，需要提供参数，将数据穿的的参数封装为AccessTokenDTO对象 
   - Client_id: github生成的
   - Client_secret: github生成的
   - Code: github: 回调提供的参数
   - Redirect_uri: 自己设置的回调接口地址
   - State: 1
   注意请求url: https://github.com/login/oauth/access_token   post方式
4. github响应请求返回access_token
5. 利用access_token请求github提供的user接口
   https://api.github.com/user?access_token=xxxxx   Get方式
6. 返回Git用户，存入数据，更新登陆状态

## 关于数据库的配置
1. MySql驱动版本小于6
   - spring.datasource.driver-class-name=com.mysql.jdbc.Driver
   - spring.datasource.url=jdbc:mysql://localhost:3306/数据库名
   - spring.datasource.username=账号
   - spring.datasource.password=密码
2. MySql驱动版本为6或大于6
   - spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   - spring.datasource.url=jdbc:mysql://localhost:3306/数据库名?useUnicode=true&characterEncoding=utf8&useSSL=false
   - spring.datasource.username=账号
   - spring.datasource.password=密码
    
## Session与Cookie 用户登录态
   - 当用户进入时，拦截器自动拦截所有Cookie，遍历Cookie找到Key为token的Cookie,如果没有找到代表没有登录
   - 找到之后拿token去数据库找该用户的所有信息并返回，然后注入到Session
   - 没找到，让用户登录，登录的时候生成token加入Cookie并设置过期时间
   - Session的会在浏览器关闭时被销毁，但是每次进入网站，如果Cookie没过期会重新注入生成一个Session，以此形成一个用户登录态
   
## 页头与页脚的分离
   - 分离出去的header.html 不需要写<html>和<head>等标签，只需写需要用的组件就行
   - 在header.html引用的css和js只对自己生效，但是被引用之后，引用他的html里的css和js会对header.html生效
   - 目前是用<span>标签配合js去引用
## 待解决的问题
   1. 登录之后，依然可以访问login.html(改为了模态框登录)
   2. 页头和页脚分离成单独的html，减少代码重复性(已解决)
   

