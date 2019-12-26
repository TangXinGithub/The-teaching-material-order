import Mock from 'mockjs'

const data={
    "id":"@guid",
    "username|1-10": "@string",
    "code":"@integer(200, 203)",
    "name":"@cname",
};

Mock.mock('/api/test', 'post', data)
// 记录数据模板。当拦截到匹配 rurl 和 rtype 的 Ajax 请求时，将根据数据模板 template 生成模拟数据，并作为响应数据返回。

//注册模拟数据
const data1={
    "code|200-203":203,
}
Mock.mock('/api/register','post',function (options) { //不要少了斜杠
    window.console.log("这是mock/register/"+options);
   window.console.log( options.body.username);
   window.console.log(options.body.password);
   window.console.log(options.body.role);
return data1;
})

//登录时候的数据
const data2={
    "code|100-106":106,
}
Mock.mock('/api/login','post',function (options) { //不要少了斜杠
    window.console.log("这是mock/login"+options);
    window.console.log( "这是mock/login/username"+options.body.username);
    window.console.log("这是mock/login/password"+options.body.password);

    return data2;
})

export default Mock;

// https://github.com/nuysoft/Mock/wiki/Mock.mock()
// 如果是GET请求，那么要从options.url里面拿，然后自己解析出来；
// 如果是普通的POST请求，那么要从options.body里面拿，然后自己解析类似a=1&b=2这种格式；
// 如果参数是JSON格式并且是POST，那么要从options.body里面拿，然后JSON.parse()再获取；