const Chat = Vue.extend({
    template: `
    <div  id="chat">
    <h2 style="cursor:default">
    有问题就有答案
    </h2>
    <template>
    <div>
  <ul class="infinite-list" v-infinite-scroll="load" style="overflow:hidden" >
    <li v-for="i in Passage" class="infinite-list-item" @click="ReadQuestion(i.id)">
    <div>
        {{i.title}}
    </div>
    <div>
    <div class="passageShow">提问人:{{i.name}}</div>
    <div class="passageShow">发布日期:{{i.date}}</div>
    <div class="passageShow">回答人数:{{i.num}}</div>
    <div class="passageShow">举报</div>
    <div style="clear:both"></div>
    </div>
    </li>
  </ul>
  </div>
</template>
    </div>`,
    data() {
        return {
            Passage: [],
            n: 0,
            page: 0,
        }
    },
    methods: {
        ReadQuestion(id) {
            window.open("question.html?" + id);
        },
        load() {
            if (this.$data.n == 0) {
                this.$data.page = this.$data.page + 5;
                var _this = this;
                var xhr = new XMLHttpRequest();
                xhr.open("get", "http://127.0.0.1:8080/NewQuestion?page=" + this.$data.page);
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.withCredentials = true;
                xhr.send();
                xhr.onreadystatechange = function() {
                    if (xhr.readyState === 4) {
                        if (xhr.responseText == "null") {
                            _this.$data.n = 1;
                        } else if (xhr.responseText == "false") {
                            alert("系统错误");
                        } else {
                            var json = JSON.parse(xhr.responseText);
                            for (var i in json) {
                                _this.$root.question.push({
                                    id: json[i][0],
                                    title: json[i][1],
                                    name: json[i][2],
                                    date: json[i][3],
                                    num: json[i][4],
                                });

                            };

                        }
                    }
                };
            }
        }
    },

})