const Film = Vue.extend({
    template: `
    <div id="Film" >
<h2 style="cursor:default">
感受电影的魅力
</h2>
<div id="film">
<ul >
<li v-for="p in move" :key="p.id" class="move">
<div class="Move">
<img :src= "p.picture"  height="180px" width="100%">
</div>
<div>
{{p.name}}
</div>
<div>
评分:{{p.goal}}
</div>
</li>
</ul>
</div>
<div id="FilmMore" @click="Film" @mouseover="Filmover($event)" @mouseleave="Filmleave($event)">
更多<i class="el-icon-d-arrow-right
"></i>
</div>
    </div>`,
    data() {
        return {
            move: [{ id: 1, picture: "1.jpg", name: '三体', goal: 9.7 }, { id: 2, picture: "2.jpg", name: '三体', goal: 9.7 }, { id: 3, picture: "3.jpg", name: '三体', goal: 9.7 }, { id: 4, picture: "4.jpg", name: '三体', goal: 9.7 }, { id: 1, picture: "1.jpg", name: '三体', goal: 9.7 }, { id: 1, picture: "1.jpg", name: '三体', goal: 9.7 }, { id: 1, picture: "1.jpg", name: '三体', goal: 9.7 }, { id: 1, picture: "1.jpg", name: '三体', goal: 9.7 }],
        }
    },
    methods: {
        Film() {

        },
        Filmover($event) {
            var p = document.getElementById("FilmMore");
            p.style.color = "gray";
        },
        Filmleave($event) {
            var p = document.getElementById("FilmMore");
            p.style.color = "black  ";
        }
    },
})