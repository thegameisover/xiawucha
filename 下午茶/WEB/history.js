const history = Vue.extend({
    template: `
    <div id=History>
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
            history: [{ id: 0, title: '三体(小说)' }, { id: 1, title: '流浪地球()' }],
        }
    },
    methods: {
        handleChange(val) {

        },
        deleteHistory(id) {
            var p = document.getElementsByClassName("history");
            p[id].style.display = "none";
        },
        cancelHistory() {
            var p = document.getElementById("History");
            p.style.display = "none";
        },

    }
})