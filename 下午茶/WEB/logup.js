const Logup = Vue.extend({
    template: `
 <div id="Logup">
  <table id="login">
  <tr>
  <td class="td">用户名:</td>
  <td class="td"><el-input
  placeholder="不得超过5个字符"
  v-model="UserName"
  clearable>
</el-input></td>
  </tr>
  <tr>
  <td class="td">账号:</td>
  <td class="td"><el-input
  placeholder="不得超过10个字符"
  v-model="account"
  clearable>
</el-input></td>
  </tr>
  <tr>
  <td class="td">密码:</td>
  <td class="td"><el-input placeholder="不得超过10个字符" v-model="password" show-password></el-input></td>
  </tr>
  </table>
  <div id="logup"><el-button type="danger" @click="logup1">注册</el-button></div>
  <div id="close"><i class="el-icon-close" @click="cancelUp"></i></div>
 </div>`,
    data() {
        return {
            UserName: '',
            account: '',
            password: '',
        }
    },
    methods: {
        logup1() {
            if (this.$data.UserName.length > 5 || this.$data.account.length > 10 || this.$data.password.length > 10) {
                alert("请输入正确的字符");
            } else {
                var json = {
                    "username": this.$data.UserName,
                    "account": this.$data.account,
                    "password": this.$data.password,
                }
                var data = JSON.stringify(json);
                var xhr = new XMLHttpRequest();
                xhr.open("post", "http://127.0.0.1:8080/logup");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.withCredentials = true;
                xhr.send(data);
                xhr.onreadystatechange = function() {
                    if (xhr.readyState === 4) {
                        if (xhr.status >= 200 & xhr.status < 300) {
                            if (xhr.responseText == "exist") {
                                alert("账号已存在");
                            } else if (xhr.responseText == "successful") {
                                alert("注册成功");
                                var p = document.getElementById("Logup");
                                p.style.display = "none";
                                p = document.getElementById("Login");
                                p.style.display = "block";
                            } else {
                                alert("注册失败");
                            }

                        }
                    }
                }
            }

        },
        cancelUp() {
            var p = document.getElementById("Logup");
            p.style.display = "none";
        }
    },
})