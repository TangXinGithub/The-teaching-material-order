<template>
  <div class="Register-vue" :style="bg">
      <div class="container">
    <a id="a1" style="color: #1c7ceb"> <Icon type="md-arrow-round-back" style="color: #2e2e2e" /> <router-link id="wq1" to="/login">返回登录</router-link></a>
<br>
    <br>
    <br>

    <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
        <FormItem label="Name" prop="name" >
            <Input prefix="ios-contact" v-model="formValidate.name" placeholder="Enter your name" ></Input>
        </FormItem>
        <FormItem label="password" prop="password" >
            <Input prefix="md-key" type="password" v-model="formValidate.passsword" placeholder="Enter your password"></Input>
        </FormItem>
      <FormItem label="Confirm" prop="passwdCheck">
        <Input prefix="md-key" type="password" v-model="formValidate.passwdCheck" placeholder="Confirm your password "></Input>
      </FormItem>
        <FormItem label="Role" prop="role">
            <Select prefix="ios-contacts" v-model="formValidate.role" placeholder="Select your city">
                <Option value="学生">学生</Option>
                <Option value="教师">教师</Option>
                <Option value="管理人员">管理人员</Option>
                <Option value="采购人员">采购人员</Option>
            </Select>
        </FormItem>

        <FormItem label="Gender" prop="gender">
            <RadioGroup v-model="formValidate.gender">
                <Icon type="ios-female" />   <Radio  label="male" style="color: #2f54eb">Male</Radio>
                <Icon type="md-female" />   <Radio label="female" style="color: #2f54eb">Female</Radio>
            </RadioGroup>
        </FormItem>


        <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')" style="margin-right:100px">Submit</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 1px">Reset</Button>
        </FormItem>
    </Form>
  </div>
  </div>
</template>

<script>
    function HashMap() {
        this.map = {};
    }
    HashMap.prototype = {
        put: function (key, value) {// 向Map中增加元素（key, value)
            this.map[key] = value;
        },
        get: function (key) { //获取指定Key的元素值Value，失败返回Null
            if (this.map.hasOwnProperty(key)) {
                return this.map[key];
            }
            return null;
        },
        remove: function (key) { // 删除指定Key的元素，成功返回True，失败返回False
            if (this.map.hasOwnProperty(key)) {
                return delete this.map[key];
            }
            return false;
        },
        removeAll: function () {  //清空HashMap所有元素
            this.map = {};
        },
        keySet: function () { //获取Map中所有KEY的数组（Array）
            var _keys = [];
            for (var i in this.map) {
                _keys.push(i);
            }
            return _keys;
        }
    };

    import Axios from 'axios'
    export default {
        created() {
            this.bg.backgroundImage = 'url(' + require('../../assets/4.jpg') +')'
        },
        data () {
//确认密码
          const validatePassCheck = (rule, value, callback) => {
            if (value === '') {
              callback(new Error('Please enter your password again'));
            } else if (value !== this.formValidate.passsword) {
              callback(new Error('The two input passwords do not match!'));
            } else {
              callback();
            }
          };
            return {
                bg: {},
                formValidate: {
                    name: '',
                    passsword: '',
                    role: '',
                    gender: '',
                  passwdCheck:'',
                },
                ruleValidate: {
                    name: [
                        { required: true, message: 'The name cannot be empty', trigger: 'blur' },
                      {
                        min:3,max:10,message: 'please length cannot be less than 3 bits',trigger: 'blur'
                      }
                    ],
                    passsword: [
                        { required: true, message: 'Mailbox cannot be empty', trigger: 'blur' },
                      { type: 'string', min: 3, max:15, message: 'The password length cannot be less than 3 bits', trigger: 'blur' }
                    ],
                  passwdCheck:[{validator: validatePassCheck,trigger: 'blur'} ],
                    role: [
                        { required: true, message: 'Please select the city', trigger: 'change' }
                    ],
                    gender: [
                        { required: true, message: 'Please select gender', trigger: 'change' }
                    ],
                }
            }
        },
        methods: {
            handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {


                      let ro=300;
                        if(this.formValidate.role="学生")ro=300;
                        if(this.formValidate.role="教师")ro=300;
                        if(this.formValidate.role="管理人员")ro=301;
                        if(this.formValidate.role="采购人员")ro=302;
                    


                        //  取值
                        var data={
                            "username":this.formValidate.name,
                            "password":this.formValidate.passsword,
                            "role":ro,
                        };

                        window.console.log(data);

                        //请求
                        Axios.post('/api/register',data).then((res) => {
                            window.console.log(res);
                            //判断返回结果
                          if(res.data=="200"){

                            this.$Message.success('Success!');
                             this.$router.push({ path:'/login'});//跳转到登录
                          }else {
                            if(res.data=="201"){
                              this.$Message.info('用户名已存在!');
                             }else {
                              this.$Message.error('未知错误!');
                            }
                          }
                          // window.alert(res);//使用window的alert才会有效
                        }).catch((err) => {

                            window.console.log(err)

                        })




                    } else {
                        this.$Message.error('Fail!');
                    }
                })
            },
            handleReset (name) {
                this.$refs[name].resetFields();
            }
        }
    }
</script>

<style scoped>

    .Register-vue {
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        color: #fff;
    }
    .Register-vue .container {
        background: rgba(255, 255, 255, .5);
        width: 500px;
        text-align: center;
        border-radius: 10px;
        padding: 30px;
    }
    .Register-vue .ivu-input {
        background-color: transparent;
        color: #3536ff;
        outline: #fff;
        border-color: #fff;
    }
    .Register-vue ::-webkit-input-placeholder { /* WebKit, Blink, Edge */
        color: rgba(66, 104, 255, 0.8);
    }
    .Register-vue :-moz-placeholder { /* Mozilla Firefox 4 to 18 */
        color: rgba(77, 213, 255, 0.8);
    }
    .Register-vue ::-moz-placeholder { /* Mozilla Firefox 19+ */
        color: rgba(98, 204, 255, 0.8);
    }
    .Register-vue :-ms-input-placeholder { /* Internet Explorer 10-11 */
        color: rgba(75, 180, 255, 0.8);
    }
    .Register-vue .title {
        font-size: 16px;
        margin-bottom: 20px;
        color: #19be6b;
    }
    .Register-vue .input-c {
        margin: auto;
        width: 200px;

    }
    .Register-vue .error {
        color: red;
        text-align: left;
        margin: 5px auto;
        font-size: 12px;
        padding-left: 30px;
        height: 20px;
    }
    .Register-vue .submit {
        width: 200px;
    }
    .Register-vue .account {
        margin-top: 30px;
    }
    .Register-vue .account span {
        cursor: pointer;
    }
    .Register-vue .ivu-icon {
        color: #eee;
    }
    .Register-vue .ivu-icon-ios-close-circle {
        color: #777;
    }

</style>
