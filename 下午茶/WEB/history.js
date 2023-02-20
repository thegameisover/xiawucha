const history = Vue.extend({
    template: `
    <div id=History>
    <el-row id=shuaxin>
    <el-button type="primary" @click="SX">点我刷新</el-button>
  </el-row>
    <ul>
    <li v-for="p in history" :key="p.id" class="history">
    <div>
    <el-collapse v-model="activeNames" @change="handleChange">
    <el-collapse-item :title="p.title">
      <div @click="deleteHistory(p.id)"> <el-button type="danger" icon="el-icon-delete" circle></el-button></div>
    </el-collapse-item>
  </el-collapse>
    </div>
    </li>
    </ul>
    <div id="cancelHistory"><i class="el-icon-close" @click="cancelHistory"></i></div>
    
    </div>`,
    data() {
        return {
            activeNames: ['1'],
            history: [],
        }
    },
    methods: {
        handleChange(val) {

        },
        deleteHistory(id) {
            var _this = this;
            var p = document.getElementsByClassName("history");
            p[id].style.display = "none";
            var _this = this;
            var xhr = new XMLHttpRequest();
            xhr.open("get", "http://127.0.0.1:8080/deleteHistory?name=" + _this.history[id].title);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.withCredentials = true;
            xhr.send();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4) {

                }
            };
        },
        cancelHistory() {
            var p = document.getElementById("History");
            p.style.display = "none";
        },
        SX() {
            this.$data.history = [];
            var _this = this;
            var xhr = new XMLHttpRequest();
            xhr.open("get", "http://127.0.0.1:8080/ReadHistory");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.withCredentials = true;
            xhr.send();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4) {
                    if (xhr.responseText == "请先登录") {
                        alert("请先登录");
                    } else {
                        var json = JSON.parse(xhr.responseText);
                        var j = 0;
                        for (var i in json) {
                            _this.$data.history.push({
                                id: j,
                                title: json[i]
                            });
                            console.log(_this.$data.history[0].title);
                            j++;
                        }
                    }
                }
            };
        }

    },
    mounted() {
        var _this = this;
        var xhr = new XMLHttpRequest();
        xhr.open("get", "http://127.0.0.1:8080/ReadHistory");
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.withCredentials = true;
        xhr.send();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                if (xhr.responseText == "请先登录") {
                    alert("请先登录");
                } else {
                    var json = JSON.parse(xhr.responseText);
                    var j = 0;
                    for (var i in json) {
                        _this.$data.history.push({
                            id: j,
                            title: json[i]
                        });

                        j++;
                    }
                }
            }
        };
    },
})