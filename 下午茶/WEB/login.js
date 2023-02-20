const Login = Vue.extend({
    template: `
    <div id="Login">
       <table id="login">
       <tr>
       <td class="td"><label for="account">账号:</label></td>
       <td class="td"><el-input
       placeholder="请输入账号"
       v-model="account"
       clearable>
     </el-input></td>
       </tr>
       <tr>
       <td class="td"><label for="password">密码:</label></td>
       <td class="td"><el-input placeholder="请输入密码" v-model="password" show-password></el-input></td>
       </tr>
       <tr>
       <td class="td" style="cursor: pointer;" @click="Code">{{mark}}</td>
       <td class="td"><el-input
       placeholder="点击获取验证码"
       v-model="Mark"
       clearable>
     </el-input></td>
       </tr>
       </table>
       <span id="in"><el-button type="primary" @click="login">登录</el-button></span>
       <span id="up"><el-button type="danger" @click="logup2">注册</el-button></span>
       <div id="close"><i class="el-icon-close" @click="cancelIn"></i></div>
    </div>`,
    data() {
        return {
            account: '',
            password: '',
            Mark: '',
            mark: '验证码',
        }
    },
    methods: {
        login() {
            var _this = this;
            var json = {
                "account": this.$data.account,
                "password": this.$data.password,
            }
            var data = JSON.stringify(json);
            var xhr = new XMLHttpRequest();
            xhr.open("post", "http://127.0.0.1:8080/login");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.withCredentials = true;
            xhr.send(data);
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4) {
                    if (xhr.status >= 200 & xhr.status < 300) {
                        var name = xhr.responseText;
                        if (name == "null") {
                            alert("密码或账号错误亦或者不存在");
                        } else if (name == "code") {
                            alert("验证码已过期");
                        } else {

                            alert("登录成功");
                            _this.$root.userName = name;
                        }
                    }
                }
            }
        },
        logup2() {
            var p = document.getElementById("Login");
            p.style.display = "none";
            var q = document.getElementById("Logup");
            q.style.display = "block";
        },
        cancelIn() {
            var p = document.getElementById("Login");
            p.style.display = "none";
        },
        Code() {
            if (this.$data.account == '') {
                alert("请先输入账号");
            } else {
                var _this = this;
                var xhr = new XMLHttpRequest();
                xhr.open("get", "http://127.0.0.1:8080/login?name=" + this.$data.account);
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.withCredentials = true;
                xhr.send();
                xhr.onreadystatechange = function() {
                    if (xhr.readyState === 4) {
                        if (xhr.status >= 200 & xhr.status < 300) {
                            _this.$data.mark = xhr.responseText;
                        }
                    }
                }
            }

        }
    },
})