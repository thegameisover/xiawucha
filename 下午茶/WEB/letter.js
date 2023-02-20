const letter = Vue.extend({
    template: `
    <div id="letter">
    <ul>
    <li v-for="p in letter" :key="p.id" class="Letter">
    <el-badge value="new" class="item" :hidden="p.read" >
  <el-button size="small"  @click="open(p.id)">你有一条新信息{{p.id}}</el-button>
    </el-badge>
    <el-button type="danger" icon="el-icon-delete" circle class="deleteMessage" @click="deleteMessage(p.id)"></el-button>
    </li>
    </ul>
    <div  @click="cancelMessage" id="closeMessage"><i class="el-icon-close" ></i></div>
    </div>`,
    data() {
        return {
            letter: [{ id: 0, read: false, content: '你有一个回复', title: '系统消息' }, { id: 1, read: false, content: '你有一个回复', title: '系统消息' }, { id: 2, read: false, content: '你有一个回复', title: '系统消息' }],

        }
    },
    methods: {

        cancelMessage() {
            var p = document.getElementById("letter");
            p.style.display = "none";
        },
        deleteMessage(id) {
            var p = document.getElementsByClassName("Letter");
            p[id].style.display = "none";
        },
        open(id) {
            this.$data.letter[id].read = true;
            this.$alert(this.$data.letter[id].content, this.$data.letter[id].title, {
                confirmButtonText: '确定',
                callback: action => {
                    this.$message({
                        type: 'info',
                        message: `action: ${ action }`
                    });
                }
            });
        }
    },
})