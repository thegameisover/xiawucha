const Chat = Vue.extend({
    template: `
    <div  id="chat">
    <h2 style="cursor:default">
    有问题就有答案
    </h2>
    <template>
    <div>
  <ul class="infinite-list" v-infinite-scroll="load" style="overflow:hidden" >
    <li v-for="i in Passage" class="infinite-list-item" >
    <div>

    </div>
    <div>
    <div class="passageShow">提问人:{{i.num}}</div>
    <div class="passageShow">发布日期:{{i.num}}</div>
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
            Passage: [{ title: '', name: '', date: '', num: '1' }, { title: '', name: '', date: '', num: '1' }, { title: '', name: '', date: '', num: '2' }, { title: '', name: '', date: '', num: '4' }, { title: '', name: '', date: '', num: '4' }, ],
        }
    },
    methods: {
        load() {
            this.$data.Passage.push({ title: '', name: '', date: '', num: '5' })

        }
    }
})