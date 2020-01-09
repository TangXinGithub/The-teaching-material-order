<template>
  <div>
    <a id="a1">  <router-link id="wq1" to="/login">返回登录</router-link></a>
<br>
    <br>
    <br>

    <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
        <FormItem label="Name" prop="name">
            <Input v-model="formValidate.name" placeholder="Enter your name"></Input>
        </FormItem>
        <FormItem label="password" prop="password">
            <Input type="password" v-model="formValidate.passsword" placeholder="Enter your password"></Input>
        </FormItem>
      <FormItem label="Confirm" prop="passwdCheck">
        <Input type="password" v-model="formValidate.passwdCheck"></Input>
      </FormItem>
        <FormItem label="Role" prop="role">
            <Select v-model="formValidate.role" placeholder="Select your city">
                <Option value="学生">学生</Option>
                <Option value="教师">教师</Option>
                <Option value="管理人员">管理人员</Option>
                <Option value="采购人员">采购人员</Option>
            </Select>
        </FormItem>

        <FormItem label="Gender" prop="gender">
            <RadioGroup v-model="formValidate.gender">
                <Radio label="male">Male</Radio>
                <Radio label="female">Female</Radio>
            </RadioGroup>
        </FormItem>


        <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">Submit</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>
        </FormItem>
    </Form>
  </div>
</template>

<script>

    import Axios from 'axios'
    export default {
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

                        //  取值
                        var data={
                            "username":this.formValidate.name,
                            "password":this.formValidate.passsword,
                            "role":this.formValidate.role,
                        }

                        window.console.log(data);

                        //请求
                        Axios.post('/api/register',data).then((res) => {
                            window.console.log(res);
                            //判断返回结果
                          if(res.data.code=="200"){

                            this.$Message.success('Success!');
                             this.$router.push({ path:'/login'});//跳转到登录
                          }else {
                            if(res.data.code=="201"){
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
div{
    margin-left: 20%;
  margin-right: 20%;
}

</style>
