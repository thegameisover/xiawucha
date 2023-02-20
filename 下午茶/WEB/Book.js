const Book = Vue.extend({
    template: `
    <div id="book">
     <h2 style="cursor:default">
     爱阅读，爱生活
     </h2>
     <div>
     <ul id="read">
     <li v-for="p in book" :key="p.id" class="BOOK" @click="BookShow(p.id)">
     <div>
     <img :src= "p.picture"  height="140px" width="100%">
     </div>
     <div>
     {{p.name}}
     </div>
     </li>
     </ul>
     </div>
     <div id="Read" @click="Read" @mouseover="Readover($event)" @mouseleave="Readleave($event)">
     更多<i class="el-icon-d-arrow-right
     "></i>
     </div>
    </div>
    `,
    data() {
        return {
            book: [{ id: 1, picture: "1.jpg", name: '三体' }, { id: 2, picture: "2.jpg", name: '三体' }, { id: 3, picture: "3.jpg", name: '三体' }, { id: 4, picture: "4.jpg", name: '三体' }, { id: 1, picture: "1.jpg", name: '三体' }, { id: 1, picture: "1.jpg", name: '三体' }, { id: 1, picture: "1.jpg", name: '三体' }, { id: 1, picture: "1.jpg", name: '三体' }],
        }
    },
    methods: {
        Read() {
            window.open("bookClassify.html?");
        },
        Readover($event) {
            var p = document.getElementById("Read");
            p.style.color = "gray";
        },
        Readleave($event) {
            var p = document.getElementById("Read");
            p.style.color = "black";
        },
        BookShow(id) {
            window.open("readBook.html?" + id);
        }
    },
})