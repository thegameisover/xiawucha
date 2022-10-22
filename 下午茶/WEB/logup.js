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

        },
        cancelUp() {
            var p = document.getElementById("Logup");
            p.style.display = "none";
        }
    },
})