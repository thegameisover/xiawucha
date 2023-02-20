const Timepicture = Vue.extend({
    template: `<div id="PictureWinde">
    <div class="block">
    <el-carousel height="200px">
      <el-carousel-item v-for="item in Picture" :key="item.id">
      <img :src= "item.picture"  height="200px" width="100%">
      </el-carousel-item>
    </el-carousel>
  </div>
    </div>`,
    data() {
        return {
            Picture: [{ id: 1, picture: "1.jpg" }, { id: 2, picture: "2.jpg" }, { id: 3, picture: "3.jpg" }, { id: 4, picture: "4.jpg" }],
        }
    },
})