<template>
    <Form ref="formInline" :model="formInline" :rules="ruleInline" inline>
        <FormItem prop="user">
            <Input type="text" v-model="formInline.user" placeholder="Username">
                <Icon type="ios-person-outline" slot="prepend"></Icon>
            </Input>
        </FormItem>
        <FormItem prop="password">
            <Input type="password" v-model="formInline.password" placeholder="Password">
                <Icon type="ios-lock-outline" slot="prepend"></Icon>
            </Input>
        </FormItem>
        <FormItem>
            <Button type="primary" @click="handleSubmit('formInline')">Signin</Button>
        </FormItem>
    </Form>
</template>
<script>
    import Axios from 'axios'
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
             var dataLogin={
                   "username":this.formInline.user,
                    "password":this.formInline.password,
                }

                        this.$Message.success('Success!');
                window.console.log("登录数据："+dataLogin)
                        //请求
                        Axios.post('/api/login',dataLogin).then((res) => {
                            window.console.log(res);
                            // window.alert(res);//使用window的alert才会有效
                        }).catch((err) => {

                            window.console.log(err)

                        })




                    } else {
                        this.$Message.error('Fail!');
                    }
                })
            }
        }



    }
</script>

<style scoped>

</style>