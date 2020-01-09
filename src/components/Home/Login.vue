<template>
    <div class="login-vue" :style="bg">
        <div class="container">
            <p class="title">WELCOME</p>
            <div class="input-c">
                <Input prefix="ios-contact" v-model="account" placeholder="用户名"  maxlength="15" clearable @on-blur="verifyAccount"/>
                <p class="error">{{accountError}}</p>
            </div>
            <div class="input-c">
                <Input type="password" v-model="pwd" prefix="md-lock" placeholder="密码" maxlength="15" clearable @on-blur="verifyPwd"/>
                <p class="error">{{pwdError}}</p>
            </div>
            <Button :loading="isShowLoading" class="submit" type="primary" @click="submit">登陆</Button>
            <p class="account"><span @click="register" style="color: #19be6b">注册账号</span> | <span @click="forgetPwd" style="color: #19be6b">忘记密码</span></p>
        </div>
    </div>
</template>

<script>
export default {
    name: 'login',
    data() {
        return {
            account: '',
            pwd: '',
            accountError: '',
            pwdError: '',
            isShowLoading: false,
            validateaccount:0,
            validatepwd:0,
            bg: {},
        }
    },
    created() {
        // this.bg.backgroundImage = 'url(' + require('../../assets/bg0' + new Date().getDay() + '.jpg') +')'

        this.bg.backgroundImage = 'url(' + require('../../assets/4.jpg') +')'
    },
    watch: {
        // $route: {
        //     handler(route) {
        //         this.redirect = route.query && route.query.redirect
        //     },
        //     immediate: true,
        // },
    },
    methods: {
        verifyAccount() {
            if (this.account == '') {
                this.accountError = '账号为不为空'
            } else {
                this.accountError = '';
                this.validateaccount=1;
            }
        },
        verifyPwd() {
            if (this.pwd =='') {
                this.pwdError = '密码不为空'
            } else {
                this.pwdError = '';
                this.validatepwd=1;
            }
        },
        register() {
                this.$router.push({path:'/register'});//跳转注册
        },
        forgetPwd() {

        },
        submit() {

                if((this.validateaccount==null && this.validatepwd==null)||this.validateaccount==0||this.validatepwd==0) { this.$Message.error('帐号或者密码不能为空！'); return ;}
            var dataLogin={
                'username':this.account,
                'password':this.pwd,};



            this.$http.post('/api/login',dataLogin).then((res)=> {
                console.log("loginpost",res);

                //存储一下用户数据：
                // window.localStorage.setItem('token', token)// 这个长期保存
                sessionStorage.setItem("username", this.account);//临时会话保存
                sessionStorage.setItem("role",res.data);//保存角色代码

                this.$Message.success('Success返回数据，!');
                switch (parseInt(res.data)) {
                    case 300:{  this.$router.push({path:'/student'}); break;}
                    case 301:{  this.$router.push({path:'/reviewer'}); break;}
                    case 302:{  this.$router.push({path:'/procurement'}); break;}
                    case 303:{  this.$router.push({path:'/teacher'}); break;}
                    default:{ this.$Message.error('没有对应代码  error!');}
                };


                // // 取值
                // switch (parseInt(res.data.code)){
                //     case 100:  {
                //         {
                //             //  ==别人的代码
                //             this.isShowLoading = true;
                //             // 登陆成功 设置用户信息
                //             localStorage.setItem('userImg', 'https://avatars3.githubusercontent.com/u/22117876?s=460&v=4')
                //             localStorage.setItem('userName', '小明')
                //             // 登陆成功 假设这里是后台返回的 token
                //             localStorage.setItem('token', 'i_am_token')
                //             //  ==别人的代码
                //
                //             this.$Message.success('Success!');
                //             switch (parseInt(res.data.role)) {
                //                 case 300:{  this.$router.push({path:'/student'}); break;}
                //                 case 301:{  this.$router.push({path:'/reviewer'}); break;}
                //                 case 302:{  this.$router.push({path:'/procurement'}); break;}
                //                 case 303:{  this.$router.push({path:'/teacher'}); break;}
                //                 default:{}
                //             }
                //
                //
                //
                //         }break;}
                //
                //     case 101:  {this.$Message.success('用户不存在!');break;}
                //     case 102:  {this.$Message.success('密码错误!');break;}
                //     case 103:  {this.$Message.success('未知错误!');break;}
                //     default:this.$Message.success('没有对应代码');break;
                // }


            }).catch( (err)=> {
                window.console.log("errorLogin:"+err);
            });


        },
    },
}
</script>

<style>
.login-vue {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    color: #fff;
}
.login-vue .container {
    background: rgba(255, 255, 255, .5);
    width: 300px;
    text-align: center;
    border-radius: 10px;
    padding: 30px;
}
.login-vue .ivu-input {
    background-color: transparent;
    color: #3536ff;
    outline: #fff;
    border-color: #fff;
}
.login-vue ::-webkit-input-placeholder { /* WebKit, Blink, Edge */
    color: rgba(66, 104, 255, 0.8);
}
.login-vue :-moz-placeholder { /* Mozilla Firefox 4 to 18 */
    color: rgba(77, 213, 255, 0.8);
}
.login-vue ::-moz-placeholder { /* Mozilla Firefox 19+ */
    color: rgba(98, 204, 255, 0.8);
}
.login-vue :-ms-input-placeholder { /* Internet Explorer 10-11 */
    color: rgba(75, 180, 255, 0.8);
}
.login-vue .title {
    font-size: 16px;
    margin-bottom: 20px;
    color: #19be6b;
}
.login-vue .input-c {
    margin: auto;
    width: 200px;

}
.login-vue .error {
    color: red;
    text-align: left;
    margin: 5px auto;
    font-size: 12px;
    padding-left: 30px;
    height: 20px;
}
.login-vue .submit {
    width: 200px;
}
.login-vue .account {
    margin-top: 30px;
}
.login-vue .account span {
    cursor: pointer;
}
.login-vue .ivu-icon {
    color: #eee;
}
.login-vue .ivu-icon-ios-close-circle {
    color: #777;
}

</style>
