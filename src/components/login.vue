<template>
  <div id="customize">
  <Row >
        <Col span="8">

    </Col>
  </Row>
    <Form ref="formInline" :model="formInline" :rules="ruleInline" inline>
        <FormItem prop="user">
            <Input type="text" v-model="formInline.user" placeholder="Username">
                <Icon type="ios-person-outline" slot="prepend"></Icon>
            </Input>
        </FormItem>
        <FormItem prop="password">
            <Input type="password" v-model="formInline.password" placeholder="Password" >
                <Icon type="ios-lock-outline" slot="prepend"></Icon>
            </Input>
        </FormItem>
        <FormItem>
            <Button type="primary" @click="handleSubmit('formInline')">Signin</Button>
            <router-link id="wq2" to="/register"><Button type="info" ghost>还没有帐号？</Button></router-link>
        </FormItem>
    </Form>
  </div>
</template>
<script>

    export default {
        name: "login",
        data () {
            return {
                formInline: {
                    user: '',
                    password: ''
                },
                ruleInline: {
                    user: [
                        { required: true, message: 'Please fill in the user name', trigger: 'blur' },
                        {
                            min:3,max:10,message: 'please length cannot be less than 3 bits',trigger: 'blur'
                        }
                    ],
                    password: [
                        { required: true, message: 'Please fill in the password.', trigger: 'blur' },
                        { type: 'string', min: 3, max:15, message: 'The password length cannot be less than 3 bits', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            handleSubmit(name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                          var that=this;/*这是一个this指向问题,this始终指向Vue,所以需要将this保存在that中,在使用其他操作的时候可以用that代替。不然下面的$Message未定义！！！what*/
                      var dataLogin={
                        'username':this.formInline.user,
                        'password':this.formInline.password,}

                  this.$http.post('/api/login',dataLogin).then(function (res) {
                      window.console.log("loginpost"+res);
                                  // 取值
                                 switch (parseInt(res.data.code)){
                                case 100:  {
                                                {
                                                    that.$Message.success('Success!');
                                                    switch (parseInt(res.data.role)) {
                                                        case 300:{  that.$router.push({path:'/student'}); break;}
                                                        case 301:{  that.$router.push({path:'/reviewer'}); break;}
                                                        case 302:{  that.$router.push({path:'/procurement'}); break;}
                                                        case 303:{  that.$router.push({path:'/teacher'}); break;}
                                                        default:{}
                                                    }



                                                }break;}

                                case 101:  {that.$Message.success('用户不存在!');break;}
                                case 102:  {that.$Message.success('密码错误!');break;}
                                case 103:  {that.$Message.success('未知错误!');break;}
                                   default:that.$Message.success('没有对应代码');break;
                                 }


                  }).catch(function (err) {
                      window.console.log("errorLogin:"+err);
                  });

                    } else {
                        this.$Message.error('Fail!');
                    }
                })
            }
        }



    }
</script>

<style scoped>
    /*表单居中*/
#customize{
    width:300px;
    height: 300px;
    align-content: center;
margin:auto;
    position: relative;
    top:100px;
}

</style>
