const New = Vue.extend({
    template: `
    <div id="News">
        <h2 id="title">
        每日新闻
        </h2>
        <div id="more" @click="More" @mouseover="Moreover($event)" @mouseleave="Moreleave($event)">
        更多<i class="el-icon-d-arrow-right
        "></i>
        </div>
        <div>
        <ul>
        <li v-for="p in news" :key="p.id" class="news" @click="Newsclick(p)">
        <el-link type="primary" >
        {{p.content}}
        </el-link>
        </li>
        </ul>
        </div>
    </div>
    `,
    data() {
        return {
            news: []
        }
    },
    methods: {
        Newsclick(event) {
            console.log(event.id);
        },
        More() {

        },
        Moreover() {
            var p = document.getElementById("more");
            p.style.color = "gray";
        },
        Moreleave() {
            var p = document.getElementById("more");
            p.style.color = "black";
        }
    },
})